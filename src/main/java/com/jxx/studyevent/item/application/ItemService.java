package com.jxx.studyevent.item.application;

import com.jxx.studyevent.event.application.MessageService;
import com.jxx.studyevent.item.domain.Item;
import com.jxx.studyevent.item.domain.ItemRepository;
import com.jxx.studyevent.item.dto.response.ItemCreateServiceResponse;
import com.jxx.studyevent.item.dto.request.ItemForm;
import com.jxx.studyevent.item.dto.response.ItemReceiveResponse;
import com.jxx.studyevent.store.domain.Store;
import com.jxx.studyevent.store.domain.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;
    private final MessageService messageService;

    public ItemReceiveResponse receive(Long itemId) {
        Item item = itemRepository.findById(itemId).get();

        return new ItemReceiveResponse(
                item.getId(),
                item.getItemName(),
                item.getPrice());
    }

    @Transactional
    public ItemCreateServiceResponse create(Long storeId, ItemForm itemForm) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("잘못된 요청"));
        Item item = new Item(store, itemForm);
        Item saveItem = itemRepository.save(item);
        return new ItemCreateServiceResponse(
                saveItem.getItemName(),
                saveItem.getItemType(),
                saveItem.getPrice(),
                saveItem.getStore().getId(),
                saveItem.getStore().getStoreName());
    }

    @Transactional
    public ItemCreateServiceResponse createV2(Long storeId, ItemForm itemForm) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new IllegalArgumentException("잘못된 요청"));
        Item item = new Item(store, itemForm);
        Item saveItem = itemRepository.save(item);

        ItemCreateServiceResponse response = new ItemCreateServiceResponse(
                saveItem.getItemName(),
                saveItem.getItemType(),
                saveItem.getPrice(),
                saveItem.getStore().getId(),
                saveItem.getStore().getStoreName());

        messageService.send(response);
        return response;
    }
}
