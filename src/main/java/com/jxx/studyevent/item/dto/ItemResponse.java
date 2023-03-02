package com.jxx.studyevent.item.dto;

import lombok.Getter;

@Getter
public class ItemResponse {
    private Long id;
    private String itemName;
    private Integer price;

    public ItemResponse(Long id, String itemName, Integer price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }
}
