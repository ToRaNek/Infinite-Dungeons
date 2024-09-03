package src.main.java;

public enum Potions implements Equipement {
    SOINPV("Potions de soin",15/*,0*/);

    private String name;
    private int pv;
    //private int pm;

    Potions(String name, int pv/*, int pm*/) {
        this.name = name;
        this.pv = pv;
        //this.pm = pm;
    }

    public String getName() {
        return name;
    }

    public int getPv() {
        return pv;
    }
    
    /*public int getPm() {
        return pm;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    /*public void setPm(int pm) {
        this.pm = pm;
    }*/
}
