package com.example.demo.coffeeMaker;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
        if (req.getIsSyrup()) {
            price += 5;
        }
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
        order.setPrice(price);
        coffeeMakerRepository.save(order);
        return order;
    }
}
