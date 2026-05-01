package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.CartRequestDto;
import com.joaofeliciano.ecommerce_api.dto.CartResponseDto;
import com.joaofeliciano.ecommerce_api.entity.Cart;
import com.joaofeliciano.ecommerce_api.entity.User;
import com.joaofeliciano.ecommerce_api.exception.InvalidId;
import com.joaofeliciano.ecommerce_api.exception.InvalidUser;
import com.joaofeliciano.ecommerce_api.repository.CartRepository;
import com.joaofeliciano.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        User user = userRepository.findById(dto.getIdUser())
                .orElseThrow(() -> new RuntimeException("User not found."));
        cart.setUser(user);
        cart.setCreationDateCart(LocalDateTime.now());
        return cart;
    }

    private CartResponseDto toResponseDto(Cart cart){
        return new CartResponseDto(
                cart.getIdCart(),
                cart.getUser().getIdUser(),
                cart.getCreationDateCart()
        );
    }

    public CartResponseDto createCart(CartRequestDto dto) throws InvalidUser{
        if(!userRepository.existsById(dto.getIdUser())){
            throw new InvalidUser("User not found.");
        }
        Cart cart = toEntity(dto);
        Cart saved = cartRepository.save(cart);
        return toResponseDto(saved);
    }

    public CartResponseDto findById(Long id) throws InvalidId{
        if(!cartRepository.existsById(id)){
            throw new InvalidId("User not found");
        }
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found."));

        return toResponseDto(cart);
    }

    public List<CartResponseDto> findAll(){
        return cartRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public CartResponseDto updateCart(Long id, CartRequestDto dto) throws InvalidId, InvalidUser{
        if(!userRepository.existsById(dto.getIdUser())){
            throw new InvalidUser("User not found");
        }
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found."));
        cart.setCreationDateCart(LocalDateTime.now());
        Cart updated = cartRepository.save(cart);
        return toResponseDto(updated);
    }

    public void deleleCart(Long id) throws InvalidId{
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found."));
        cartRepository.delete(cart);
    }
}