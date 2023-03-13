package com.jxx.studyevent.item.domain;

import com.jxx.studyevent.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
