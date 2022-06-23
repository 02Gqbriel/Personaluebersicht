package personaluebersicht.java.model.company;

import org.junit.Before;
import org.junit.Test;
import personaluebersicht.java.model.employees.Person;
import personaluebersicht.java.model.employees.Picture;

import static org.junit.Assert.assertEquals;

public class CompanyTest {
    private Company company;
    private Department department;
    private Person quandale;
    private JobFunctions jobFunctions;
    private Teams teams;

    @Before
    public void init() {
        company = new Company("TJK Konk. AG");
        department = new Department("KSH");
        company.addDepartment(department);
        quandale = new Person("Quandale", "Dingle", new Picture("pic.png"));
        department.addMember(quandale);
        jobFunctions = new JobFunctions();
        jobFunctions.addJobFunction("qiener");
        teams = new Teams();
        teams.addTeam("A-Team");
    }

    // Company

    @Test
    public void getCompanyCorrectName() {
        assertEquals(company.getCompanyName(), "TJK Konk. AG");
    }

    @Test
    public void getDepartment() {
        assertEquals(company.getDepartment(0), department);
    }

    @Test
    public void getDepartmentsName() {
        assertEquals(company.getDepartment(0).getName(), "KSH");
    }

    @Test
    public void getNumberDepartments() {
        assertEquals(company.getNumberOfDepartments(), 1);
    }

    // Department

    @Test
    public void getDepartmentMember() {
        assertEquals(department.getMember(0), quandale);
    }

    @Test
    public void getDepartmentNumberOfMembers() {
        assertEquals(department.getNumberOfMembers(), 1);
    }

    // JobFunctions

    @Test
    public void getJobFunction() {
        assertEquals(jobFunctions.getJobFunction(0), "qiener");
    }

    @Test
    public void JobFunctionGetSize() {
        assertEquals(jobFunctions.getSize(), 1);
    }

    // Teams

    @Test
    public void TeamsGetTeam() {
        assertEquals(teams.getTeam(0), "A-Team");
    }

    @Test
    public void teamsGetSize() {
        assertEquals(teams.getSize(), 1);
    }

}
