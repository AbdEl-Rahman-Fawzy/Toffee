package org.example;

import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OTPMessage {
    private static final String OTP_CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6; // length of the OTP

    // Email configuration parameters
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String SMTP_USERNAME = "mariam2003.04.14@gmail.com";
    private static final String SMTP_PASSWORD = "ltfantfzeovihkcb";
    private static final String FROM_EMAIL_ADDRESS = "mariam2003.04.14@gmail.com";

    public static String Generate() {
        StringBuilder stringBuilder = new StringBuilder(OTP_LENGTH);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(OTP_CHARACTERS.length());
            stringBuilder.append(OTP_CHARACTERS.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

    public static void SendByMail(String toEmailAddress, String otp) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
            }
        };

        Session session = Session.getInstance(properties, authenticator);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL_ADDRESS));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
            message.setSubject("OTP Code : " + otp);
            message.setText("Dear user,\n\nYour OTP Code is " + otp);
            System.out.println("Please wait a moment\n");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}