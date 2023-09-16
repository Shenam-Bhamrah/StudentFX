package Content;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *Group Member Names: 
 * @author Shenam Bhamrah (Student id: 991577012) 
 * @author Hill Panchal (Student id: 991700346)
 * @date 12-12-2023
 */
public class StudentSearch {

    Stage stageTwo = new Stage();
    private Button btnCitySearch = new Button("Search By City");
    private Button btnCourseSearch = new Button("Search By Course");
    private GridPane grid2 = new GridPane();
    private TextField i = new TextField();
    private TextArea txtArea = new TextArea();
    private VBox display = new VBox(txtArea);

    private VBox search = new VBox(10, i, grid2, display);

    /**
     *
     */
    public StudentSearch() {

        grid2.add(btnCitySearch, 4, 0);
        grid2.add(btnCourseSearch, 6, 0);
        grid2.setHgap(10);
        Scene sc = new Scene(search, 300, 400);
        btnCitySearch.setOnAction(e -> searchCity(i.getText()));
        btnCourseSearch.setOnAction(e -> searchCourse(i.getText()));
        sc.getStylesheets().add("/CSS/TheStyle.css");
        stageTwo.setResizable(false);
        stageTwo.setTitle("Search Stage");
        stageTwo.setScene(sc);
    }

    /**
     *
     */
    public void SearchWindow() {
        stageTwo.show();
    }

    private void searchCity(String city) {
        txtArea.clear();
        try {
            ArrayList<Student> studentList = StudentFile.getStudent("Student.dat");
            for (Student student : studentList) {
                if (student.getCity().equalsIgnoreCase(city)) {
                    txtArea.appendText("ID: " + student.getID() + "\t" + " Name: " + student.getName() + "\t" + " Program: " + student.getProgram() + "\t" + " City: " + student.getCity() + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    private void searchCourse(String course) {
        txtArea.clear();
        try {
            ArrayList<Student> studentList = StudentFile.getStudent("Student.dat");
            for (Student student : studentList) {
                if (student.getProgram().equalsIgnoreCase(course)) {
                    txtArea.appendText("ID: " + student.getID() + "\t" + " Name: " + student.getName() + "\t" + " Program: " + student.getProgram() + "\t" + " City: " + student.getCity() + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
