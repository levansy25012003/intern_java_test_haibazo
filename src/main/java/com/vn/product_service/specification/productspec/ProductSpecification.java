package com.vn.product_service.specification.productspec;

import com.vn.product_service.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.List;

@SuppressWarnings("deprecation")
public class ProductSpecification {

    public static Specification<Product> buildWhere(String color, Integer categoryId, Integer  styleId, List<String> sizes, Integer price) {

        Specification<Product> where = null;
        if (!StringUtils.isEmpty(color)) {
            color = color.trim();
            CustomProductSpecification colorSpec = new CustomProductSpecification("colorName", color);
            where = Specification.where(colorSpec);
        }

        if (categoryId != null && categoryId > 0) {
            CustomProductSpecification categorySpec = new CustomProductSpecification("categoryId", categoryId);
            where = (where == null) ? Specification.where(categorySpec) : where.and(categorySpec);
        }

        if (styleId != null && styleId > 0) {
            CustomProductSpecification styleSpec = new CustomProductSpecification("styleId", styleId);
            where = (where == null) ? Specification.where(styleSpec) : where.and(styleSpec);
        }

        if (sizes != null && !sizes.isEmpty()) {
            CustomProductSpecification sizeSpec = new CustomProductSpecification("sizeNames", sizes);
            where = (where == null) ? Specification.where(sizeSpec) : where.and(sizeSpec);
        }

        if (price != null && price > 0) {
            CustomProductSpecification priceSpec = new CustomProductSpecification("price", price);
            where = (where == null) ? Specification.where(priceSpec) : where.and(priceSpec);
        }
        return where;
    }
}
