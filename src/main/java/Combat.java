package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;
import java.util.List;

/**
 * 
 */
public class Combat {
    /**
     * 
     */
    private final static String ENDLINE = System.lineSeparator();
    private Mob monster;
    private Player player;
    private boolean endCombat;
    int damageMonster;
    int damagePlayer;
    int healPlayer;
    int healMonster;
    

   

    public Combat(Mob monster, Player player) {
        this.monster = monster;
        this.player = player;
        this.endCombat = false;
        this.healMonster = 0;
        this.healPlayer = 0;
    }

    public Mob getMonstre() {
        return monster;
    }
    public void setMonstre(Mob monster) {
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
        while(!endCombat){
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
        return !(this.player.getHp() > 0);
    }

    private void monsterPlay(boolean block){
        if(!block){
            int playerDamage = this.monster.getDmgA() + this.monster.getDmgP();
            this.player.damageTaken(playerDamage);
            if(this.player.getHp() <= 0){
                this.player.setHp(0);
                endCombat = true;
                System.out.println("Perdu");
            }else{
                System.out.println("Vous avez reçu " + playerDamage + " dégats du monstre. Il vous reste " + this.player.getHp() + "hp");
            }
            
        }
    }

    private boolean playerPlay() throws IOException{
        boolean resp = false;
        String rep;
        while(!resp){
            System.out.println("Que voulez vous faire ?" + ENDLINE + "1 - Attaque        2 - Bloquer        3- Changer Equipement");
            rep = Utils.readString();
            if(rep.equals("1")){
                int monsterDamage = this.player.getDmgA() + this.player.getDmgP();
                this.monster.damageTaken(monsterDamage);
                if(this.monster.getHp() <= 0){
                    endCombat = true;
                    System.out.println("Gagné");
                }else{
                    System.out.println("Vous avez fait " + monsterDamage + " dégats au monstre. Il a " + this.monster.getHp() + "hp");
                    resp = true;
                }
                
            }else if (rep.equals("2")) {
                resp = true;
                return true;
            }else if (rep.equals("3")) {
                resp = true;
                boolean resp2 = false;
                while(!resp2){
                    System.out.println("Quelle équipement voulez vous changer?" + "\n" + "1 - Armes        2 - Armures");
                    String choice = Utils.readString();
                    if(choice.equals("1")){
                        resp2 = true;
                        System.out.println("Choisissez l'arme que vous souhaitez utiliser");
                        List<Weapons> tmp = this.player.getInventory().stream().filter(equipement -> equipement instanceof Weapons).map(equipement -> (Weapons) equipement).toList();
                        for (int i = 0; i < tmp.size(); i++){
                            System.out.println("" + (i+1) + " " + tmp.get(i));
                        }
                        boolean resp3 = false;
                        while(!resp3){
                            int choicearme = Utils.readInt();
                            if (choicearme-1 <  0 || choicearme-1 >  player.getInventory().size() ){
                                System.out.println("Choississez une option valide en notant le numéro correspondant."); 
                            }else{
                                this.player.setArmeActuelle(tmp.get(choicearme-1));
                                System.out.println("Vous avez selectionnez l'arme : " + this.player.getArme().name()); 
                                resp3= true;
                            }
                        }
                        
                        
                    }else if (choice.equals("2")){
                        resp2 = true;
                        System.out.println("Choisissez l'armure que vous souhaitez utiliser");
                        List<Armors> tmp = this.player.getInventory().stream().filter(equipement -> equipement instanceof Armors).map(equipement -> (Armors) equipement).toList();
                        for (int i = 0; i < tmp.size(); i++){
                            System.out.println("" + (i+1) + " " +  tmp.get(i));
                        }
                        boolean resp4 = false;
                        while(!resp4){
                            int choicearme = Utils.readInt();
                            if (choicearme-1 <  0 || choicearme-1 >  player.getInventory().size() ){
                                System.out.println("Choississez une option valide en notant le numéro correspondant."); 
                            }else{
                                this.player.setArmureActuelle(tmp.get(choicearme-1));
                                System.out.println("Vous avez selectionnez l'armure : " + this.player.getArmure().name()); 
                                resp4= true;
                            }
                        }


                    }else{
                    System.out.println("Choississez une option valide en notant le numéro correspondant.");
                    }    
                }
                

                
            }else{
                System.out.println("Choississez une option valide en notant le numéro correspondant.");
            }
        }
        return false;
    }
    

    
    
}
