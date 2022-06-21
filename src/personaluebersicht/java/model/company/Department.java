package personaluebersicht.java.model.company;

import personaluebersicht.java.model.employees.*;
import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Person> members;

    public Department(String name) {
        this.name = name;
        members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public Person getMember(int index) {
        return members.get(index);
    }

    public void removeMember(int index) {
        members.remove(index);
    }

    public int getNumberOfMembers() {
        return members.size();
    }
}
