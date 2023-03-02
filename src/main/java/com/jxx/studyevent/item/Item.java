package com.jxx.studyevent.item;

import com.jxx.studyevent.item.dto.ItemForm;
import com.jxx.studyevent.store.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Item {

    @Id @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public Item(Store store, ItemForm itemForm) {
        this.store = store;
        this.itemName = itemForm.getItemName();
        this.price = itemForm.getPrice();
    }
}
