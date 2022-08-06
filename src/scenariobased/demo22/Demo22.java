package scenariobased.demo22;

import java.io.*;

/**
 * Output :
 * Student1 object before serialization : Student1{id=101, name='shubham'}
 * Student11 object after deserialization (id is transient) : Student1{id=0, name='shubham'}
 * Student2 object before externalization : Student2{id=202, name='vyavahare'}
 * Student21 object after externalization (id is not externalized) : Student2{id=0, name='vyavahare'}
 */
public class Demo22 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student1 student1 = new Student1(101, "shubham");
        System.out.println("Student1 object before serialization : " + student1);

        FileOutputStream fileOutputStream = new FileOutputStream("src/scenariobased/demo22/OutputFile1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student1);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("src/scenariobased/demo22/OutputFile1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student1 student11 = (Student1) objectInputStream.readObject();
        System.out.println("Student11 object after deserialization (id is transient) : " + student11);

        Student2 student2 = new Student2(202, "vyavahare");
        System.out.println("Student2 object before externalization : " + student2);

        FileOutputStream fileOutputStream1 = new FileOutputStream("src/scenariobased/demo22/OutputFile2.txt");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
        student2.writeExternal(objectOutputStream1);
        objectOutputStream1.flush();
        objectOutputStream1.close();
        fileOutputStream1.close();

        FileInputStream fileInputStream1 = new FileInputStream("src/scenariobased/demo22/OutputFile2.txt");
        ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
        Student2 student21 = new Student2();
        student21.readExternal(objectInputStream1);
        objectInputStream1.close();
        fileInputStream1.close();

        System.out.println("Student21 object after externalization (id is not externalized) : " + student21);
    }
}
