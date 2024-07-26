package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.RespGetListDto;
import com.study.rest.service.ComputerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ComputerController {

    @Autowired
    private ComputerServiceImpl computerService;

    @PostMapping("/computer")
    public ResponseEntity<?> registerApi(@RequestBody ReqRegisterComputerDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.registerComputer(reqDto));
    }

    public ResponseEntity<?> modifyApi() {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/computers")       // get 요청은 JSON(객체를 문자열로 바꿔주는 친구)이 아니기 때문에 @RequestBody를 붙여주지 않고, params로 받는다.
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }

    //http://localhost:8080/api/v1/computer/1 or 2 or 3 등 경로자체에 변수를 써주는 것
    @GetMapping("/computer/{computerId}")
    public ResponseEntity<?> getApi(@PathVariable int computerId) {
        log.info("{}", computerId);
        return ResponseEntity.ok().body(computerService.getComputer(computerId));
    }

    public ResponseEntity<?> removeApi() {
        return ResponseEntity.ok().body(null);
    }
}
