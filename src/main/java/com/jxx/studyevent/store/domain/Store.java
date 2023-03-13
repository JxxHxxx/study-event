package com.jxx.studyevent.store.domain;

import com.jxx.studyevent.item.domain.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Store {

    @Id @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;

    @OneToMany(mappedBy = "store")
    private List<Item> items = new ArrayList<>();

    public Store(String storeName) {
        this.storeName = storeName;
    }
}

