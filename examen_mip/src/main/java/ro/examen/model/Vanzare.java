package ro.examen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vanzari_efectuate")
public class Vanzare {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Carte carte;

    public Vanzare() {}
    public Vanzare(Carte carte) { this.carte = carte; }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
}
