package ro.examen.model;

import jakarta.persistence.*;

@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;
    private Double pret;

    public Carte() {}


    public Long getId() { return id; }
    public String getNume() { return nume; }
    public Double getPret() { return pret; }
}