package com.farhad.example.templatebasedemail;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EmailScheduler {
    
    private final EmailService emailService;

    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void sendDailyNewsletter() {
        String subject = "Daily Newsletter";
        String content = "Here is your daily dose of news and updates!";
        emailService.sendEmail("subscriber@example.com", subject, content);
    }
}
