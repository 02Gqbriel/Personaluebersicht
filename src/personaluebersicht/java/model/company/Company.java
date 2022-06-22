package personaluebersicht.java.model.company;

import java.util.ArrayList;

/**
 * a company
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class Company {
    private String name;
    private ArrayList<Department> departments;

    /**
     * public constructor
     * @param name of the company
     */
    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    /**
     * gets CompanyName
     * @return name
     */
    public String getCompanyName() {
        return name;
    }

    /**
     * adds a department into departments ArrayList
     * @param department to add
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * gets Department
     * @return department
     */
    public Department getDepartment(int index) {
        return departments.get(index);
    }

    /**
     * gets a List of all departmentnames in departments arraylist as String
     * @return names of all departments
     */
    public String getDepartmentsName() {
        String names = "";
        for (Department entry : departments) {
            names += ", " + entry.getName();
        }
        return names;
    }

    /**
     * removes a department from deparments arraylist
     * @param index of the department in departments arraylist
     */
    public void removeDepartment(int index) {
        departments.remove(index);
    }

    /**
     * gets amount of departments in departments arraylist
     * @return int of departments size
     */
    public int getNumberOfDepartments() {
        return departments.size();
    }

    /**
     * sets the company name
     * @param name of the company
     */
    public void setName(String name) {
        this.name = name;
    }
}
