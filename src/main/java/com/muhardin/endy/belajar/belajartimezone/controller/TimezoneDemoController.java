package com.muhardin.endy.belajar.belajartimezone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class TimezoneDemoController {
    @GetMapping("/")
    public Map<String, Object> printNow() {
        Map<String, Object> result = new LinkedHashMap<>();

        LocalTime now = LocalTime.now();
        LocalTime nowJakarta = LocalTime.now(ZoneId.of("Asia/Jakarta"));

        LocalTime openTime = LocalTime.of(9, 30);
        LocalTime closeTime = LocalTime.of(20, 45);

        result.put("Server Time", now);
        result.put("Server Time (Asia/Jakarta)", nowJakarta);
        result.put("Open Time", openTime);
        result.put("Close Time", closeTime);
        result.put("Is now open?", (now.isAfter(openTime) && now.isBefore(closeTime)));
        result.put("Is now (Asia/Jakarta) open?", (nowJakarta.isAfter(openTime) && nowJakarta.isBefore(closeTime)));

        return result;
    }
}
