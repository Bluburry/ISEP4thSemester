package jobs4u.base.notificationmanagement.domain;

import eapli.framework.domain.events.DomainEvent;
import eapli.framework.infrastructure.pubsub.EventHandler;
import jobs4u.base.notificationmanagement.application.CheckNewNotificationsEventWatchdogController;
import jobs4u.base.notificationmanagement.application.JobApplicationNotificationWatchdogController;
import lombok.SneakyThrows;

public class CheckNewNotificationsEventWatchdog implements EventHandler {

    private int SLEEPTIME = 30;
    final CheckNewNotificationsEventWatchdogController controller = new CheckNewNotificationsEventWatchdogController();

    @SneakyThrows
    @Override
    public void onEvent(final DomainEvent domainevent) {
        assert domainevent instanceof CheckNewNotificationsEvent;

        final CheckNewNotificationsEvent event = (CheckNewNotificationsEvent) domainevent;

       while (true){
           boolean flag = controller.checkForNotifications(event.getPassword());

           if(flag){
               System.out.println("-=-[NEW NOTIFICATIONS IN INBOX]-=-");
           }

           Thread.sleep(SLEEPTIME*1000);
       }

    }
}
