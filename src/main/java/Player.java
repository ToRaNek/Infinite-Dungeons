package main.java;

import java.util.ArrayList;

public class Player extends Entity{
    public Player(String name, int hpMax, int dmgA, int dmgP, int defA, int defP, int speed, int gold) {
        super(name, hpMax, dmgA, dmgP, defA, defP, speed, gold);
        this.inventory = new ArrayList<Equipement>();
        this.inventory.add(Weapons.DAGUE);
        this.inventory.add(Weapons.ARC);
        this.armeactuelle = Weapons.DAGUE;
        this.inventory.add(Armors.BRIGANDINE);
        this.inventory.add(Armors.ECU);
        this.armureactuelle = Armors.BRIGANDINE;  
    }

    private ArrayList<Equipement> inventory;
    private Weapons armeactuelle;
    private Armors armureactuelle;
    
    public int getDmgA() {
        return super.getDmgA() + armeactuelle.getAD();
    }
    public int getDefA() {
        return super.getDefA() + armureactuelle.getResPhy();
    }
    public int getDmgP() {
        return super.getDmgP() + armeactuelle.getAP();
    }
    public int getDefP() {
        return super.getDefP() + armureactuelle.getResMag();
    }
    public Armors getArmure() {
        return armureactuelle;
    }
    public Weapons getArme() {
        return armeactuelle;
    }
    public ArrayList<Equipement> getInventory() {
        if (inventory == null) {
            throw new NullPointerException("inventory must not be null");
        }else{
            return inventory;
        }
    }

    public void setArmeActuelle(Weapons newArme) {
        this.armeactuelle = newArme;
    }
    public void setArmureActuelle(Armors newArmure) {
        this.armureactuelle = newArmure;
    }

    public void setInventory(ArrayList<Equipement> inventory) {
        if (inventory == null) {
            throw new NullPointerException("inventory must not be null");
        }
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}