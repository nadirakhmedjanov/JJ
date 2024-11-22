package ru.geekbrains;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        // Добавление объектов
        personDAO.savePerson(new Person("Ali", 30));
        personDAO.savePerson(new Person("Kamila", 25));

        // Обновление объекта
        personDAO.updatePerson(1, "Alisher", 35);

        // Удаление объекта
        personDAO.deletePerson(2);

        HibernateUtil.close();
    }
}
