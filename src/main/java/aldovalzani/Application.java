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
        Collezione collezione = new Collezione();

        try {
            VideoGame vg1 = new VideoGame(faker.book().title(), 2021, 57.99, 30, GenereGioco.FANTASY, "PS5");
            VideoGame vg2 = new VideoGame(faker.book().title(), 2022, 69.99, 40, GenereGioco.AZIONE, "PC");
            GiocoDaTavolo tg1 = new GiocoDaTavolo(faker.book().title(), 1995, 20.00, 120, 4);
            GiocoDaTavolo tg2 = new GiocoDaTavolo(faker.book().title(), 2010, 35.50, 90, 6);

            collezione.addGioco(vg1);
            collezione.addGioco(vg2);
            collezione.addGioco(tg1);
            collezione.addGioco(tg2);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore durante l'inizializzazione della collezione: " + e.getMessage());
        }

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

            try {
                int scelta = Integer.parseInt(in.nextLine());

                switch (scelta) {
                    case 1:
                        int tipoGioco;
                        while (true) {
                            System.out.print("Vuoi aggiungere un Videogioco (1) o un Gioco da Tavolo (2)? ");
                            try {
                                tipoGioco = Integer.parseInt(in.nextLine());
                                if (tipoGioco == 1 || tipoGioco == 2) {
                                    break; // L'input è valido, esci dal ciclo
                                } else {
                                    System.out.println("Errore: Devi scegliere 1 per Videogioco o 2 per Gioco da Tavolo. Riprova.");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Errore: L'input deve essere un numero valido. Inserisci 1 per Videogioco o 2 per Gioco da Tavolo.");
                            }
                        }

                        System.out.print("Inserisci il titolo del gioco: ");
                        String titoloGioco = in.nextLine();

                        int annoGioco;
                        while (true) {
                            System.out.print("Inserisci l'anno di pubblicazione (dal 1900 ad oggi): ");
                            try {
                                annoGioco = Integer.parseInt(in.nextLine());
                                if (annoGioco >= 1900 && annoGioco <= 2024) {
                                    break;  // L'anno è valido, esci dal ciclo
                                } else {
                                    System.out.println("Errore: L'anno di pubblicazione deve essere compreso tra 1900 e 2024.");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Errore: L'anno deve essere un numero valido. Riprova con un valore valido.");
                            }
                        }

                        double prezzoGioco;
                        while (true) {
                            System.out.print("Inserisci il prezzo del gioco (maggiore di 0): ");
                            try {
                                prezzoGioco = Double.parseDouble(in.nextLine());
                                if (prezzoGioco > 0) {
                                    break;  // Il prezzo è valido, esci dal ciclo
                                } else {
                                    System.out.println("Errore: Il prezzo deve essere maggiore di zero.");
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Errore: Il prezzo deve essere un numero valido. Riprova con un valore valido.");
                            }
                        }

                        if (tipoGioco == 1) {
                            System.out.print("Inserisci la piattaforma del videogioco: ");
                            String piattaforma = in.nextLine();

                            int durata;
                            while (true) {
                                System.out.print("Inserisci la durata di gioco (in ore, maggiore di 0): ");
                                try {
                                    durata = Integer.parseInt(in.nextLine());
                                    if (durata > 0) {
                                        break;  // La durata è valida, esci dal ciclo
                                    } else {
                                        System.out.println("Errore: La durata deve essere maggiore di zero.");
                                    }
                                } catch (NumberFormatException ex) {
                                    System.out.println("Errore: La durata deve essere un numero valido. Riprova con un valore valido.");
                                }
                            }

                            System.out.print("Inserisci il genere del videogioco (AZIONE, AVVENTURA, SPORT, FANTASY): ");
                            String genereInput = in.nextLine();
                            try {
                                GenereGioco genere = GenereGioco.valueOf(genereInput.toUpperCase());
                                VideoGame nuovoVideogioco = new VideoGame(titoloGioco, annoGioco, prezzoGioco, durata, genere, piattaforma);
                                collezione.addGioco(nuovoVideogioco);
                                System.out.println("Videogioco aggiunto con successo.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Errore: Genere non valido. I generi validi sono: AZIONE, AVVENTURA, SPORT, FANTASY.");
                            }

                        } else if (tipoGioco == 2) {
                            int numGiocatori;
                            while (true) {
                                System.out.print("Inserisci il numero di giocatori (tra 2 e 10): ");
                                try {
                                    numGiocatori = Integer.parseInt(in.nextLine());
                                    if (numGiocatori >= 2 && numGiocatori <= 10) {
                                        break;  // Il numero di giocatori è valido, esci dal ciclo
                                    } else {
                                        System.out.println("Errore: Il numero di giocatori deve essere compreso tra 2 e 10.");
                                    }
                                } catch (NumberFormatException ex) {
                                    System.out.println("Errore: Il numero di giocatori deve essere un numero valido. Riprova con un valore valido.");
                                }
                            }

                            int durataPartita;
                            while (true) {
                                System.out.print("Inserisci la durata media della partita (in minuti, maggiore di 0): ");
                                try {
                                    durataPartita = Integer.parseInt(in.nextLine());
                                    if (durataPartita > 0) {
                                        break;  // La durata è valida, esci dal ciclo
                                    } else {
                                        System.out.println("Errore: La durata media deve essere maggiore di zero.");
                                    }
                                } catch (NumberFormatException ex) {
                                    System.out.println("Errore: La durata deve essere un numero valido. Riprova con un valore valido.");
                                }
                            }

                            try {
                                GiocoDaTavolo newGiocoDaTavolo = new GiocoDaTavolo(titoloGioco, annoGioco, prezzoGioco, durataPartita, numGiocatori);
                                collezione.addGioco(newGiocoDaTavolo);
                                System.out.println("Gioco da Tavolo aggiunto con successo.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Errore: " + e.getMessage());
                            }

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
                        collezione.ricercaGiocoPerNumGiocatori(numGiocatoriPerRicerca)
                                .forEach(giocoDaTavolo -> System.out.println(giocoDaTavolo));
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

// Codice aggiornato della sezione di modifica del gioco nel main:

                    case 6:
                        System.out.print("Inserisci l'ID del gioco da modificare: ");
                        int idGiocoDaModificare = Integer.parseInt(in.nextLine());
                        Optional<Gioco> giocoDaModificare = collezione.ricercaConId(idGiocoDaModificare);
                        if (giocoDaModificare.isPresent()) {
                            Gioco giocoPreModifiche = giocoDaModificare.get();

                            System.out.print("Titolo attuale (" + giocoPreModifiche.getTitolo() + "): ");
                            String nuovoTitolo = in.nextLine();
                            if (!nuovoTitolo.trim().isEmpty()) {
                                giocoPreModifiche.setTitolo(nuovoTitolo);
                            }

                            System.out.print("Anno di pubblicazione attuale (" + giocoPreModifiche.getAnnoDiPubblicazione() + "): ");
                            String nuovoAnno = in.nextLine();
                            if (!nuovoAnno.trim().isEmpty()) {
                                try {
                                    int anno = Integer.parseInt(nuovoAnno);
                                    if (anno >= 1900 && anno <= 2024) {
                                        giocoPreModifiche.setAnnoDiPubblicazione(anno);
                                    } else {
                                        System.out.println("Errore: L'anno di pubblicazione deve essere compreso tra 1900 e 2024.");
                                    }
                                } catch (NumberFormatException ex) {
                                    System.out.println("Errore: L'anno deve essere un numero. Riprova con un valore valido.");
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("Errore: " + ex.getMessage());
                                }
                            }

                            System.out.print("Prezzo attuale (" + giocoPreModifiche.getPrezzo() + "): ");
                            String nuovoPrezzo = in.nextLine();
                            if (!nuovoPrezzo.trim().isEmpty()) {
                                try {
                                    double prezzo = Double.parseDouble(nuovoPrezzo);
                                    if (prezzo > 0) {
                                        giocoPreModifiche.setPrezzo(prezzo);
                                    } else {
                                        System.out.println("Errore: Il prezzo deve essere maggiore di zero.");
                                    }
                                } catch (NumberFormatException ex) {
                                    System.out.println("Errore: Il prezzo deve essere un numero valido. Riprova.");
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("Errore: " + ex.getMessage());
                                }
                            }

                            if (giocoPreModifiche instanceof VideoGame) {
                                VideoGame nuovoVg = (VideoGame) giocoPreModifiche;

                                System.out.print("Piattaforma attuale (" + nuovoVg.getPiattaforma() + "): ");
                                String nuovaPiattaforma = in.nextLine();
                                if (!nuovaPiattaforma.trim().isEmpty()) {
                                    try {
                                        nuovoVg.setPiattaforma(nuovaPiattaforma);
                                    } catch (IllegalArgumentException ex) {
                                        System.out.println("Errore: " + ex.getMessage());
                                    }
                                }

                                System.out.print("Durata di gioco attuale (" + nuovoVg.getDurata() + " ore): ");
                                String nuovaDurata = in.nextLine();
                                if (!nuovaDurata.trim().isEmpty()) {
                                    try {
                                        int durata = Integer.parseInt(nuovaDurata);
                                        if (durata > 0) {
                                            nuovoVg.setDurata(durata);
                                        } else {
                                            System.out.println("Errore: La durata deve essere maggiore di zero.");
                                        }
                                    } catch (NumberFormatException ex) {
                                        System.out.println("Errore: La durata deve essere un numero valido. Riprova.");
                                    } catch (IllegalArgumentException ex) {
                                        System.out.println("Errore: " + ex.getMessage());
                                    }
                                }

                                System.out.print("Genere attuale (" + nuovoVg.getGenere() + "): ");
                                String nuovoGenere = in.nextLine();
                                if (!nuovoGenere.trim().isEmpty()) {
                                    try {
                                        nuovoVg.setGenere(GenereGioco.valueOf(nuovoGenere.toUpperCase()));
                                    } catch (IllegalArgumentException ex) {
                                        System.out.println("Errore: Genere non valido. I generi validi sono: AZIONE, AVVENTURA, SPORT, FANTASY.");
                                    }
                                }

                            } else if (giocoPreModifiche instanceof GiocoDaTavolo) {
                                GiocoDaTavolo nuovoGt = (GiocoDaTavolo) giocoPreModifiche;

                                System.out.print("Numero di giocatori attuale (" + nuovoGt.getNumGiocatori() + "): ");
                                String nuovoNumGiocatori = in.nextLine();
                                if (!nuovoNumGiocatori.trim().isEmpty()) {
                                    try {
                                        int numGiocatori = Integer.parseInt(nuovoNumGiocatori);
                                        if (numGiocatori >= 2 && numGiocatori <= 10) {
                                            nuovoGt.setNumGiocatori(numGiocatori);
                                        } else {
                                            System.out.println("Errore: Il numero di giocatori deve essere compreso tra 2 e 10.");
                                        }
                                    } catch (NumberFormatException ex) {
                                        System.out.println("Errore: Il numero di giocatori deve essere un numero valido. Riprova.");
                                    } catch (IllegalArgumentException ex) {
                                        System.out.println("Errore: " + ex.getMessage());
                                    }
                                }

                                System.out.print("Durata media della partita attuale (" + nuovoGt.getDurataMediaPartita() + " minuti): ");
                                String nuovaDurataPartita = in.nextLine();
                                if (!nuovaDurataPartita.trim().isEmpty()) {
                                    try {
                                        int durataMediaPartita = Integer.parseInt(nuovaDurataPartita);
                                        if (durataMediaPartita > 0) {
                                            nuovoGt.setDurataMediaPartita(durataMediaPartita);
                                        } else {
                                            System.out.println("Errore: La durata media della partita deve essere maggiore di zero.");
                                        }
                                    } catch (NumberFormatException ex) {
                                        System.out.println("Errore: La durata deve essere un numero valido. Riprova.");
                                    } catch (IllegalArgumentException ex) {
                                        System.out.println("Errore: " + ex.getMessage());
                                    }
                                }
                            }
                            System.out.println("Gioco aggiornato con successo.");
                        } else {
                            System.out.println("Errore: Nessun gioco trovato con ID " + idGiocoDaModificare);
                        }
                        break;


                    case 7:
                        collezione.statisticheCollezione();
                        break;

                    case 8:
                        System.out.println(collezione);
                        break;

                    case 0:
                        flag = false;
                        System.out.println("Uscita dal programma...");
                        break;

                    default:
                        System.out.println("Opzione non valida. Riprovare.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Per favore, inserisci un numero.");
            }
        }

        in.close();
    }
}
