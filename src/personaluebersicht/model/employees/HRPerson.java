package personaluebersicht.model.employees;

public class HRPerson extends Person {
    private int modus;
    private String pwd;

    public HRPerson(String fName, String lName, Picture photo, int modus) {
        super(fName, lName, photo);
        this.modus = modus;
    }

    public void change(Person person, int modus) {
        // Unklar
    }

    public void setModus(int modus) {
        this.modus = modus;
    }

    public int getModus() {
        return modus;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void writeLogEntry(int action, Person person) {
        // unklar
    }
}
