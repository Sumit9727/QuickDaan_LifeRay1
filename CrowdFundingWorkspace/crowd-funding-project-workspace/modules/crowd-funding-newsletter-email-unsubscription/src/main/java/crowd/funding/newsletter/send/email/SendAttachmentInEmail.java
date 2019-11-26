package crowd.funding.newsletter.send.email;

import java.io.File;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.BodyPart;
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

import com.crowd.funding.database.model.SubscriptionRegistration;
import com.crowd.funding.database.service.SubscriptionRegistrationLocalServiceUtil;

public class SendAttachmentInEmail {
	
   public void sendEmail(String toemail, String subject, String body, String filepath) {
	   
	   try {
		   MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap(); 
	       mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html"); 
	       mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml"); 
	       mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain"); 
	       mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed"); 
	       mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822");
	       
	       mc.addMailcap("multipart/report;;  x-java-content-handler=com.sun.mail.dsn.multipart_report");
	       mc.addMailcap("message/delivery-status;; x-java-content-handler=com.sun.mail.dsn.message_deliverystatus");
	       mc.addMailcap("message/disposition-notification;; x-java-content-handler=com.sun.mail.dsn.message_dispositionnotification");
	       mc.addMailcap("text/rfc822-headers;;   x-java-content-handler=com.sun.mail.dsn.text_rfc822headers");
	       
		      final String username = "crowdfundasia@gmail.com";//change accordingly
		      final String password = "Prakat@123";//change accordingly 
		      
		
		      String text = "<p>You have recieved this mail, because you have Subscrided to QuickDaan newsletter. click here to</p>";
		      String redirectURL = "http://127.0.0.1:8080/web/bindu/news-letter-unsubscribe?email="+toemail+"";
		
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
	     
	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(username));
	         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toemail));
	         message.setSubject(subject);
	
	         BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setText(body);
	         messageBodyPart.setContent(""+ text +"<a href="+redirectURL+" > UNSUBSCRIBE</a>", "text/html");
	
	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);
	         
	         messageBodyPart = new MimeBodyPart();
	         String filename = filepath;
	         
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("Document");
	         multipart.addBodyPart(messageBodyPart);
	         message.setContent(multipart);
	         
	         Transport.send(message);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
   	}
}