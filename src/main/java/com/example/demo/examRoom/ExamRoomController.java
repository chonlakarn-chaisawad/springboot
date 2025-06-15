package com.example.demo.examRoom;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class ExamRoomController {
    private final ExamRoomService examRoomService;

    @PostMapping()
    public ResponseEntity<ExamRoomModel> createExamRoom(@RequestBody ExamBodyReq req) {
        ExamRoomModel res = examRoomService.createRoom(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping()
    public ResponseEntity<List<ExamRoomModel>> getAllExamRoom() {
        List<ExamRoomModel> res = examRoomService.getAll();
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamRoomModel> updateExamRoom(@PathVariable Long id, @RequestBody ExamBodyReq req) throws BadRequestException {
        ExamRoomModel examRoomModel = examRoomService.updateRoom(id, req);
        return ResponseEntity.ok(examRoomModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        examRoomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
