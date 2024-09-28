package com.vn.product_service.controller;

import com.vn.product_service.dto.response.ApiResponse;
import com.vn.product_service.dto.response.product.PageResponse;
import com.vn.product_service.dto.response.product.ProductDetailResponse;
import com.vn.product_service.dto.response.product.ProductResponse;
import com.vn.product_service.service.IProductService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final IProductService productService;

    @GetMapping(value = "")
    public ResponseEntity<?> getListProduct(@RequestParam(defaultValue = "0") int pageNo,
                                            @RequestParam(defaultValue = "5") int pageSize,
                                            @RequestParam(required = false) String color,
                                            @RequestParam(required = false) Integer categoryId,
                                            @RequestParam(required = false) Integer styleId,
                                            @RequestParam(required = false) List<String> size,
                                            @RequestParam(required = false) Integer price
                                            ) {
        // Lấy dữ liệu sản phầm
        Page<ProductResponse> productDTO = productService.getAllProduct(pageNo, pageSize, color, categoryId, styleId, size, price);

        // Xây dựng thông tin phân trang
        PageResponse<ProductResponse> pageResponse = PageResponse.<ProductResponse>builder()
                .pageNo(productDTO.getPageable().getPageNumber())
                .pageSize(productDTO.getPageable().getPageSize())
                .totalPage(productDTO.getTotalPages())
                .totalElements(productDTO.getTotalElements())
                .items(productDTO.getContent())
                .build();

        // Tạo 1 phản hồi API chuẩn với status code, message và data.
        ApiResponse<PageResponse<ProductResponse>> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(), // status code
                "Fetched product list successfully", // message
                pageResponse // data
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") @Min(value = 0, message = "Product ID must be non-negative") Integer productId) {
         ProductDetailResponse productDetailResponse = productService.getProduct(productId);
         ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>(
                 HttpStatus.OK.value(),
                 "Fetched product successfully",
                 productDetailResponse
         );
         return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
