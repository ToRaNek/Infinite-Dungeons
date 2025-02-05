package fr.univlille.iut.infinited.entity;

import fr.univlille.iut.infinited.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * fr.univlille.iut.infinited.entity.Mob
 */
public class Mob extends Entity{
   
    private MobType type;
 
    public Mob(String name, MobType type, int hpMax, int dmgA, int dmgP, int defA, int defP,int penA, int penP, float speed, int gold) {
        super(name, hpMax, dmgA, dmgP, penA, penP, defA, defP, speed, gold);
        this.type = type;
    }

    public MobType getType() {
        return type;
    }

    public static Mob randomNewMob(int difficulty){
        Random rdm = new Random();
        MobType[] listMob = MobType.values();
        int longueur = listMob.length;
        int num = rdm.nextInt(longueur);
        int hp = 80 + (int)((20*rdm.nextInt(101)/100) * (0.1*difficulty));
        int defA =  (int)((0*rdm.nextInt(101)/100 + 10) *(0.03*difficulty));
        int defP =  (int)((0*rdm.nextInt(101)/100 + 10) *(0.03*difficulty));
        int dmgA;
        int dmgP;
        int penA;
        int penP;
        if(rdm.nextInt(2)==0){
            dmgA = (int)((5*rdm.nextInt(101)/100 + 5) *(0.08*difficulty));
            dmgP = 0;
            penA = (int)((3*rdm.nextInt(101)/100 + 1) *(0.01*difficulty));
            penP = 0;
            if(dmgA <5){dmgA = 5;}
        }else{
            dmgA = 0;
            dmgP = (int)((5*rdm.nextInt(101)/100 + 5) *(0.08*difficulty));
            penA = 0;
            penP = (int)((3*rdm.nextInt(101)/100 + 1) *(0.01*difficulty));
            if(dmgP <5){dmgP = 5;}
        }
        int gold =  (int)((10*rdm.nextInt(101)/100 + 5) *0.25*difficulty);
        if(hp <25){hp = 25;}
        Mob newMob = new Mob(listMob[num].toString(), listMob[num] , hp, dmgA, dmgP,penA, penP, defA, defP, 5, gold);

        return newMob;
    }
    @Override
    public void monsterToImage() throws IOException{
        String path = System.getProperty("user.dir") + File.separator + "res" + File.separator + "mobs" + File.separator + "ansi" +  File.separator;
        Utils.printAnsi(new File(path + this.type.getPath()));
    }


}