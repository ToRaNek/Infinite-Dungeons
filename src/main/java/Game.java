package src.main.java;



/**
 * 
 */
public class Game {


    //TODO 
    /*
     * Create constructor with User  
     */

    private Player player;

    public Game(Player player) {
        this.player = player;
    }


    public void start() {

    }


    public void showStartMenu() {
        System.out.println("Bienvenue " + player + " sur Infinite Dungeons");
        System.out.println("Entrer les valeurs correspondantes a chaque option: ");
        System.out.println(" 1. Lancer la partie ");
        System.out.println(" 2. Charger une partie (Indisponible)");
        System.out.println(" 3. Infos regles (Indisponible)");
        System.out.println(" 4. Quitter");


       
    }


    public void showHelpMenu() {
        System.out.println("Bienvenue " + player + " sur Infinite Dungeons");
        System.out.println("Infinite Dungeons consiste en un jeu de donjon au tour par tour");
        System.out.println("Chaque tour vous affrontez des ennemis différent");
        System.out.println("Récuperer des objets pour devenir de plus en plus puissant");
    }

    
}
