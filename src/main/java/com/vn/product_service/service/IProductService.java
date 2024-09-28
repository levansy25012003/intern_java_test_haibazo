package com.vn.product_service.service;

import com.vn.product_service.dto.response.product.ProductDetailResponse;
import com.vn.product_service.dto.response.product.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    Page<ProductResponse> getAllProduct(int pageNo, int pageSize, String color, Integer categoryId, Integer styleName, List<String> size, Integer price);

    ProductDetailResponse getProduct(Integer id);

}
