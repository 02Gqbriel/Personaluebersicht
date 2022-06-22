package personaluebersicht.java.model.employees;

/**
 * a Picture
 * @author Diego Fantino
 * @since 22.06.2022
 * @version 1.0
 */
public class Picture {
    private String path;

    /**
     * public constructor
     * @param path to the picture
     */
    public Picture(String path) {
        this.path = path;
    }

    /**
     * gets the path of the picture
     * @return path of the picture
     */
    public String getPath() {
        return path;
    }

    /**
     * sets the path of the picture
     * @param path of the picture
     */
    public void setPath(String path) {
        this.path = path;
    }
}
