package com.moviematrix.moviematrix.mail;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    private final EmailService emailService;

    @SneakyThrows
    @GetMapping
    public void testSendVerificationMail() {
        emailService.sendVerificationEmail("jankolek0@gmail.com", "Dupa");
    }

}
