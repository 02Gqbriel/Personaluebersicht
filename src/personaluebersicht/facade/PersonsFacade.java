package personaluebersicht.facade;

import java.util.HashMap;
import java.util.Vector;

import personaluebersicht.model.company.Department;
import personaluebersicht.model.employees.Participation;
import personaluebersicht.model.employees.Person;

public class PersonsFacade {
    private Vector<Person>  persons;
    private Vector<Participation> participations;
    private Vector<Department> departments;
    
    public PersonsFacade(Vector<Person> persons, Vector<Participation> participations, Vector<Department> departments){
        this.persons = persons;
        this.participations = participations;
        this.departments = departments;
    }

    public Person getPerson(String firstName, String lastName){
        for (Person person : persons) {
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                return person;
            }
        }

        return null;
    }

    public Vector<String> getFunctionList(Person person){
        Vector<String> functionList = new Vector<>();

        for (Participation participation : participations) {
            if(participation.getOwner() == person){
                for (int i = 0; i < participation.getNumberOfFunctions(); i++) {
                    functionList.add(participation.getFunctionName(i));
                }
            }
        }

        return functionList;
    }

    public Vector<String> getTeamList(Person person){
        Vector<String> teamList = new Vector<>();

        for (Participation participation : participations) {
            if(participation.getOwner() == person){
                for (int i = 0; i < participation.getNumberOfTeams(); i++) {
                    teamList.add(participation.getTeamName(i));
                }
            }
        }

        return teamList;
    }

    public String getDepartmentName(Person person){
        for (Department department : departments) {
            for (int i = 0; i < department.getNumberOfMembers(); i++) {
                if(department.getMember(i) == person){
                    return department.getName();
                }
            }
        }

        return null;
    }

    public Vector<String> getPersonsList(String sort, HashMap<String, String[]> filter){
        return getPersonsList(sort, filter, getPersonsList());
    }

    public Vector<String> getPersonsList(String sort){
        return getPersonsList(sort, null, getPersonsList());
    }

    public Vector<String> getPersonsList(HashMap<String, String[]> filter){
        return getPersonsList(null, filter, getPersonsList());
    }

    public Vector<String> getPersonsList(){
        Vector<String> personsList = new Vector<>();

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            personsList.add(person.getFirstName() + " " + person.getLastName());
        }

        return personsList;
    }

    private Vector<String> getPersonsList(String sort, HashMap<String, String[]> filter, Vector<String> personsList){
        Vector<String> newPersonsList = new Vector<>();
        
        if(filter != null){
            for (int i = 0; i < personsList.size(); i++) {
                boolean add = false;

                if(filter.containsKey("Abteilung")){
                    String[] abteilungsFilter = filter.get("Abteilung");

                    for (int j = 0; j < abteilungsFilter.length; j++) {
                        participations.forEach((item) -> 
                        // !!!! Missing function !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                            add = item.getOwner().equals(persons.get(i))
                        );
                    }
                }

                if(add) newPersonsList.add(personsList.get(i));
            }
        }
        
        if(sort != null){
            if(sort.equals("desc")){
                newPersonsList.sort((e1,e2) -> e2.compareTo(e1));
            }else if(sort.equals("asc")){
                newPersonsList.sort((e1,e2) -> e1.compareTo(e2));
            }
        }

        return newPersonsList;
    }
}
