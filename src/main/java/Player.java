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
    private ArrayList<Equipement> inventory;
    private Weapons armeactuelle;
    private Armors armureactuelle;
    
    public Player(String name, int hp, int dmgA, int defA, int dmgP, int defP, float speed) {
        this.inventory = new ArrayList<Equipement>();
        this.inventory.add(Weapons.DAGUE);
        this.armeactuelle = Weapons.DAGUE;
        this.armureactuelle = Armors.BRIGANDINE;  
        this.name = name;
        this.hp = MAXHP;
        this.dmgA = dmgA; /*inventory.stream().filter(equipement -> equipement instanceof Weapons).map(equipement -> (Weapons) equipement).toList().get(0).getAD();*/
        this.defA = defA;
        this.dmgP = dmgP;
        this.defP = defP;
        this.speed = speed;
        
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getDmgA() {
        return dmgA + armeactuelle.getAD();
    }
    public int getDefA() {
        return defA + armureactuelle.getResPhy();
    }
    public int getDmgP() {
        return dmgP + armeactuelle.getAP();
    }
    public int getDefP() {
        return defP + armureactuelle.getResMag();
    }
    public float getSpeed() {
        return speed;
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

    public void damageTaken(int dmg) {
        setHp(getHp()-dmg);
    }

    public void HealTaken(int heal) {
        if((getHp()+heal)>=MAXHP){
            setHp(20);
        }else{
            setHp(getHp()+heal); 
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

}