package aldovalzani;

import aldovalzani.gameClass.GenereGioco;
import aldovalzani.gameClass.gamesChildren.GiocoDaTavolo;
import aldovalzani.gameClass.gamesChildren.VideoGame;
import com.github.javafaker.Faker;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker();
        VideoGame vg1 = new VideoGame(faker.book().title(),
                2021, 57.99,
                30, GenereGioco.FANTASY, "PS5");

        GiocoDaTavolo tg1 = new GiocoDaTavolo(faker.book().title(),
                1995, 20.00, 120, 4);

        System.out.println(vg1);
        System.out.println(tg1);

    }
}
