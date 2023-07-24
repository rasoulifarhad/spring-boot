package com.farhad.example.valueobjectsdemo.config;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.UUID;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.farhad.example.valueobjectsdemo.domain.User;
import com.farhad.example.valueobjectsdemo.domain.User.ID;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class UserIdSerdeProvider implements SerdeProvider<User.ID> {

    @Override
    public JsonDeserializer<ID> getJsonDeserializer() {
        return new JsonDeserializer<User.ID>() {

            @Override
            public ID deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException, JacksonException {
                final String value = p.getValueAsString();
                return value == null? null : new ID(UUID.fromString(value));
            }
            
        };
    }

    @Override
    public JsonSerializer<ID> getJsonSerializer() {
        return new JsonSerializer<User.ID>() {

            @Override
            public void serialize(final ID value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
                if (value == null ) {
                    gen.writeNull();
                } else {
                    gen.writeString(value.toString());
                }
            }
        };
    }

    @Override
    public Formatter<ID> getTypedFieldFormatter() {
        return new Formatter<User.ID>() {

            @Override
            public String print(ID object, Locale locale) {
                return object.getId().toString();
            }

            @Override
            public ID parse(String text, Locale locale) throws ParseException {
                return new ID(UUID.fromString(text));
            }
            
        };
    }

    @Override
    public Class<ID> getType() {
        return User.ID.class;
    }

    
}
