package com.stockian.stockian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService{

  @Autowired
  private MailSender mailSender;
  @Autowired
  private JavaMailSender javaMailSender;
  @Autowired
  private TemplateEngine templateEngine;
  @Autowired
  MailProperties mailProperties;

  @Autowired
  PropertyLoader loader;
  @Async
  public void sendConfirmationEmail(String emailAddress, String userName) throws javax.mail.MessagingException {
    Context cont = new Context();
    cont.setVariable("userName", userName);
    cont.setVariable("activationUrl", "http://" + loader.getDNS() + "/api/" + userName + "/activation");
    System.out.println(cont.getVariable("activationUrl"));
    sendHtmlMail(emailAddress,"Activation", "ActivationEmailTemplate.html", cont);
  }

  @Async
  public void sendTextMail(String to, String subject, String body, String cc, String bcc) throws MessagingException {
    SimpleMailMessage message=new SimpleMailMessage();
    message.setTo(to);
    message.setText(body);
    message.setSubject(subject);
    if(cc!=null) message.setCc(cc);
    if(bcc!=null) message.setBcc(bcc);
    mailSender.send(message);
  }

  @Async
  public void sendHtmlMail(String to, String subject, String templateName, Context context) throws MessagingException, javax.mail.MessagingException {
    MimeMessage mail = javaMailSender.createMimeMessage();
    String body = templateEngine.process(templateName, context);
    MimeMessageHelper helper = new MimeMessageHelper(mail, true);
    try {
      //helper.setFrom(mailProperties.getProperties().get("from"),mailProperties.getProperties().get("personal"));
      helper.setFrom("huha.inc","huha.personal");

    } catch (Exception e) {
      System.out.println("error in mail service sendHtmlMail method"+e);
    }
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(body, true);
    javaMailSender.send(mail);


  }

}

