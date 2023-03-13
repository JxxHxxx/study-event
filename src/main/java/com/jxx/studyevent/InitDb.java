package com.jxx.studyevent;

import com.jxx.studyevent.store.application.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final StoreService storeService;

        public void dbInit1() {
            storeService.enroll("춘리마라탕");
            storeService.enroll("교촌치킨");
            storeService.enroll("메가커피");
            }
        }

    }
