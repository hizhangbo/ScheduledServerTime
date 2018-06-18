package top.crazybanana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledUpdatesOnTime {
    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay=1000)
    public void publishUpdates(){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        template.convertAndSend("/msg/datetime", now);
    }
}
