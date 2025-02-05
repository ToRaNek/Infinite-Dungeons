package fr.univlille.iut.infinited.entity;

import fr.univlille.iut.infinited.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * fr.univlille.iut.infinited.entity.Mob
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
        int hp = (int)((100*rdm.nextInt(101)/100 + 20) *(0.05*difficulty));
        int defA = (int)((20*rdm.nextInt(101)/100 + 10) *(0.06*difficulty));
        int defP = (int)((20*rdm.nextInt(101)/100 + 10) *(0.04*difficulty));
        int dmgA = (int)((25*rdm.nextInt(101)/100 + 5) *(0.06*difficulty));
        int dmgP = (int)((20*rdm.nextInt(101)/100 + 5) *(0.02*difficulty));
        int gold = (int)((25*rdm.nextInt(101)/100 + 5) *(0.3*difficulty));
        int penA = (int)((3*rdm.nextInt(101)/100 + 1) *(0.05*difficulty));
        int penP = (int)((3*rdm.nextInt(101)/100 + 1) *(0.02*difficulty));
        BossType type = BossType.HARPY;
        if(hp <40){hp = 40;}
        if(dmgA <10){dmgA = 10;}
        if(dmgP <10){dmgP = 7;}
        Boss newBoss = new Boss("Harpie", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 15.0, gold, (float) 0.8, (float) 1.0);
        return newBoss;
    }
    private static Boss createWerewolf(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((110*rdm.nextInt(101)/100 + 20) *(0.05*difficulty));
        int defA =  (int)((20*rdm.nextInt(101)/100 + 10) *(0.06*difficulty));
        int defP =  (int)((20*rdm.nextInt(101)/100 + 10) *(0.04*difficulty));
        int dmgA =  (int)((30*rdm.nextInt(101)/100 + 5) *(0.06*difficulty));
        int dmgP =  (int)((20*rdm.nextInt(101)/100 + 5) *(0.02*difficulty));
        int gold =  (int)((25*rdm.nextInt(101)/100 + 5) *(0.3*difficulty));
        int penA = (int)((3*rdm.nextInt(101)/100 + 1) *(0.05*difficulty));
        int penP = (int)((3*rdm.nextInt(101)/100 + 1) *(0.02*difficulty));
        BossType type = BossType.WEREWOLF;
        if(hp <40){hp = 40;}
        if(dmgA <10){dmgA = 9;}
        if(dmgP <10){dmgP = 8;}
        Boss newBoss = new Boss("Loup-Garou", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 20.0, gold, (float) 0.95, (float) 1.0);
        return newBoss;
    }
    private static Boss createVampire(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((90*rdm.nextInt(101)/100 + 20) *(0.05*difficulty));
        int defA =  0;
        int defP =  (int)((0*rdm.nextInt(101)/100 + 10) *(0.04*difficulty));
        int dmgA =  0;
        int dmgP =  (int)((25*rdm.nextInt(101)/100 + 5) *(0.06*difficulty));
        int gold =  (int)((25*rdm.nextInt(101)/100 + 5) *(0.3*difficulty));
        int penA = 0;
        int penP = (int)((3*rdm.nextInt(101)/100 + 1) *(0.05*difficulty));
        BossType type = BossType.VAMPIRE;
        if(hp <40){hp = 40;}
        if(dmgP <15){dmgP = 15;}
        Boss newBoss = new Boss("Vampire", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 30.0, gold, (float) 1.0, (float) 0.9);
        return newBoss;
    }
    private static Boss createDragon(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp = (int)((100*rdm.nextInt(101)/100 + 20) *(0.05*difficulty));
        int defA = (int)((30*rdm.nextInt(101)/100 + 10) *(0.07*difficulty));
        int defP = (int)((20*rdm.nextInt(101)/100 + 10) *(0.03*difficulty));
        int dmgA = (int)((15*rdm.nextInt(101)/100 + 5) *(0.02*difficulty));
        int dmgP = (int)((30*rdm.nextInt(101)/100 + 5) *(0.06*difficulty));
        int gold = (int)((25*rdm.nextInt(101)/100 + 5) *(0.3*difficulty));
        int penA = (int)((3*rdm.nextInt(101)/100 + 1) *(0.02*difficulty));
        int penP = (int)((3*rdm.nextInt(101)/100 + 1) *(0.06*difficulty));
        BossType type = BossType.DRAGON;
        if(hp <50){hp = 50;}
        if(dmgA <10){dmgA = 10;}
        if(dmgP <15){dmgP = 15;}
        Boss newBoss = new Boss("Dragon", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 30.0, gold, (float) 0.75, (float) 1.0);
        return newBoss;
    }
    private static Boss createMinotaur(int difficulty){
        Random rdm = new Random();
        BossType[] listBoss = BossType.values();
        int hp =  (int)((130*rdm.nextInt(101)/100 + 20) *(0.05*difficulty));
        int defA =  (int)((5*rdm.nextInt(101)/100 + 10) *(0.07*difficulty));
        int defP =  0;
        int dmgA =  (int)((35*rdm.nextInt(101)/100 + 5) *(0.06*difficulty));
        int dmgP =  0;
        int gold =  (int)((30*rdm.nextInt(101)/100 + 5) *(0.3*difficulty));
        int penA = (int)((3*rdm.nextInt(101)/100 + 1) *(0.06*difficulty));
        int penP = 0;
        BossType type = BossType.MINOTAUR;
        if(hp <40){hp = 40;}
        if(dmgA <15){dmgA = 15;}
        Boss newBoss = new Boss("Minotaure", type, hp, dmgA, dmgP,penA, penP, defA, defP, (float) 30.0, gold, (float) 0.8, (float) 1.2);
        return newBoss;
    }
    @Override
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