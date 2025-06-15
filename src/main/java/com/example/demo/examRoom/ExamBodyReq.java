package com.example.demo.examRoom;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamBodyReq {
    private String teacherName;
    private String studentAmount;
    private String subject;
}
