package com.example.demo.example;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

//    @GetMapping()
//    public String example() {
//        return "example controller";
//    }

    @GetMapping()
    public ResponseEntity<List<ExampleModel>> getExample() {
        List<ExampleModel> data = exampleService.getAllData();
        return ResponseEntity.ok(data);
    }

    @PostMapping()
    public ResponseEntity<ExampleModel> createExample(@RequestBody ExampleRequest req) {
        ExampleModel data = exampleService.createData(req);
        return ResponseEntity.status(200).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExampleModel> updateExample(@PathVariable long id, @RequestBody ExampleRequest req) throws BadRequestException {
        ExampleModel exampleModel = exampleService.updateData(id,req);
        return ResponseEntity.ok(exampleModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateExample(@PathVariable long id) {
        exampleService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}
