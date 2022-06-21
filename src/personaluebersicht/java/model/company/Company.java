package personaluebersicht.java.model.company;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public String getCompanyName() {
        return name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public Department getDepartment(int index) {
        return departments.get(index);
    }

    public String getDepartmentsName() {
        // Unklar
        return "";
    }

    public void removeDepartment(int index) {
        departments.remove(index);
    }

    public int getNumberOfDepartments() {
        return departments.size();
    }

    public void setName(String name){
        this.name = name;
    }
}
