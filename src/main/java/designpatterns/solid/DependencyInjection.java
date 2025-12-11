package designpatterns.solid;

public class DependencyInjection {
    public static void main(String[] args) {
        UserNotification emailNotification = new UserNotification(new EmailNotification());
        emailNotification.notifyUser("Welcome!", "user@example.com");
        UserNotification smsNotification  = new UserNotification(new SMSNotification());
        smsNotification .notifyUser("Welcome!", "123425432");
    }
}

interface NotificationService{
    void sendNotification(String message, String toReceipent);
}

class SMSNotification implements NotificationService {

    @Override
    public void sendNotification(String message, String toReceipent) {
        System.out.println("Sending SMS Notification to " + toReceipent + " that contain the message = " + message );
    }
}

class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message, String toReceipent) {
        System.out.println("Sending EMAIL Notification to " + toReceipent + " that contain the message = " + message );
    }
}

class UserNotification {
    NotificationService notificationService;
    public UserNotification(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void notifyUser(String message, String toReceipent) {
        notificationService.sendNotification(message, toReceipent);
    }
}