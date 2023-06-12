package com.liangzai.hello_mall_api;


import com.liangzai.hello_mall_api.entity.mbg.*;
import com.liangzai.hello_mall_api.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class HelloMallApiApplicationTests {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CarouselMapper carouselMapper;
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private CartsMapper cartsMapper;
    @Autowired
    private CartsItemsMapper cartItemsMapper;
    @Autowired
    private  OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    @Test
    void testGetAll() {
        List<Users> usersList = usersMapper.selectList(null);
        System.out.println(usersList);
    }

    @Test
    void getCarsoulImg(){
        List<CarouselImg> carsoulImgs = carouselMapper.selectList(null);
        System.out.println(carsoulImgs);
    }

    @Test
    void getAllCategory(){
        List<Categories> categories = categoriesMapper.selectList(null);
        System.out.println(categories);
    }

    @Test
    void getAllAddress(){
        List<UserAddress> addresses = userAddressMapper.selectList(null);
        System.out.println(addresses);
    }

    @Test
    void getProductByCategoryName(){
        HashMap<String, Object> category_map = new HashMap<>();
        category_map.put("category_name","牛肉类");
        List<Categories> categories = categoriesMapper.selectByMap(category_map);
        categories.forEach(System.out::println);
        Long categoryId = categories.get(0).getId();
        System.out.println("分类ID是："+categoryId);

        HashMap<String,Object> product_map = new HashMap<>();
        product_map.put("category_id", categoryId);
        List<Products> products = productsMapper.selectByMap(product_map);
        products.forEach(System.out::println);
    }

    @Test
    void getHotSaleProducts(){
        HashMap<String, Object> category_map = new HashMap<>();
        category_map.put("category_name","热销");
        List<Categories> categories = categoriesMapper.selectByMap(category_map);
        categories.forEach(System.out::println);
        Long categoryId = categories.get(0).getId();
        System.out.println("分类ID是："+categoryId);

        HashMap<String,Object> product_map = new HashMap<>();
        product_map.put("category_id", categoryId);
        List<Products> products = productsMapper.selectByMap(product_map);
        products.forEach(System.out::println);
    }

    @Test
    void selectCartsByUser(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id", "1");
        List<Carts> carts = cartsMapper.selectByMap(map);
        System.out.println(carts);
    }

    @Test
    void selectCartsItemByUser(){
        HashMap<String,Object> cart_map = new HashMap<>();
        cart_map.put("user_id", "1");
        List<Carts> carts = cartsMapper.selectByMap(cart_map);
        System.out.println(carts);
        Long cartId = carts.get(0).getId();

        HashMap<String,Object> cartItem_map = new HashMap<>();
        cartItem_map.put("cart_id", cartId);
        List<CartsItems> cartItems = cartItemsMapper.selectByMap(cartItem_map);
        System.out.println(cartItems);
    }

    @Test
    void selectOrdersByUserId(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id","1");
        List<Orders> orders = ordersMapper.selectByMap(map);
        orders.forEach(System.out::println);
        List<Long> order_id = new ArrayList<>();
        for(int i = 0; i < orders.size(); i++){
            order_id.add(orders.get(i).getId());
        }
        System.out.println(order_id);
    }

    @Test
    void selectOrderDetailsByOrderId(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id","1");
        List<Orders> orders = ordersMapper.selectByMap(map);
        System.out.println(orders);
        HashMap<String,Object> order_map = new HashMap<>();
        List<Object> allOrders = new ArrayList<>();
        for(int i = 0; i < orders.size(); i++){
            Long order_id = orders.get(i).getId();
            order_map.put("order_id", order_id);
            List<OrderDetails> orderList = orderDetailsMapper.selectByMap(order_map);
            allOrders.add(orderList);
        }
        System.out.println(allOrders);
    }

    @Test
    void getAllCollection(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id","1");
        List<Collection> AllCollection = collectionMapper.selectByMap(map);
        System.out.println(AllCollection);
        List<Long> proId = new ArrayList<>();
        for(int i = 0; i < AllCollection.size(); i++){
            proId.add(AllCollection.get(i).getProductId());
        }
        List<Products> product = productsMapper.selectBatchIds(proId);
        System.out.println(product);
    }

    @Test
    void deleteProduct(){
        Long carItemId = 3L;
        cartItemsMapper.deleteById(carItemId);
    }

}
