package main.java;

import java.io.Serializable;

public class Entity implements Serializable {
    private String name;
    private int hp;
    private int hpMax;
    private int dmgA;
    private int dmgP;
    private int penA;
    private int penP;
    private int defA;
    private int defP;
    private float speed;
    private int gold;

    public Entity(String name, int hpMax, int dmgA, int dmgP, int defA, int defP,int penA, int penP, float speed, int gold) {
        this.name = name;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.dmgA = dmgA;
        this.dmgP = dmgP;
        this.penA = penA;
        this.penP = penP;
        this.defA = defA;
        this.defP = defP;
        this.speed = speed;
        this.gold = gold;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void sethpMax(int hpMax){
        this.hpMax = hpMax;
    }
    public void setDmgA(int dmgA) {
        this.dmgA = dmgA;
    }
    public void setDmgP(int dmgP) {
        this.dmgP = dmgP;
    }
    public void setDefA(int defA) {
        this.defA = defA;
    }
    public void setDefP(int defP) {
        this.defP = defP;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }
    public void setPenA(int penA) {
        this.penA = penA;
    }

    public void setPenP(int penP) {
        this.penP = penP;
    }
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
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
    public int getDefA() {
        return defA;
    }
    public int getDefP() {
        return defP;
    }
    public float getSpeed() {
        return speed;
    }
    protected int getGold() {
        return gold;
    }
    public int getPenA() {
        return penA;
    }
    public int getPenP() {
        return penP;
    }

    public void healTaken(int nbrHp){
        this.hp += nbrHp;
        if(this.hp>this.hpMax){this.hp=this.hpMax;}
    }

    public int damageTaken(int dmgA, int dmgP){
        int totalDamage = 0;
        int damA = 0;
        int damP = 0;
        damA = (int)(dmgA-(this.defA*(1-(this.penA/100))));
        if(damA < 0){damA = 0;}
        damP = (int)(dmgP - this.defP*(1-(this.penP/100)));
        if(damP < 0){damP = 0;}
        if(totalDamage < 0 ){totalDamage = 0;}
        this.hp -= totalDamage;
        if(this.hp<0){this.hp=0;}
        return totalDamage;
    }

    public void addGold(int gold){
        this.gold += gold;
    }



    
}
