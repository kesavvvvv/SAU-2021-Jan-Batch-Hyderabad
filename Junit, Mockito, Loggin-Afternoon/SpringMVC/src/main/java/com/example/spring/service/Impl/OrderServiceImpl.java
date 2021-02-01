package com.example.spring.service.Impl;

import com.example.spring.model.Items;
import com.example.spring.model.Orders;
import com.example.spring.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    private HashMap<Integer, Orders> orderMap = new HashMap<>();

    @Override
    public String newOrder(int orderId, Orders order) {
        orderMap.put(orderId, order);
        order.setOrderId(orderId);
        System.out.println(order);
        return "Created New Order with Order ID: " + order.getOrderId();
    }

    @Override
    public String addItem(int orderId, Items item) {

        if(!orderMap.containsKey(orderId)) {
            return "not found";
        }
        orderMap.get(orderId).getItemMap().put(item.getItemId(), item);

        System.out.println(item.getItemId() + " " + item.getItemName() + " " + item.getItemQuantity() + " " + item.getItemPrice());
        return "New Item added to Order ID:" + orderId;

    }

//    @Override
//    public Optional<Orders> getItem(int orderId) {
//        Optional<Orders> order = null;
//        if(!orderMap.containsKey(orderId))
//            return order;
//        return Optional.ofNullable(orderMap.get(orderId));
//    }

    @Override
    public String deleteItem(int orderId, int itemId) {
        if(!orderMap.containsKey(orderId)) {
            return "not found";
        }

        if(!orderMap.get(orderId).getItemMap().containsKey(itemId)) {
            return "not found";
        }


        orderMap.get(orderId).getItemMap().remove(itemId);

        return "Item removed from Order ID: " + orderId;


    }

    @Override
    public String updateItem(int orderId, int itemId, Items item) {

        if(!orderMap.containsKey(orderId)) {
            return "not found";
        }

        if(!orderMap.get(orderId).getItemMap().containsKey(itemId)) {
            return "not found";
        }

        orderMap.get(orderId).getItemMap().remove(itemId);
        orderMap.get(orderId).getItemMap().put(itemId, item);

        return "Updated Item: " + itemId + " in Order: " + orderId;

    }

    @Override
    public Items getItems(int orderId, int itemId) {
        if(!orderMap.containsKey(orderId)) {
            return null;
        }

        if(!orderMap.get(orderId).getItemMap().containsKey(itemId)) {
            return null;
        }

        return orderMap.get(orderId).getItemMap().get(itemId);

    }


}
