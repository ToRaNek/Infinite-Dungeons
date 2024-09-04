package main.java;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Set<String> playerNames = Utils.loadPlayerNames();

        Main.showStartMenu();

        boolean optionEntered = false;
        do{
                    String result = Utils.readString();
                    switch (result) {
                        case "1":
                            optionEntered = true;
                            String name = "Robertineux";
                            while(name.length() > 10 || name.length() < 3){
                                name = "Robert";
                                System.out.println("Bonjour aventurier.ère, comment vous appellez vous ? (Max : 10 caractères)");
                                name = Utils.readString();
                            }
                            if(playerNames.contains(name)){
                                System.out.println("Erreur, nom d'utilisateur deja utilisé !");
                                System.exit(0);
                            }
                            boolean classes = false;
                            Classes classe = Classes.VOLEUR;
                            while (!classes) {
                                 Utils.printAnsi(new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "classe" + File.separator + "ansi" + File.separator+"Voleur_et_berserker-art.utf.ans"));
                                 System.out.println("1 - Voleur \t\t\t\t\t\t\t\t\t 2 - Berserker ");
                                 Utils.printAnsi(new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "classe" + File.separator + "ansi" + File.separator+"Mage_et_paladin-art.utf.ans"));
                                 System.out.println("3 - Mage \t\t\t\t\t\t\t\t\t 4 - Paladin");
                                 System.out.println("Quelle classe voulez vous jouer ?");
                              
                                 String nbrClasse = Utils.readString(); 
                                if(nbrClasse.equals("1")){
                                    classe = Classes.VOLEUR;
                                    classes = true;
                                }else if(nbrClasse.equals("2")){
                                    classe = Classes.BERSERKER;
                                    classes = true;
                                }else if(nbrClasse.equals("3")){
                                    classe = Classes.MAGE;
                                    classes = true;
                                }else if(nbrClasse.equals("4")){
                                    classe = Classes.PALADIN;
                                    classes = true;
                                }else {
                                    System.out.println("Veuillez entrer un chiffre valable !\n");
                                }
                            }
                            System.out.println("Vous avez sélectioné la classe "+classe.getName());
                            Player player = new Player(name, 100, classe);
                            gameLoop(player);                           
                            break;
                        case "2":
                            printSaveChoices();
                            choiceSave();
                            optionEntered = true;
                            break;
                        case "3":
                            Main.showHelpMenu();
                            TimeUnit.SECONDS.sleep(4);
                            Main.showStartMenu();
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


    public static void printSaveChoices() {
        List<Combat> combats = Utils.loadGames();
        System.out.println("Partie sauvegardé: ");
       
        for(int i = 0; i<combats.size(); i++) {
            System.out.println(" " + (i+1) + ". Combat de " + combats.get(i).getPlayer().getName());
        }
    }

   public static void choiceSave() throws IOException, InterruptedException {
        List<Combat> combats = Utils.loadGames();
        boolean correctChoice = false;
        int choice = -1;
        while(!correctChoice) {
            choice = Utils.readInt();
            if(choice > 0 && choice <= combats.size()) correctChoice = true;
        }

        System.out.println("Chargement de la partie sélectionnée... ");
        TimeUnit.SECONDS.sleep(4);
        Main.gameLoop(combats.get(choice-1).getPlayer(), combats.get(choice-1));
   }


    public static void showStartMenu() throws IOException{
        Utils.printAnsi(new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "logo-art.utf.ans"));

        System.out.println("Bienvenue Joueur 1 sur Infinite Dungeons");
        System.out.println("Entrer les valeurs correspondantes a chaque option: ");
        System.out.println(" 1. Lancer la partie ");
        System.out.println(" 2. Charger une partie (Indisponible)");
        System.out.println(" 3. Infos regles");
        System.out.println(" 4. Quitter");


       
    }

    public static void showHelpMenu() {
        System.out.println("\n");
        System.out.println("Infinite Dungeons consiste en un jeu de donjon au tour par tour");
        System.out.println("Chaque tour vous affrontez des ennemis différent");
        System.out.println("Récuperer des objets pour devenir de plus en plus puissant\n");
    }

    public static void gameLoop(Player player, Combat loadCombat) throws IOException{
        int generalDifficulty = 1;
        boolean deadPlayer = false;
        Mob mob = Mob.randomNewMob(generalDifficulty);
        Combat combat = loadCombat;
        //Combat combatTest = new Combat(mob, player);
        while(!deadPlayer){
            Combat c;
            if(combat == null) {
                mob = Mob.randomNewMob(generalDifficulty);
                c = new Combat(mob, player);
                deadPlayer = c.launchCombat();
            }else {
                deadPlayer = combat.launchCombat();
                c= combat;
                combat = null;
            }
            generalDifficulty ++;
            EventsRandom.rdmEventChoice(generalDifficulty, player);     
            if(!Main.continueGame()) {
                deadPlayer = true;
                Utils.saveGame(c);
                System.out.println("Votre partie a été sauvegardé ! A bientôt");
            }   
        }
    }

    public static void gameLoop(Player player) throws IOException {
        Main.gameLoop(player, null);
    }

    public static boolean continueGame() throws IOException{
       


        System.out.println("Souhaitez vous continuer ou sauvegarder votre partie ?");
        System.out.println("1. Continuer");
        System.out.println("2. Sauvegarder et quitter");

        String choice = Utils.readString();
        while(!choice.equals("1") && !choice.equals("2")) {
            choice = Utils.readString();
        }
        
        if(choice.equals("1")) return true;

        return false;
    }

    

}
