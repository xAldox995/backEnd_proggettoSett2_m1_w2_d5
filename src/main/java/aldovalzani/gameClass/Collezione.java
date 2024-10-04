package aldovalzani.gameClass;

import aldovalzani.gameClass.gamesChildren.GiocoDaTavolo;
import aldovalzani.gameClass.gamesChildren.VideoGame;

import java.util.*;

public class Collezione {
    private List<Gioco> giochi = new ArrayList<>();

    public void addGioco(Gioco gioco) {
        if (giochi.stream().anyMatch(g -> g.getIdGioco() == gioco.getIdGioco())) {
            throw new IllegalArgumentException("Il gioco ID: " + gioco.getIdGioco() + " è già presente nella collezioen");
        }
        giochi.add(gioco);
    }

    public Optional<Gioco> ricercaConId(int id) {
        return giochi.stream().filter(gioco -> gioco.getIdGioco() == id).findFirst();
    }

    public List<Gioco> ricercaGiocoRangePrezzo(double prezzo) {
        return giochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
    }

    public List<GiocoDaTavolo> ricercaGiocoPerNumGiocatori(int numGiocatori) {
        return giochi.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).
                map(gioco -> (GiocoDaTavolo) gioco).
                filter(giocoDaTavolo -> giocoDaTavolo.getNumGiocatori() == numGiocatori).toList();
    }

    public void eliminaGioco(int id) throws NoSuchElementException {
        boolean elimina = giochi.removeIf(gioco -> gioco.getIdGioco() == id);
        if (!elimina) {
            throw new NoSuchElementException("Non esiste il gioco con ID: " + id);
        }
    }

    public void modificaGioco(int id, Gioco giocoModificato) throws NoSuchElementException {
        for (int i = 0; i < giochi.size(); i++) {
            if (giochi.get(i).getIdGioco() == id) {
                giochi.set(i, giocoModificato);
                return;
            }
        }
        throw new NoSuchElementException("Non puoi modificare il gioco con ID " + id);
    }

    public void statisticheCollezione() {
        long videoGamesInColl = giochi.stream().filter(gioco -> gioco instanceof VideoGame).count();
        long giochiDaTavolaInColl = giochi.stream().filter(gioco -> gioco instanceof GiocoDaTavolo).count();
        Optional<Gioco> moreExpenciveGame = giochi.stream().max(Comparator.comparingDouble(Gioco::getPrezzo));
        OptionalDouble mediaDeiPrezzi = giochi.stream().mapToDouble(Gioco::getPrezzo).average();

        System.out.println("Numero VideoGames: " + videoGamesInColl);
        System.out.println("Numero Giochi da Tavolo: " + giochiDaTavolaInColl);
        moreExpenciveGame.ifPresent(gioco -> System.out.println("Il gioco più costoso è: " + gioco));
        if (mediaDeiPrezzi.isPresent()) {
            System.out.println("Media dei prezzi di tutti gli elementi: " + mediaDeiPrezzi.getAsDouble() + "€");
        } else {
            System.out.println("Nessun gioco disponibile per calcolare la media dei prezzi.");
        }
    }

    public List<Gioco> getGiochi() {
        return giochi;
    }


    @Override
    public String toString() {
        if (giochi.isEmpty()) {
            return "La collezione è vuota.";
        }

        String result = "Lista dei giochi nella collezione:\n";
        for (Gioco gioco : giochi) {
            result += gioco.toString() + "\n";
        }
        return result;
    }
}
