package first_game;

import first_game.objects.FIRE;
import first_game.objects.GROUND;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GROUND Dexter = new GROUND("Dexter Morgan", 15, 150, 10,
                10, TypeUnit.DAMAGE_DEALER);
        FIRE Arthur = new FIRE("Arthur Mitchell", 10, 100, 10,
                10, TypeUnit.FLANG);

        System.out.println("Dexter Morgan vs Arthur Mitchell");
        System.out.println("Hello, Dexter Morgan.");
        System.out.println("Hello, Arthur Mitchell.");

        for (int round = 1; round <= 10; round++) {
            System.out.println("Round " + round);
            Dexter.damage(Arthur);
            Arthur.damage(Dexter);
            System.out.println(Dexter.getName() + " HP: " + Dexter.getHealth());
            System.out.println(Arthur.getName() + " HP: " + Arthur.getHealth());
            System.out.println();
        }
    }
}