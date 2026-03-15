package sn.isi.l3gl.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.dto.ProductDTO;
import sn.isi.l3gl.core.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> listProducts() {
        return productService.listProducts();
    }

    @PutMapping("/{id}")
    public ProductDTO updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        return productService.updateQuantity(id, quantity);
    }

    @GetMapping("/low-stock/count")
    public long countLowStockProducts(@RequestParam Integer threshold) {
        return productService.countLowStockProducts(threshold);
    }
}
