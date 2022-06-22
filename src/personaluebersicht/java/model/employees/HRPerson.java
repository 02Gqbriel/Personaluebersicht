package personaluebersicht.java.model.employees;

import personaluebersicht.java.model.log.LogBook;
import personaluebersicht.java.model.log.UserAction;

/**
 * a HRPerson which extends from a Person
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class HRPerson extends Person {
    private int modus;
    private String pwd;

    /**
     * public constructor
     * @param fName the Firstname of the HRPerson
     * @param lName the Lastname of the HRPerson
     * @param photo a photo of the HRPerson
     * @param modus the modus of the HRPerson
     */
    public HRPerson(String fName, String lName, Picture photo, int modus) {
        super(fName, lName, photo);
        this.modus = modus;
    }

    /**
     * changes the modus of a HRPerson
     * @param hrperson the person to change
     * @param modus the modus to change
     */
    public void change(HRPerson hrperson, int modus) {
        hrperson.setModus(modus);
    }

    /**
     * sets the modus of this HRPerson
     * @param modus to change
     */
    public void setModus(int modus) {
        this.modus = modus;
    }

    /**
     * gets the Modus of this HRPerson
     * @return modus of the HRPerson
     */
    public int getModus() {
        return modus;
    }

    /**
     * sets a password for the HRPerson
     * @param pwd the password
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * gets the password of the HRPerson
     * @return pwd the password of the HRPerson
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * writes a Log entry
     * @param action to add in log
     * @param person which action was performed to
     */
    public void writeLogEntry(int action, Person person) {
        UserAction userAction = new UserAction(this, person, action);
        LogBook.getLogBookInstance().addEntry(userAction.getEntry());
    }
}
