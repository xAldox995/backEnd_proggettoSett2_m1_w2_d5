package aldovalzani.gameClass;

public abstract class Gioco {
    private static int contatoreId = 1;
    private final int idGioco;
    private String titolo;
    private int annoDiPubblicazione;
    private double prezzo;

    public Gioco(String titolo, int annoDiPubblicazione, double prezzo) {
        this.idGioco = contatoreId++;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        setPrezzo(prezzo);
    }


    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) throws IllegalArgumentException {

        if (annoDiPubblicazione > 0) {
            this.annoDiPubblicazione = annoDiPubblicazione;
        } else {
            throw new IllegalArgumentException("l'anno deve essere positivo");
        }
    }

    public int getIdGioco() {
        return idGioco;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) throws IllegalArgumentException {
        if (prezzo > 0) {
            this.prezzo = prezzo;
        } else {
            throw new IllegalArgumentException("Il prezzo deve essere positivo");
        }
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "ID: " + idGioco + ", Titolo: " + titolo + ", Anno: " + annoDiPubblicazione + ", Prezzo: " + prezzo + "€";
    }

}
