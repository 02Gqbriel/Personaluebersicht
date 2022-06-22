package personaluebersicht.java.facade;

import java.util.Vector;

import personaluebersicht.java.model.company.*;

/**
 * the facade for the "stammdaten" class
 *
 * @author Gabriel Egli
 * @since 2020-06-21
 * @version 1.0
 *
 */
public class StammdatenFacade {
    private Company company;
    private Vector<Department> departments;
    private JobFunctions jobFunctions;
    private Teams teams;

    public StammdatenFacade(Company company, Vector<Department> departments, JobFunctions jobFunctions, Teams teams) {
        this.company = company;
        this.departments = departments;
        this.jobFunctions = jobFunctions;
        this.teams = teams;
    }

    /**
     * getter for the company name
     * 
     * @return String the company name
     */
    public String getCompanyName() {
        return company.getCompanyName();
    }

    /**
     * setter for the company name
     * 
     * @param companyName the new company name
     */
    public void setCompanyName(String companyName) {
        company.setName(companyName);
    }

    /**
     * returns a vector of all the departments names
     * 
     * @return Vector<String> the department name vector
     */
    public Vector<String> getDepartmentList() {
        Vector<String> departmentNameList = new Vector<>();

        for (Department department : departments) {
            departmentNameList.add(department.getName());
        }

        return departmentNameList;
    }

    /**
     * adds a new department to the department vector
     * 
     * @param departmentName the name of the new department
     */
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    /**
     * edits a department
     * 
     * @param department     the department to be edited
     * @param departmentName the new department name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean editDepartment(Department department, String departmentName) {
        for (Department department2 : departments) {
            if (department == department2) {
                department2.setName(departmentName);
                return true;
            }
        }

        return false;
    }

    /**
     * deletes an existing department
     * 
     * @param department department to be deleted
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean deleteDepartment(Department department) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i) == department) {
                departments.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * gets a department based on its name
     * 
     * @param name name of the department
     * @return Department the requested department
     */
    public Department getDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }

        return null;
    }

    /**
     * gets a vector of all job function names
     * 
     * @return Vector<String> the vector of names
     */
    public Vector<String> getJobFunctionList() {
        Vector<String> jobFunctionList = new Vector<>();

        for (int i = 0; i < jobFunctions.getSize(); i++) {
            jobFunctionList.add(jobFunctions.getJobFunction(i));
        }

        return jobFunctionList;
    }

    /**
     * adds a new job function by its name
     * 
     * @param jobFunctionName name of the new job function
     */
    public void addJobFunction(String jobFunctionName) {
        jobFunctions.addJobFunction(jobFunctionName);
    }

    /**
     * edits a job function
     * 
     * @param jobFunctions    the job function to be edited
     * @param jobFunctionName the new job function name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean editJobFunction(String oldJobFunctions, String newJobFunctionName) {
        for (int i = 0; i < jobFunctions.getSize(); i++) {
            if (jobFunctions.getJobFunction(i).equals(oldJobFunctions)) {
                jobFunctions.setJobFunction(i, newJobFunctionName);
                return true;
            }
        }
        return false;
    }

    /**
     * deletes a job function
     * 
     * @param jobFunctions the to be deleted job functiuon
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean deleteJobFunction(String jobFunctionName) {
        for (int i = 0; i < jobFunctions.getSize(); i++) {
            if (jobFunctionName.equals(jobFunctions.getJobFunction(i))) {
                jobFunctions.removeJobFunction(i);
                return true;
            }

        }
        return false;
    }

    /**
     * gets a vector of all team names
     * 
     * @return Vector<String> the vector of names
     */
    public Vector<String> getTeamList() {
        Vector<String> teamList = new Vector<>();

        for (int i = 0; i < teams.getSize(); i++) {
            teamList.add(teams.getTeam(i));
        }

        return teamList;
    }

    /**
     * adds new a team to the team vector
     * 
     * @param teamName the new team name
     */
    public void addTeam(String teamName) {
        teams.addTeam(teamName);
    }

    /**
     * edits a team
     * 
     * @param oldTeamName the to be edited team
     * @param newTeamName the new team name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean editTeam(String oldTeamName, String newTeamName) {
        for (int i = 0; i < teams.getSize(); i++) {
            if (oldTeamName.equals(teams.getTeam(i))) {
                teams.setTeam(i, newTeamName);
                return true;
            }
        }

        return false;
    }

    /**
     * deletes a team
     * 
     * @param teamName the to be deleted team
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean deleteTeam(String teamName) {
        for (int i = 0; i < teams.getSize(); i++) {
            if (teamName.equals(teams.getTeam(i))) {
                teams.removeTeam(i);
                return true;
            }
        }

        return false;
    }
}
