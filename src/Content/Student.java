package Content;

/**
 *Group Member Names: 
 * @author Shenam Bhamrah (Student id: 991577012) 
 * @author Hill Panchal (Student id: 991700346)
 * @date 12-12-2023
 */
public class Student {

    private int ID;
    private String name;
    private String city;
    private String program;

    /**
     *
     * @param ID
     */
    public Student(int ID) {
        this.ID = ID;

    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @param program the program to set
     */
    public void setProgram(String program) {
        this.program = program;
    }

}
