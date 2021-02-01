package com.example.spring.service;

import com.example.spring.model.Items;
import com.example.spring.model.Orders;

public interface OrderService {
    public String newOrder(int orderId, Orders order);

    public String addItem(int OrderId, Items item);
  //  public Optional<Orders> getItem(int orderId);

    public String deleteItem(int orderId, int itemId);

    public String updateItem(int orderId, int itemId, Items item);

    Items getItems(int orderId, int itemId);
}
