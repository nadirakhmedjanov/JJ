/* Домашнее задание №2:Используя Reflection API, напишите программу, которая выводит на экран 
все методы класса String.
*/

import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        // Получаем класс String
        Class<String> stringClass = String.class;

        // Получаем все методы класса String
        Method[] methods = stringClass.getDeclaredMethods();

        // Выводим информацию о каждом методе
        System.out.println("Методы класса String:");
        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
            System.out.print("Параметры: ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> paramType : parameterTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println("\n");
        }
    }
}
