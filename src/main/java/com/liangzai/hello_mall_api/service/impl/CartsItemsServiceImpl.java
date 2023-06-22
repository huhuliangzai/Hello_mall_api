package com.liangzai.hello_mall_api.service.impl;

import com.liangzai.hello_mall_api.common.api.Result;
import com.liangzai.hello_mall_api.common.util.CopyUtil;
import com.liangzai.hello_mall_api.entity.dto.InsertCartItemDto;
import com.liangzai.hello_mall_api.entity.mbg.Carts;
import com.liangzai.hello_mall_api.entity.mbg.CartsItems;
import com.liangzai.hello_mall_api.entity.mbg.Products;
import com.liangzai.hello_mall_api.entity.mbg.Users;
import com.liangzai.hello_mall_api.mapper.CartsItemsMapper;
import com.liangzai.hello_mall_api.mapper.CartsMapper;
import com.liangzai.hello_mall_api.mapper.ProductsMapper;
import com.liangzai.hello_mall_api.service.CartsItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-05-26
 */
@Service
public class CartsItemsServiceImpl extends ServiceImpl<CartsItemsMapper, CartsItems> implements CartsItemsService {

    @Autowired
    private CartsMapper cartsMapper;
    @Autowired
    private CartsItemsMapper cartsItemsMapper;
    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public Result getCartsItemByUser(Users users) {
        Long userId = users.getId();
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<Carts> carts = cartsMapper.selectByMap(map);
        Long cartsId = carts.get(0).getId();

        HashMap<String,Object> cartItems_map = new HashMap<>();
        cartItems_map.put("cart_id", cartsId);
        List<CartsItems> cartItems = cartsItemsMapper.selectByMap(cartItems_map);
        if (CollectionUtils.isEmpty(cartItems)) {
            return Result.fail(400, "No cart items");
        }
            return Result.succ(200,"Success",cartItems);
    }

    @Override
    public Boolean deleteCartsItem(CartsItems cartsItems) {
        Long carItemId = cartsItems.getId();
        boolean u = cartsItemsMapper.deleteById(carItemId) >1;
        return u;
    }

    @Override
    public Result insertCartsItem(InsertCartItemDto insertCartItemDto) {
        CartsItems cartsItems = CopyUtil.copy(insertCartItemDto, CartsItems.class);

        HashMap<String,Object> cart_map = new HashMap<>();
        cart_map.put("user_id", insertCartItemDto.getUserId());
        List<Carts> carts = cartsMapper.selectByMap(cart_map);
        cartsItems.setCartId(carts.get(0).getId());

        HashMap<String,Object> product_map = new HashMap<>();
        product_map.put("id", insertCartItemDto.getProductId());
        List<Products> products = productsMapper.selectByMap(product_map);
        cartsItems.setProductName(products.get(0).getName());
        cartsItems.setImage(products.get(0).getImage());
        cartsItems.setProductPrice(products.get(0).getPrice());

        System.out.println(cartsItems);
        int insert = cartsItemsMapper.insert(cartsItems);
        return insert >= 1 ?
                Result.succ(200,"success",null) : Result.fail(400,"error",null);
    }
}