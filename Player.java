package src.main.java;

import java.util.ArrayList;

public class Player {
    private final int MAXHP = 20;
    private String name;
    private int hp;
    private int dmgA;
    private int dmgP;
    private int defA;
    private int defP;
    private float speed;
    private ArrayList<Object> inventory;
    
    public Player(String name, int hp, int dmgA, int defA, int dmgP, int defP, float speed, ArrayList<Object> inventory) {
        this.name = name;
        this.hp = hp;
        this.dmgA = dmgA;
        this.defA = defA;
        this.dmgP = dmgP;
        this.defP = defP;
        this.speed = speed;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getDmgA() {
        return dmgA;
    }
    public int getDefA() {
        return defA;
    }
    public int getDmgP() {
        return dmgP;
    }
    public int getDefP() {
        return defP;
    }
    public float getSpeed() {
        return speed;
    }
    public ArrayList<Object> getInventory() {
        if (inventory == null) {
            throw new NullPointerException("inventory must not be null");
        }else{
            return inventory;
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setDmgA(int dmgA) {
        this.dmgA = dmgA;
    }
    public void setDefA(int defA) {
        this.defA = defA;
    }
    public void setDmgP(int dmgP) {
        this.dmgP = dmgP;
    }
    public void setDefP(int defP) {
        this.defP = defP;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setStringList(ArrayList<Object> inventory) {
        if (inventory == null) {
            throw new NullPointerException("inventory must not be null");
        }
        this.inventory = inventory;
    }

    public void damageTaken(int dmg) {
        setHp(getHp()-dmg);
    }

    public void HealTaken(int heal) {
        if((getHp()+heal)>20){
            setHp(20);
        }else{
            setHp(getHp()+heal); 
        }
    }
}