package fr.univlille.iut.infinited.entity;

import fr.univlille.iut.infinited.equipement.*;
import fr.univlille.iut.infinited.statut.StatutEffect;

import java.util.ArrayList;


public class Player extends Entity{

    private ArrayList<Equipement> inventory;
    private Weapons armeactuelle;
    private Armors armureactuelle;
    private Scepter scepter;
    private Potions potionslastuse;
    private Classes classe;

    public Player(String name, int hpMax, Classes classe) {
        super(name, hpMax, classe.getDegatPhy(), classe.getDegatMag(), classe.getResPhy(), classe.getResMag(), classe.getPenPhy(), classe.getPenMag(), classe.getSpeed(), classe.getGold());
        this.inventory = new ArrayList<Equipement>();
        this.inventory.add(Weapons.DAGUE);
        this.inventory.add(Weapons.ARC);
        this.armeactuelle = Weapons.DAGUE;
        this.inventory.add(Armors.BRIGANDINE);
        this.inventory.add(Armors.ECU);
        this.armureactuelle = Armors.BRIGANDINE;
        this.inventory.add(Potions.SOINPV);
        this.inventory.add(Potions.FORCEPHYSIQUE);
        this.inventory.add(Scepter.SCEPTER_POISON);
          
    }

    public Classes getClasse() {
        return classe;
    }
    // ((city.getName() == null) ? "N/A" : city.getName());
    public int getDmgA() {
        return super.getDmgA() + ((armeactuelle == null) ? scepter.getAD() : armeactuelle.getAD());
    }

    public int getDefA() {
        return super.getDefA() +  armureactuelle.getResPhy();
    }
    public int getDmgP() {
        return super.getDmgP() + ((armeactuelle == null) ? scepter.getAP() : armeactuelle.getAP());
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
    public Potions getPotion() {
        return potionslastuse;
    }
    @Override
    public int getPenA() {
        return super.getPenA() + ((armeactuelle == null) ? scepter.getPenA() : armeactuelle.getPenA());
    }
    @Override
    public int getPenP() {
        return super.getPenP() + ((armeactuelle == null) ? scepter.getPenP() : armeactuelle.getPenP());
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
        this.scepter = null;
    }
    public void setArmureActuelle(Armors newArmure) {
        this.armureactuelle = newArmure;
    }

    public void setScepter(Scepter scepter) {
        this.scepter = scepter;
        this.armeactuelle = null;
    }

    public Scepter getScepter() {
        return this.scepter;
    }

    public void setPotionsLastUse(Potions lastPotions) {
        this.potionslastuse = lastPotions;
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

    public void usePotion(StatutEffect<Player> effetPlayer){
        if(this.potionslastuse!= null){
            switch (this.potionslastuse) {
                case SOINPV:
                    effetPlayer.caut(this.potionslastuse.getStatsboost());
                    break;
                case FORCEPHYSIQUE:
                    this.setDmgA(this.getDmgA() + this.potionslastuse.getStatsboost());
                    break;
                case FORCEMAGIQUE:
                    this.setDmgP(this.getDmgP() + this.potionslastuse.getStatsboost());
                    break;
                case RESMAGIQUE:
                    this.setDefP(this.getDefP() + this.potionslastuse.getStatsboost());
                    break;
                case RESPHYSIQUE:
                    this.setDefA(this.getDefA() + this.potionslastuse.getStatsboost());
                    break;
                case VITESSE:
                    this.setSpeed(this.getSpeed() + this.potionslastuse.getStatsboost());
                    break;
                default:
                    System.out.println("Aucune potions n'a été bu");
            }
            this.inventory.remove(this.potionslastuse);
        }
    }

}