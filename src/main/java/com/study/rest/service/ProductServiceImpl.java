package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;          // final 걸어줘도 되나?

    @Override
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<ColorDto.Info> getColorListAll() {

        return ColorDto.toList(colorMapper.findAll());
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {       // reqProductDto에 있는 것을 product 객체에 담아주는 과정
        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));     // 0 보다 크다는 것은 insert 가 되었다는 의미
    }

    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
//        Size size = Size.builder()
//                .sizeName(reqRegisterSizeDto.getSizeName())
//                .build();
//
//        int successCount = sizeMapper.save(size);
//        return CommonResponseDto.ofDefault(successCount);
        return CommonResponseDto.ofDefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }

    @Override
    public CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto) {
//        Color color = Color.builder()
//                .colorName(reqRegisterColorDto.getColorName())
//                .build();
//
//        int successCount = colorMapper.save(color);
//        return CommonResponseDto.ofDefault(successCount);
        return CommonResponseDto.ofDefault(colorMapper.save(reqRegisterColorDto.toEntity()));
    }
}
