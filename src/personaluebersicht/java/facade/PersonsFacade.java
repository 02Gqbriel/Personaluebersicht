package personaluebersicht.java.facade;

import java.util.Vector;

import personaluebersicht.java.model.employees.HRPerson;
import personaluebersicht.java.model.employees.Person;
import personaluebersicht.java.model.employees.Picture;

/**
* the facade for the person class
*
* @author Gabriel Egli
* @since 2020-06-21
* @version 1.0
*
*/
public class PersonsFacade {
    private Vector<Person> persons;

    public PersonsFacade(Vector<Person> persons) {
        this.persons = persons;
    }

    /** 
     * returns a person object by their name
     * 
     * @param name the name of the wanted person
     * @return Person the wanted person object
     */
    public Person getPerson(String name) {
        String[] names = name.split(" ");

        for (Person person : persons) {
            if (person.getFirstName().equals(names[0]) && person.getLastName().equals(names[1]))
                return person;
        }

        return null;
    }

    
    /** 
     * adds a person to the person vector
     * 
     * @param name the name of the person to be added
     * @param picture a picture object that should be used by the person
     * @param modus the modus the person should have
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean addPerson(String name, Picture picture, int modus) {
        String[] names = name.split(" ");

        if (names.length != 2)
            return false;

        // ! Ich han ka was de modus isch?
        if (modus == 0) {
            persons.add(new Person(names[0], names[1], picture));
        } else {
            persons.add(new HRPerson(names[0], names[1], picture, modus));
        }

        return true;
    }

    
    /** 
     * updates a persons credentials
     * 
     * @param person the person which the update should be done on
     * @param name  the name to be updated person
     * @param picture the picture object of the to be updated person
     * @param modus the modus of the person
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean updatePerson(Person person, String name, Picture picture, int modus) {
        if (name != null) {
            String[] names = name.split("");
            person.setFirstName(names[0]);
            person.setLastName(names[1]);
        }

        if (picture != null) {
            person.setPhoto(picture);
        }

        if (modus != 0) {
            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i) == person) {
                    persons.set(i, new HRPerson(person.getFirstName(), person.getLastName(), person.getPhoto(), modus));
                }
            }
        }

        return true;
    }

    
    /** 
     * deletes a person
     * 
     * @param person the person to be deleted
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean deletePerson(Person person) {
        for (Person person2 : persons) {
            if (person2 == person) {
                return persons.remove(person2);
            }
        }

        return false;
    }
}
