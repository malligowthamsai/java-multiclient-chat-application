import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {

        try (

                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)

        ) {

            Thread readThread = new Thread(() -> {

                String message;

                try {

                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            readThread.start();

            while (true) {

                String userInput = scanner.nextLine();
                out.println(userInput);

                if (userInput.equals("/quit")) {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}