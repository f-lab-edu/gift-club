package com.giftclub.product;

import com.giftclub.member.MemberRole;
import com.giftclub.member.aop.MemberRoleCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @MemberRoleCheck(memberRole = MemberRole.SELLER)
    public void insertProduct(@RequestBody Product product) {
        productService.insertProduct(product);
    }
}
