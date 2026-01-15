package com.app.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void addItem(Menu menu) {
        if(items.containsKey(menu.getMenuId())){
            items.get(menu.getMenuId())
                 .setQuantity(items.get(menu.getMenuId()).getQuantity() + 1);
        } else {
            items.put(menu.getMenuId(), new CartItem(menu, 1));
        }
    }

    public void increase(int menuId){
        items.get(menuId).setQuantity(items.get(menuId).getQuantity() + 1);
    }

    public void decrease(int menuId){
        if(items.get(menuId).getQuantity() > 1){
            items.get(menuId).setQuantity(items.get(menuId).getQuantity() - 1);
        } else {
            items.remove(menuId);
        }
    }

    public Collection<CartItem> getItems(){
        return items.values();
    }

    public double getTotalPrice(){
        double total = 0;
        for(CartItem item : items.values()){
            total += item.getMenu().getPrice() * item.getQuantity();
        }
        return total;
    }
}
