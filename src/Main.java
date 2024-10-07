import java.io.*;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Иван", 20, 3.8);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.bin"))){
            oos.writeObject(student);
            System.out.println("Студент сериализован в файл 'student.bin'");
        }catch (IOException e){
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.bin"))){

            Student deserializedStudent = (Student) ois.readObject();

            System.out.println("Десериализованный студент:");
            System.out.println("Имя: " + deserializedStudent.getName());
            System.out.println("Возраст: " + deserializedStudent.getAge());
            System.out.println("GPA: " + deserializedStudent.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
