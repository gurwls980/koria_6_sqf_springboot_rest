package com.study.rest.dto;

import lombok.Data;


@Data       // toString, Setter가 필요하기 때문에 Data 어노테이션을 가져온 것. Dto는 무조건 dada 어노테이션을 달아주자
public class ReqStudentDto {
    private String schoolName;
    private String department;
    private int grade;
    private String name;
}
