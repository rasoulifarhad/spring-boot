package com.farhad.example.valueobjectsdemo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
@SuppressWarnings({"unchecked", "rawtypes"})
public class WebMvcConfig implements WebMvcConfigurer {
    
    private final List<SerdeProvider<?>> serdeProviders;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        for (SerdeProvider<?> p : serdeProviders ) {
            log.info("Add custom formatter for field type '{}'", p.getType());            
            registry.addFormatterForFieldType(p.getType(),p.getTypedFieldFormatter());
        }
    } 

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                        .registerModule(new Jdk8Module())
                        .registerModule(new JavaTimeModule())
                        .registerModule(customeSerdeModule())
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private Module customeSerdeModule() {
        SimpleModule m = new SimpleModule("Custom SerDe module");
        for (SerdeProvider serdeProvider : serdeProviders) {
            log.info("Add custom serde for type '{}'", serdeProvider.getType());
            m.addSerializer(serdeProvider.getType(), serdeProvider.getJsonSerializer());
            m.addDeserializer(serdeProvider.getType(), serdeProvider.getJsonDeserializer());

        }
        return m;
    }
    
}
