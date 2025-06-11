package com.example.demo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SnackReq {
    private String name;
    private int price;
    private int amount;
}
