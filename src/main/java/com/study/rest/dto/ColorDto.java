package com.study.rest.dto;

import com.study.rest.entity.Color;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class ColorDto {

    @Builder
    @Data
    public static class Info {
        private int colorId;
        private String colorName;
    }

    @Builder
    @Data
    public static class ListResponse {
        List<Info> colorList;
    }

    public static List<Info> toList(List<Color> colorList) {
        return colorList.stream().map(Color::toDto).collect(Collectors.toList());
    }
}
