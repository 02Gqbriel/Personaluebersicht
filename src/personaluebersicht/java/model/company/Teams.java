package personaluebersicht.java.model.company;

import java.util.ArrayList;

public class Teams {
    private ArrayList<String> designations;

    public Teams() {
        designations = new ArrayList<String>();
    }

    public void addTeam(String function) {
        designations.add(function);
    }

    public String getTeam(int index) {
        return designations.get(index);
    }

    public void removeTeam(int index) {
        designations.remove(index);
    }

    public int getSize() {
        return designations.size();
    }

    public void setTeam(int index, String teamName) {
        designations.set(index, teamName);
    }
}
