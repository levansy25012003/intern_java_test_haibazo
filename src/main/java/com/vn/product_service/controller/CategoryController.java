package com.vn.product_service.controller;

import com.vn.product_service.dto.response.ApiResponse;
import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getListCategory() {
        List<BaseResponse> categoryList = categoryService.getListCategory();

        ApiResponse<List<BaseResponse>> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(), // status code
                "Fetched category list successfully", // message
                categoryList
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
