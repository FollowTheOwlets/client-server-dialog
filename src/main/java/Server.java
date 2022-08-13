import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");

        out.println("Write your name:");

        final String name = in.readLine();

        out.println("Are you child? (yes/no)");

        final String answer = in.readLine();

        if (answer.equals("yes")) {
            out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
        } else if (answer.equals("no")) {
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
        }
    }
}
