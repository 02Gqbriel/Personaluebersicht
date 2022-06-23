package personaluebersicht.java;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;

import personaluebersicht.java.facade.*;
import personaluebersicht.java.model.company.*;

public class UseCaseTest {
    private static Company company;

    private static StammdatenFacade stammdatenFacade;

    private static Teams team;
    private static JobFunctions jobFunctions;

    private static Vector<Department> departments = new Vector<>();

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

        for (int i = 0; i < departments.size(); i++) {
            company.addDepartment(departments.get(i));
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
    public void getDepartmentByName() {
        int index = random(0, departments.size());

        assertEquals(departments.get(index), stammdatenFacade.getDepartment(departments.get(index).getName()));
    }

    @Test
    public void getDepartmentByNameWrong() {
        assertNull(stammdatenFacade.getDepartment("This Department doesn't exist"));
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

    private static int random(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}