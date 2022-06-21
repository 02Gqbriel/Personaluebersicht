package personaluebersicht.java;

import java.util.Random;
import java.util.Vector;

import personaluebersicht.java.facade.*;
import personaluebersicht.java.model.employees.*;
import personaluebersicht.java.model.company.*;
import personaluebersicht.java.model.log.*;
import personaluebersicht.java.view.*;

public class App {
    private static String[] vornamen = new String[] { "Gabriel", "Nadim", "Lorenzo", "Nathanael", "Filip", "Blerim",
            "Jonathan", "Guenther", "Markus", "Thomas", "Max", "Justus", "Fabian", "Lukas", "Ben", "Nathan" };

    private static String[] nachnamen = new String[] { "Egli", "Bhatti", "Vöge", "Preu", "Kotur", "Mueller", "Meier",
            "Benak", "Ronaldo", "Messi", "Pogba", "Bale", "Imbrahimovic", "Slavkovic", "Joksimovic", "Maurizi" };

    // model > company
    static Company company;
    static Vector<Department> departments = new Vector<>();
    static Vector<JobFunctions> jobFunctions = new Vector<>();
    static Vector<Teams> teams = new Vector<>();

    // model > employees
    static Vector<Participation> participations = new Vector<>();
    static Vector<Person> persons = new Vector<>();
    static HRPerson hrPerson;

    // model > log
    static LogBook logBook;

    // facade
    static PersonsFacade personsFacade;
    static LogbuchFacade logbuchFacade;

    // view
    static PersonaluebersichtGUIFinal mainFrame;

    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        // Modelklassen
        company = new Company("Produkta Konkurs GmbH");

        departments.add(new Department("Informatik"));
        departments.add(new Department("Finanzen"));
        departments.add(new Department("Kundeservice"));
        departments.add(new Department("Werbung"));
        departments.add(new Department("Human Resources"));

        for (int i = 1; i < 3; i++) {
            JobFunctions jb = new JobFunctions();

            jb.addJobFunction("Telekomunist " + i);
            jb.addJobFunction("Ausbildner " + i);

            jobFunctions.add(new JobFunctions());
        }

        for (int i = 1; i < 4; i++) {
            Teams team = new Teams();

            team.addTeam("Webentwickler " + i);
            team.addTeam("Netzwerktechniker " + i);
            team.addTeam("Androidentwickler " + i);
            team.addTeam("Backendentwickler " + i);

            teams.add(team);
        }

        for (int i = 0; i < 20; i++) {
            persons.add(genratePerson());
        }

        hrPerson = new HRPerson("Frederico", "Maneca", new Picture("person.jpg"), 2);

        for (int i = 0; i < persons.size(); i++) {
            Participation participation = new Participation(persons.get(i));

            participation.addFunction(jobFunctions.get(random(0, jobFunctions.size() - 1)));
            participation.addTeam(teams.get(random(0, teams.size() - 1)));

            participations.add(participation);
        }

        for (int i = 0; i < departments.size(); i++) {
            company.addDepartment(departments.get(i));
        }

        for (int i = 0; i < persons.size(); i++) {
            departments.get(random(0, departments.size() - 1)).addMember(persons.get(i));
        }

        logBook = LogBook.getLogBookInstance();

        // Facaden

        personsFacade = new PersonsFacade(persons);
        logbuchFacade = new LogbuchFacade();

        // GUI
        mainFrame = new PersonaluebersichtGUIFinal();

    }

    
    /** 
     * @return Person
     */
    private static Person genratePerson() {
        return new Person(vornamen[random(0, vornamen.length - 1)], nachnamen[random(0, nachnamen.length - 1)],
                new Picture("person.jpg"));
    }

    
    /** 
     * @param min
     * @param max
     * @return int
     */
    private static int random(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
