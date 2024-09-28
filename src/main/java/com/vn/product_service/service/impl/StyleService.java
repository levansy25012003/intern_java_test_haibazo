package com.vn.product_service.service.impl;

import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.model.Style;
import com.vn.product_service.repository.StyleRepository;
import com.vn.product_service.service.IStyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StyleService implements IStyleService {

    private final StyleRepository styleRepository;

    @Override
    public List<BaseResponse> getListStyle() {
        List<Style> styles = styleRepository.findAll();
        return styles.stream()
                .map(style -> BaseResponse.builder()
                        .id(style.getId())
                        .name(style.getName())
                        .build())
                .collect(Collectors.toList());
    }
}