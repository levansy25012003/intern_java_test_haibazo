package com.vn.product_service.service;

import com.vn.product_service.dto.response.BaseResponse;
import com.vn.product_service.model.Category;

import java.util.List;

public interface ICategoryService {
    List<BaseResponse> getListCategory();
}
