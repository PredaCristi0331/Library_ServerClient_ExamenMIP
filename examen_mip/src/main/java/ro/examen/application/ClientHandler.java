package ro.examen.application;

import ro.examen.model.Carte;
import ro.examen.service.LibrarieService;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final LibrarieService service;

    public ClientHandler(Socket socket, LibrarieService service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            List<Carte> cos = new ArrayList<>();
            out.println("CASA DESCHISA. Introduceti ID, GATA sau RAPORT.");

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("[SERVER] Comanda primita: " + line); // Vezi asta in consola serverului

                if (line.equalsIgnoreCase("RAPORT")) {
                    String r = service.genereazaRaportGlobal();
                    out.println(r);
                }
                else if (line.equalsIgnoreCase("GATA")) {
                    if (cos.isEmpty()) {
                        out.println("Cosul este gol!");
                    } else {
                        double suma = cos.stream().mapToDouble(Carte::getPret).sum();
                        service.inregistreazaVanzare(cos);
                        out.println("Vanzare salvata! Total: " + suma + " lei.");
                        cos.clear();
                    }
                }
                else {
                    try {
                        Long id = Long.parseLong(line);
                        Carte c = service.gasesteCarte(id);
                        if (c != null) {
                            cos.add(c);
                            out.println("Adaugat: " + c.getNume() + " (" + c.getPret() + " lei)");
                        } else {
                            out.println("ID " + id + " nu exista in baza de date!");
                        }
                    } catch (NumberFormatException e) {
                        out.println("Eroare: Introduceti un numar valid sau GATA/RAPORT.");
                    }
                }

                // TRIMITEM MEREU ASTA LA FINALUL ORICAREI COMENZI
                out.println("---END---");
                System.out.println("[SERVER] Am trimis ---END--- la client.");
            }
        } catch (Exception e) {
            System.err.println("CRASH in ClientHandler: " + e.getMessage());
            e.printStackTrace();
        }
    }
}