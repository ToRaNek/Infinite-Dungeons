package main.java;

import java.util.Random;

/**
 * Mob
 */
public class Mob {
    private String name;
    private int hp;
    private int hpMax;
    private int defA;
    private int defP;
    private int speed;
    private int dmgA;
    private int dmgP;
    private MobType type;
    
    public Mob(String name, MobType type, int hpMax, int defA,int defP, int dmgA, int dmgP, int speed) {
        this.name = name;
        this.type = type;
        this.hp = hpMax;
        this.hpMax = hpMax;
        this.defA = defA;
        this.speed = speed;
        this.dmgA = dmgA;
        this.dmgP = dmgP;
    }

    public MobType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getDefA() {
        return defA;
    }
    public int getDefP() {
        return defP;
    }
    public int getSpeed(){
        return speed;
    }
    
    public int getHpMax() {
        return hpMax;
    }

    public int getDmgA() {
        return dmgA;
    }

    public int getDmgP() {
        return dmgP;
    }

    public void healTaken(int nbrHp){
        this.hp += nbrHp;
        if(hp>hpMax){hp=hpMax;}
    }
    public void damageTaken(int dmgTaken){
        hp -= (dmgTaken-(defA + defP));
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public void setDefA(int defA) {
        this.defA = defA;
    }
    public void setDefP(int defP) {
        this.defP = defP;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDmgA(int ad) {
        this.dmgA = ad;
    }

    public void setDmgP(int ap) {
        this.dmgP = ap;
    }

    public static Mob randomNewMob(int difficulty){
        Random rdm = new Random();
        MobType[] listMob = MobType.values();
        int longueur = listMob.length;
        int num = rdm.nextInt(longueur);
        int hp =  (int)((80*rdm.nextInt(101)/100 + 20) *difficulty);
        int defA =  (int)((5*rdm.nextInt(101)/100 + 10) *0.25*difficulty);
        int defP =  (int)((20*rdm.nextInt(101)/100 + 10) *0.25*difficulty);
        int dmgA =  (int)((5*rdm.nextInt(101)/100 + 5) *0.25*difficulty);
        int dmgP =  (int)((5*rdm.nextInt(101)/100 + 5) *0.25*difficulty);
        Mob newMob = new Mob(listMob[num].toString(), listMob[num] , hp, defA, defP, dmgA, dmgP, 5);

        return newMob;
    }


}