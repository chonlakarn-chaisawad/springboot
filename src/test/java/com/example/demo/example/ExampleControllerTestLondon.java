//package com.example.demo.example;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class ExampleControllerTestLondon {
//
//    @InjectMocks
//    private ExampleService exampleService;
//    @Mock
//    private ExampleModelRepository exampleModelRepository;
//
//    @Test
//    void getExample() {
//        List<ExampleModel> allData = exampleService.getAllData();
//        Assertions.assertThat(allData).isEmpty();
//    }
//
//    @Test
//    void createExanple() {
//        //input
//        ExampleRequest req = new ExampleRequest();
//        ExampleModel exampleModel = new ExampleModel();
//        exampleModel.setId(1L);
//        //Mocking
//        when(exampleModelRepository.save(any(ExampleModel.class))).thenReturn(exampleModel);
//        //assertion
//        ExampleModel data = exampleService.createData(req);
//        Assertions.assertThat(data).isNotNull();
//        Assertions.assertThat(data.getId()).isNotNull();
//        verify(exampleModelRepository,times(1)).save(any(ExampleModel.class));
//    }
//}