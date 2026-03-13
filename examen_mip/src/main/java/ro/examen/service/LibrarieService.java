package ro.examen.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import ro.examen.model.*;
import java.util.*;

@ApplicationScoped
public class LibrarieService {
    @Inject EntityManager em;

    public Carte gasesteCarte(Long id) {
        return em.find(Carte.class, id);
    }

    @Transactional
    public void inregistreazaVanzare(List<Carte> cos) {
        for (Carte c : cos) {
            em.persist(new Vanzare(c));
        }
    }

    public String genereazaRaportGlobal() {
        List<Vanzare> toate = em.createQuery("SELECT v FROM Vanzare v", Vanzare.class).getResultList();
        double total = toate.stream().mapToDouble(v -> v.getCarte().getPret()).sum();
        return "Total carti vandute global: " + toate.size() + " | Valoare totala: " + total + " lei";
    }

    public double calculeazaDiscount(double suma) {
        if (suma > 300) return suma * 0.07;
        if (suma > 200) return suma * 0.05;
        return 0;
    }
}