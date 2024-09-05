package main.java;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 */
public class Combat implements Serializable {
    /**
     * 
     */
    private final static String ENDLINE = System.lineSeparator();
    private Entity monster;
    private Player player;
    private boolean endCombat;
    int damageMonster;
    int damagePlayer;
    int healPlayer;
    int healMonster;
    StatutEffect<Player> effectPlayer;
    StatutEffect<Entity> effectMob;
    
    
    public Combat(Entity monster, Player player) {
        this.monster = monster;
        this.player = player;
        this.endCombat = false;
        this.healMonster = 0;
        this.healPlayer = 0;
        effectPlayer = new StatutEffect<Player>(player);
        effectMob = new StatutEffect<Entity>(monster);
    }

    public Entity getMonstre() {
        return monster;
    }
    public void setMonstre(Entity monster) {
        this.monster = monster;
    }
    public Player getPlayer() {
        return player;
    }
    public void setJoueur(Player player) {
        this.player = player;
    }

    private boolean faster(){
        boolean playerTurn = player.getSpeed() > monster.getSpeed(); 
        return playerTurn;
    }

    public boolean launchCombat() throws IOException{
        boolean playerTurn = this.faster();
        boolean block = false;
        
        while(!this.endCombat){
    
            
            if (playerTurn) {
                System.out.println(ENDLINE + "Tour du joueur :");
                block = this.playerPlay();
                playerTurn = false;
            } else {
                System.out.println(ENDLINE + "Tour de l'ennemie");
                this.monsterPlay(block);
                block = false;
                playerTurn = true;
            }
        }
        this.player.addGold(this.monster.getGold());
        Random rand = new Random();
        int nombreRandom = rand.nextInt(101);
        if(nombreRandom>=0 && nombreRandom <=10){
            this.player.getInventory().add(Potions.SOINPV);
            System.out.println("Vous avez récupéré une potion du monstre.");
        }else if(nombreRandom>=11 && nombreRandom <=15){
            this.player.getInventory().add(Weapons.values()[rand.nextInt(Weapons.nbrOfWeapons+1)]);
            System.out.println("Vous avez récupéré une arme du monstre.");
        }else if(nombreRandom>=16 && nombreRandom <=20){
            this.player.getInventory().add(Weapons.values()[rand.nextInt(Armors.nbrOfArmors+1)]);
            System.out.println("Vous avez récupéré une armure du monstre.");
        }
        return !(this.player.getHp() > 0);
    }

    private void monsterPlay(boolean block) {
        int[] totalDamage = new int[]{0};  
        if(!block){
            totalDamage[0] = this.player.damageTaken(monster.getDmgA(), monster.getDmgP(),this.monster);
            if(this.player.getHp() <= 0){
                this.player.setHp(0);
                this.endCombat = true;
                System.out.println("Perdu");
            }else{
                try{
                    this.monster.monsterToImage();
                }catch(IOException e ) {
                    System.out.println(this.monster.getName());
                } 
                Timer timer = new Timer();
               // TimerTask test = new TimerTask() {
                 //   public void run() {
                        System.out.println("\n Vous avez reçu " + totalDamage[0] + " dégats du monstre.");
                   // }
                //};
                //timer.schedule(test, 15L);
                
            }
            
        }
    }

    private boolean playerPlay() throws IOException{
        int totalDamage = 0;
        boolean resp = false;
        String rep;
        while(!resp){
            System.out.println("\nVos Statistiques\t                         Statistiques du monstre\n 🪶 : "+ this.player.getSpeed()+ "                 ❤️ : "+ this.player.getHp() +"                  🪶 : "+ this.monster.getSpeed()+ "                 ❤️ : "+ this.monster.getHp()
            +"\n ⚔️ : " + this.player.getDmgA()+ " (+ " +this.player.getPenA() + "%penArm)    🪄 : " + this.player.getDmgP()+ " (+ " + this.player.getPenP() +"%penMag)\t  ⚔️ : " + this.monster.getDmgA()+ " (+ " +this.monster.getPenA() + " %penArm)     🪄 : " + this.monster.getDmgP() + " (+" + this.monster.getPenP() + "%penMag)"
            +"\n 🛡️ : " + this.player.getDefA()+ "                   ⭐: " + this.player.getDefP()+"\t                  🛡️ : " + this.monster.getDefA()+ "                   ⭐: " + this.monster.getDefP()
            +"\n 🪙 : " + this.player.getGold());
            System.out.print("\nQue voulez vous faire ?" + ENDLINE + "1 - Attaque        2 - Bloquer        3 - Changer Equipement       4 - Potions");
            if(player.getScepter() != null) {
                System.out.print("    5 - Lancer un sort");
            }
            System.out.println();
            rep = Utils.readString();
            
            if(rep.equals("1")){
               
                    totalDamage = this.monster.damageTaken(this.player.getDmgA(), this.player.getDmgP(),this.player);
                if(this.monster.getHp() <= 0){
                    this.endCombat = true;
                    System.out.println("Gagné");
                    resp= true;
                }else{
                    System.out.println("Vous avez fait " + totalDamage + " dégats au monstre. Il a " + this.monster.getHp() + "hp");
                    resp = true;
                }
                
                
                
            }else if (rep.equals("2")) {
                return true;
            }else if (rep.equals("3")) {
                resp = true;
                boolean resp2 = false;
                while(!resp2){
                    System.out.println("Quelle équipement voulez vous changer?\n  1 - Armes        2 - Armures");
                    String choice = Utils.readString();
                    resp2 = this.choiceEquipement(choice);  
                }
                
            }else if (rep.equals("4")) {    
                resp = true;
                boolean resp2 = false;
                List<Potions> playerInventoryPotions = this.player.getInventory().stream().filter(equipement -> equipement instanceof Potions).map(equipement -> (Potions) equipement).toList();
                if(playerInventoryPotions.size() > 0) {
                    while(!resp2){
                        System.out.println("Quelle potions voulez vous boire?");
                        for (int i = 0; i < playerInventoryPotions.size(); i++){
                            System.out.println("" + (i+1) + " " +  playerInventoryPotions.get(i));
                        }
                        resp2 = this.choicePotions(playerInventoryPotions);  
                    }
                }else{
                    System.out.println("Inventaire de potions VIDE");
                }
            }else if (rep.equals("5") && player.getScepter() != null) {
                    
                    Scepter scepter = player.getScepter();
                    if(scepter.getStatut().getPositive()) {
                        effectPlayer.applyEffect(scepter.getStatut());
                    }else {
                        effectMob.applyEffect(scepter.getStatut());
                    }

            }else{
                System.out.println("Choississez une option valide en notant le numéro correspondant.");
            }
        }
        return false;
    }

