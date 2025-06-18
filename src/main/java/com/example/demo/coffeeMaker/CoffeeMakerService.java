package com.example.demo.coffeeMaker;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeMakerService {

    private final CoffeeMakerRepository coffeeMakerRepository;

    public CoffeeMakerModel createOrder(CoffeeMakerReq req) throws BadRequestException {
        int price = 40;
        CoffeeMakerModel order = new CoffeeMakerModel();
        order.setOrderName(req.getOrderName());

        if ("S".equals(req.getSize()) || "s".equals(req.getSize())) {
            price += 0;
        } else if ("M".equals(req.getSize()) || "m".equals(req.getSize())) {
            price += 10;
        } else if ("L".equals(req.getSize()) || "l".equals(req.getSize())) {
            price += 20;
        } else {
            throw new BadRequestException("Invalid size: " + req.getSize());
        }
        order.setSize(req.getSize());
        if (req.getIsMilk()) {
            price += 10;
        }
        order.setIsMilk(req.getIsMilk());
        order.setIsSyrup(req.getIsSyrup());
        order.setHowSweet(req.getHowSweet());
        if (req.getIsIce()) {
            price += 5;
        }
        order.setIsIce(req.getIsIce());
        if (req.getIsTakeAway()) {
            price += 5;
        }
        order.setIsTakeAway(req.getIsTakeAway());
        if (req.getIsTakeAway()) {
            price += 5;
        }
        order.setPrice(price);
        coffeeMakerRepository.save(order);
        return order;
    }

    public List<CoffeeMakerModel> getOrder() {
        return coffeeMakerRepository.findAll();
    }

    public CoffeeMakerModel getOrderById(Long id) throws BadRequestException {
        Optional<CoffeeMakerModel> orderOption = coffeeMakerRepository.findById(id);
        if (orderOption.isPresent()) {
            CoffeeMakerModel order = orderOption.get();
            return order;
        }
        throw new BadRequestException();
    }

    public CoffeeMakerModel updateOrder(Long id,CoffeeMakerReq req) throws BadRequestException {
        Optional<CoffeeMakerModel> orderOptional = coffeeMakerRepository.findById(id);
        if (orderOptional.isPresent()) {
            CoffeeMakerModel res = orderOptional.get();
            if (res.getOrderName() != req.getOrderName()){
                res.setOrderName(req.getOrderName());
            }
            if (res.getSize() != req.getSize()){
                res.setSize(req.getSize());
            }
            if (res.getIsMilk() != req.getIsMilk()){
                res.setIsMilk(req.getIsMilk());
            }
            if (res.getIsSyrup() != req.getIsSyrup()){
                res.setIsSyrup(req.getIsSyrup());
            }
            if (res.getHowSweet() != req.getHowSweet()){
                res.setHowSweet(req.getHowSweet());
            }
            if (res.getIsIce() != req.getIsIce()){
                res.setIsIce(req.getIsIce());
            }
            if (res.getIsTakeAway() != req.getIsTakeAway()){
                res.setIsTakeAway(req.getIsTakeAway());
            }
            res.setPrice(res.getPrice()+10);
            return coffeeMakerRepository.save(res);
        }
        throw new BadRequestException();
    }

    public void deleteOrder (Long id){
        coffeeMakerRepository.deleteById(id);
    }
}
