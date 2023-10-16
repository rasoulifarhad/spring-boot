package com.farhad.example.dddmonolithic.apis;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.dddmonolithic.apis.assembler.ProductAssembler;
import com.farhad.example.dddmonolithic.apis.dto.ProductCreationRequest;
import com.farhad.example.dddmonolithic.apis.dto.ProductResponse;
import com.farhad.example.dddmonolithic.application.ProductService;
import com.farhad.example.dddmonolithic.domain.model.product.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService  productService;
	private final ProductAssembler productAssembler;

    @GetMapping
	// @ApiOperation("Get all products")
    public List<ProductResponse> getAllProducts() {
        final List<Product> products = productService.getProducts();
        return productAssembler.toProductResponseList(products);
    }

    @GetMapping("/{productId}")
	// @ApiOperation("Get product by id")
	// @ApiImplicitParams	({
	// 	@ApiImplicitParam(name = "productId", required = true, defaultValue = "1") 
	// })
    public ProductResponse getProductById(@PathVariable("productId") final Long productId) {

        final Product product = productService.getProductById(productId);
        return productAssembler.toProductResponse(product);
    }


    @PostMapping
	// @ApiOperation("Create new product")
    public ProductResponse createProduct(@RequestBody ProductCreationRequest productCreationRequest) {
        Product product = productAssembler.toDomainObject(productCreationRequest);
        return productAssembler.toProductResponse(productService.save(product));
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable("productId") final Long productId,
                              @RequestBody ProductCreationRequest productUpdateRequest){
        Product newProduct = productAssembler.toDomainObject(productUpdateRequest);
        Product oldProduct = productService.getProductById(productId);
        if(newProduct.getName() != null){
            oldProduct.setName(newProduct.getName());
        }
        if(newProduct.getDescription() != null){
            oldProduct.setDescription(newProduct.getDescription());

        }
        if (newProduct.getPrice() != null) {
            oldProduct.setPrice(newProduct.getPrice());
        }
        productService.save(oldProduct);
    }	
}
