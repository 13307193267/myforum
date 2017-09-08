package mcj.mail;

public class McjTest {
	public static void main(String[] args){     
        //这个类主要是设置邮件     
     MailSenderInfo mailInfo = new MailSenderInfo();      
     mailInfo.setMailServerHost("smtp.163.com");      
     mailInfo.setMailServerPort("25");      
     mailInfo.setValidate(true);      
     mailInfo.setUserName("m136642169@163.com");      
     mailInfo.setPassword("m136642169");//您的邮箱密码      
     mailInfo.setFromAddress("m136642169@163.com");      
     mailInfo.setToAddress("136642169@qq.com");      
     mailInfo.setSubject("帅锅");      
     mailInfo.setContent("在搞么子！ ");    
        //这个类主要来发送邮件     
     SimpleMailSender sms = new SimpleMailSender();     
       sms.sendTextMail(mailInfo);//发送文体格式      
       sms.sendHtmlMail(mailInfo);//发送html格式     
   }  
	
}
