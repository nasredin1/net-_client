import java.io.*;
import java.net.*;

public class MainServer {
    public static void main(String[] args) {
        int port = 8888;
        System.out.println("Служба запущена на порту " + port);

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.printf("Новое подключение клиента с порта: %d%n", clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Привет %s, порт с которого вы подключились %d", name, clientSocket.getPort()));

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}

