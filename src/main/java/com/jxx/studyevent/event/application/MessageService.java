package com.jxx.studyevent.event.application;

import com.jxx.studyevent.event.dto.ItemCreated;
import com.jxx.studyevent.item.dto.response.ItemCreateServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

    public void send(ItemCreated form) {
        if ("ex".equals(form.getItemName())) {
            throw new IllegalArgumentException("예외 발생");
        }
        log.info("[메시지 전송!! 아이템 정보 storeId : {} storeName : {} itemName : {} price : {}]",
                form.getStoreId(), form.getStoreName(), form.getItemName(), form.getPrice());
    }

    public void send(ItemCreateServiceResponse form) {
        if ("ex".equals(form.getItemName())) {
            throw new IllegalArgumentException("예외 발생");
        }
        log.info("[메시지 전송!! 아이템 정보 storeId : {} storeName : {} itemName : {} price : {}]",
                form.getStoreId(), form.getStoreName(), form.getItemName(), form.getPrice());
    }
}
