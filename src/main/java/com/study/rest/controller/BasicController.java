package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// REST API : 데이터 응답, view 를 리턴하더라도 데이터로 볼 것이다. 또한 주소(URL)에는 '동사'가 들어가지 않도록 한다.
@RestController     // 응답하는 것이 데이터만 받는 요청을 RestController 라고 한다. view 리턴을 안한다.
@Slf4j              // log 를 찍는 컴포넌트
public class BasicController {

    @Autowired
    private ProductService productService;

    //    @ResponseBody       // view 응답이 없다 => 데이터 응답만 해줄 것이다.
    @PostMapping("/basic/student")      // PostMapping 은 '추가'를 의미하겠다.
    @CrossOrigin
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {     // 여기서 어노테이션 RequestBody 가 있어야 JSON 으로 바꿔준다 ! 중요 ! 데이터가 json 이면 무조건 @RequestBody 로 써줘야 함. 요청 데이터니까.
        log.info("Student : {}", reqStudentDto);  // "{}", x 는 {} 안에 x 가 들어간다.
        return ResponseEntity.ok().body(reqStudentDto);       // 요청으로 들어온 데이터를 그대로 응답해 주겠다. 객체 형태로 응답해줘야 한다. // .ok() 는 상태코드가 200을 의미함
    }

    /*
    *   REST API
    *
    *   데이터 통신을 위한 HTTP 요청 방식
    *   HTTP 프로토콜을 조금 더 잘 쓰기 위해서 정의된 개념
    *
    *   1. 요청에 대한 동작은 무조건 메소드에 따라서 정의하자.
    *    - 데이터 추가(등록)는 POST 요청으로 하자. 그리고 POST 요청은 JSON 데이터로 요청하자.
    *    - 데이터 조회는 GET 요청으로 하자. 그리고 GET 요청은 QueryString(params) 으로 요청하자.
    *       ex) QueryString(params) : 주소?key1=value1&key2=value2
    *    - 데이터 수정은 PUT, PATCH 요청으로 하자. JSON 으로 요청하자.
    *       PUT 요청과 PATCH 요청의 차이점
    *           PUT 요청 : 공백 또는 NULL 인 데이터도 수정을 함
    *           PATCH 요청 : 공백 또는 NULL 인 데이터는 수정하지 않음. 공백이나 NULL 이 넘어오면 기존 데이터를 유지함.
    *    - 데이터 삭제는 DELETE 요청으로 하자. params 로 요청하자.
    *
    *   2. 주소(URL) 요청 메세지(Resource) 자원 작성법
    *    - URL 은 가능한 동사를 사용하지 않는다.
    *    - 계층 구조로 작성한다.
    *       ex) /집/주방/가스레인지, /식당/주방/가스레인지
    *    - 요청 메소드 마다 작성하는 방법이 다르다.
    *       상품 등록(POST) : /product
    *       상품 한개(단건) 조회(GET) : /product/1(id, key)
    *       상품 여러개(다건) 조회(GET) : /products(전체), /products?page=1&count=30(한페이지에 30개씩 조회)
    *       상품 수정(PUT) : /product/1(id, key)
    *       상품 삭제(DELETE) : /product/1(id, key)
    *
    *   3. 주소는 가능한 대문자를 사용하지 않는다.
    *
    */


    // Controller(Dto service 에 전송) -> Service(Dto 를 Entity로 변환해서 repository 에 전송) -> repository
    // xml 에서 리턴해 줄때는 Entity 객체로, Service에서 Entity를 Dto로 변환해서 Dto를 controller에 보내줌. 응답은 Dto로
    // 이걸 왜 하는거냐? 했더니 Dto에서 필요한 자료들만 뽑아서 Entity로 옮긴 후 정제를 하는 과정
    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register ) {
        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> responseEntity(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        log.info("{}", reqRegisterSizeDto);
        return ResponseEntity.ok().body(productService.registerSize(reqRegisterSizeDto));
    }

    @CrossOrigin
    @PostMapping("/api/v1/color")
    public ResponseEntity<?> responseEntity(@RequestBody ReqRegisterColorDto reqRegisterColorDto) {
        log.info("{}", reqRegisterColorDto);
        return ResponseEntity.ok().body(productService.registerColor(reqRegisterColorDto));
    }

}
