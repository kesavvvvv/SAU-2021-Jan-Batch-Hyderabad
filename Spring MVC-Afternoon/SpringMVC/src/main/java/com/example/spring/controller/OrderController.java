package com.example.spring.controller;

import com.example.spring.exception.CustomNotFoundException;
import com.example.spring.model.Items;
import com.example.spring.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spring.service.OrderService;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/new/{orderId}")
    public ResponseEntity<String> newOrder(@PathVariable("orderId") int orderId, @RequestBody Orders order) {
        String ord = orderService.newOrder(orderId, order);

        if (null == ord) {
            throw new CustomNotFoundException("Not found id " + orderId);
        }

        return ResponseEntity.ok(ord);
    }



    @PostMapping("/add/{orderId}")
    public ResponseEntity<String> addItem(@RequestBody Items item, @PathVariable("orderId") int orderId) {
        String ord = orderService.addItem(orderId, item);
        System.out.println(orderId);
        if (null == ord) {
            throw new CustomNotFoundException("Not found id " + orderId);
        }

        return ResponseEntity.ok(ord);
    }

//    @GetMapping("/get/{orderId}")
//    public Object getOrder(@PathVariable("orderId") int orderId){
//        Optional<Orders> response = orderService.getItem(orderId);
//        if(Objects.nonNull(response)){
//            return ResponseEntity.ok(response);
//        }else{
//            if (null == response) {
//                throw new CustomNotFoundException("Not found id " + orderId);
//            }
//            return new String("Order not found Id: "+orderId);
//        }
//    }

    @PostMapping("/update/{orderId}/{itemId}")
    public ResponseEntity<String> updateItem(@RequestBody Items item, @PathVariable("itemId") int itemId, @PathVariable("orderId") int orderId) {
        String ord = orderService.updateItem(orderId,itemId,item);
        return ResponseEntity.ok(ord);
    }

    @GetMapping("/delete/{orderId}/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") int itemId, @PathVariable("orderId") int orderId) {
        String ord = orderService.deleteItem(orderId, itemId);
        return ResponseEntity.ok(ord);
    }

    @GetMapping("/getItem/{orderId}/{itemId}")
    public ResponseEntity<Object> getItem(@PathVariable("itemId") int itemId, @PathVariable("orderId") int orderId) {
        Items ord = orderService.getItems(orderId, itemId);
        if (null == ord) {
            throw new CustomNotFoundException("Not found id " + itemId);
        }
        return ResponseEntity.ok(ord);
    }





}
