package com.example.demo.snack;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snack")
@RequiredArgsConstructor
public class SnackController {
    private final SnackService snackService;
    //todo

    //get all snack from snack machine
//    API name : get snacks
//    endpoint : /snack
//    Method : GET
//    Header :
//    Request :
//    Response : [{id : , name : , price : , amount : }]
    @GetMapping()
    public List<SnackModel> getSnack() {
        List<SnackModel> res = snackService.getAll();
        return res;
    }

    //add new snack data in to snack machine ()
//    API name : create snack
//    endpoint : /snack
//    Method : POST
//    Header :
//    Request : {name : , price : , amount : }
//    Response : {id : , name : , price : , amount : }
    @PostMapping()
    public ResponseEntity<SnackModel> createSnack(@RequestBody SnackReq req) {
        SnackModel snackModel = snackService.createData(req);
        return ResponseEntity.ok(snackModel);
    }

    //    edit snack data from snack machine
//    API name : modify snack
//    endpoint : /snack/:id
//    Method : PATCH
//    Header :
//    Request : {name : || price : || amount : }
//    Response : {id : , name : , price : , amount : }
    @PatchMapping("/{id}")
    public ResponseEntity<SnackModel> updateSnack(@PathVariable Long id, @RequestBody SnackReq req) throws BadRequestException {
        SnackModel snackModel = snackService.updateData(id, req);
        return ResponseEntity.ok(snackModel);
    }
}
