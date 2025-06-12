//package com.example.demo.example;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class ExampleControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ExampleModelRepository exampleModelRepository;
//
//    @BeforeEach
//    void setUp() {
//        exampleModelRepository.deleteAll();
//        ExampleModel exampleModel = ExampleModel.builder().name("name").email("email").phone("12345").build();
//        exampleModelRepository.save(exampleModel);
//    }
//
//
//    @Test
//    void getAllData_ShouldReturnListOfExampleModels() throws Exception {
//        ExampleModel model = new ExampleModel();
//
//        mockMvc.perform(get("/example"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    void createData_ShouldCreateNewExampleModel() throws Exception {
//        String req = """
//                { "name":"test","email":"new@email.com","phone":"0987654321"}
//                """;
//        mockMvc.perform(post("/example")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(req))
//                .andExpect(status().is(240))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.name").value("test"))
//                .andExpect(jsonPath("$.email").value("new@email.com"))
//                .andExpect(jsonPath("$.phone").value("0987654321"));
//    }
//}