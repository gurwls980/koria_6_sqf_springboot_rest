package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl {

    @Autowired
    private ComputerMapper computerMapper;

    public int registerComputer(ReqRegisterComputerDto reqDto) {
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.save(computer);
    }

    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
        List<RespGetListDto> respDtos = new ArrayList<>();

        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .build();

        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);

        for(Computer com : computers) {     // stream 을 사용하면 한줄로 만들 수 있는 것을 풀어서 쓴 것
            RespGetListDto dto = RespGetListDto.builder()   // toEntity는 직관적으로 Entity로 보낸다고 해석해도 되나?
                    .computerId(com.getComputerId())
                    .company(com.getCompany())
                    .build();

            respDtos.add(dto);
        }

        return respDtos;
    }

    // getComputerList 1과 2는 같은 구문. stream을 사용하면 코드를 많이 줄일 수 있음
    public List<RespGetListDto> getComputerList2(ReqGetListDto reqDto) {

        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .build();

        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);


        return computers.stream().map(com -> RespGetListDto.builder()
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
            ).collect(Collectors.toList());
    }

    public RespGetComputerDto getComputer(int computerId) {
        Computer computer = computerMapper.findComputerById(computerId);
        return RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    public int deleteComputer(int computerId) {

        return computerMapper.delete(computerId);
    }

    public int updateComputer(ReqUpdateComputerDto reqDto) {
        Computer computer = Computer.builder()
                .computerId(reqDto.getComputerId())
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();
        return computerMapper.update(computer);
    }

}
