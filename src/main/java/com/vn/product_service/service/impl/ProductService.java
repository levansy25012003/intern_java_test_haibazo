package com.vn.product_service.service.impl;

import com.vn.product_service.dto.response.product.ProductDetailResponse;
import com.vn.product_service.dto.response.product.ProductResponse;
import com.vn.product_service.model.Product;
import com.vn.product_service.repository.ProductRepository;
import com.vn.product_service.service.IProductService;
import com.vn.product_service.specification.productspec.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductResponse> getAllProduct(int pageNo, int pageSize, String color, Integer categoryId,
                                               Integer styleName, List<String> sizes, Integer price) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        Specification<Product> where = ProductSpecification.buildWhere(color, categoryId, styleName, sizes, price);

        Page<Product> productList = productRepository.findAll(where, pageable);

        Page<ProductResponse> productResponseList = productList.map(product -> new ProductResponse(product));

        return productResponseList;
    }

    @Override
    public ProductDetailResponse getProduct(Integer id) {

        Optional<Product> productOptional = productRepository.findById(id);

        // Kiểm tra xem sản phẩm có tồn tại không
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return ProductDetailResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .rating(product.getRating())
                    .price(product.getPrice())
                    .originalPrice(product.getOriginalPrice())
                    .reviewCount(product.getReviewCount())
                    .discountEnd(product.getDiscountEnd())
                    .quantity(product.getQuantity())
                    .codeColor(product.getColors().stream()
                            .map(color -> color.getCode()) // Giả định rằng color có phương thức getCode()
                            .collect(Collectors.toList()))
                    .size(product.getSizes().stream()
                            .map(size -> size.getName()) // Giả định rằng size có phương thức getName()
                            .collect(Collectors.toList()))
                    .images(product.getImages().stream()
                            .map(image -> image.getUrl()) // Giả định rằng image có phương thức getUrl()
                            .collect(Collectors.toList()))
                .build();
        }
        return null;
    }
}
