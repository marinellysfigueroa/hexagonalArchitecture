package com.intraway.mefa.fizzbuzz.infraestructura;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intraway.mefa.fizzbuzz.aplicacion.comando.ComandoOperacion;
import com.intraway.mefa.fizzbuzz.testdatabuilder.OperacionTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorOperacionTest {

    public static final String DES_MULTIPLO_TRES = "Se encontraron múltiplos de 3";
    public static final String DES_MULTIPLO_CINCO = "Se encontraron múltiplos de 5";
    public static final String DES_MULTIPLO_TRES_CINCO = "Se encontraron múltiplos de 3 y de 5";
    public static final String DES_MULTIPLO_NINGUNO = "No se encontraron múltiplos de 3 ni de 5";

    public static final String LIST_MULTIPLO_TRES = "2,Fizz";
    public static final String LIST_MULTIPLO_CINCO = "4,Buzz";
    public static final String LIST_MULTIPLO_TRES_CINCO = "Buzz,Fizz";
    public static final String LIST_MULTIPLO_NINGUNO = "1,2";
    public static final int ERROR = 400;
    public static final String BAD_REQUEST = "Bad Request";
    public static final String EXCEPTION = "com.intraway.exceptions.badrequest";
    public static final String MESSAGE = "Los parámetros enviados son incorrectos";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void registrarOperacionMultiploNinguno() throws Exception
    {

        ComandoOperacion comandoOperacion= new OperacionTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .get("/intraway/api/fizzbuzz/{min}/{max}", 1,2)
                .content(objectMapper.writeValueAsString(comandoOperacion))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list").value(LIST_MULTIPLO_NINGUNO))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(DES_MULTIPLO_NINGUNO));

    }
    @Test
    public void registrarOperacionMultiploTres() throws Exception
    {

        ComandoOperacion comandoOperacion= new OperacionTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .get("/intraway/api/fizzbuzz/{min}/{max}", 2,3)
                .content(objectMapper.writeValueAsString(comandoOperacion))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list").value(LIST_MULTIPLO_TRES))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(DES_MULTIPLO_TRES));

    }
    @Test
    public void registrarOperacionMultiploCinco() throws Exception
    {

        ComandoOperacion comandoOperacion= new OperacionTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .get("/intraway/api/fizzbuzz/{min}/{max}", 4,5)
                .content(objectMapper.writeValueAsString(comandoOperacion))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list").value(LIST_MULTIPLO_CINCO))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(DES_MULTIPLO_CINCO));

    }
    @Test
    public void registrarOperacionMultiploTresCinco() throws Exception
    {

        ComandoOperacion comandoOperacion= new OperacionTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .get("/intraway/api/fizzbuzz/{min}/{max}", 5,6)
                .content(objectMapper.writeValueAsString(comandoOperacion))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list").value(LIST_MULTIPLO_TRES_CINCO))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(DES_MULTIPLO_TRES_CINCO));

    }
    @Test
    public  void badRequest() throws Exception {
        ComandoOperacion comandoOperacion= new OperacionTestDataBuilder().buildComando();
        mvc.perform( MockMvcRequestBuilders
                .get("/intraway/api/fizzbuzz/{min}/{max}", 5,-2)
                .content(objectMapper.writeValueAsString(comandoOperacion))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(ERROR))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value(BAD_REQUEST))
                .andExpect(MockMvcResultMatchers.jsonPath("$.exception").value(EXCEPTION))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(MESSAGE));


    }
}
