package Content;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *Group Member Names: 
 * @author Shenam Bhamrah (Student id: 991577012) 
 * @author Hill Panchal (Student id: 991700346)
 * @date 12-12-2023
 */
public class StudentFile {

    /**
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Student> getStudent(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        ArrayList<Student> studentList = new ArrayList();
        while (scan.hasNext()) {
            String Line = scan.nextLine();
            StringTokenizer st = new StringTokenizer(Line, ",");
            int ID = Integer.parseInt(st.nextToken().trim());
            String name = st.nextToken().trim();
            String city = st.nextToken().trim();
            String program = st.nextToken().trim();
            Student s1 = new Student(ID);
            s1.setName(name);
            s1.setCity(city);
            s1.setProgram(program);
            studentList.add(s1);
        }
        return studentList;
    }

    /**
     *
     * @param fileName
     * @param record
     * @throws IOException
     */
    public static void setStudent(String fileName, String record)
            throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(record);
        bw.newLine();
        bw.close();
        fw.close();
    }

    /**
     *
     * @param fileName
     * @param studentList
     * @throws IOException
     */
    public static void updateStudent(String fileName, ArrayList<Student> studentList)
            throws IOException {
        FileWriter f = new FileWriter(fileName);
        BufferedWriter b = new BufferedWriter(f);
        for (Student student : studentList) {
            String record = student.getID() + "," + student.getName() + "," + student.getCity() + "," + student.getProgram();
            b.write(record);
            b.newLine();
        }
        b.close();
        f.close();
    }
}
