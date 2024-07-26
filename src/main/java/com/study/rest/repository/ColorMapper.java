package com.study.rest.repository;

import com.study.rest.entity.Color;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColorMapper {
    int save(Color color);
    List<Color> findAll();
//    Color findAll();  // 얘는 단건조회
}
