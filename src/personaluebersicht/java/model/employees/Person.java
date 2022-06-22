package personaluebersicht.java.model.employees;

/**
 * a Person
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class Person {
    private Picture photo;
    private String firstName;
    private String lastName;
    private Participation participation;

    /**
     * public constructor
     * @param fName the Firstname of the Person
     * @param lName the Lastname of the Person
     * @param photo a photo of the Person
     */
    public Person(String fName, String lName, Picture photo) {
        this.photo = photo;
        this.firstName = fName;
        this.lastName = lName;
    }

    /**
     * sets the firstname of the person
     * @param firstName of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * sets the lastname of the person
     * @param lastName of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * sets the photo of the person
     * @param photo the photo
     */
    public void setPhoto(Picture photo) {
        this.photo = photo;
    }

    /**
     * gets the firstname of the person
     * @return firstName of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * gets the lastname of the person
     * @return lastname of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * gets the photo of the person
     * @return photo of the person
     */
    public Picture getPhoto() {
        return photo;
    }
}
