package main.java;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Mob
 */
public class Boss extends Entity{
    
    private BossType type;
    private int resistanceA;
    private int resistanceP;

    public Boss(String name, BossType listBoss,int hpMax, int dmgA, int dmgP, int defA, int defP, float speed, int gold, int resistanceA, int resistanceP) {
        super(name, hpMax, dmgA, dmgP, defA, defP, speed, gold);
        this.resistanceA = resistanceA;
        this.resistanceP = resistanceP;
    }

    public BossType getType() {
        return type;
    }

    public static Boss randomNewBoss(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        String bossChosen = listBoss[rdm.nextInt(listBoss.length)].toString();
        Boss newBoss;
        if (bossChosen.equals("HARPY")){
            newBoss = createHarrpy(difficulty);
        }else if (bossChosen.equals("WEREWOLF")){
            newBoss = createWerewolf(difficulty);
        }else if (bossChosen.equals("VAMPIRE")){
            newBoss = createVampire(difficulty);
        }else if (bossChosen.equals("Dragon")){
            newBoss = createDragon(difficulty);
        }

        return newBoss;
    }

    private static Boss createHarrpy(int difficulty){
        int hp =  (int)((110*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA =  (int)((10*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int defP =  (int)((30*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int dmgA =  (int)((10*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int dmgP =  (int)((10*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int gold =  (int)((50*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        Boss newBoss = new Boss(listBoss[num].toString(), listBoss[num] , hp, dmgA, dmgP, defA, defP, 30, gold, 10);
        return newBoss;
    }
    public void bossToImage() throws IOException{
        String path = System.getProperty("user.dir") + File.separator + "res" + File.separator + "boss" + File.separator + "ansi" +  File.separator;
        Utils.printAnsi(new File(path + this.type.getPath()));
    }

    public int damageTaken(int dmgA, int dmgP){
        int totalDamage = 0;
        totalDamage = (dmgA-getDefA())*resistanceA + (dmgP - getDefP())*resistanceP;
        if(totalDamage <= 0 ){totalDamage = 1;}
        setHp(getHp()-totalDamage);
        if(getHp()<0){setHp(0);}
        return totalDamage;
    }

}