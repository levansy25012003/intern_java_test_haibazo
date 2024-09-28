package com.vn.product_service.controller;


import com.vn.product_service.dto.response.ApiResponse;
import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.service.IStyleService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/style")
@RequiredArgsConstructor
public class StyleController {
    private final IStyleService styleService;

    @GetMapping("")
    public ResponseEntity<?> getListStyle() {
        List<BaseResponse> styleList = styleService.getListStyle();

        ApiResponse<List<BaseResponse>> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Fetched style list successfully",
                styleList
        );

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
