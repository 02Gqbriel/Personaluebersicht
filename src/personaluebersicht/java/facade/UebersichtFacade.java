package personaluebersicht.java.facade;

import java.util.HashMap;
import java.util.Vector;

import personaluebersicht.java.model.company.Department;
import personaluebersicht.java.model.employees.Participation;
import personaluebersicht.java.model.employees.Person;

/**
 * the facade for the overview, "uebersicht", class
 *
 * @author Gabriel Egli
 * @since 2020-06-21
 * @version 1.0
 *
 */
public class UebersichtFacade {
    private Vector<Person> persons;
    private Vector<Participation> participations;
    private Vector<Department> departments;

    public UebersichtFacade(Vector<Person> persons, Vector<Participation> participations,
            Vector<Department> departments) {
        this.persons = persons;
        this.participations = participations;
        this.departments = departments;
    }

    /**
     * gets a person based on his name
     * 
     * @param name the name of the person
     * @return Person the person object
     */
    public Person getPerson(String name) {
        String[] names = name.split("");

        for (Person person : persons) {
            if (person.getFirstName().equals(names[0]) && person.getLastName().equals(names[1])) {
                return person;
            }
        }

        return null;
    }

    /**
     * gets a vector of function names of one person
     * 
     * @param person the person assocaited to the function vector
     * @return Vector<String> the function name vector
     */
    public Vector<String> getFunctionList(Person person) {
        Vector<String> functionList = new Vector<>();

        for (Participation participation : participations) {
            if (participation.getOwner() == person) {
                for (int i = 0; i < participation.getNumberOfFunctions(); i++) {
                    functionList.add(participation.getFunctionName(i));
                }
            }
        }

        return functionList;
    }

    /**
     * gets a vector of team names of one person
     * 
     * @param person the person assocaited to the team vector
     * @return Vector<String> the team name vector
     */
    public Vector<String> getTeamList(Person person) {
        Vector<String> teamList = new Vector<>();

        for (Participation participation : participations) {
            if (participation.getOwner() == person) {
                for (int i = 0; i < participation.getNumberOfTeams(); i++) {
                    teamList.add(participation.getTeamName(i));
                }
            }
        }

        return teamList;
    }

    /**
     * get the name of the department associated with the person
     * 
     * @param person the person in question
     * @return String the name of the department
     */
    public String getDepartmentName(Person person) {
        for (Department department : departments) {
            for (int i = 0; i < department.getNumberOfMembers(); i++) {
                if (department.getMember(i) == person) {
                    return department.getName();
                }
            }
        }

        return null;
    }

    /**
     * get a filtered and sorted list of all the person in the company
     * 
     * @param sort   the sort parameter ["asc" => alphabetic ascending; "desc" =>
     *               alphabetic descending]
     * @param filter the filter hash map; key => "Abteilung" || "Funktion" ||
     *               "Team"; value => an array of corresponding values
     * @return Vector<String> the filtered and sorted list
     */
    public Vector<String> getPersonsList(String sort, HashMap<String, String[]> filter) {
        return getPersonsList(sort, filter, getPersonsList());
    }

    /**
     * get a sorted list of all the person in the company
     * 
     * @param sort the sort parameter ["asc" => alphabetic ascending; "desc" =>
     *             alphabetic descending]
     * @return Vector<String> the sorted list
     */
    public Vector<String> getPersonsList(String sort) {
        return getPersonsList(sort, null, getPersonsList());
    }

    /**
     * get a filtered list of all the person in the company
     * 
     * @param filter the filter hash map; key => "Abteilung" || "Funktion" ||
     *               "Team"; value => an array of corresponding values
     * @return Vector<String> the filtered list
     */
    public Vector<String> getPersonsList(HashMap<String, String[]> filter) {
        return getPersonsList(null, filter, getPersonsList());
    }

    /**
     * gets a not sorted and neither filtered list of persons
     * 
     * @return Vector<String> the vector of persons
     */
    public Vector<String> getPersonsList() {
        Vector<String> personsList = new Vector<>();

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            personsList.add(person.getFirstName() + " " + person.getLastName());
        }

        return personsList;
    }

    /**
     * the mother function which handles all other getPersonList functions
     * 
     * @param sort        the sort parameter ["asc" => alphabetic ascending; "desc"
     *                    => alphabetic descending]
     * @param filter      the filter hash map; key => "Abteilung" || "Funktion" ||
     *                    "Team"; value => an array of corresponding values
     * @param personsList the current person list
     * @return Vector<String> the requested person vector
     */
    private Vector<String> getPersonsList(String sort, HashMap<String, String[]> filter, Vector<String> personsList) {
        Vector<String> newPersonsList = new Vector<>();

        if (filter != null) {
            for (int i = 0; i < personsList.size(); i++) {
                boolean add = false;

                if (filter.containsKey("Abteilung")) {
                    String[] abteilungsFilter = filter.get("Abteilung");

                    for (String abteilungString : abteilungsFilter) {
                        for (Department department : departments) {
                            for (int j = 0; j < department.getNumberOfMembers(); j++) {
                                add = department.getMember(j) == persons.get(i)
                                        && department.getName().equals(abteilungString);
                            }
                        }
                    }

                }

                for (Participation participation : participations) {
                    if (filter.containsKey("Funktion")) {
                        String[] functionFilter = filter.get("Funktion");

                        for (String functionString : functionFilter) {
                            for (int j = 0; j < participation.getNumberOfFunctions(); j++) {
                                add = participation.getOwner() == persons.get(i)
                                        && participation.getFunctionName(j).equals(functionString);
                            }
                        }
                    }

                    if (filter.containsKey("Team")) {
                        String[] temaFilter = filter.get("Team");

                        for (String teamString : temaFilter) {
                            for (int j = 0; j < participation.getNumberOfTeams(); j++) {
                                add = participation.getOwner() == persons.get(i)
                                        && participation.getTeamName(j).equals(teamString);
                            }
                        }
                    }
                }

                if (add)
                    newPersonsList.add(personsList.get(i));
            }
        }

        if (sort != null)

        {
            if (sort.equals("desc")) {
                newPersonsList.sort((e1, e2) -> e2.compareTo(e1));
            } else if (sort.equals("asc")) {
                newPersonsList.sort((e1, e2) -> e1.compareTo(e2));
            }
        }

        return newPersonsList;
    }
}
