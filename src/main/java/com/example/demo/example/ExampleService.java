package com.example.demo.example;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleModelRepository exampleModelRepository;

    public ExampleModel createData(ExampleRequest req) {
        ExampleModel exampleModel = new ExampleModel();
        exampleModel.setEmail(req.getEmail());
        exampleModel.setName(req.getName());
        exampleModel.setPhone(req.getPhone());
        exampleModelRepository.save(exampleModel);
        return exampleModel;
    }

    public List<ExampleModel> getAllData() {
        return exampleModelRepository.findAll();
    }

    public ExampleModel updateData(long id, ExampleRequest req) throws BadRequestException {
        Optional<ExampleModel> exampleModelOptional = exampleModelRepository.findById(id);
        if (exampleModelOptional.isPresent()) {
            ExampleModel exampleModel = exampleModelOptional.get();
            exampleModel.setName(req.getName());
            exampleModel.setEmail(req.getEmail());
            exampleModel.setPhone(req.getPhone());
            exampleModelRepository.save(exampleModel);
            return exampleModel;
        } else {
            throw new BadRequestException();
        }
    }

    public void deleteData(Long id) {
        exampleModelRepository.deleteById(id);
    }
}
