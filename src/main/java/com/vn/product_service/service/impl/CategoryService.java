package com.vn.product_service.service.impl;

import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.model.Category;
import com.vn.product_service.repository.CategoryRepository;
import com.vn.product_service.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<BaseResponse> getListCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<BaseResponse> baseResponses = categories.stream()
                .map(category -> BaseResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .collect(Collectors.toList());
        return baseResponses;
    }
}
