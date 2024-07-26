package com.study.rest.entity;

import com.study.rest.dto.SizeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Size {
    private int sizeId;
    private String sizeName;

    public SizeDto.Info toDto() {       // entity에 있는 Dto를 xx로 변환
        return SizeDto.Info.builder()
                .sizeId(sizeId)
                .sizeName(sizeName)
                .build();
    }
}
