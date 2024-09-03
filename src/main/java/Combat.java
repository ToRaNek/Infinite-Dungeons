package src.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;

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

    public void launchCombat() throws IOException{
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
            
            if(this.player.getHp() <= 0){
                this.player.setHp(0);
                endCombat = true;
                System.out.println("Perdu");
            }else if(this.monster.getHp() <= 0){
                endCombat = true;
                System.out.println("Gagné");
            }
        }
    }

    private void monsterPlay(boolean block){
        if(!block){
            int playerDamage = this.monster.getDmgA() + this.monster.getDmgP();
            this.player.damageTaken(playerDamage);
            System.out.println("Vous avez reçu " + playerDamage + " dégats au monstre. Il vous reste " + this.player.getHp() + "hp");
        }
    }

    private boolean playerPlay() throws IOException{
        boolean resp = false;
        String rep;
        while(!resp){
            System.out.println("Que voulez vous faire ?" + ENDLINE + "1 - Attaque        2 - Bloquer");
            rep = Utils.readString();
            if(rep.equals("1")){
                int monsterDamage = this.player.getDmgA() + this.player.getDmgP();
                this.monster.damageTaken(monsterDamage);
                System.out.println("Vous avez fait " + monsterDamage + " dégats au monstre. Il a " + this.monster.getHp() + "hp");
                resp = true;
            }else if (rep.equals("2")) {
                resp = true;
                return true;
            }else{
                System.out.println("Choississez une option valide en notant le numéro correspondant.");
            }
        }
        return false;
    }
    

    
    
}
