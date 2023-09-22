package com.farhad.example.validation_demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.farhad.example.validation_demo.Input;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ValidateRequestBodyController.class)
public class ValidateRequestBodyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
        Input input = invalidInput();
        String body = objectMapper.writeValueAsString(input);
        mvc.perform(post("/validateBody")
                        .contentType("application/json")
                        .content(body))
                    .andExpect(status().isBadRequest());
                
    }

    @Test
    void whenInputIsValid_thenReturnsStatus200() throws Exception {
        Input input = validInput();
        String body = objectMapper.writeValueAsString(input);

        mvc.perform(post("/validateBody")
                       .contentType("application/json")
                       .content(body))
                    .andExpect(status().isOk());
    }

    @Test
    void whenInputIsInvalid_thenReturnsStatus400WithErrorObject() throws Exception {
        Input input = invalidInput();
        String body = objectMapper.writeValueAsString(input);

        MvcResult result = mvc.perform(post("/validateBody")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).contains("violations");
    }   
     
    private Input invalidInput() {
        Input input = new Input();
        input.setIpAddress("invalid");
        input.setNumberBetweenOneAndTen(99);
        return input;
      }

    private Input validInput() {
        Input input = new Input();
        input.setIpAddress("255.255.255.255");
        input.setNumberBetweenOneAndTen(10);
        return input;
      }      
}
