package kz.itstep.rest2.resources;

import kz.itstep.rest2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;

    @GetMapping("/products")
    public String getAllProductsPage(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "product/products";
    }

    @GetMapping("/products/details/{id}")
    public String getProductDetailsPageById(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product/details";
    }
}
