package co.develhope.loginsystem.notifications.services;

import co.develhope.loginsystem.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendActivationMail(User user) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setFrom("development@develhope.co");
        simpleMailMessage.setReplyTo("development@develhope.co");
        simpleMailMessage.setSubject("Ti sei iscritto alla piattaforma");
        simpleMailMessage.setText("Il codice di attivazione è: " + user.getActivationCode());
        javaMailSender.send(simpleMailMessage);
    }
}
