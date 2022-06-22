package personaluebersicht.java.model.employees;

import java.util.ArrayList;

/**
 * a Participation
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class Participation {
    private ArrayList<String> function;
    private ArrayList<String> teams;
    private Person owner;

    /**
     * public constructor
     * @param person the owner of the participation
     */
    public Participation(Person person) {
        this.owner = person;
        function = new ArrayList<>();
        teams = new ArrayList<>();
    }

    /**
     * adds a function into function arraylist
     * @param function the function to add
     */
    public void addFunction(String function) {
        this.function.add(function);
    }

    /**
     * gets the Functionname from the function arraylist
     * @param index of the function in function arraylist
     * @return the function name as String
     */
    public String getFunctionName(int index) {
        return function.get(index);
    }

    /**
     * removes a function from the function arraylist
     * @param index of the function in function arraylist
     */
    public void removeFunction(int index) {
        function.remove(index);
    }

    /**
     * gets amount of functions in function arraylist
     * @return int amount of functions in function arraylist
     */
    public int getNumberOfFunctions() {
        return function.size();
    }

    /**
     * adds a team in teams arraylist
     * @param teams team to add
     */
    public void addTeam(String teams) {
        this.teams.add(teams);
    }

    /**
     * gets the team name from team in teams arraylist
     * @param index of the team in teams arraylist
     * @return the teams name
     */
    public String getTeamName(int index) {
        return teams.get(index);
    }

    /**
     * removes a team from the teams arraylist
     * @param index pof the team in teams arraylist
     */
    public void removeTeam(int index) {
        teams.remove(index);
    }

    /**
     * gets amount of teams in teams arraylist
     * @return int the amount of teams
     */
    public int getNumberOfTeams() {
        return teams.size();
    }

    /**
     * gets the owner of this participation
     * @return owner the owner
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * sets the owner of this participation
     * @param owner the owner of this participation
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
