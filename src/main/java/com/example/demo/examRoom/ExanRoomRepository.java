package com.example.demo.examRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExanRoomRepository extends JpaRepository<ExamRoomModel, Long> {
}
