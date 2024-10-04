package aldovalzani.gameClass.gamesChildren;

import aldovalzani.gameClass.Giochi;

public class GiocoDaTavolo extends Giochi {
    private int numGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String titolo, int annoDiPubblicazione, int prezzo, int durataMediaPartita, int numGiocatori) {
        super(titolo, annoDiPubblicazione, prezzo);
        setNumGiocatori(numGiocatori);
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public void setNumGiocatori(int numGiocatori) {
        if (numGiocatori <= 10 && numGiocatori >= 2) this.numGiocatori = numGiocatori;
        else throw new IllegalArgumentException("Il numero dei giocatori non è valido");
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero Giocatori: " + numGiocatori +
                ", Durata Media Partita: " + durataMediaPartita + " minuti";
    }
}
