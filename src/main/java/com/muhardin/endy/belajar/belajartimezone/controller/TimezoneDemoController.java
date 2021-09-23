package com.muhardin.endy.belajar.belajartimezone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class TimezoneDemoController {
    @GetMapping("/")
    public Map<String, Object> printNow() {
        Map<String, Object> result = new LinkedHashMap<>();

        ZoneId currentTimezone = ZoneId.systemDefault();
        ZoneId jakartaTimezone = ZoneId.of("Asia/Jakarta");

        LocalTime now = LocalTime.now(currentTimezone);
        LocalTime nowJakarta = LocalTime.now(jakartaTimezone);

        LocalTime openTime = LocalTime.of(9, 30);
        LocalTime closeTime = LocalTime.of(20, 45);

        result.put("Current Timezone", currentTimezone);
        result.put("Server Time", now);
        result.put("Server Time (Asia/Jakarta)", nowJakarta);
        result.put("Server Time from LocalDateTime (Asia/Jakarta)",
                LocalDateTime.now(jakartaTimezone).toLocalTime());
        result.put("Open Time", openTime);
        result.put("Close Time", closeTime);
        result.put("Is now open?", (now.isAfter(openTime) && now.isBefore(closeTime)));
        result.put("Is now (Asia/Jakarta) open?", (nowJakarta.isAfter(openTime) && nowJakarta.isBefore(closeTime)));

        return result;
    }
}
