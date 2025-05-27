import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234); // connect to server on localhost
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String msgFromServer;
        while (true) {
            System.out.print("You: ");
            String message = keyboard.readLine();
            out.println(message);

            msgFromServer = in.readLine();
            System.out.println("Server: " + msgFromServer);
            socket.close();
        }
    }
}
