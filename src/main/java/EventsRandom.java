package main.java;

import java.util.ArrayList;
import java.util.Random;

public class EventsRandom {
    
    private static final String[] EVENTS = new String[]{"COMBAT","SHOP","BOSS","CAMP"};
    private static final Random RDM = new Random();
    private final static String ENDLINE = System.lineSeparator();

    public String randomEvent()  {
        return EVENTS[RDM.nextInt(EVENTS.length)];
    }

    public static int rdmEventChoice(int difficulty, Player player){
        int rdmNumber = RDM.nextInt(101);
        if(rdmNumber > 50 && rdmNumber <= 74){
            shop(difficulty);
        }else if(rdmNumber > 75 && rdmNumber <= 89){
            return boss(difficulty);
        }else if(rdmNumber > 90){
            camp(player);
        }
        return 0;
    }

    public static void shop(int difficulty){
        // Choix de 1 objets aléatoire parmis les armes et 1 parmis les équipement et 1 potion de soin
        Equipement[] shopList = choiceObject();
        System.out.println("Marchand : Bonjour et bienvenue dans mon petit marché itinérant." + ENDLINE 
        + " Je suis ici pour vous servir." + ENDLINE 
        + " Je vous laisse regarder ma cargaison."
        + " Ici vous pouvoir voir mes différents objets :"
        + " 1 - " + shopList[1].toString() + "2- " + shopList[2].toString() + "3- " + shopList[3].toString());
    }

    public static int boss(int difficulty){
        return 5;
    }

    public static void camp(Player player){
        boolean resp = false;
        System.out.println("Inconnu :Bonjour et bienvenue dans mon camp étranger vous pouvez vous y restaurer la nuit si vous voulez." + ENDLINE
         + "Ou bien je vous propose de mettre à profit mes dons de soigneur si cela est necéssaire." +  ENDLINE 
         + " Biensur ce sera seulement si vous avez de quoi me payer." 
         + " 1 - Pour se soigner 20% des hp (gratuit)  2 - Pour payer un soin complet (100 golds)");
        while(!resp){
            int rep = Utils.readInt();
            if(rep == 1){
                player.healTaken((int)(player.getHpMax()*0.2));
                System.out.println("D'accord bon repos à vous... ^^" + ENDLINE
                + "Vous vous êtes reposez vous avez maintenant " + player.getHp() + "/" + player.getHpMax());

                resp = true;
            }if(rep == 2){
                if(player.getGold() < 100){
                    System.out.println("Vous n'avez pas assez d'argent ;) Si vous me recroiser plutard peut-être que vous pourrez.");
                }else{
                    player.setHp(player.getHpMax());
                    System.out.println("Vous avez été soigné complêtement : " + player.getHp() + "/" + player.getHpMax());
                }
                resp = true;
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
