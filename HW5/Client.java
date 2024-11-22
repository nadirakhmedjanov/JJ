import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost"; // Адрес сервера
    private static final int SERVER_PORT = 12345; // Порт сервера

    public static void main(String[] args) {
        Socket socket = null;

        try {
            // Пытаемся подключиться к серверу
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Подключено к серверу");

            // Создаем потоки для ввода и вывода
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Пример отправки и получения сообщений
            out.writeUTF("Привет, сервер!");
            String response = in.readLine();
            System.out.println("Ответ от сервера: " + response);

        } catch (ConnectException e) {
            // Игнорируем ошибку подключения и продолжаем выполнение программы
            System.out.println("Не удалось подключиться к серверу. Попробуйте позже.");
        } catch (IOException e) {
            // Обрабатываем другие ошибки ввода/вывода
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
