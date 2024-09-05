package fr.univlille.iut.infinited.combat;

import fr.univlille.iut.infinited.entity.Player;
import fr.univlille.iut.infinited.equipement.Armors;
import fr.univlille.iut.infinited.equipement.Equipement;
import fr.univlille.iut.infinited.equipement.Potions;
import fr.univlille.iut.infinited.equipement.Weapons;
import fr.univlille.iut.infinited.utils.Utils;

import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;

public class EventsRandom {
    
    private static final String[] EVENTS = new String[]{"COMBAT","SHOP","BOSS","CAMP"};
    private static final Random RDM = new Random();
    private final static String ENDLINE = System.lineSeparator();
    private static int luck =5;

    public String randomEvent()  {
        return EVENTS[RDM.nextInt(EVENTS.length)];
    }

    public static int rdmEventChoice(int difficulty, Player player) throws IOException{
        int rdmNumber = RDM.nextInt(101);
        if(rdmNumber<luck){
            luck = 0;
            System.out.println("\nVous vous retrouvez face à une intersection, quel chemin voulez-vous prendre?");
            ArrayList<String> eventsChosen = new ArrayList<String>();
            for(int i = 0; i <2; i++){
                rdmNumber = RDM.nextInt(101);
                if(rdmNumber >= 0 && rdmNumber <= 33){
                    eventsChosen.add("Shop");
                }else if(rdmNumber >=34 && rdmNumber <= 66){
                    eventsChosen.add("Camp");
                }else if(rdmNumber >=67){
                    eventsChosen.add("fr.univlille.iut.infinited.entity.Boss");
                }
            }
            String rep = "";
            do{
                System.out.println("1 - "+ eventsChosen.get(0)+ "\t 2 - "+eventsChosen.get(1));
                rep = Utils.readString();
            }while(!rep.equals("1")&&!rep.equals("2"));
            if(rep.equals("1")){
                if(eventsChosen.get(0).equals("Shop")){
                    shop(player);
                } else if(eventsChosen.get(0).equals("Camp")){
                    camp(player);
                } else if(eventsChosen.get(0).equals("fr.univlille.iut.infinited.entity.Boss")){
                    return boss();
                }
            }else{
                if(eventsChosen.get(1).equals("Shop")){
                    shop(player);
                } else if(eventsChosen.get(1).equals("Camp")){
                    camp(player);
                } else if(eventsChosen.get(1).equals("fr.univlille.iut.infinited.entity.Boss")){
                    return boss();
                }
            }
            
        }else{luck+=5;}
        return 0;
    }

    public static void shop(Player player){
        // Choix de 1 objets aléatoire parmis les armes et 1 parmis les équipement et 1 potion de soin
        Equipement[] shopList = choiceObject();
        boolean resp = false;
        System.out.println("Marchand : Bonjour et bienvenue dans mon petit marché itinérant." + ENDLINE 
        + " Je suis ici pour vous servir." + ENDLINE 
        + " Je vous laisse regarder ma cargaison."
        + " Ici vous pouvoir voir mes différents objets :"
        + " 1 - " + shopList[0].toString() + "(150 golds) 2 - " + shopList[1].toString() + "(150 golds) 3 - " + shopList[2].toString() + "(100 golds)"+ ENDLINE
        + "Choississez l'item que vous voulez (Tapez 4 pour sortir du marché et continuer votre route): [Vous avez " + player.getGold() + " d'or]");
        while(!resp){
            int ans = Utils.readInt();
            if(ans == 1){
                if(player.getGold() < 150){
                    System.out.println("Vous n'avez pas assez d'argent ;)[Vous avez " + player.getGold() + " d'or]");
                }else{
                    player.setGold(player.getGold() - 150);
                    player.getInventory().add(shopList[0]);
                    System.out.println("Vous avez acheté l'équipement : " + shopList[0].toString());
                }
            }else if(ans == 2){
                if(player.getGold() < 150){
                    System.out.println("Vous n'avez pas assez d'argent ;)[Vous avez " + player.getGold() + " d'or]");
                }else{
                    player.setGold(player.getGold() - 150);
                    player.getInventory().add(shopList[1]);
                    System.out.println("Vous avez acheté l'équipement : " + shopList[1].toString());
                }
            }else if(ans == 3){
                if(player.getGold() < 100){
                    System.out.println("Vous n'avez pas assez d'argent ;)[Vous avez " + player.getGold() + " d'or]");
                }else{
                    player.setGold(player.getGold() - 100);
                    player.getInventory().add(shopList[2]);
                    System.out.println("Vous avez acheté l'équipement : " + shopList[2].toString());
                }
            }else if(ans == 4){
                resp = true;
            }else{
                System.out.println("Système: choix invalide");
            }
        }
    }

    public static int boss(){
        return 1;
    }

    public static void camp(Player player){
        boolean resp = false;
        System.out.println("Inconnu :Bonjour et bienvenue dans mon camp étranger vous pouvez vous y restaurer la nuit si vous voulez." + ENDLINE
         + "Ou bien je vous propose de mettre à profit mes dons de soigneur si cela est necéssaire." +  ENDLINE 
         + " Biensur ce sera seulement si vous avez de quoi me payer." 
         + " 1 - Pour se soigner 20% des hp (gratuit)  2 - Pour payer un soin complet (100 golds). [Vous avez " + player.getGold() + " d'or]");
        while(!resp){
            int rep = Utils.readInt();
            if(rep == 1){
                player.healTaken((int)(player.getHpMax()*0.2));
                System.out.println("D'accord bon repos à vous... ^^" + ENDLINE
                + "Vous vous êtes reposez vous avez maintenant " + player.getHp() + "/" + player.getHpMax());

                resp = true;
            }if(rep == 2){
                if(player.getGold() < 100){
                    System.out.println("Vous n'avez pas assez d'argent ;) Si vous me recroiser plutard peut-être que vous pourrez.[Vous avez " + player.getGold() + " d'or]");
                }else{
                    player.setHp(player.getHpMax());
                    System.out.println("Vous avez été soigné complêtement : " + player.getHp() + "/" + player.getHpMax());
                    resp = true;
                }
                
            }else{
                System.out.println("Veuillez choisir une option valide.");
            }
        }
    }

    private static Equipement[] choiceObject(){
        Weapons[] weaponList = Weapons.values();
        Armors[] ArmorsList = Armors.values();
        Equipement[] listRes = new Equipement[]{weaponList[RDM.nextInt(weaponList.length)], ArmorsList[RDM.nextInt(ArmorsList.length)], Potions.valueOf("SOINPV")};
        return listRes;
    }
}
