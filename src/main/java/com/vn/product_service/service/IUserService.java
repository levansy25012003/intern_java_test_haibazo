package com.vn.product_service.service;

import com.vn.product_service.exception.DataNotFoundException;
import io.jsonwebtoken.Claims;

public interface IUserService {
    String login (String phoneNumber, String password) throws Exception;
}
