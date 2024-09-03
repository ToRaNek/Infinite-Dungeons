package src.main.java;
/**
 * Mob
 */
public class Mob {
    private String name;
    private int hp;
    private int hpMax;
    private int dmg;
    private int def;
    private int speed;
    private int ad;
    private int ap;
    
    public Mob(String name, int hpMax, int def, int speed, int dmgA, int dmgP) {
        this.name = name;
        this.hp = hpMax;
        this.hpMax = hpMax;
        this.def = def;
        this.speed = speed;
        this.dmgA = dmgA;
        this.dmgP = dmgP;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getDmg() {
        return dmg;
    }
    public int getDef() {
        return def;
    }
    public int getSpeed(){
        return speed;
    }
    
    public int getHpMax() {
        return hpMax;
    }

    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
    }

    public void healTaken(int nbrHp){
        this.hp += nbrHp;
        if(hp>hpMax){hp=hpMax;}
    }
    public void damageTaken(int dmgTaken){
        hp -= (dmgTaken-def);
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }


}