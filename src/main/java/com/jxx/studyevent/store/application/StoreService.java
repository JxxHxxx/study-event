package com.jxx.studyevent.store.application;

import com.jxx.studyevent.store.domain.Store;
import com.jxx.studyevent.store.domain.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public void enroll(String storeName) {
        Store store = new Store(storeName);
        storeRepository.save(store);
    }

    public Integer countItems(Long storeId) {
        Store store = storeRepository.findById(storeId).get();
        return store.getItems().size();
    }
}
