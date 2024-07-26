package com.study.rest.controller;

import com.study.rest.di.무기;
import com.study.rest.di.방패;
import com.study.rest.di.칼;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.TypedValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class 캐릭터 {

    @Autowired              // 공통적인 것들을 추상화시켜 분리한다.
    @Qualifier("칼")
    private 무기 weapon;

    @Autowired
    @Qualifier("물리공격방패")
    private 방패 shield;

    @Autowired
    private TypedValue typedValue;

    @ResponseBody
    @GetMapping("/maple/attack")
    public Object mapleAttack() {
        weapon.공격();

        return null;
    }

    @ResponseBody
    @GetMapping("/maple/defence")
    public Object mapleDefence() {
        shield.방어();

        return null;
    }
}
