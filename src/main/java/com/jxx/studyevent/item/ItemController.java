package com.jxx.studyevent.item;

import com.jxx.studyevent.event.MessageService;
import com.jxx.studyevent.item.dto.ItemForm;
import com.jxx.studyevent.item.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final MessageService messageService;

    @PostMapping("/items")
    public void create(@RequestBody ItemForm itemForm, Long storeId) {
        itemService.create(storeId, itemForm);
        messageService.send(itemForm.getItemName());
    }

    @GetMapping("/items/{item-id}")
    public ItemResponse show(@PathVariable("item-id") Long itemId) {
        return itemService.receive(itemId);
    }
}
