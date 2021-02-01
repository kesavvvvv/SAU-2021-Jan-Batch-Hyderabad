package com.example.spring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Orders {

    private Integer orderId;
    private HashMap<Integer, Items> itemMap = new HashMap<>();

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public HashMap<Integer, Items> getItemMap() {
        return itemMap;
    }

    public void setItemMap(HashMap<Integer, Items> itemMap) {
        this.itemMap = itemMap;
    }
}
