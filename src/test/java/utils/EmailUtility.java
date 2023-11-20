//package utils;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.util.Properties;
//
//public class EmailUtility {
//
//    public static boolean sendEmailWithExtentReport(String recipientEmail, String subject, String body, String reportFilePath) {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("ankitsharma3@pbpartners.com", "PBbz@r#$789");
//            }
//        });
//
//        boolean emailSent = false;
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("ankitsharma3@pbpartners.com"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//            message.setSubject(subject);
//
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText(body);
//
//            BodyPart attachmentBodyPart = new MimeBodyPart();
//            DataSource source = new FileDataSource(reportFilePath);
//            attachmentBodyPart.setDataHandler(new DataHandler(source));
//            attachmentBodyPart.setFileName("report.html");
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            multipart.addBodyPart(attachmentBodyPart);
//
//            message.setContent(multipart);
//
//            Transport.send(message);
//
//            System.out.println("Email sent successfully.");
//            emailSent = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return emailSent;
//    }
//}
