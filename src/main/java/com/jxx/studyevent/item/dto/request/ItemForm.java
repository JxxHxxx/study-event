package com.jxx.studyevent.item.dto.request;

import com.jxx.studyevent.item.domain.ItemType;
import lombok.Getter;

@Getter
public class ItemForm {
    private String itemName;
    private ItemType itemType;
    private Integer price;

    public ItemForm(String itemName, ItemType itemType, Integer price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
    }
}
