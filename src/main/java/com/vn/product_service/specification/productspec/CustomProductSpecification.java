package com.vn.product_service.specification.productspec;

import com.vn.product_service.model.Color;
import com.vn.product_service.model.Product;
import com.vn.product_service.model.Size;
import jakarta.persistence.criteria.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SuppressWarnings("serial")
@RequiredArgsConstructor
public class CustomProductSpecification implements Specification<Product> {

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            Root<Product> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("categoryId")) {
            return criteriaBuilder.equal(root.get("category").get("id"), value.toString());
        }

        if (field.equalsIgnoreCase("styleId")) {
            return criteriaBuilder.equal(root.get("style").get("id"), value.toString());
        }


        if (field.equalsIgnoreCase("colorName")) {
            // Join với bảng `colors`
            Join<Product, Color> colorJoin = root.join("colors");
            return criteriaBuilder.equal(colorJoin.get("name"), value.toString());
        }

        if (field.equalsIgnoreCase("sizeNames")) {
            Join<Product, Size> sizeJoin = root.join("sizes");
            CriteriaBuilder.In<String> inClause = criteriaBuilder.in(sizeJoin.get("name"));
            for (String size : (List<String>) value) {
                inClause.value(size);
            }
            return inClause;
        }

        if (field.equalsIgnoreCase("price")) {
            return criteriaBuilder.equal(root.get("price"), Integer.parseInt(value.toString()));
        }

        return null;
    }
}
