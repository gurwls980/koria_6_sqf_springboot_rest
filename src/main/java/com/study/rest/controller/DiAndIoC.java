package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiAndIoC {

    @Autowired  // autowired 는 사용에 제약이 없는건가? 쓸 수 없는 경우는 없나? = 객체가 있으면 어디서나 쓸 수 있음 ㅇㅇ
    private C c;

    @Autowired
    @Qualifier("ts")
    private TestService testService1;

    @Autowired
    @Qualifier("newTestServiceImpl")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        // A가 B를 의존하는 관계, 외부에서 주입되어졌기 때문에 의존성이 낮은 관계
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;    //  => return null;을 없애고 void로 하면 차이점이??
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }
        return null;

//        testService1.test();
//        testService2.test();
//
//        return null;
    }
}

