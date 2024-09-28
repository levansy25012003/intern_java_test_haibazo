package com.vn.product_service.dto.response.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductDetailResponse {
    private int id;
    private String name;
    private String description;
    private BigDecimal rating;
    private int price;
    private int originalPrice;
    private int reviewCount;
    private int quantity;
    private LocalDateTime discountEnd;
    private List<String> codeColor;
    private List<String> size;
    private List<String> images;
}
