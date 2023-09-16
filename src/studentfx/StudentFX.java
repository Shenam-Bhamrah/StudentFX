package studentfx;

import Content.Student;
import Content.StudentFile;
import Content.StudentModify;
import Content.StudentSearch;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *Group Member Names: 
 * @author Shenam Bhamrah (Student id: 991577012) 
 * @author Hill Panchal (Student id: 991700346)
 * @date 12-12-2023
 */
public class StudentFX extends Application {

    private Ellipse ellipse = new Ellipse(250, 50, 20, 20);
    private Rectangle rectangle = new Rectangle(220, 70, 60, 40);
    private Text header1 = new Text("MEMBER NAME");
    private Text header2 = new Text("MEMBER ID");
    private Text name1 = new Text("Shenam Bhamrah");
    private Text name2 = new Text("Hill Panchal");
    private Text id1 = new Text("991577012");
    private Text id2 = new Text("991700346");
    private Button btnModify = new Button("Student Modify");
    private Button btnSearch = new Button("Student Search");
    private GridPane two = new GridPane();
    private StudentModify modify = new StudentModify();
    private StudentSearch search = new StudentSearch();
    private Pane pane = new Pane(ellipse, rectangle);
    private GridPane gw = new GridPane();
    private VBox v = new VBox(pane, gw, two);
    Scene scene = new Scene(v, 500, 260);

    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        ellipse.setStrokeWidth(2);
        ellipse.setFill(Color.BLUE);
        ellipse.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.BLUE);
        header1.setUnderline(true);
        header2.setUnderline(true);
        Font font = new Font("Courier", 14);
        Font font2 = new Font("Arial", 12);
        header1.setFont(font);
        header2.setFont(font);

        gw.add(header1, 15, 0);
        gw.add(header2, 16, 0);
        gw.add(name1, 15, 1);
        gw.add(id1, 16, 1);
        gw.add(name2, 15, 2);
        gw.add(id2, 16, 2);
        gw.setHgap(10);
        gw.setVgap(2);
        v.setSpacing(25);
        two.add(btnModify, 13, 0);
        two.add(btnSearch, 15, 0);
        two.setHgap(10);
        ///////

        ///////////
        ///
        btnModify.setOnAction(e -> modify.ModifyWindow());

        ///
        btnSearch.setOnAction(e -> search.SearchWindow());
        scene.getStylesheets().add("/CSS/TheStyle.css");
        stage.setScene(scene);
        stage.setTitle("Student Portal");
        stage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
        try {
            ArrayList<Student> studentList = StudentFile.getStudent("Student.dat");
            for (Student student : studentList) {
                System.out.println(student.getID() + "\t" + student.getName() + student.getProgram() + student.getCity());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

    }

}
