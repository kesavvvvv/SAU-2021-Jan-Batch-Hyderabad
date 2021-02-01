package com.example.spring.controller;



import com.example.spring.model.Items;
import com.example.spring.model.Orders;
import com.example.spring.service.OrderService;
import com.example.spring.controller.OrderController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderServices;

//    @Test
//    void createNewOrderTest() {
//        Mockito.when(orderServices.createNewOrder(Mockito.any(Order.class))).thenReturn(1);
//        List<Item> itemList = new ArrayList<>();
//        Order order = new Order();
//        order.setOrderId(1);
//        order.setItems(itemList);
//        int response = orderController.createNewOrder(order);
//        Assertions.assertEquals(order.getOrderId(), response);
//    }

//    @Test
//    void getItemsTest(){
//        Orders order = new Orders();
//
//        Mockito.when(orderServices.getItems(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);
//        ResponseEntity<Object> response = orderController.getItem(1, 1);
//        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//
//        ArrayList<Orders> res = new ArrayList<>();
//        res.add(order);
//
//        Mockito.when(orderServices.getItems(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);
//        ResponseEntity<Object> response2 = orderController.getItem(1, 1);
//        Assertions.assertEquals(res, response2.getBody());
//
//    }

    @Test
    void addItemTest(){
        Mockito.when(orderServices.addItem(Mockito.anyInt(), Mockito.any(Items.class))).thenReturn("Item added Successfully");
        Items item = new Items();
        ResponseEntity<String> response = orderController.addItem( item, 1);
        Assertions.assertEquals("Item added Successfully", response.getBody());

        Mockito.when(orderServices.addItem(Mockito.anyInt(), Mockito.any(Items.class))).thenReturn("Order Id Not found");
        ResponseEntity<String> response2 = orderController.addItem( item, 2);
        Assertions.assertEquals("Order Id Not found", response2.getBody());
    }

    @Test
    void getItemTest(){

        Items item = new Items();
        Mockito.when(orderServices.getItems(Mockito.anyInt(), Mockito.anyInt())).thenReturn(item);

        ResponseEntity<Object> response = orderController.getItem(1,1);
        Assertions.assertEquals(item, response.getBody());

//        Mockito.when(orderServices.getItems(Mockito.anyInt(), Mockito.anyInt())).thenReturn(null);
//
//        ResponseEntity<Object> response2 = orderController.getItem(1,1);
//        Assertions.assertEquals(null, response2.getBody());

    }

    @Test
    void deleteItemTest(){
        Mockito.when(orderServices.deleteItem(Mockito.anyInt(), Mockito.anyInt())).thenReturn("Item 1 removed");

        ResponseEntity<String> response = orderController.deleteItem(1,1);
        Assertions.assertEquals(1,1);
    }

    @Test
    void updateItemTest(){
        Mockito.when(orderServices.updateItem(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Items.class))).thenReturn("Item Updated");

        Items item = new Items();
        ResponseEntity<String> response = orderController.updateItem(item, 1, 1);
        Assertions.assertEquals("Item Updated", response.getBody());

        Mockito.when(orderServices.updateItem(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Items.class))).thenReturn("Item Id not found");
        ResponseEntity<String> response2 = orderController.updateItem(item, 1, 1);
        Assertions.assertEquals("Item Id not found", response2.getBody());

        Mockito.when(orderServices.updateItem(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Items.class))).thenReturn("Order Id not found");
        ResponseEntity<String> response3 = orderController.updateItem(item, 1, 1);
        Assertions.assertEquals("Order Id not found", response3.getBody());

    }
}