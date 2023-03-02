package com.jxx.studyevent.store;

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
}
