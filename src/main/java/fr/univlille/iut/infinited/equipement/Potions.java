package fr.univlille.iut.infinited.equipement;

public enum Potions implements Equipement {
    SOINPV("fr.univlille.iut.infinited.equipement.Potions de soin",15/*heal*/),
    FORCEPHYSIQUE("fr.univlille.iut.infinited.equipement.Potions de Force",10/*degatsAD*/),
    FORCEMAGIQUE("fr.univlille.iut.infinited.equipement.Potions de Sagesse",10/*degatsAP*/),
    RESMAGIQUE("fr.univlille.iut.infinited.equipement.Potions de Résistance Magique",5/*ResAP*/),
    RESPHYSIQUE("fr.univlille.iut.infinited.equipement.Potions de Résistance Physique",5/*ResAD*/),
    VITESSE("fr.univlille.iut.infinited.equipement.Potions de Vitesse",5);

    private String name;
    private int statsboost;
    //private int pm;

    Potions(String name, int statsboost/*, int pm*/) {
        this.name = name;
        this.statsboost = statsboost;
        //this.pm = pm;
    }
    
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public int getStatsboost() {
        return statsboost;
    }
    
    /*public int getPm() {
        return pm;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setPv(int statsboost) {
        this.statsboost = statsboost;
    }

    /*public void setPm(int pm) {
        this.pm = pm;
    }*/
}
