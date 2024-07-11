package kz.itstep.rest2.service;

import kz.itstep.rest2.exceptions.ProductNotFoundException;
import kz.itstep.rest2.model.Product;
import kz.itstep.rest2.model.User;

import java.util.List;

public interface ProductService {
    Product getProductById(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product product);
    void deleteProduct(Long productId);
    List<Product> getAllProducts();

}
