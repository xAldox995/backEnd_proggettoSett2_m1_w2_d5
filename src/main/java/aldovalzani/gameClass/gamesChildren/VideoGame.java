package aldovalzani.gameClass.gamesChildren;

import aldovalzani.gameClass.GenereGioco;
import aldovalzani.gameClass.Gioco;

public class VideoGame extends Gioco {
    private String piattaforma;
    private int durataDiGioco;
    private GenereGioco genere;

    public VideoGame(String titolo, int annoDiPubblicazione, double prezzo, int durataDiGioco, GenereGioco genere, String piattaforma) {
        super(titolo, annoDiPubblicazione, prezzo);
        this.durataDiGioco = durataDiGioco;
        this.genere = genere;
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durataDiGioco;
    }

    public GenereGioco getGenere() {
        return genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    @Override
    public String toString() {
        return super.toString() + ", Piattaforma: " + piattaforma +
                ", Durata: " + durataDiGioco + " ore, Genere: " + genere;
    }
}
