package com.giftclub.shop;

import com.giftclub.shop.domain.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
@Slf4j
public class ShopController {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopService shopService;

    @PostMapping("")
    public Shop post(@RequestBody final Shop shop) {
        return shopService.add(shop);
    }

    @GetMapping("")
    public List<Shop> getAll() {
        // return shopService.getAll();
        for (final Shop s : shopMapper.getAll()) {
            log.info("degg", s.getId());
        }
        return shopMapper.getAll();
    }

    @GetMapping("/{id}")
    public Shop getById(@PathVariable("id") final int id) {
        return shopMapper.findShopById(id);
    }


    @PutMapping("")
    public int update(@RequestBody final Shop shop) {

        return shopMapper.update(shop);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") final int id) {
        shopMapper.deleteById(id);
    }
}
