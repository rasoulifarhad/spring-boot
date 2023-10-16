package com.farhad.example.dddmonolithic.apis.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.farhad.example.dddmonolithic.apis.dto.ProductCreationRequest;
import com.farhad.example.dddmonolithic.apis.dto.ProductResponse;
import com.farhad.example.dddmonolithic.application.ProductFactory;
import com.farhad.example.dddmonolithic.domain.model.product.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductAssembler {
	
	protected static final ModelMapper mapper = new ModelMapper();

	private final ProductFactory productFactory;

	private final boolean isOnSale = false;

    public Product toDomainObject(ProductCreationRequest creationRequest) {
        return productFactory.create(creationRequest.getName(),
                creationRequest.getDescription(), creationRequest.getPrice(), isOnSale);
    }

    public ProductCreationRequest toDto(Product product) {
        return mapper.map(product, ProductCreationRequest.class);
    }

    public ProductResponse toProductResponse(Product product) {
        if (product != null) {
            return mapper.map(product, ProductResponse.class);
        } else {
            return null;
        }
    }

    public List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream()
                .map(c -> mapper.map(c, ProductResponse.class))
                .collect(Collectors.toList());
    }	
}
