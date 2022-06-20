package personaluebersicht;

import java.util.Random;
import java.util.Vector;

import personaluebersicht.model.company.Company;
import personaluebersicht.model.company.Department;
import personaluebersicht.model.company.JobFunctions;
import personaluebersicht.model.employees.Person;
import personaluebersicht.model.employees.Picture;

public class App {
    private static String[] vornamen = new String[] { "Gabriel", "Nadim", "Lorenzo", "Nathanael", "Filip", "Blerim",
            "Jonathan", "Guenther", "Markus", "Thomas", "Max", "Justus", "Fabian", "Lukas", "Ben", "Nathan" };

    private static String[] nachnamen = new String[] { "Egli", "Bhatti", "Vöge", "Preu", "Kotur", "Mueller", "Meier",
            "Benak", "Ronaldo", "Messi", "Pogba", "Bale", "Imbrahimovic", "Slavkovic", "Joksimovic", "Maurizi" };

    static Company company;
    static Vector<Department> departments = new Vector<>();
    static Vector<JobFunctions> jobFunctions = new Vector<>();
    static Vector<Person> persons = new Vector<>();

    public static void main(String[] args) {
        company = new Company("Produkta Konkurs GmbH");

        departments.add(new Department("Informatik"));
        departments.add(new Department("Finanzen"));
        departments.add(new Department("Kundeservice"));
        departments.add(new Department("Werbung"));
        departments.add(new Department("Human Resources"));

        for (int i = 0; i < 2; i++) {
            JobFunctions jb = new JobFunctions();

            jb.addJobFunction("Telekomunist");
            jb.addJobFunction("Ausbildner");

            jobFunctions.add(new JobFunctions());
        }

        for (int i = 0; i < 20; i++) {
            persons.add(genratePerson());
        }

    }

    private static Person genratePerson() {
        return new Person(vornamen[random(0, vornamen.length)], nachnamen[random(0, nachnamen.length)],
                new Picture("person.jpg"));
    }

    private static int random(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
