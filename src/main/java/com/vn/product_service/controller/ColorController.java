package com.vn.product_service.controller;

import com.vn.product_service.dto.response.ApiResponse;
import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.service.IColorService;
import com.vn.product_service.service.ISizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/v1/color")
@RequiredArgsConstructor
public class ColorController {

    private final IColorService colorService;

    @GetMapping("")
    public ResponseEntity<?> getListColor() {
        List<BaseResponse> colorList = colorService.getListColor();

        ApiResponse<List<BaseResponse>> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Fetched color list successfully",
                colorList
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}