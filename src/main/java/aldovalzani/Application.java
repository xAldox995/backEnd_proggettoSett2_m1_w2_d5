package aldovalzani;

import aldovalzani.gameClass.Collezione;
import aldovalzani.gameClass.GenereGioco;
import aldovalzani.gameClass.Gioco;
import aldovalzani.gameClass.gamesChildren.GiocoDaTavolo;
import aldovalzani.gameClass.gamesChildren.VideoGame;
import com.github.javafaker.Faker;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker();
        VideoGame vg1 = new VideoGame(faker.book().title(),
                2021, 57.99,
                30, GenereGioco.FANTASY, "PS5");

        VideoGame vg2 = new VideoGame(faker.book().title(),
                2022, 69.99,
                40, GenereGioco.AZIONE, "PC");

        GiocoDaTavolo tg1 = new GiocoDaTavolo(faker.book().title(),
                1995, 20.00, 120, 4);

        GiocoDaTavolo tg2 = new GiocoDaTavolo(faker.book().title(),
                2010, 35.50, 90, 6);

//        System.out.println(vg1);
//        System.out.println(tg1);

        Collezione collezione = new Collezione();
        collezione.addGioco(vg1);
        collezione.addGioco(vg2);
        collezione.addGioco(tg1);
        collezione.addGioco(tg2);

//        System.out.println(collezione);

        Scanner in = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\n--- Menu Di Navigazione della Tua Collezione ---");
            System.out.println("1. Aggiungi gioco ");
            System.out.println("2. Ricerca gioco con ID");
            System.out.println("3. Filtra giochi tramite prezzo");
            System.out.println("4. Ricerca giochi da tavola tramite N° giocatori");
            System.out.println("5. Rimuovi gioco da ID");
            System.out.println("6. Modifica gioco");
            System.out.println("7. Statistiche della tua collezione");
            System.out.println("8. Mostra collezione");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = Integer.parseInt(in.nextLine());

            switch (scelta) {
                case 1:
                    System.out.print("Vuoi aggiungere un Videogioco (1) o un Gioco da Tavolo (2)? ");
                    int tipoGioco = Integer.parseInt(in.nextLine());
                    System.out.print("Inserisci il titolo del gioco: ");
                    String titoloGioco = in.nextLine();
                    System.out.print("Inserisci l'anno di pubblicazione: ");
                    int annoGioco = Integer.parseInt(in.nextLine());
                    System.out.print("Inserisci il prezzo del gioco: ");
                    double prezzoGioco = Double.parseDouble(in.nextLine());

                    if (tipoGioco == 1) {
                        System.out.print("Inserisci la piattaforma del videogioco: ");
                        String piattaforma = in.nextLine();

                        System.out.print("Inserisci la durata di gioco (in ore): ");
                        int durata = Integer.parseInt(in.nextLine());

                        System.out.print("Inserisci il genere del videogioco (AZIONE, AVVENTURA, RPG, SPORT, SIMULAZIONE, STRATEGIA, FANTASY): ");
                        String genereInput = in.nextLine();
                        GenereGioco genere = GenereGioco.valueOf(genereInput.toUpperCase());

                        VideoGame nuovoVideogioco = new VideoGame(titoloGioco, annoGioco, prezzoGioco, durata, genere, piattaforma);
                        collezione.addGioco(nuovoVideogioco);
                        System.out.println("Videogioco aggiunto con successo.");
                    } else if (tipoGioco == 2) {
                        System.out.print("Inserisci il numero di giocatori: ");
                        int numGiocatori = Integer.parseInt(in.nextLine());
                        System.out.print("Inserisci la durata media della partita (in minuti): ");
                        int durataPartita = Integer.parseInt(in.nextLine());
                        GiocoDaTavolo newGiocoDaTavolo = new GiocoDaTavolo(titoloGioco, annoGioco, prezzoGioco, durataPartita, numGiocatori);
                        System.out.println("Gioco da Tavolo aggiunto con successo.");
                    } else {
                        System.out.println("Dati non validi. Riprovare");
                    }
                    break;
                case 2:
                    System.out.print("Inserisci l'ID del gioco da cercare: ");
                    int idPerRicerca = Integer.parseInt(in.nextLine());
                    Optional<Gioco> giocoDaCercare = collezione.ricercaConId(idPerRicerca);
                    if (giocoDaCercare.isPresent()) {
                        System.out.println("Ecco il gioco che cercavi: " + giocoDaCercare.get());
                    } else {
                        System.out.println("Errore: L'ID " + idPerRicerca + " non esiste");
                    }
                    break;
                case 3:
                    System.out.print("Inserisci il prezzo massimo: ");
                    double rangePrezzo = Double.parseDouble(in.nextLine());
                    collezione.ricercaGiocoRangePrezzo(rangePrezzo).forEach(gioco -> System.out.println(gioco));
                    break;
                case 4:
                    System.out.print("Inserisci il numero di giocatori: ");
                    int numGiocatoriPerRicerca = Integer.parseInt(in.nextLine());
                    collezione.ricercaGiocoPerNumGiocatori(numGiocatoriPerRicerca).
                            forEach(giocoDaTavolo -> System.out.println(giocoDaTavolo));
                    break;
                case 5:
                    System.out.print("Inserisci l'ID del gioco da rimuovere: ");
                    int idDaEliminare = Integer.parseInt(in.nextLine());
                    try {
                        collezione.eliminaGioco(idDaEliminare);
                        System.out.println("Gioco Eliminato");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Non esiste il gioco con ID: " + idDaEliminare);
                    }
                    break;

                case 6:
                    System.out.print("Inserisci l'ID del gioco da modificare: ");
                    int idGiocoDaModificare = Integer.parseInt(in.nextLine());

            }

        }


    }
}
