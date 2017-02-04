package org.fasttrackit.dev.lesson1.numgenerator;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by icondor on 04/02/17.
 */
public class SendMail implements Runnable{

    public String subject;
    public SendMail(String sub, double time, int nr) {
        subject=sub;
        //
        //

    }

    public void run() {

        final String username = "fasttrackit.intro1";
        final String password = "fasttrackit.intro@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ionel.condor@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("flaviu.sfdf@dfdsfsd.dsfsString username = fasttrackit.intro1\n" +
                            "String password = fasttrackit.intro@gmail.com\n"));
            message.setSubject(subject);
            message.setText("Congratulation!");

            Transport.send(message);

            System.out.println("done, email sent ok");

        } catch (Exception e) {
            System.out.println("Email sending problems");
            e.printStackTrace();
        }
    }



}
