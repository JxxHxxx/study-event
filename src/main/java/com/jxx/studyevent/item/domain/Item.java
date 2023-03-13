package com.jxx.studyevent.item.domain;

import com.jxx.studyevent.common.TimeStamped;
import com.jxx.studyevent.item.dto.request.ItemForm;
import com.jxx.studyevent.store.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Item extends TimeStamped {

    @Id @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;

    @Enumerated(value = EnumType.STRING)
    private ItemType itemType;

    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public Item(Store store, ItemForm itemForm) {
        this.store = store;
        this.itemName = itemForm.getItemName();
        this.itemType = itemForm.getItemType();
        this.price = itemForm.getPrice();
    }
}
