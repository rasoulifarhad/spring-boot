package com.farhad.example.valueobjectsdemo.config;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.farhad.example.valueobjectsdemo.domain.value.Passport;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class PassportSerdeProvider implements SerdeProvider<Passport> {

    @Override
    public JsonDeserializer<Passport> getJsonDeserializer() {
        return new JsonDeserializer<Passport>() {

            @Override
            public Passport deserialize(JsonParser p, DeserializationContext ctxt)
                    throws IOException, JacksonException {

                        if (p.getValueAsString() == null) {
                            return null;
                        }
                        return Passport.parse(p.getValueAsString());
            }
            
        };
    }

    @Override
    public JsonSerializer<Passport> getJsonSerializer() {
        return new JsonSerializer<Passport>() {

            @Override
            public void serialize(Passport value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                        if (value == null) {
                            gen.writeNull();
                        } else {
                            gen.writeString(value.toString());
                        }

            }
            
        };
    }

    @Override
    public Formatter<Passport> getTypedFieldFormatter() {
        return new Formatter<Passport>() {

            @Override
            public String print(Passport object, Locale locale) {
                return object.toString();
            }

            @Override
            public Passport parse(String text, Locale locale) throws ParseException {
                return Passport.parse(text);
            }
            
        };
    }

    @Override
    public Class<Passport> getType() {
        return Passport.class;
    }
    
}
