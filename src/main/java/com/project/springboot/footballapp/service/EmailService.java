package com.project.springboot.footballapp.service;

import com.project.springboot.footballapp.utils.OTPGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private Map<String, String> otpCache = new HashMap<>();

    public String generateAndSendOTP(String email) {
        String otp = OTPGenerator.generateOTP();
        otpCache.put(email, otp);

        sendOTPEmail(email, otp);
        return otp;
    }

    private void sendOTPEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP for registration");
        message.setText("Your OTP is: " + otp);

        javaMailSender.send(message);
    }

    public boolean validateOTP(String email, String otp) {
        String cachedOTP = otpCache.get(email);
        return cachedOTP != null && cachedOTP.equals(otp);
    }
}