    public boolean choiceEquipement(String choice) {
        boolean resp2 = false;
        if(choice.equals("1")){
            resp2 = true;
            System.out.println("Choisissez l'arme que vous souhaitez utiliser");
            List<Equipement> playerInventoryWeapons = new ArrayList<>();
            playerInventoryWeapons.addAll(this.player.getInventory().stream().filter(equipement -> equipement instanceof Weapons).map(equipement -> (Weapons) equipement).toList());
            playerInventoryWeapons.addAll(this.player.getInventory().stream().filter(equipement -> equipement instanceof Scepter).map(equipement -> (Scepter) equipement).toList());
            for (int i = 0; i < playerInventoryWeapons.size(); i++){
                System.out.println("" + (i+1) + " " + playerInventoryWeapons.get(i));
            }
            boolean resp3 = false;
            while(!resp3){
                resp3 = this.choiceWeapon(playerInventoryWeapons);
            }
            
            
        }else if (choice.equals("2")){
            resp2 = true;
            System.out.println("Choisissez l'armure que vous souhaitez utiliser");
            List<Armors> playerInventoryArmors = this.player.getInventory().stream().filter(equipement -> equipement instanceof Armors).map(equipement -> (Armors) equipement).toList();
            for (int i = 0; i < playerInventoryArmors.size(); i++){
                System.out.println("" + (i+1) + " " +  playerInventoryArmors.get(i));
            }
            boolean resp4 = false;
            while(!resp4){
                resp4 = choiceArmor(playerInventoryArmors);
            }


        }else{
        System.out.println("Choississez une option valide en notant le numéro correspondant.");
        }  

        return resp2; 
    }



    /**
     * Ask player to enter a number to get a weapons in his inventory
     * @param playerInventoryWeapons the Weapons in the player inventory
     * @return  a boolean if the choice was correct
     */
    public boolean choiceWeapon(List<Equipement> playerInventoryWeapons) {
        boolean resp3 = false;
        int choiceWeapon = Utils.readInt();
        if (choiceWeapon-1 <  0 || choiceWeapon-1 >  player.getInventory().size() ){
            System.out.println("Choississez une option valide en notant le numéro correspondant."); 
        }else{
            if(playerInventoryWeapons.get(choiceWeapon-1) instanceof Weapons) {
                this.player.setArmeActuelle((Weapons) playerInventoryWeapons.get(choiceWeapon-1));
                System.out.println("Vous avez selectionnez l'arme : " + this.player.getArme().name()); 
                resp3= true;
            }else if(playerInventoryWeapons.get(choiceWeapon-1) instanceof Scepter) {
                this.player.setScepter((Scepter) playerInventoryWeapons.get(choiceWeapon-1));
                System.out.println("Vous avez selectionnez le scpetre : " + this.player.getScepter().name()); 
                resp3= true;
            }
            
        }

        return resp3;
    }


    public boolean choiceArmor(List<Armors> playerInventoryArmors) {
        boolean resp4 = false;
        int chocieArmor = Utils.readInt();
        if (chocieArmor-1 <  0 || chocieArmor-1 >  player.getInventory().size() ){
            System.out.println("Choississez une option valide en notant le numéro correspondant."); 
        }else{
            this.player.setArmureActuelle(playerInventoryArmors.get(chocieArmor-1));
            System.out.println("Vous avez selectionnez l'armure : " + this.player.getArmure().name()); 
            resp4= true;
        }

        return resp4;
    }

    public boolean choicePotions(List<Potions> playerInventoryPotions) {
        boolean resp4 = false;
        int chociePotions = Utils.readInt();
        if (chociePotions-1 <  0 || chociePotions-1 >  player.getInventory().size() ){
            System.out.println("Choississez une option valide en notant le numéro correspondant."); 
        }else{
            this.player.setPotionsLastUse(playerInventoryPotions.get(chociePotions-1));
            System.out.println("Vous avez selectionnez la potions : " + this.player.getPotion().name());;
            this.player.usePotion(); 
            resp4= true;
        }

        return resp4;
    }


    
}
