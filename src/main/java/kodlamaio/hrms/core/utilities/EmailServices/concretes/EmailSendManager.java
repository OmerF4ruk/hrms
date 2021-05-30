package kodlamaio.hrms.core.utilities.EmailServices.concretes;

import org.springframework.stereotype.Service;

@Service
public class EmailSendManager {
    public void emailSending(String email) {
        System.out.println("'"+email+"' mail adresine doğrulama maili gönderildi.");
    }
}
