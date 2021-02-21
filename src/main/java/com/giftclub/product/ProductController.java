package com.giftclub.product;

import com.giftclub.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @PostMapping("")
    public Product post(@RequestBody final Product product) {
        productMapper.insert(product);
        return product;
    }

    @GetMapping("")
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") final int id) {
        return productMapper.getById(id);
    }
}
