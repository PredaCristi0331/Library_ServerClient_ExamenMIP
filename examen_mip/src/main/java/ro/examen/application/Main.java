package ro.examen.application;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ro.examen.service.LibrarieService;
import java.net.ServerSocket;
import java.net.Socket;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    LibrarieService service;

    public static void main(String[] args) {
        io.quarkus.runtime.Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {

        int port = 8020;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("==========================================");
            System.out.println("   SERVER LIBRARIE (Sistem Centralizat)   ");
            System.out.println("       Activ pe portul: " + port);
            System.out.println("==========================================");

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("[INFO] O nouă casă de marcat s-a conectat: " + clientSocket.getInetAddress());


                ClientHandler handler = new ClientHandler(clientSocket, service);
                new Thread(handler).start();
            }
        } catch (Exception e) {
            System.err.println("[EROARE] Serverul a întâmpinat o problemă: " + e.getMessage());
            return 1;
        }
    }
}