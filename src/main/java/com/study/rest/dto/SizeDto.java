package com.study.rest.dto;

import com.study.rest.entity.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class SizeDto {

    @Builder
    @Data
    public static class Info {
        private int sizeId;
        private String sizeName;
    }

    @Builder
    @Data
    public static class ListResponse {
        List<Info> sizeList;
    }

    public static List<Info> toList(List<Size> sizeList) {
        return sizeList.stream().map(Size::toDto).collect(Collectors.toList());
    }
}
