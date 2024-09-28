package com.vn.product_service.service;

import com.vn.product_service.dto.response.BaseResponse;

import java.util.List;

public interface IStyleService {
    List<BaseResponse> getListStyle();
}