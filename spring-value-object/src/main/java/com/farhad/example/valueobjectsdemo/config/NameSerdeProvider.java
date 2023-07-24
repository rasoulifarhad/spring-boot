package com.farhad.example.valueobjectsdemo.config;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.User.Name;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class NameSerdeProvider implements SerdeProvider<Name> {

    @Override
    public JsonDeserializer<Name> getJsonDeserializer() {
        return new JsonDeserializer<Name>() {

            @Override
            public Name deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                if(p.getValueAsString( ) == null) {
                    return null;
                }
                return new Name(p.getValueAsString(null));
            }
            
        };
    }

    @Override
    public JsonSerializer<Name> getJsonSerializer() {
        return new JsonSerializer<Name>() {

            @Override
            public void serialize(Name value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if(value == null) {
                    gen.writeNull();
                } else {
                    gen.writeString(value.getValue());
                }
            }
            
        };
    }

    @Override
    public Formatter<Name> getTypedFieldFormatter() {
        return new Formatter<Name>() {

            @Override
            public String print(Name object, Locale locale) {
                return object.getValue();
            }

            @Override
            public Name parse(String text, Locale locale) throws ParseException {
                return new Name(text);
            }
            
        };
    }

    @Override
    public Class<Name> getType() {
        return User.Name.class;
    }
    
}
