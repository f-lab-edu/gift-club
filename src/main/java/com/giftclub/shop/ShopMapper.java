package com.giftclub.shop;

import com.giftclub.shop.domain.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopMapper {
    final String getAll = "SELECT * FROM shop";
    final String getById = "SELECT * FROM shop WHERE id=#{id}";
    final String deleteById = "DELETE from shop WHERE id= #{id}";
    final String insert = "INSERT INTO shop(name, description) VALUES(#{shop.name}, #{shop.description})";
    final String update = "UPDATE shop SET name = #{shop.name}, description = #{shop.description} WHERE id= #{shop.id}";

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
        // 생성된 키를 가지고, "id" 에 대한 property 를 주세요.
    int insert(@Param("shop") Shop shop);

    @Select("SELECT * FROM shop")
    @Results(id = "shopMapper", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "productList", column = "id", many = @Many(select = "com.giftclub.product.ProductMapper.getByShopId")),
    })
    List<Shop> getAll();

    @Select(getById)
    @ResultMap("shopMapper")
    Shop findShopById(@Param("id") int id);

    @Update(update)
    int update(@Param("shop") Shop shop);

    @Delete(deleteById)
    void deleteById(@Param("id") int id);

}


