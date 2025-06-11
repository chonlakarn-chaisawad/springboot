package com.example.demo;

import com.example.demo.example.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SnackModelRepository extends JpaRepository<SnackModel,Long> {

}
