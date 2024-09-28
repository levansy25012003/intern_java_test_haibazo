package com.vn.product_service.service.impl;

import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.model.Size;
import com.vn.product_service.model.Style;
import com.vn.product_service.repository.SizeRepository;
import com.vn.product_service.repository.StyleRepository;
import com.vn.product_service.service.ISizeService;
import com.vn.product_service.service.IStyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SizeService implements ISizeService {

    private final SizeRepository sizeRepository;

    @Override
    public List<BaseResponse> getListSize() {
        List<Size> sizes = sizeRepository.findAll();
        return sizes.stream()
                .map(size -> BaseResponse.builder()
                        .id(size.getId())
                        .name(size.getName())
                        .build())
                .collect(Collectors.toList());
    }
}