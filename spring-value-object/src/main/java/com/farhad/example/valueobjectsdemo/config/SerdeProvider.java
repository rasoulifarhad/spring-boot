package com.farhad.example.valueobjectsdemo.config;


import org.springframework.format.Formatter;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

public interface SerdeProvider<T> {
    
    JsonDeserializer<T> getJsonDeserializer();
    JsonSerializer<T>   getJsonSerializer();
    Formatter<T>  getTypedFieldFormatter();
    Class<T> getType();

}
