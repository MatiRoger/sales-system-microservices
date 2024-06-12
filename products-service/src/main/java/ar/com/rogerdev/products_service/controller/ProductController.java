package ar.com.rogerdev.products_service.controller;

import ar.com.rogerdev.products_service.dto.ProductDTO;
import ar.com.rogerdev.products_service.model.Product;
import ar.com.rogerdev.products_service.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productServ;

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productData, UriComponentsBuilder uriComponentsBuilder) {

        Product newProduct = productServ.saveProduct(productData);
        URI url = uriComponentsBuilder.path("/products/{productCode}").buildAndExpand(newProduct.getProduct_code()).toUri();
        return ResponseEntity.created(url).body(new ProductDTO(newProduct));
    }
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts (Pageable pagination) {
        return ResponseEntity.ok().body(productServ.getProducts(pagination).map(ProductDTO::new));
    }
    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDTO> findProductByCode (@PathVariable String productCode){
        Product foundProduct = productServ.findProductByCode(productCode);
        return ResponseEntity.ok().body(new ProductDTO(foundProduct));
    }
    @DeleteMapping("/{productCode}")
    @Transactional
    public ResponseEntity deleteProductByCode (@PathVariable String productCode) {
        productServ.deleteProductByCode(productCode);
        return ResponseEntity.noContent().build();
    }
}
