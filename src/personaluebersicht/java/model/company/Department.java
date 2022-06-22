package personaluebersicht.java.model.company;

import personaluebersicht.java.model.employees.*;
import java.util.ArrayList;

/**
 * a department
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class Department {
    private String name;
    private ArrayList<Person> members;

    /**
     * public constructor
     * @param name of the department
     */
    public Department(String name) {
        this.name = name;
        members = new ArrayList<>();
    }

    /**
     * gets department name
     * @return name of department
     */
    public String getName() {
        return name;
    }

    /**
     * sets department name
     * @param name of the department
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * add a member into members arraylist
     * @param person member of the department
     */
    public void addMember(Person person) {
        members.add(person);
    }

    /**
     * gets a member from members arraylist
     * @return person the member
     */
    public Person getMember(int index) {
        return members.get(index);
    }

    /**
     * removes a member from members arraylist
     * @param index of the member in members arraylist
     */
    public void removeMember(int index) {
        members.remove(index);
    }

    /**
     * gets amount of members in members arraylist
     * @return int amount of members in members arraylist
     */
    public int getNumberOfMembers() {
        return members.size();
    }
}
