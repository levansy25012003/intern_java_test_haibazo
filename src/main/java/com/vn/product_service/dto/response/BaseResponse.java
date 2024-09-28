package com.vn.product_service.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BaseResponse {
    private int id;
    private String name;
}
