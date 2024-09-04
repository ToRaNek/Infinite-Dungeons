package main.java;

public enum Potions implements Equipement {
    SOINPV("Potions de soin",15/*heal*/),
    FORCEPHYSIQUE("Potions de Force",10/*degatsAD*/),
    FORCEMAGIQUE("Potions de Sagesse",10/*degatsAP*/),
    RESMAGIQUE("Potions de Résistance Magique",5/*ResAP*/),
    RESPHYSIQUE("Potions de Résistance Physique",5/*ResAD*/);

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
