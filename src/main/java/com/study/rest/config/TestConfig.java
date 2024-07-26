package com.study.rest.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.TypedValue;

@Configuration
public class TestConfig {

    @Bean                                   // bean 어노테이션은 configuration 안에서 가능
    public TypedValue typedValue() {        // bean 객체 생성
        return new TypedValue(null);        // => IoC에 bean 등록
    }
}
