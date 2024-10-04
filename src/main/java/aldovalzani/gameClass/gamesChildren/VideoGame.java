package aldovalzani.gameClass.gamesChildren;

import aldovalzani.gameClass.GenereGioco;
import aldovalzani.gameClass.Giochi;

public class VideoGame extends Giochi {
    private String piattaforma;
    private int durataDiGioco;
    private GenereGioco genere;

    public VideoGame(String titolo, int annoDiPubblicazione, int prezzo, int durataDiGioco, GenereGioco genere, String piattaforma) {
        super(titolo, annoDiPubblicazione, prezzo);
        this.durata = durataDiGioco;
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
