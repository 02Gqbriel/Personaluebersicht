package personaluebersicht.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import personaluebersicht.java.facade.*;
import personaluebersicht.java.model.company.*;
import personaluebersicht.java.model.employees.*;
import personaluebersicht.java.model.log.*;

public class UseCaseTest {
    private static Company company;

    private static StammdatenFacade stammdatenFacade;
    private static UebersichtFacade uebersichtFacade;
    private static PersonsFacade personsFacade;
    private static ZuordnungFacade zuordnungFacade;
    private static LogbuchFacade logbuchFacade;

    private static Teams team;
    private static JobFunctions jobFunctions;

    private static Vector<Department> departments = new Vector<>();
    private static Vector<Participation> participations = new Vector<>();

    private static Vector<Person> persons = new Vector<>();
    private static HRPerson hrPerson;

    private static LogBook logBook;

    private static String[] vornamen = new String[] { "Gabriel", "Nadim", "Lorenzo", "Nathanael", "Filip", "Blerim",
            "Jonathan", "Guenther", "Markus", "Thomas", "Max", "Justus", "Fabian", "Lukas", "Ben", "Nathan" };

    private static String[] nachnamen = new String[] { "Egli", "Bhatti", "Vöge", "Preu", "Kotur", "Mueller", "Meier",
            "Benak", "Ronaldo", "Messi", "Pogba", "Bale", "Imbrahimovic", "Slavkovic", "Joksimovic", "Maurizi" };

    @Before
    public void init() {
        company = new Company("Company Tester");

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

        stammdatenFacade = new StammdatenFacade(company, departments, jobFunctions, team);
    }

    @Test
    public void getCorrectCompanyName() {
        assertEquals("Company Tester", stammdatenFacade.getCompanyName());
    }

    @Test
    public void editCompanyName() {
        stammdatenFacade.setCompanyName("New Company Name");

        assertEquals("New Company Name", company.getCompanyName());
    }

    @Test
    public void getDepartmentListOfStrings() {
        Vector<String> departmentList = stammdatenFacade.getDepartmentList();

        assertEquals(new Vector<String>().getClass(), departmentList.getClass());
        assertEquals(departments.size(), departmentList.size());
    }

    @Test
    public void addDepartmentToList() {
        Vector<Department> departmentsBefore = (Vector<Department>) departments.clone();

        stammdatenFacade.addDepartment("Bildungzentrum");

        assertNotEquals(departmentsBefore, departments);
        assertEquals("Bildungzentrum", departments.get(departments.size() - 1).getName());
    }

    @Test
    public void editDepartmentName() {
        int index = random(0, departments.size() - 1);

        stammdatenFacade.editDepartment(departments.get(index), "New Department name");

        assertEquals("New Department name", departments.get(index).getName());
    }

    @Test
    public void deleteDepartmentFromList() {
        Vector<Department> departmentsBefore = (Vector<Department>) departments.clone();
        int index = random(0, departments.size() - 1);

        assertTrue("successfully deleted", stammdatenFacade.deleteDepartment(departments.get(index)));
        assertNotEquals(departmentsBefore.get(index).getName(), departments.get(index).getName());
    }

    @Test
    public void getJobFunctionListOfStrings() {
        Vector<String> jobFunctionList = stammdatenFacade.getJobFunctionList();

        assertEquals(new Vector<String>().getClass(), jobFunctionList.getClass());
        assertEquals(jobFunctionList.size(), jobFunctions.getSize());
    }

    @Test
    public void addJobFunctionToList() {
        JobFunctions jobFunctionBefore = new JobFunctions();

        for (int i = 0; i < jobFunctions.getSize(); i++) {
            jobFunctionBefore.addJobFunction(jobFunctions.getJobFunction(i));
        }

        stammdatenFacade.addJobFunction("Kanalreiniger");

        assertNotEquals(jobFunctionBefore, jobFunctions);
        assertEquals("Kanalreiniger", jobFunctions.getJobFunction(jobFunctions.getSize() - 1));
    }

    @Test
    public void editJobFunctionName() {
        int index = random(0, jobFunctions.getSize() - 1);

        stammdatenFacade.editJobFunction(jobFunctions.getJobFunction(index), "New Function name");

        assertEquals("New Function name", jobFunctions.getJobFunction(index));
    }

    @Test
    public void deleteJobFunctionFromList() {
        JobFunctions jobFunctionBefore = new JobFunctions();

        System.out.println(jobFunctions.getSize());

        for (int i = 0; i < jobFunctions.getSize(); i++) {
            jobFunctionBefore.addJobFunction(jobFunctions.getJobFunction(i));
        }
        int index = random(0, jobFunctions.getSize() - 2);

        assertTrue("successfully deleted", stammdatenFacade.deleteJobFunction(jobFunctions.getJobFunction(index)));
        assertNotEquals(jobFunctionBefore.getJobFunction(index), jobFunctions.getJobFunction(index));
    }

    @Test
    public void getTeamListOfStrings() {
        Vector<String> teamList = stammdatenFacade.getTeamList();

        assertEquals(new Vector<String>().getClass(), teamList.getClass());
        assertEquals(teamList.size(), team.getSize());
    }

    @Test
    public void addTeamToList() {
        Teams teamsBefore = new Teams();

        for (int i = 0; i < team.getSize(); i++) {
            teamsBefore.addTeam(team.getTeam(i));
        }

        stammdatenFacade.addTeam("Verwaltung");

        assertNotEquals(teamsBefore, team);
        assertEquals("Verwaltung", team.getTeam(team.getSize() - 1));
    }

    @Test
    public void editTeamName() {
        int index = random(0, team.getSize() - 1);

        stammdatenFacade.editTeam(team.getTeam(index), "New Teamname");

        assertEquals("New Teamname", team.getTeam(index));
    }

    @Test
    public void deleteTeamFromList() {
        Teams teamsBefore = new Teams();

        for (int i = 0; i < team.getSize(); i++) {
            teamsBefore.addTeam(team.getTeam(i));
        }
        int index = random(0, team.getSize() - 2);

        assertTrue("successfully deleted", stammdatenFacade.deleteTeam(team.getTeam(index)));
        assertNotEquals(teamsBefore.getTeam(index), team.getTeam(index));
    }

    private static Person genratePerson() {
        return new Person(vornamen[random(0, vornamen.length - 1)], nachnamen[random(0, nachnamen.length - 1)],
                new Picture("person.jpg"));
    }

    private static int random(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
