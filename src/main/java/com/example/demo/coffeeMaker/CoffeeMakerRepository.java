package com.example.demo.coffeeMaker;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeMakerRepository extends JpaRepository<CoffeeMakerModel,Long> {
}
