package ro.examen.application;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClasaAditionala {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 8020);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("S: " + in.readLine());
            while (true) {
                System.out.print("Scanare (ID/GATA/RAPORT/EXIT): ");
                String cmd = sc.nextLine();
                out.println(cmd);
                if (cmd.equalsIgnoreCase("EXIT")) break;

                String response;

                while ((response = in.readLine()) != null) {
                    if (response.equals("---END---")) {
                        break;
                    }
                    System.out.println(response);
                }


                if (response == null) {
                    System.out.println("[Sistem] Conexiunea cu serverul a fost pierdută.");
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}