package com.jxx.studyevent.item.controller;

import com.jxx.studyevent.event.dto.ItemCreated;
import com.jxx.studyevent.item.application.ItemService;
import com.jxx.studyevent.item.dto.request.ItemForm;
import com.jxx.studyevent.item.dto.response.ItemCreateResponse;
import com.jxx.studyevent.item.dto.response.ItemCreateServiceResponse;
import com.jxx.studyevent.item.dto.response.ItemReceiveResponse;
import com.jxx.studyevent.item.dto.response.ItemSimpleResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ApplicationEventPublisher eventPublisher;

    @PostMapping("/stores/{store-id}/items")
    public ResponseEntity<ItemSimpleResult> create(@PathVariable("store-id") Long storeId, @RequestBody ItemForm itemForm) {
        //아이템 등록 응답 API에 필요한 데이터 선별
        ItemCreateServiceResponse serviceResponse = itemService.create(storeId, itemForm);
        ItemCreated itemCreated = serviceResponse.toEventResponse();

        ItemCreateResponse response = serviceResponse.toPresentationResponse();
        eventPublisher.publishEvent(itemCreated);
        log.info("[아이템  : {} 등록이 완료되었습니다]", response.getItemName());
        return ResponseEntity.ok(new ItemSimpleResult("아이템 등록 성공", response));
    }

    @PostMapping("/v2/stores/{store-id}/items")
    public ResponseEntity<ItemSimpleResult> createV2(@PathVariable("store-id") Long storeId, @RequestBody ItemForm itemForm) {
        //아이템 등록 응답 API에 필요한 데이터 선별
        ItemCreateServiceResponse serviceResponse = itemService.createV2(storeId, itemForm);
        ItemCreateResponse response = serviceResponse.toPresentationResponse();
        log.info("[아이템  : {} 등록이 완료되었습니다]", response.getItemName());
        return ResponseEntity.ok(new ItemSimpleResult("아이템 등록 성공", response));
    }

    @GetMapping("/items/{item-id}")
    public ResponseEntity<ItemSimpleResult> readOne(@PathVariable("item-id") Long itemId) {
        ItemReceiveResponse response = itemService.receive(itemId);
        return ResponseEntity.ok(new ItemSimpleResult("아이템 조회 성공", response));
    }
}
