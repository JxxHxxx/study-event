package com.jxx.studyevent.item.dto;

import lombok.Getter;

@Getter
public class ItemForm {
    private String itemName;
    private Integer price;

    public ItemForm(String itemName, Integer price) {
        this.itemName = itemName;
        this.price = price;
    }
}
