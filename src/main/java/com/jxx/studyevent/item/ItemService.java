package com.jxx.studyevent.item;

import com.jxx.studyevent.item.dto.ItemForm;
import com.jxx.studyevent.item.dto.ItemResponse;
import com.jxx.studyevent.store.Store;
import com.jxx.studyevent.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;

    public ItemResponse receive(Long itemId) {
        Item item = itemRepository.findById(itemId).get();

        return new ItemResponse(
                item.getId(),
                item.getItemName(),
                item.getPrice());
    }

    public void create(Long storeId, ItemForm itemForm) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("잘못된 요청"));
        Item item = new Item(store, itemForm);
        itemRepository.save(item);
        log.info("[{} 아이템 등록]", item.getItemName());
    }
}
