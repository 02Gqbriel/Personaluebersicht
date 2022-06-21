package personaluebersicht.java.model.employees;

public class Person {
    private Picture photo;
    private String firstName;
    private String lastName;
    private Participation participation;

    public Person(String fName, String lName, Picture photo) {
        this.photo = photo;
        this.firstName = fName;
        this.lastName = lName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoto(Picture photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Picture getPhoto() {
        return photo;
    }
}
