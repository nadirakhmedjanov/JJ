/*Задание 1: Создайте класс Person с полями name и age. 
  Реализуйте сериализацию и десериализацию этого класса в файл.
*/

import java.io.*;


class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    
    // Геттеры и сеттеры
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}


public class Main {
    public static void main(String[] args) {
        // Создаем объект
        Person person = new Person("Alice", 25);

        // Путь к файлу
        String filePath = "person.ser";

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Сериализация прошла успешно!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Десериализованный объект: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
