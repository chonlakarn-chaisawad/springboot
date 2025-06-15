package com.example.demo.examRoom;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamRoomService {

    private final ExanRoomRepository exanRoomRepository;

    public ExamRoomModel createRoom(ExamBodyReq req) {
        ExamRoomModel examRoom = new ExamRoomModel();
        examRoom.setTeacherName(req.getTeacherName());
        examRoom.setSubject(req.getSubject());
        examRoom.setStudentAmount(req.getStudentAmount());
        return exanRoomRepository.save(examRoom);
    }

    public List<ExamRoomModel> getAll() {
        return exanRoomRepository.findAll();
    }

    public ExamRoomModel updateRoom(Long id, ExamBodyReq req) throws BadRequestException {
        Optional<ExamRoomModel> optionalRoom = exanRoomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            ExamRoomModel room = exanRoomRepository.getReferenceById(id);
            room.setTeacherName(req.getTeacherName());
            room.setSubject(req.getSubject());
            room.setStudentAmount(req.getStudentAmount());
            exanRoomRepository.save(room);
            return room;
        }
        throw new BadRequestException();
    }

    public void delete(Long id) {
        exanRoomRepository.deleteById(id);
    }
}
