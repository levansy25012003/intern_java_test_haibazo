package com.vn.product_service.service.impl;

import com.vn.product_service.exception.DataNotFoundException;
import com.vn.product_service.model.User;
import com.vn.product_service.repository.ProductRepository;
import com.vn.product_service.repository.UserRepository;
import com.vn.product_service.service.IJwtService;
import com.vn.product_service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;


    @Override
    public String login(String phoneNumber, String password) throws Exception {
        Optional<User> optUser = userRepository.findByPhoneNumber(phoneNumber);

        // Kiểm tra tài khoản.
        if (optUser.isEmpty()) {
            throw new DataNotFoundException("Invalid phone number/password.");
        }

        // Kiểm tra mật khẩu.
        if (!passwordEncoder.matches(password, optUser.get().getPassword())) {
            throw new BadCredentialsException("Invalid phone number/password.");
        }
        User user = optUser.get();

        // Authentication
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                phoneNumber, password, user.getAuthorities());
        authenticationManager.authenticate(authenticationToken);
        return jwtService.generateToken(user);
    }
}
