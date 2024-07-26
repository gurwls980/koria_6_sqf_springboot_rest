package com.study.rest.dto;

import com.study.rest.entity.Product;
import lombok.Builder;
import lombok.Data;

public class ProductDto {

    @Builder
    public static class CommonResponse {
        private String message;
        private int count;

        public static ProductDto.CommonResponse ofDefault(int count) {
            return CommonResponse.builder()
                    .message("Successfully")
                    .count(count)
                    .build();
        }
    }

    @Data
    public static class Register {
        private String productName;
        private int price;
        private int sizeId;
        private int colorId;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .price(price)
                    .sizeId(sizeId)
                    .colorId(colorId)
                    .build();
        }
    }
}
