package com.study.rest.entity;

import com.study.rest.dto.ColorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Color {
    private int colorId;
    private String colorName;

    public ColorDto.Info toDto() {
        return ColorDto.Info.builder()
                .colorId(colorId)
                .colorName(colorName)
                .build();
    }
}
