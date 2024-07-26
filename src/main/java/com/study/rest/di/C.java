package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // = bean : IOC에서 생성되어진
public class C {

    @Autowired(required = false)    // 주입 무조건 해줄 필요는 없다. 있어도 되고 없어도 되는경우에는 required = false를 걸어둠.
    private D d;

    public void cCall() {
        System.out.println("C 객체에서 메소드 호출");
        d.dCall();
    }
}
