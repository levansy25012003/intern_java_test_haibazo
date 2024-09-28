package com.vn.product_service.dto.response.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageResponse<T> {
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private long totalElements;
    private List<T> items;
}
