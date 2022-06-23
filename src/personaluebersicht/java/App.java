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
    static Teams team;
    static JobFunctions jobFunctions;
    static Vector<Department> departments = new Vector<>();

    // model > employees
    static Vector<Participation> participations = new Vector<>();
    static Vector<Person> persons = new Vector<>();
    static HRPerson hrPerson;

    // model > log
    static LogBook logBook;

    // facade
    static PersonsFacade personsFacade;
    static LogbuchFacade logbuchFacade;
    static UebersichtFacade uebersichtFacade;
    static StammdatenFacade stammdatenFacade;
    static ZuordnungFacade zuordnungFacade;

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

        jobFunctions = new JobFunctions();
        jobFunctions.addJobFunction("Telekomunist");
        jobFunctions.addJobFunction("Ausbildner");

        team = new Teams();
        team.addTeam("Webentwickler");
        team.addTeam("Netzwerktechniker");
        team.addTeam("Androidentwickler");
        team.addTeam("Backendentwickler");

        for (int i = 0; i < 20; i++) {
            persons.add(genratePerson());
        }

        hrPerson = new HRPerson("Frederico", "Maneca", new Picture("person.jpg"), 2);

        for (int i = 0; i < persons.size(); i++) {
            Participation participation = new Participation(persons.get(i));

            participation.addFunction(jobFunctions.getJobFunction(random(0, jobFunctions.getSize() - 1)));
            participation.addTeam(team.getTeam(random(0, team.getSize() - 1)));

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
        zuordnungFacade = new ZuordnungFacade(persons, participations, departments);
        stammdatenFacade = new StammdatenFacade(company, departments, jobFunctions, team);
        uebersichtFacade = new UebersichtFacade(persons, participations, departments);

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
