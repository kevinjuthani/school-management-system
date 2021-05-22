package com.backend.schoolManagementSystem.util;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * A class to send email to the user using smtp.
 */

public class MailSender
{ 
	
	/**
	 * Sends email to the user using smtp.
	 *
	 * @param to the email id in which the OTP is to be sent.
	 *
	 * @param sub the subject of the corresponding email.
	 * 
	 * @param msg the mail body to be sent.
	 * 
	 * @param user the email id of password recovery gmail account.
	 * 
	 * @param pass the password id of password recovery gmail account.
	 *
	 * @return Nothing.
	 * 
	 * @exception Exception  any exception that may occur.

	 *
	 */
	
    public static void send(String to, String sub, 
                         String msg)
    { 
        Properties props = new Properties();
     
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587");		
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
  	 	         return new PasswordAuthentication(Constants.FROM_EMAIL,Constants.FROM_PASSWORD); 
            }
        });

        try {
     
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constants.FROM_EMAIL));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg,"text/html");
            Transport.send(message);
        }
        catch(Exception e) {
    	     e.printStackTrace();
        }
    }  
}