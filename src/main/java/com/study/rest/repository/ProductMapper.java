package com.study.rest.repository;

import com.study.rest.entity.Color;
import com.study.rest.entity.Product;
import com.study.rest.entity.Size;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int save(Product product);      // insert, update, delete 는 리턴타입이 무조건 int.

}
