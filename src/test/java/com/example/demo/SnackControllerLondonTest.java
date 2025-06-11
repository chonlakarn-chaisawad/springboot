package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SnackControllerLondonTest {

    @InjectMocks
    private SnackService snackService;
    @Mock
    private SnackModelRepository snackModelRepository;

    @Test
    void getSnacks() {
        //input
        //Mocking
        List<SnackModel> snackModels = snackService.getAll();
        //assertion
        Assertions.assertThat(snackModels).isEmpty();
    }

    @Test
    void createSnack() {
        //input
        SnackReq req = new SnackReq();
        SnackModel snackModel = new SnackModel();
        snackModel.setId(1L);
        //Mocking
        when(snackModelRepository.save(any(SnackModel.class))).thenReturn(snackModel);
        //assertion
        SnackModel res = snackService.createData(req);
        Assertions.assertThat(res).isNotNull();
        Assertions.assertThat(res.getId()).isNotNull();
        verify(snackModelRepository,times(1)).save(any(SnackModel.class));
    }
}