package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnackService {

    private final SnackModelRepository snackModelRepository;

    public SnackModel createData(SnackReq req) {
        SnackModel snackModel = new SnackModel();
        snackModel.setName(req.getName());
        snackModel.setAmount(req.getAmount());
        snackModel.setPrice(req.getPrice());
        return snackModelRepository.save(snackModel);
    }

    public List<SnackModel> getAll() {
        return snackModelRepository.findAll();
    }

    public SnackModel updateData(Long id, SnackReq req) throws BadRequestException {
        Optional<SnackModel> snackModelOptional = snackModelRepository.findById(id);
        if (snackModelOptional.isPresent()) {
            SnackModel snackModel = snackModelOptional.get();
            if (req.getName() != null) {
                snackModel.setName(req.getName());
            }
            if (req.getAmount() != 0 && req.getAmount() != snackModel.getAmount()) {
                snackModel.setAmount(req.getAmount());
            }
            if (req.getPrice() != 0 && req.getPrice() != snackModel.getPrice()) {
                snackModel.setPrice(req.getPrice());
            }
            snackModelRepository.save(snackModel);
            return snackModel;
        } else {
            throw new BadRequestException();
        }
    }
}
