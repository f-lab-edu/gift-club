package com.giftclub.product;

import com.giftclub.product.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ProductMapper {
    final String insert = "INSERT INTO product(name,shop_id, description,discount,price) VALUES(#{product.name},#{product.shopId}, #{product.description},#{product.discount},#{product.price})";
    final String select = "SELECT * FROM product";
    final String getById = "SELECT * FROM product WHERE id=#{id}";
    final String getByShopId = "SELECT * FROM product WHERE shop_id=#{shopId}";


    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("product") Product product);


    @Select(select)
    @Results(id = "productMap",
            value = {@Result(property = "shopId", column = "shop_id")})
    List<Product> getAll();

    @Select(getById)
    @ResultMap("productMap")
    Product getById(@Param("id") int id);


    @Select(getByShopId)
    @ResultMap("productMap")
    List<Product> getByShopId(@Param("shopId") int shopId);


}
