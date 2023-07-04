package com.farhad.example.templatebasedemail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmailController {
    
    private final UserRepository userRepository;

    @RequestMapping("/sendEmail")
    public String sendMail(@RequestParam Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        EmailTemplate emailTemplate = generateCustomizedTemplate(user);
        // send email
        return "Email sent successfully";
    }

    private EmailTemplate generateCustomizedTemplate(User user) {
        EmailTemplate customizedEmailTemplate = new EmailTemplate();
        return customizedEmailTemplate;
    }
}
