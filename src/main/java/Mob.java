package src.main.java;
/**
 * Mob
 */
public class Mob {
    private String name;
    private int hp;
    private int hpMax;
    private int def;
    private int speed;
    private int dmgA;
    private int dmgP;
    private MobType type;
    
    public Mob(String name, MobType type, int hpMax, int def, int speed, int dmgA, int dmgP) {
        this.name = name;
        this.type = type;
        this.hp = hpMax;
        this.hpMax = hpMax;
        this.def = def;
        this.speed = speed;
        this.dmgA = dmgA;
        this.dmgP = dmgP;
    }

    public MobType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
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

    public int getDmgA() {
        return dmgA;
    }

    public int getDmgP() {
        return dmgP;
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

    public void setDmgA(int ad) {
        this.dmgA = ad;
    }

    public void setDmgP(int ap) {
        this.dmgP = ap;
    }


}