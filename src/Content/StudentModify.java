package Content;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *Group Member Names: 
 * @author Shenam Bhamrah (Student id: 991577012) 
 * @author Hill Panchal (Student id: 991700346)
 * @date 12-12-2023
 */
public class StudentModify {

    ArrayList<Student> studentList = new ArrayList<>();
    private Label lblID = new Label("ID");
    private Label lblName = new Label("NAME");
    private Label lblCity = new Label("CITY");
    private Label lblCourse = new Label("COURSE");
    private TextField textID = new TextField();
    private TextField textName = new TextField();
    private TextField textCity = new TextField();
    private TextField textCourse = new TextField();
    private Button btnFirst = new Button("First");
    private Button btnNext = new Button("Next");
    private Button btnPrevious = new Button("Previous");
    private Button btnLast = new Button("Last");
    private Button btnAdd = new Button("ADD");
    private Button btnModify = new Button("MODIFY");
    private Button btnDelete = new Button("DELETE");
    private GridPane grid = new GridPane();
    private Pane pane11 = new Pane(grid);
    private HBox h = new HBox(5, btnFirst, btnNext, btnPrevious, btnLast);
    private HBox h2 = new HBox(20, btnAdd, btnModify, btnDelete);
    private VBox vh = new VBox(20, pane11, h, h2);
    private Scene scene = new Scene(vh, 200, 300);
    private Stage stageOne = new Stage();
    private int currentIndex = 0;

    /**
     *
     */
    public StudentModify() {
        try {
            studentList = StudentFile.getStudent("Student.dat");

            textID.setText(String.valueOf(studentList.get(currentIndex).getID()));
            textName.setText(studentList.get(currentIndex).getName());
            textCity.setText(studentList.get(currentIndex).getCity());
            textCourse.setText(studentList.get(currentIndex).getProgram());

            btnFirst.setOnAction((e -> {
                first(studentList);
            }));
            btnNext.setOnAction((e -> {
                next(studentList);
            }));
            btnPrevious.setOnAction((e -> {
                previous(studentList);
            }));
            btnLast.setOnAction((e -> {
                last(studentList);
            }));
            btnAdd.setOnAction((e -> {
                add();
            }));
            btnModify.setOnAction((e -> {
               modify();
            }));
            btnDelete.setOnAction((e -> {
                delete();
            }));
            grid.add(lblID, 0, 0);
            grid.add(textID, 1, 0);
            grid.add(lblName, 0, 1);
            grid.add(textName, 1, 1);
            grid.add(lblCity, 0, 2);
            grid.add(textCity, 1, 2);
            grid.add(lblCourse, 0, 3);
            grid.add(textCourse, 1, 3);
            grid.setVgap(10);
            scene.getStylesheets().add("/CSS/TheStyle.css");
            stageOne.setScene(scene);
            stageOne.setTitle("Modify Stage");
            stageOne.setResizable(false);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    private void first(ArrayList<Student> studentList) {
        textID.setText(String.valueOf(studentList.get(0).getID()));
        textName.setText(studentList.get(0).getName());
        textCity.setText(studentList.get(0).getCity());
        textCourse.setText(studentList.get(0).getProgram());
        currentIndex = 0;
    }

    private void last(ArrayList<Student> studentList) {
        textID.setText(String.valueOf(studentList.get(studentList.size() - 1).getID()));
        textName.setText(studentList.get(studentList.size() - 1).getName());
        textCity.setText(studentList.get(studentList.size() - 1).getCity());
        textCourse.setText(studentList.get(studentList.size() - 1).getProgram());
        currentIndex = studentList.size() - 1;
    }

    private void next(ArrayList<Student> studentList) {
        if (currentIndex != studentList.size() - 1) {
            textID.setText(String.valueOf(studentList.get(currentIndex + 1).getID()));
            textName.setText(studentList.get(currentIndex + 1).getName());
            textCity.setText(studentList.get(currentIndex + 1).getCity());
            textCourse.setText(studentList.get(currentIndex + 1).getProgram());
            currentIndex += 1;
        } else {
            textID.setText(String.valueOf(studentList.get(currentIndex).getID()));
            textName.setText(studentList.get(currentIndex).getName());
            textCity.setText(studentList.get(currentIndex).getCity());
            textCourse.setText(studentList.get(currentIndex).getProgram());
        }
    }

    private void previous(ArrayList<Student> studentList) {
        if (currentIndex != 0) {
            textID.setText(String.valueOf(studentList.get(currentIndex - 1).getID()));
            textName.setText(studentList.get(currentIndex - 1).getName());
            textCity.setText(studentList.get(currentIndex - 1).getCity());
            textCourse.setText(studentList.get(currentIndex - 1).getProgram());
            currentIndex -= 1;
        } else {
            textID.setText(String.valueOf(studentList.get(currentIndex).getID()));
            textName.setText(studentList.get(currentIndex).getName());
            textCity.setText(studentList.get(currentIndex).getCity());
            textCourse.setText(studentList.get(currentIndex).getProgram());
        }
    }

    private void add() {
        String record = textID.getText() + "," + textName.getText() + "," + textCity.getText() + "," + textCourse.getText();
        try {
            StudentFile.setStudent("Student.dat", record);
            studentList = StudentFile.getStudent("Student.dat");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void modify() {
        int newID = Integer.parseInt(textID.getText());
        String newName = textName.getText();
        String newCity = textCity.getText();
        String newProgram = textCourse.getText();
        studentList.get(currentIndex).setID(newID);
        studentList.get(currentIndex).setName(newName);
        studentList.get(currentIndex).setProgram(newProgram);
        studentList.get(currentIndex).setCity(newCity);
        try {
            StudentFile.updateStudent("Student.dat", studentList);

        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void delete() {
        studentList.remove(currentIndex);
        try {
            StudentFile.updateStudent("Student.dat", studentList);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     *
     */
    public void ModifyWindow() {
        stageOne.show();
    }
}
