package aldovalzani.gameClass.gamesChildren;

import aldovalzani.gameClass.Gioco;

public class GiocoDaTavolo extends Gioco {
    private int numGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo(String titolo, int annoDiPubblicazione, double prezzo, int durataMediaPartita, int numGiocatori) {
        super(titolo, annoDiPubblicazione, prezzo);
        setNumGiocatori(numGiocatori);
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) throws IllegalArgumentException {
        if (durataMediaPartita > 0) {
            this.durataMediaPartita = durataMediaPartita;
        } else {
            throw new IllegalArgumentException("La durata media della partita deve essere maggiore di zero.");
        }
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public void setNumGiocatori(int numGiocatori) throws IllegalArgumentException {
        if (numGiocatori <= 10 && numGiocatori >= 2) {
            this.numGiocatori = numGiocatori;
        } else {
            throw new IllegalArgumentException("Il numero dei giocatori non è valido");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero Giocatori: " + numGiocatori +
                ", Durata Media Partita: " + durataMediaPartita + " minuti";
    }
}
