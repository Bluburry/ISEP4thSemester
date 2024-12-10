package jobs4u.base.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.List;

import jobs4u.base.usermanagement.application.ManageUserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
public class ActivateUserUI extends AbstractUI{
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivateUserUI.class);

    private final ManageUserController theController = new ManageUserController();

    @Override
    protected boolean doShow() {
        final List<SystemUser> list = new ArrayList<>();
        final Iterable<SystemUser> iterable = this.theController.inactiveUsers();
        if (!iterable.iterator().hasNext()) {
            System.out.println("There is no deactivated User");
        } else {
            int cont = 1;
            System.out.println("SELECT User to activate\n");
            // FIXME use select widget, see, ChangeDishTypeUI
            System.out.printf("%-25s%-25s%-25s%-25s%n", "Nº:", "Username", "Firstname", "Lastname");
            for (final SystemUser user : iterable) {
                list.add(user);
                System.out.printf("%-25d%-25s%-25s%-25s%n", cont, user.username(), user.name().firstName(),
                        user.name().lastName());
                cont++;
            }
            final int option = Console.readInteger("Enter user nº to Activate or 0 to finish ");
            if (option == 0) {
                System.out.println("No user selected");
            } else {
                try {
                    this.theController.activateUser(list.get(option - 1));
                } catch (IntegrityViolationException | ConcurrencyException ex) {
                    LOGGER.error("Error performing the operation", ex);
                    System.out.println(
                            "Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Activate User";
    }
}
