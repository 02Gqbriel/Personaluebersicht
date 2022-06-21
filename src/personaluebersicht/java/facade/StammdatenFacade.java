package personaluebersicht.java.facade;

import java.util.Vector;

import personaluebersicht.java.model.company.Company;
import personaluebersicht.java.model.company.Department;
import personaluebersicht.java.model.company.JobFunctions;
import personaluebersicht.java.model.company.Teams;
import personaluebersicht.java.model.employees.Participation;

public class StammdatenFacade {
    private Company company;
    private Vector<Department> departments;
    private Vector<JobFunctions> jobFunctions;
    private Vector<Teams> teams;

    public StammdatenFacade(Company company, Vector<Department> departments, Vector<JobFunctions> jobFunctions, Vector<Teams> teams){
        this.company = company;
        this.departments = departments;
        this.jobFunctions = jobFunctions;
        this.teams = teams;
    }

    public String getCompanyName(){
        return company.getCompanyName();
    }

    public void setCompanyName(String companyName){
        company.setName(companyName);
    }

    public Vector<String> getDepartmentList(){
        Vector<String> departmentNameList = new Vector<>();

        for (Department department : departments) {
            departmentNameList.add(department.getName());
        }

        return departmentNameList;
    }

    public void addDepartment(String departmentName){
        departments.add(new Department(departmentName));
    }

    public boolean editDepartment(Department department, String departmentName){
        for (Department department2 : departments) {
            if(department == department2) {
                department2.setName(departmentName);
                return true;
            }
        }

        return false;
    }

    public boolean deleteDepartment(Department department){
        for (int i = 0; i < departments.size(); i++) {
            if(departments.get(i) == department){
                department.removeMember(i);
                return true;
            }
        }
        return false;
    }

    public Department getDepartment(String name){
        for (Department department : departments) {
            if(department.getName().equals(name)){
                return department;
            }
        }

        return null;
    }

    public Vector<String> getJobFunctionList(){
        Vector<String> jobFunctionList = new Vector<>();

        for (JobFunctions jobFunction : jobFunctions) {
            for (int i = 0; i < jobFunction.getSize(); i++) {
                jobFunctionList.add(jobFunction.getJobFunction(i));
            }
        }

        return jobFunctionList;
    }

    public void addJobFunction(String jobFunctionName){
        jobFunctions.add(new JobFunctions());
    }

    public boolean editJobFunction(JobFunctions jobFunctions, String jobFunctionName){
        // ! komisch

        return false;
    }

    public boolean deleteJobFunction(JobFunctions jobFunctions){
        // ! komisch
        return false;
    }

    public JobFunctions getJobFunction(String jobFunctionName){
        for (JobFunctions jobFunction : jobFunctions) {
            for (int i = 0; i < jobFunction.getSize(); i++) {
                if(jobFunction.getJobFunction(i).equals(jobFunctionName)) return jobFunction;
            }
        }

        return null;
    }

    public Vector<String> getTeamList(){
        Vector<String> teamList = new Vector<>();

        for (Teams team : teams) {
            for (int i = 0; i < team.getSize(); i++) {
                teamList.add(team.getTeam(i));
            }
        }

        return teamList;
    }

    public void addTeam(String teamName){
        teams.add(new Teams());
    }

    public boolean editTeam(Teams team, String teamName){
        // ! komisch

        return false;
    }

    public boolean deleteTeam(Teams team){
        // ! komisch
        return false;
    }

    public Teams getTeam(String teamName){
        for (Teams team : teams) {
            for (int i = 0; i < team.getSize(); i++) {
                if(team.getTeam(i).equals(teamName)) return team;
            }
        }

        return null;
    }
}
