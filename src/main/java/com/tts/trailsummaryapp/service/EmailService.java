package com.tts.trailsummaryapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tts.trailsummaryapp.model.TrailForm;
import com.tts.trailsummaryapp.repository.TrailFormRepository;

@Service
public class EmailService 
{
	//change made here
	@Autowired
	private TrailFormRepository trailFormRepository;
	
	// change made here
	public List<TrailForm> findByContactEmail(String contactEmail)
	{
		return trailFormRepository.findByContactEmail(contactEmail);
	}
	
	//change made here
	public List<TrailForm> findByStartedAt(Date startedAt)
	{
		return trailFormRepository.findByStartedAt(startedAt);
	}
	
	@Value("${mail.smtp.auth}")
	String smtpAuth;
	
	@Value("${mail.smtp.starttls.enable}")
	String tlsEnable;
	
	//names of values that will exist in either application.properties or in environment variables
	@Value("${mail.smtp.host}")
	String smtpHost;
	
	@Value("${mail.smtp.port}")
	String smtpPort;
	
	@Value("${mail.smtp.ssl.trust}")
	String sslTrust;
	
	@Value("${mail.smtp.password}")
	String password;
	
	@Value("${mail.smtp.username}")
	String username;
	
	Properties properties = new Properties();
	
	
	@PostConstruct
	public void init()
	{
	properties.put("mail.smtp.auth", smtpAuth);
	properties.put("mail.smtp.starttls.enable", tlsEnable);
	properties.put("mail.smtp.host", smtpHost);
	properties.put("mail.smtp.port", smtpPort);
	properties.put("mail.smtp.ssl.trust", sslTrust);
	}
	
	private Session openSession()
	{
		return Session.getInstance(properties, new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
			return new PasswordAuthentication(username, password);
			}
		});
	}
	
	public boolean sendMail(String email, String title, String emailMessage)
	{
		Session session = openSession();
		Message message = new MimeMessage(session);
	try
	{
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject(title);

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(emailMessage, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		
		message.setContent(multipart);

		Transport.send(message);
	}
	catch (MessagingException e)
	{
		//Handle error case however you want here....
		//Email wasnt sent
		e.printStackTrace();
		return false;
	}
	return true;
	}

}
	

