package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.models.Lapto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptoControllerTest {


    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Lapto[]> response =
                testRestTemplate.getForEntity("/api/laptos", Lapto[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        List<Lapto> laptos = Arrays.asList(response.getBody());
        System.out.println(laptos.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Lapto> response =
                testRestTemplate.getForEntity("/api/laptos/1", Lapto.class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());

    }

    @Test
    void create() {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON) );

        String json = """
                {
                        "titulo": "alpaca",
                        "autor": "oveja",
                        "pagina": 2200,
                        "valor": 3003.2,
                        "fechaLanzaiento": "2018-12-05",
                        "online": true
                }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,header);

        ResponseEntity<Lapto> respuesta = testRestTemplate.exchange("/api/laptos",HttpMethod.POST,request,Lapto.class);

        Lapto result = respuesta.getBody();

        assertEquals(1L, result.getId());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}