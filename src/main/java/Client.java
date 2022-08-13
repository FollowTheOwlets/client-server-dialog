import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket1 = new Socket(host, port);
             PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
             BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()))) {

            String resp = in1.readLine();
            System.out.println(resp);
            out1.println(scan.nextLine());

            resp = in1.readLine();
            System.out.println(resp);
            out1.println(scan.nextLine());

            resp = in1.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
