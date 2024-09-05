package fr.univlille.iut.infinited.equipement;

import fr.univlille.iut.infinited.InfiniteDungeons;
import fr.univlille.iut.infinited.statut.Statut;

import java.io.Serializable;

public enum Scepter implements Equipement, Serializable{


    SCEPTER_POISON("Sceptre de Poison", 5, 10,0,10, Statut.POISON),
    SCEPTER_FIRE("Sceptre de feu", 5, 10,0,10, Statut.BURN),
    SCEPTER_DRAIN("Sceptre de Drain", 5, 10,0,10, Statut.DRAIN),
    SCEPTER_CAUT("Sceptre de cautérisation", 5, 10,0,10, Statut.CAUT),
    SCEPTER_RESAD("Sceptre de resistance physique", 5, 10,0,10, Statut.RESAD),
    SCEPTER_RESAP("Sceptre de resistance magique", 5, 10,0,10, Statut.RESAP),
    SCEPTER_RAGE("Sceptre de furie", 5, 10,0,10, Statut.RAGE),
    SCEPTER_SANCTUARY("Sceptre de sanctuaire", 5, 10,0,10, Statut.SANCTUARY);

    private String name;
    private int AD;
    private int AP;
    private int penA;
    private int penP;
    private Statut statut;

    Scepter(String name, int degatPhy, int degatMag, int penA, int penP, Statut statut) {
        this.name = name;
        this.AD = degatPhy;
        this.AP = degatMag;
        this.penA = penA;
        this.penP = penP;
        this.statut = statut;
    }

    @Override
    public String getName() {
        return this.name;
    }


    public int getPenA() {
        return penA;
    }
    public int getPenP() {
        return penP;
    }
    public String toString(){
        return name;
    }


    public int getAD() {
        return (int) (AD*(0.08* InfiniteDungeons.difficulty));
    }

    public int getAP() {
        return (int) (AP*(0.08*InfiniteDungeons.difficulty));
    }

    public Statut getStatut() {
        return this.statut;
    }




    
}
