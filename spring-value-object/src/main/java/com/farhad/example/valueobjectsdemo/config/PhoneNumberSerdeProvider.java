package com.farhad.example.valueobjectsdemo.config;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.farhad.example.valueobjectsdemo.domain.value.PhoneNumber;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PhoneNumberSerdeProvider implements SerdeProvider<PhoneNumber> {

    @Override
    public JsonDeserializer<PhoneNumber> getJsonDeserializer() {
        return new JsonDeserializer<PhoneNumber>() {

            @Override
            public PhoneNumber deserialize(JsonParser p, DeserializationContext ctxt)
                    throws IOException, JacksonException {
                        final String value = p.getValueAsString();
                        if(value == null) {
                            return null;
                        } else {
                            return new PhoneNumber(value);
                        }
            }
            
        };
    }

    @Override
    public JsonSerializer<PhoneNumber> getJsonSerializer() {
        return new JsonSerializer<PhoneNumber>() {

            @Override
            public void serialize(PhoneNumber value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {
                        if(value  == null) {
                            gen.writeNull();
                        } else {
                            gen.writeString(value.toString());
                        }
            }
            
        };
    }

    @Override
    public Class<PhoneNumber> getType() {
        return PhoneNumber.class;
    }

    @Override
    public Formatter<PhoneNumber> getTypedFieldFormatter() {
        return new Formatter<PhoneNumber>() {

            @Override
            public String print(PhoneNumber object, Locale locale) {
                return object.toString();
            }

            @Override
            public PhoneNumber parse(String text, Locale locale) throws ParseException {
                return new PhoneNumber(text);
            }
            
        };
    }

    
}
