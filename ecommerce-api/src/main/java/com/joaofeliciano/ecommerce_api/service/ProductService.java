package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.ProductRequestDto;
import com.joaofeliciano.ecommerce_api.dto.ProductResponseDto;
import com.joaofeliciano.ecommerce_api.entity.Category;
import com.joaofeliciano.ecommerce_api.entity.Product;
import com.joaofeliciano.ecommerce_api.exception.InvalidCategory;
import com.joaofeliciano.ecommerce_api.exception.InvalidId;
import com.joaofeliciano.ecommerce_api.exception.InvalidProduct;
import com.joaofeliciano.ecommerce_api.repository.CategoryRepository;
import com.joaofeliciano.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private Product toEntity(ProductRequestDto dto){
        Product product = new Product();
        Category category = categoryRepository.findById(dto.getIdCategory())
                .orElseThrow(() -> new RuntimeException("Category not found."));
        product.setProductName(dto.getProductName());
        product.setProductPrice(dto.getProductPrice());
        product.setActive(true);
        product.setDescription(dto.getDescription());
        product.setQuantityStock(dto.getQuantityStock());
        product.setCategory(category);
        return product;
    }

    private ProductResponseDto toResponseDto(Product product) {
        return new ProductResponseDto(
                product.getIdProduct(),
                product.getProductName(),
                product.getProductPrice(),
                product.getDescription(),
                product.isActive(),
                product.getQuantityStock(),
                product.getCreationDateProduct(),
                product.getCategory().getIdCategory()
        );
    }

    public ProductResponseDto createProduct(ProductRequestDto dto) throws InvalidCategory{
        if (!categoryRepository.existsById(dto.getIdCategory())) {
            throw new InvalidCategory("Category not found.");
        }
        Product product = toEntity(dto);
        Product saved = productRepository.save(product);
        return toResponseDto(saved);
    }

    public ProductResponseDto findById(Long id) throws InvalidId, InvalidProduct {
        if (!productRepository.existsById(id)) {
            throw new InvalidProduct("Product not found.");
        }
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Product not found."));
        return toResponseDto(product);
    }

    public List<ProductResponseDto> findAll() throws InvalidProduct {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new InvalidProduct("No products found.");
        }
        return products.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponseDto updateProduct(Long id, ProductRequestDto dto) throws InvalidId, InvalidProduct, InvalidCategory {
        if (!productRepository.existsById(id)) {
            throw new InvalidProduct("Product not found.");
        }
        if (!categoryRepository.existsById(dto.getIdCategory())) {
            throw new InvalidCategory("Category not found.");
        }
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Product not found."));
        product.setProductName(dto.getProductName());
        product.setProductPrice(dto.getProductPrice());
        product.setDescription(dto.getDescription());
        product.setQuantityStock(dto.getQuantityStock());
        Product updated = productRepository.save(product);
        return toResponseDto(updated);
    }

    public void deleteProduct(Long id) throws InvalidId {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Product not found."));
        productRepository.delete(product);
    }
}