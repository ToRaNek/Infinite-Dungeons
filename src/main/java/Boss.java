package main.java;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Mob
 */
public class Boss extends Entity{
    
    private BossType type;
    private float resistanceA;
    private float resistanceP;

    public Boss(String name, BossType type,int hpMax, int dmgA, int dmgP,int penA, int penP, int defA, int defP, float speed, int gold, float resistanceA, float resistanceP) {
        super(name, hpMax, dmgA, dmgP, defA, defP,penA, penP, speed, gold);
        this.resistanceA = resistanceA;
        this.resistanceP = resistanceP;
        this.type = type;
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
            newBoss = createHarpy(difficulty);
        }else if (bossChosen.equals("WEREWOLF")){
            newBoss = createWerewolf(difficulty);
        }else if (bossChosen.equals("VAMPIRE")){
            newBoss = createVampire(difficulty);
        }else if (bossChosen.equals("DRAGON")){
            newBoss = createDragon(difficulty);
        }else{
            newBoss = createMinotaur(difficulty);
        }
        return newBoss;
    }

    private static Boss createHarpy(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp = (int)((100*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA = (int)((20*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int defP = (int)((20*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int dmgA = (int)((25*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int dmgP = (int)((20*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int gold = (int)((25*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int penA = 5; //à changer
        int penP = 5; //à changer
        BossType type = BossType.HARPY;
        Boss newBoss = new Boss("Harpie", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 15.0, gold, (float) 0.8, (float) 1.0);
        return newBoss;
    }
    private static Boss createWerewolf(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((110*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA =  (int)((20*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int defP =  (int)((20*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int dmgA =  (int)((30*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int dmgP =  (int)((20*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int gold =  (int)((25*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int penA = 5; //à changer
        int penP = 5; //à changer
        BossType type = BossType.WEREWOLF;
        Boss newBoss = new Boss("Loup-Garou", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 20.0, gold, (float) 0.95, (float) 1.0);
        return newBoss;
    }
    private static Boss createVampire(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((90*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA =  (int)((10*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int defP =  (int)((0*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int dmgA =  (int)((20*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int dmgP =  (int)((25*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int gold =  (int)((25*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int penA = 5; //à changer
        int penP = 5; //à changer
        BossType type = BossType.VAMPIRE;
        Boss newBoss = new Boss("Vampire", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 30.0, gold, (float) 1.0, (float) 0.9);
        return newBoss;
    }
    private static Boss createDragon(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((100*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA =  (int)((30*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int defP =  (int)((20*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int dmgA =  (int)((15*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int dmgP =  (int)((30*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int gold =  (int)((25*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int penA = 5; //à changer
        int penP = 5; //à changer
        BossType type = BossType.DRAGON;
        Boss newBoss = new Boss("Dragon", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 30.0, gold, (float) 0.75, (float) 1.0);
        return newBoss;
    }
    private static Boss createMinotaur(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((130*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA =  (int)((5*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int defP =  (int)((0*rdm.nextInt(101)/100 + 10) *0.30*difficulty);
        int dmgA =  (int)((35*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int dmgP =  (int)((0*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int gold =  (int)((30*rdm.nextInt(101)/100 + 5) *0.30*difficulty);
        int penA = 5; //à changer
        int penP = 5; //à changer
        BossType type = BossType.MINOTAUR;
        Boss newBoss = new Boss("Minotaure", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 30.0, gold, (float) 0.8, (float) 1.2);
        return newBoss;
    }

    public void monsterToImage() throws IOException{
        String path = System.getProperty("user.dir") + File.separator + "res" + File.separator + "mobs" + File.separator + "ansi" +  File.separator;
        Utils.printAnsi(new File(path + this.type.getPath()));
    }

    public int damageTaken(int dmgA, int dmgP){
        int totalDamage = 0;
        totalDamage = (int)((dmgA-getDefA())*resistanceA + (dmgP - getDefP())*resistanceP);
        if(totalDamage <= 0 ){totalDamage = 1;}
        setHp(getHp()-totalDamage);
        if(getHp()<0){setHp(0);}
        return totalDamage;
    }

}