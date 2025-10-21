package com.secretFriend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.secretFriend.model.Person;
import com.secretFriend.repository.PersonRepository;

@Service
public class SecretSantaService {
    private final PersonRepository repo;
    private final JavaMailSender mailSender;

    public SecretSantaService(PersonRepository repo, JavaMailSender mailSender) {
        this.repo = repo;
        this.mailSender = mailSender;
    }

    public void performDraw() {
        List<Person> persons = repo.findAll();
        if (persons.size() < 2) throw new RuntimeException("Precisa de pelo menos 2 pessoas!");

        List<Person> shuffled = new ArrayList<>(persons);
        Collections.shuffle(shuffled);

        for (int i = 0; i < shuffled.size(); i++) {
            Person giver = shuffled.get(i);
            Person receiver = shuffled.get((i + 1) % shuffled.size());

            sendEmail(giver.getEmail(), receiver.getName());
        }
    }

    private void sendEmail(String to, String receiverName) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("Amigo Secreto 🎁");
        msg.setText("Você deve presentear: " + receiverName);
        mailSender.send(msg);
    }
}
