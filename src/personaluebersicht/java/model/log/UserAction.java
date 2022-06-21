package personaluebersicht.java.model.log;

import java.time.LocalDate;
import java.time.LocalTime;

import personaluebersicht.java.model.employees.*;

public class UserAction {
    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;

    private String[] actionDescription;
    private String entry;

    public UserAction() {
        this.actionDescription = new String[] { "create person", "change value", "set assignement", "delete person" };
    }

    public UserAction(HRPerson hrPerson, Person person, int action) {
        this();
        entry = LocalDate.now() + " " + LocalTime.now() + ": " + hrPerson.getFirstName() + " " + hrPerson.getLastName()
                + " do ";

        if (action >= 0 && action < actionDescription.length) {
            entry += this.actionDescription[action] + " for " + person.getFirstName() + " " + person.getLastName()
                    + ";";
        } else {
            entry += "unknown action";
        }
    }

    public String getEntry() {
        return entry;
    }
}
