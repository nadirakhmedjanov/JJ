import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamAverage {
    public static void main(String[] args) {
        // Исходный список чисел
        List<Integer> numbers = Arrays.asList(0, 15, 20, 25, 30, 35, 40, 25, 1, 6);

        // Вычисление среднего значения всех четных чисел
        OptionalDouble average = numbers.stream()       // Создаем поток данных из списка
                .filter(num -> num % 2 == 0)            // Фильтруем только четные числа
                .mapToInt(Integer::intValue)            // Преобразуем в поток int
                .average();                              // Вычисляем среднее значение
                
        
        // Проверяем наличие результата и выводим сообщение
        if (average.isPresent()) {
            System.out.println("Среднее значение четных чисел: " + average.getAsDouble());
        } else {
            System.out.println("В списке нет четных чисел.");
        }
    }
}
