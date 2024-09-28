package com.vn.product_service.dto.response.product;

import com.vn.product_service.model.Image;
import com.vn.product_service.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class ProductResponse {
    private int id;
    private String name;
    private BigDecimal rating;
    private int price;
    private int originalPrice;
    private String categoryName;
    private String styleName;
    private String urlImage;

    // Constructor
    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.rating = product.getRating();
        this.price = product.getPrice();
        this.originalPrice = product.getOriginalPrice();
        this.categoryName = product.getCategory().getName();  // Lấy tên Category
        this.styleName = product.getStyle().getName();
        // Lấy ảnh đầu tiên từ danh sách ảnh
        List<Image> images = product.getImages();
        this.urlImage = (images != null && !images.isEmpty()) ? images.get(0).getUrl() : null; // Lấy ảnh đầu tiên
    }
}
