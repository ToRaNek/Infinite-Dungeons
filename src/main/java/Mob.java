package src.main.java;
/**
 * Mob
 */
public class Mob {
    private String name;
    private int hp;
    private int dmg;
    private int def;
    
    public Mob(String name, int hp, int dmg, int def) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.def = def;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
    public void setDef(int def) {
        this.def = def;
    }
}