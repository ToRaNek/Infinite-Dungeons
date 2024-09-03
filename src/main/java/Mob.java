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
    
    public Mob(String name, int hp, int dmg, int def, int speed, int ad, int ap) {
        this.name = name;
        this.hp = hp;
        this.hpMax = hp;
        this.dmg = dmg;
        this.def = def;
        this.speed = speed;
        this.ad = ad;
        this.ap = ap;
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


}