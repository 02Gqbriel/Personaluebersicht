package personaluebersicht.java.model.company;

import java.util.ArrayList;

/**
 * a Teams
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class Teams {
    private ArrayList<String> designations;

    /**
     * public constructor
     */
    public Teams() {
        designations = new ArrayList<String>();
    }

    /**
     * adds a Team into designations arraylist
     * @param function the team to add
     */
    public void addTeam(String function) {
        designations.add(function);
    }

    /**
     * gets a team from the designations arraylist
     * @param index of the team in designations arraylist
     * @return team in designations arraylist
     */
    public String getTeam(int index) {
        return designations.get(index);
    }

    /**
     * removes a team from the designations arraylist
     * @param index of the team in desginations arraylist
     */
    public void removeTeam(int index) {
        designations.remove(index);
    }

    /**
     * gets amount of teams in designations arraylist
     * @return int amount of teams in designations arraylist
     */
    public int getSize() {
        return designations.size();
    }

    /**
     * adds a team into specific index in designations arraylist
     * @param index the designations arraylist
     * @param teamName the team to add
     */
    public void setTeam(int index, String teamName) {
        designations.set(index, teamName);
    }
}
