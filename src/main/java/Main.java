package main.java;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Player player = new Player("Joueur 1", 100, 10, 1, 10, 1, 1, 0);
        

        Main.showStartMenu(player);

        boolean optionEntered = false;
        do{
                    String result = Utils.readString();
                    switch (result) {
                        case "1":
                            optionEntered = true;
                            gameLoop(player);                        
                            break;
                        case "2":
                            optionEntered = true;
                        case "3":
                            Main.showHelpMenu(player);
                            TimeUnit.SECONDS.sleep(4);
                            Main.showStartMenu(player);
                            break;
                        case "4":
                            optionEntered = true;
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Choix Invalide");
                            break;
                    }       


        }while (!optionEntered);
         




    }


    public static void showStartMenu(Player player) {
        System.out.println("Bienvenue " + player + " sur Infinite Dungeons");
        System.out.println("Entrer les valeurs correspondantes a chaque option: ");
        System.out.println(" 1. Lancer la partie ");
        System.out.println(" 2. Charger une partie (Indisponible)");
        System.out.println(" 3. Infos regles");
        System.out.println(" 4. Quitter");


       
    }

    public static void showHelpMenu(Player player) {
        System.out.println("\n");
        System.out.println("Infinite Dungeons consiste en un jeu de donjon au tour par tour");
        System.out.println("Chaque tour vous affrontez des ennemis différent");
        System.out.println("Récuperer des objets pour devenir de plus en plus puissant");
    }

    public static void gameLoop(Player player) throws IOException{
        int generalDifficulty = 1;
        boolean deadPlayer = false;
        Mob mob = Mob.randomNewMob(generalDifficulty);
        //Combat combatTest = new Combat(mob, player);
        while(!deadPlayer){
            mob = Mob.randomNewMob(generalDifficulty);
            deadPlayer = new Combat(mob, player).launchCombat();
            System.out.println("Turn finished");
            generalDifficulty ++;
            EventsRandom.rdmEventChoice(generalDifficulty, player);        
        }
    }

}
