package personaluebersicht.java.model.employees;

import personaluebersicht.java.model.company.*;

import java.util.ArrayList;

public class Participation {
    private ArrayList<JobFunctions> function;
    private ArrayList<Teams> teams;
    private Person owner;

    public Participation(Person person) {
        this.owner = person;
        function = new ArrayList<>();
        teams = new ArrayList<>();
    }

    public void addFunction(JobFunctions function) {
        this.function.add(function);
    }

    public String getFunctionName(int index) {
        // Potentielle Fehlerquelle
        return function.get(index).getJobFunction(index);
    }

    public void removeFunction(int index) {
        function.remove(index);
    }

    public int getNumberOfFunctions() {
        return function.size();
    }

    public void addTeam(Teams teams) {
        this.teams.add(teams);
    }

    public String getTeamName(int index) {
        // potentielle Fehlerquelle
        return teams.get(index).getTeam(index);
    }

    public void removeTeam(int index) {
        teams.remove(index);
    }

    public int getNumberOfTeams() {
        return teams.size();
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

}
