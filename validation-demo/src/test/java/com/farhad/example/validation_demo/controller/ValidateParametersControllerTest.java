package com.farhad.example.validation_demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ValidateParametersController.class)
public class ValidateParametersControllerTest {

  @Autowired
  private MockMvc mvc;


  @Test
  void whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
    mvc.perform(get("/validatePathVariable/3"))
            .andExpect(status().isBadRequest());
  }  

  @Test
  void whenRequestParameterIsInvalid_thenReturnsStatus400() throws Exception {
    mvc.perform(get("/validateRequestParameter")
            .param("param", "3"))
            .andExpect(status().isBadRequest());
  }

  @Test
  void whenPathVariableIsValid_thenReturnsStatus200() throws Exception {
    mvc.perform(get("/validatePathVariable/10"))
            .andExpect(status().isOk());
  }

}
