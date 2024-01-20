package Business.Functions;


import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author prasanna
 */
public class NotificationText {
     
    private static final String SMTP_HOST_NAME = "smtp.gmail.com"; 
    private static final String SMTP_PORT_NUMBER = "587"; 
     private static StringBuilder emailMsgTxt ;
        
        private static String emailSubjectTxt = "Thank you!";
        private static String emailFromAddress = "hospitalmanagement.aed@gmail.com";
    

    public static String generateUserPassword(String name)
    {
        try
        {
      Random random = new Random();
      String value = String.valueOf(random.nextInt(10000));
      String value1 = String.valueOf(random.nextInt(100));
        StringBuilder sb = new StringBuilder();
        sb.append(value1);
        sb.append(name);
        sb.append(value);
        System.out.println("*****Password is:*****"+sb.toString());
         return sb.toString();
        }
        catch(Exception e)
        {
          
        }
        return null;
    }
    
    public static String generateUserName(String name)
    {
        try
        {
      Random random = new Random();
      String value1 = String.valueOf(random.nextInt(100));
        StringBuilder sb = new StringBuilder();
        sb.append(value1);
        sb.append(name);
        System.out.println("*****Username is:*****"+sb.toString());
         return sb.toString();
    }
     catch(Exception e)
        {
            
        }
        return null;
    }
      

 // Send Email                   
    
    public static boolean sendMailNotification(String msg, String emailId, String userName, String password)
    {
      boolean isSent = true;
 
    try {
     Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);                                                        
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Authenticator mailAuthenticator = new EmailAuthorization();
        Session mailSession = Session.getDefaultInstance(props,mailAuthenticator);
        Message message = new MimeMessage(mailSession);
         InternetAddress fromAddress ;
        InternetAddress toAddress;
        try
           {
         fromAddress = new InternetAddress(emailFromAddress);
         toAddress = new InternetAddress(emailId);
         }
        
        catch (AddressException ae) {
            ae.printStackTrace();
         isSent= false;
         return isSent;
         }
        
        message.setFrom(fromAddress);
        message.setRecipient(RecipientType.TO, toAddress);
        message.setSubject(emailSubjectTxt);
        message.setText(msg);
 
       Transport.send(message);
       System.out.println("Email is Sent!");
        } 
         catch (MessagingException mex) {
            isSent=false;
            return isSent;
       }
       
       catch (Exception e) {
            isSent=false;
       }

         return isSent;
    }
}
