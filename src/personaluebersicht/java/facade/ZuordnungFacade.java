package personaluebersicht.java.facade;

import java.util.Vector;

import personaluebersicht.java.model.employees.*;
import personaluebersicht.java.model.company.*;;

/**
* the facade for the assignment class
*
* @author Gabriel Egli
* @since 2020-06-21
* @version 1.0
*
*/
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

    
    /** 
     * gets a person by their name
     * 
     * @param name the name of the person
     * @return Person the person searched for
     */
    public Person getPerson(String name) {
        String[] names = name.split(" ");

        for (Person person : persons) {
            if (person.getFirstName().equals(names[0]) && person.getLastName().equals(names[1])) {
                return person;
            }
        }

        return null;
    }

    
    /** 
     * updates a person
     * 
     * @param person the person to be updated
     * @param name the new name
     * @return boolean true = successful; false = unsuccessful
     */
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

    
    /** 
     * updates department of a person
     * 
     * @param person the person in question
     * @param abteilung the new department name
     * @return boolean true = successful; false = unsuccessful
     */
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

    
    /** 
     * updates one function of a person
     * 
     * @param person the person in question
     * @param function the new function name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean updateFunction(Person person, String function) {
        for (Participation participation : participations) {
            if (participation.getOwner() == person) {
                // ! Function im gui nur 1 aber im model meherere
                return true;
            }
        }

        return false;
    }

    
    /** 
     * updates a team of a person
     * 
     * @param person the person in question
     * @param team the new team name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean updateTeam(Person person, String team) {
        for (Participation participation : participations) {
            if (participation.getOwner() == person) {
                // ! Team im gui nur 1 aber im model meherere
                return true;
            }
        }

        return false;
    }

    
    /** 
     * gets a list of person
     * 
     * @return Vector<String> the person vector
     */
    public Vector<String> getPersonsList() {
        Vector<String> personsList = new Vector<>();

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            personsList.add(person.getFirstName() + " " + person.getLastName());
        }

        return personsList;
    }
}
