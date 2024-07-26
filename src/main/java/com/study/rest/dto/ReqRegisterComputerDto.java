package com.study.rest.dto;

import lombok.Data;

@Data   // react에서 컴퓨터 객체를 만들었고, Dto에서 요청받기 위해 Dto를 만듬
public class ReqRegisterComputerDto {
    private String company;
    private String cpu;
    private int ram;
    private int ssd;

}
