package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.CartRequestDto;
import com.joaofeliciano.ecommerce_api.dto.CartResponseDto;
import com.joaofeliciano.ecommerce_api.entity.Cart;
import com.joaofeliciano.ecommerce_api.repository.CartRepository;
import com.joaofeliciano.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    private Cart toEntity(CartRequestDto dto){
        Cart cart = new Cart();
        cart.setIdCart(dto.getIdUser());
        cart.setCreationDateCart(LocalDateTime.now());
        return cart;
    }

    private CartResponseDto toResponseDto(Cart cart){
        return new CartResponseDto();
    }
}
