package com.vn.product_service.service.impl;

import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.model.Color;
import com.vn.product_service.repository.ColorRepository;
import com.vn.product_service.service.IColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService implements IColorService {

    private final ColorRepository colorRepository;

    @Override
    public List<BaseResponse> getListColor() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream()
                .map(color -> BaseResponse.builder()
                        .id(color.getId())
                        .name(color.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
