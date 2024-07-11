package kz.itstep.rest2.resources;

import kz.itstep.rest2.model.Product;
import kz.itstep.rest2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;

    @GetMapping("")
    public String getAllProductsPage(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "product/products";
    }

    @GetMapping("/details/{id}")
    public String getProductDetailsPageById(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product/details";
    }

    @GetMapping("/create-product")
    public String createProductPage(Model model){
        model.addAttribute("product", new Product());
        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product){
        return "/product/products";
    }
}
