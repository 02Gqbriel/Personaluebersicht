package personaluebersicht.java.model.company;

import java.util.ArrayList;

/**
 * a JobFunction
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class JobFunctions {
    private ArrayList<String> designations;

    /**
     * public constructor
     */
    public JobFunctions() {
        designations = new ArrayList<String>();
    }

    /**
     * adds a JobFunction in designations arrayList
     * @param function String to add
     */
    public void addJobFunction(String function) {
        designations.add(function);
    }

    /**
     * gets a JobFunction from the designations arraylist
     * @param index of the JobFunction in designations arraylist
     * @return JobFunction String
     */
    public String getJobFunction(int index) {
        return designations.get(index);
    }

    /**
     * removes a JobFunction from designations arraylist
     * @param index from the JobFunction in designations arraylist
     */
    public void removeJobFunction(int index) {
        designations.remove(index);
    }

    /**
     * gets amount of JobFunctions in designations arraylist
     * @return int amount of JobFunctions
     */
    public int getSize() {
        return designations.size();
    }

    /**
     * adds a JobFunction to a specific index in arraylist designations
     * @param index in the designations arraylist
     * @param jobFunctionName job function to ass
     */
    public void setJobFunction(int index, String jobFunctionName) {
        designations.set(index, jobFunctionName);
    }
}
