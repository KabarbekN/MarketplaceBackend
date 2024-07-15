package kz.itstep.rest2.controller;

import jakarta.validation.Valid;
import kz.itstep.rest2.model.Product;
import kz.itstep.rest2.model.User;
import kz.itstep.rest2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product") // localhost:8080/product
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/") // localhost:8080/product/ GET
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.accepted().body(productService.getAllProducts());
    }

    @GetMapping("/{id}") // localhost:8080/product/856
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/") // localhost:8080/product/ POST
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PatchMapping("/{id}") // localhost:8080/product/ METHOD=PATCH
    public ResponseEntity<?> updateProduct(@Valid @PathVariable Long id ,@RequestBody Product product){
        return ResponseEntity.accepted().body(productService.updateProduct(id, product));
    }

    //    @DeleteMapping("/product/{id}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.accepted().body("User with id: " + id + " was deleted.");
    }




}
