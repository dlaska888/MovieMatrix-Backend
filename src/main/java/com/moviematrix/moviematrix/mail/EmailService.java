package com.moviematrix.moviematrix.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendVerificationEmail(String recipientEmail, String confirmationLink) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Potwierdzenie adresu e-mail");
        message.setText("Aby potwierdzić swój adres e-mail, kliknij w poniższy link: " + confirmationLink);

        javaMailSender.send(message);

        log.info("Mail sent successfully!");
    }

}
