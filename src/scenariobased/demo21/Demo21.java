package scenariobased.demo21;

import java.io.*;

/**
 * Implement serialization and deserialization
 * <p>
 * Output :
 * Student Object : Student{id=1, name='shubham', address='warje', pincode='411058'}
 */
public class Demo21 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student s1 = new Student(1, "shubham", "warje", "411058");

        FileOutputStream fileOutputStream = new FileOutputStream("src/scenariobased/demo21/StudentTempFile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(s1);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("src/scenariobased/demo21/StudentTempFile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Student Object : " + student);
    }
}
