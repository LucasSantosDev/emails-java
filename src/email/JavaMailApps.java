package Email;

import java.util.Properties;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
public class JavaMailApps
{  
     public static void enviarHotmail(){  
                       
            Properties props = new Properties();  
            /** Parâmetros de conexão com servidor Hotmail */  
            props.put("mail.transport.protocol", "smtp");  
            props.put("mail.smtp.host", "smtp.live.com");  
            props.put("mail.smtp.socketFactory.port", "587");  
            props.put("mail.smtp.socketFactory.fallback", "false");  
            props.put("mail.smtp.starttls.enable", "true");  
            props.put("mail.smtp.auth", "true");  
            props.put("mail.smtp.port", "587");  
  
            Session session = Session.getDefaultInstance(props,  
                        new javax.mail.Authenticator() {  
                             protected PasswordAuthentication getPasswordAuthentication()   
                             {  
                                   return new PasswordAuthentication("SeuEmail", "suaSenha");  
                             }  
                        });  
  
            /** Ativa Debug para sessão */  
            session.setDebug(true);  
  
            try {  
  
                  Message message = new MimeMessage(session);  
                  message.setFrom(new InternetAddress("Enviado por ... de preferencia seu email")); //Remetente  
  
                  message.setRecipients(Message.RecipientType.TO,       
                                    InternetAddress.parse("Email de quem vai receber")); //Destinatário(s)  
                  message.setSubject("Enviando email com JavaMail");//Assunto  
                  message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");  
                  /**Método para enviar a mensagem criada*/  
                  Transport.send(message);  
  
                  System.out.println("Feito!!!");  
  
             } catch (MessagingException e) {  
                  throw new RuntimeException(e);  
            }  
      }  
                   
     
     public static void main(String[] args) {  
           
                enviarHotmail();  
                     
                }  
      } 