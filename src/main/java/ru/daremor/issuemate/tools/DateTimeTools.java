package ru.daremor.issuemate.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DateTimeTools {

    @Tool(description = "Get the current date and time in the user's timezone")
    public String getCurrentDateTime() {
        return LocalDateTime.now()
                .atZone(LocaleContextHolder.getTimeZone().toZoneId())
                .toString();
    }

    @Tool(description = "Set a user alarm for the given time, provided in ISO-8601 format")
    public void setAlarm(
            @ToolParam(description = "ISO-8601 date-time, e.g. 2025-09-02T18:10:00")
            String time
    ) {
        var alarmTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        // здесь любая твоя логика (persist, scheduler, уведомление и т.п.)
        System.out.println("Alarm set for " + alarmTime);
    }
}