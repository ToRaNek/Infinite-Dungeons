package main.java;

import java.io.Serializable;

public enum Classes implements Serializable{
    VOLEUR("Voleur",11,4,0,0,0,0,10,25),
    BERSERKER("Berserker",15,0,10,0,0,0,1,15),
    MAGE("Mage",0,15,0,10,0,0,5,15),
    PALADIN("Paladin",7,8,5,5,0,0,2,15);

    private String name; 
    private int degatPhy;
    private int degatMag;
    private int resPhy;
    private int resMag;
    private int penPhy;
    private int penMag;
    private int speed;
    private int gold;

    Classes(String name,int degatPhy, int degatMag, int resPhy, int resMag, int penPhy, int penMag, int speed, int gold) {
        this.name = name;
        this.degatPhy = degatPhy;
        this.degatMag = degatMag;
        this.resPhy = resPhy;
        this.resMag = resMag;
        this.penPhy = penPhy;
        this.penMag = penMag;
        this.speed = speed;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public int getDegatPhy() {
        return degatPhy;
    }

    public void setDegatPhy(int degatPhy) {
        this.degatPhy = degatPhy;
    }

    public int getDegatMag() {
        return degatMag;
    }

    public void setDegatMag(int degatMag) {
        this.degatMag = degatMag;
    }

    public int getResPhy() {
        return resPhy;
    }

    public void setResPhy(int resPhy) {
        this.resPhy = resPhy;
    }

    public int getResMag() {
        return resMag;
    }

    public void setResMag(int resMag) {
        this.resMag = resMag;
    }

    public int getPenPhy() {
        return penPhy;
    }

    public void setPenPhy(int penPhy) {
        this.penPhy = penPhy;
    }

    public int getPenMag() {
        return penMag;
    }

    public void setPenMag(int penMag) {
        this.penMag = penMag;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
