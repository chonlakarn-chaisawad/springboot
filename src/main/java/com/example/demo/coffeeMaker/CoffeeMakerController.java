package com.example.demo.coffeeMaker;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee-maker")
@RequiredArgsConstructor
public class CoffeeMakerController {

    private final CoffeeMakerService coffeeMakerService;

//    description req
//    String orderName = the name who order this coffee.
//    String size = what size that you want (S/M/L)?
//    Boolean isMilk = Do you want to add some milk?
//    Boolean isSyrup = Do you want to add some syrup?
//    int howSweet = How sweet do you want (0/25/50/75/100/200)%?
//    Boolean isIce = Do you want hot or iced coffee(hot:false iced:true)?
//    Boolean isTakeAway = Would you like to drink it here or take away?

    @PostMapping()
    public ResponseEntity<CoffeeMakerModel> createOrder(@RequestBody CoffeeMakerReq req) throws BadRequestException {
        CoffeeMakerModel res = coffeeMakerService.createOrder(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping()
    public ResponseEntity<List<CoffeeMakerModel>> getOrders() {
        List<CoffeeMakerModel> res = coffeeMakerService.getOrder();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeMakerModel> getOrderById(@PathVariable Long id) throws BadRequestException {
        CoffeeMakerModel res = coffeeMakerService.getOrderById(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoffeeMakerModel> updateOrder(@PathVariable Long id, @RequestBody CoffeeMakerReq req) throws BadRequestException {
        CoffeeMakerModel res = coffeeMakerService.updateOrder(id, req);
        return ResponseEntity.ok(res);
    }
}
