package main.java;

import java.io.Serializable;

public enum Armors implements Equipement, Serializable {
    MAILLE("Cotte de maille", 5, 0),
    TOGE("Toge", 0, 5),
    BRIGANDINE("Brigandine", 3, 0),
    CUIRASSE("Cuirasse", 7, 0),
    ROBE("Robe Enchanté",0,7),
    BAGUEPROTECTION("Bague de protection",0,8),
    ECU("Ecu",8,0),
    PAVOIS("Pavois",7,0),
    RONDACHE("Rondache",6,0);

    
    private String name;
    private int ResAD;
    private int ResAP; 

    Armors(String name, int ResPhy, int ResMag) {
        this.name = name;
        this.ResAD = ResPhy;
        this.ResAP = ResMag;
    }

    public String getName() {
        return name;
    }

    public int getResPhy() {
        return ResAD;
    }

    public int getResMag() {
        return ResAP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResPhy(int ResPhy) {
        this.ResAD = ResPhy;
    }

    public void setResMag(int ResMag) {
        this.ResAP = ResMag;
    } 
}
