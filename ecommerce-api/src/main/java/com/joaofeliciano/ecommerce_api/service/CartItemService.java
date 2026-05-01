package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.CartItemRequestDto;
import com.joaofeliciano.ecommerce_api.dto.CartItemResponseDto;
import com.joaofeliciano.ecommerce_api.entity.Cart;
import com.joaofeliciano.ecommerce_api.entity.CartItem;
import com.joaofeliciano.ecommerce_api.entity.Product;
import com.joaofeliciano.ecommerce_api.exception.InvalidCart;
import com.joaofeliciano.ecommerce_api.exception.InvalidId;
import com.joaofeliciano.ecommerce_api.exception.InvalidProduct;
import com.joaofeliciano.ecommerce_api.repository.CartItemRepository;
import com.joaofeliciano.ecommerce_api.repository.CartRepository;
import com.joaofeliciano.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    private CartItem toEntity(CartItemRequestDto dto){
        CartItem cartItem = new CartItem();
        Cart cart = cartRepository.findById(dto.getIdCart())
                .orElseThrow(() -> new RuntimeException("Cart not found."));
        Product product = productRepository.findById(dto.getIdProduct())
                .orElseThrow(() -> new RuntimeException("Product not found."));
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(dto.getQuantity());
        cartItem.setUnitaryPrice(product.getProductPrice());
        return cartItem;
    }

    private CartItemResponseDto toResponseDto(CartItem cartItem){
        return new CartItemResponseDto(
                cartItem.getIdItemCart(),
                cartItem.getCart().getIdCart(),
                cartItem.getProduct().getIdProduct(),
                cartItem.getQuantity(),
                cartItem.getUnitaryPrice()
        );
    }

    public CartItemResponseDto createItemCart(CartItemRequestDto dto) throws InvalidCart, InvalidProduct {
        if(!cartRepository.existsById(dto.getIdCart())){
            throw new InvalidCart("Your cart is invalid.");
        }
        if (!productRepository.existsById(dto.getIdProduct())) {
            throw new InvalidProduct("Product not found.");
        }
        CartItem cartItem = toEntity(dto);
        CartItem save = cartItemRepository.save(cartItem);
        return toResponseDto(save);
    }

    public CartItemResponseDto findById(Long id) throws InvalidId {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found."));
        return toResponseDto(cartItem);
    }

    public List<CartItemResponseDto> findAll(){
        return cartItemRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public CartItemResponseDto updateCartItem(Long id, CartItemRequestDto dto) throws InvalidCart, InvalidId{
        if(!cartRepository.existsById(dto.getIdCart())){
            throw new InvalidCart("Your cart is invalid.");
        }
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() ->  new InvalidId("Id not found."));
        cartItem.setQuantity(dto.getQuantity());
        CartItem updated = cartItemRepository.save(cartItem);
        return toResponseDto(updated);
    }

    public void deleteCartItem(Long id) throws InvalidId{
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found"));
        cartItemRepository.delete(cartItem);
    }
}