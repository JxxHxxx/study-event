package com.jxx.studyevent.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

    public void send(String name) {
        log.info("[사장님 {} 아이템이 등록되었습니다.]", name);
    }
}
