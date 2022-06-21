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
    private Vector<JobFunctions> jobFunctions;
    private Vector<Teams> teams;

    public StammdatenFacade(Company company, Vector<Department> departments, Vector<JobFunctions> jobFunctions, Vector<Teams> teams){
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
    public String getCompanyName(){
        return company.getCompanyName();
    }

    
    /** 
     * setter for the company name
     * 
     * @param companyName the new company name
     */
    public void setCompanyName(String companyName){
        company.setName(companyName);
    }

    
    /** 
     * returns a vector of all the departments names
     * 
     * @return Vector<String> the department name vector
     */
    public Vector<String> getDepartmentList(){
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
    public void addDepartment(String departmentName){
        departments.add(new Department(departmentName));
    }

    
    /** 
     * edits a department
     * 
     * @param department the department to be edited
     * @param departmentName the new department name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean editDepartment(Department department, String departmentName){
        for (Department department2 : departments) {
            if(department == department2) {
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
    public boolean deleteDepartment(Department department){
        for (int i = 0; i < departments.size(); i++) {
            if(departments.get(i) == department){
                department.removeMember(i);
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
    public Department getDepartment(String name){
        for (Department department : departments) {
            if(department.getName().equals(name)){
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
    public Vector<String> getJobFunctionList(){
        Vector<String> jobFunctionList = new Vector<>();

        for (JobFunctions jobFunction : jobFunctions) {
            for (int i = 0; i < jobFunction.getSize(); i++) {
                jobFunctionList.add(jobFunction.getJobFunction(i));
            }
        }

        return jobFunctionList;
    }

    
    /** 
     * adds a new job function by its name
     * 
     * @param jobFunctionName name of the new job function
     */
    public void addJobFunction(String jobFunctionName){
        //! komisch
        jobFunctions.add(new JobFunctions());
    }

    
    /** 
     * edits a job function
     * 
     * @param jobFunctions the job function to be edited
     * @param jobFunctionName the new job function name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean editJobFunction(JobFunctions jobFunctions, String jobFunctionName){
        // ! komisch

        return false;
    }

    
    /** 
     * deletes a job function
     * 
     * @param jobFunctions the to be deleted job functiuon
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean deleteJobFunction(JobFunctions jobFunctions){
        // ! komisch
        return false;
    }

    
    /** 
     * gets a job function based on its name
     * 
     * @param jobFunctionName the requested job functions name
     * @return JobFunctions the job function
     */
    public JobFunctions getJobFunction(String jobFunctionName){
        for (JobFunctions jobFunction : jobFunctions) {
            for (int i = 0; i < jobFunction.getSize(); i++) {
                if(jobFunction.getJobFunction(i).equals(jobFunctionName)) return jobFunction;
            }
        }

        return null;
    }

    
    /** 
     * gets a vector of all team names
     * 
     * @return Vector<String> the vector of names
     */
    public Vector<String> getTeamList(){
        Vector<String> teamList = new Vector<>();

        for (Teams team : teams) {
            for (int i = 0; i < team.getSize(); i++) {
                teamList.add(team.getTeam(i));
            }
        }

        return teamList;
    }

    
    /** 
     * adds new a team to the team vector
     * 
     * @param teamName the new team name
     */
    public void addTeam(String teamName){
        teams.add(new Teams());
    }

    
    /** 
     * edits a team
     * 
     * @param team the to be edited team
     * @param teamName the new team name
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean editTeam(Teams team, String teamName){
        // ! komisch

        return false;
    }

    
    /** 
     * deletes a team
     * 
     * @param team the to be deleted team
     * @return boolean true = successful; false = unsuccessful
     */
    public boolean deleteTeam(Teams team){
        // ! komisch
        return false;
    }

    
    /** 
     * gets a team based on its name
     * 
     * @param teamName the team name of the requested team
     * @return Teams the requested team
     */
    public Teams getTeam(String teamName){
        for (Teams team : teams) {
            for (int i = 0; i < team.getSize(); i++) {
                if(team.getTeam(i).equals(teamName)) return team;
            }
        }

        return null;
    }
}
