package main.java;
package main.java;

import java.util.ArrayList;

public class Player extends Entity{
    public Player(String name, int hpMax, int dmgA, int dmgP, int defA, int defP, float speed, int gold) {
        super(name, hpMax, dmgA, dmgP, defA, defP, speed, gold);
        this.inventory = new ArrayList<Equipement>();
        this.inventory.add(Weapons.DAGUE);
        this.armeactuelle = Weapons.DAGUE;
        this.armureactuelle = Armors.BRIGANDINE;  
    }

    private ArrayList<Equipement> inventory;
    private Weapons armeactuelle;
    private Armors armureactuelle;
    
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

    public void setArmeActuelle(Weapons NewArme) {
        this.armeactuelle = NewArme;
    }
    public void setArmeActuelle(Armors NewArmure) {
        this.armureactuelle = NewArmure;
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