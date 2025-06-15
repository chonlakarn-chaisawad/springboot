package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SnackControllerChicacoTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SnackModelRepository snackModelRepository;

    @BeforeEach
    void setUp() {
        snackModelRepository.deleteAll();
        SnackModel snackModel = SnackModel.builder().name("candy").price(10).amount(100).build();
        snackModelRepository.save(snackModel);
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/snack"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("candy"))
                .andExpect(jsonPath("$[0].price").value(10))
                .andExpect(jsonPath("$[0].amount").value(100));
    }

    @Test
    void createSnack() throws Exception {
        String req = """
                {
                    "name":"apple",
                    "price":20,
                    "amount":15
                }
                """;
        mockMvc.perform(post("/snack")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("apple"))
                .andExpect(jsonPath("$.price").value(20))
                .andExpect(jsonPath("$.amount").value(15));
    }

    @Test
    void Update() throws Exception {
        long id = 1L;
        String req = """
                {
                    "amount":9
                }
                """;
        mockMvc.perform(patch("/snack/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(req))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("candy"))
                .andExpect(jsonPath("$.price").value(10))
                .andExpect(jsonPath("$.amount").value(9));
    }
}