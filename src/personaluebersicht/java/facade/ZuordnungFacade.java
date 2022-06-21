package personaluebersicht.java.facade;

import java.util.Vector;

import personaluebersicht.java.model.employees.*;
import personaluebersicht.java.model.company.*;;

public class ZuordnungFacade {
    private Vector<Person> persons;
    private Vector<Participation> participations;
    private Vector<Department> departments;

    public ZuordnungFacade(Vector<Person> persons, Vector<Participation> participations,
            Vector<Department> departments) {
        this.persons = persons;
        this.departments = departments;
        this.participations = participations;
    }

    public Person getPerson(String firstName, String lastName) {
        for (Person person : persons) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return person;
            }
        }

        return null;
    }

    public boolean updateName(Person person, String name) {
        String[] names = name.split(" ");

        if (names.length == 2) {
            person.setFirstName(names[0]);
            person.setLastName(names[1]);

            return true;
        } else {
            return false;
        }
    }

    public boolean updateDepartment(Person person, String abteilung) {
        boolean removeDone = false, addDone = false;

        for (Department department : departments) {
            if (!removeDone) {
                for (int i = 0; i < department.getNumberOfMembers(); i++) {
                    if (department.getMember(i) == person) {
                        department.removeMember(i);
                        removeDone = true;
                    }
                }
            }

            if (department.getName() == abteilung && !addDone) {
                department.addMember(person);
            }
        }

        return (removeDone && addDone);
    }

    public boolean updateFunction(Person person, String function) {
        for (Participation participation : participations) {
            if (participation.getOwner() == person) {
                // ! Function im gui nur 1 aber im model meherere
                return true;
            }
        }

        return false;
    }

    public boolean updateTeam(Person person, String team) {
        for (Participation participation : participations) {
            if (participation.getOwner() == person) {
                // ! Team im gui nur 1 aber im model meherere
                return true;
            }
        }

        return false;
    }

    public Vector<String> getPersonsList() {
        Vector<String> personsList = new Vector<>();

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            personsList.add(person.getFirstName() + " " + person.getLastName());
        }

        return personsList;
    }
}
