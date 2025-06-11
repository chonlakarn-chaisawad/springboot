package com.example.demo.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExampleModelRepository extends JpaRepository<ExampleModel,Long> {
    //selete * from example_model where email =:email
    Optional<ExampleModel> findByEmail(String email);
    //conmention query
}
