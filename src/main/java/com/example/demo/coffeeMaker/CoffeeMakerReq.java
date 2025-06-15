package com.example.demo.coffeeMaker;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeMakerReq {
    private String orderName;
    private String size;
    private Boolean isMilk = false;
    private Boolean isSyrup = false;
    private int howSweet;
    private Boolean isIce = false;
    private Boolean isTakeAway = false;
}
