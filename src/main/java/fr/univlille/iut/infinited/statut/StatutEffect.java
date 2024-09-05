package fr.univlille.iut.infinited.statut;

import fr.univlille.iut.infinited.entity.Entity;
import fr.univlille.iut.infinited.entity.Mob;
import fr.univlille.iut.infinited.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatutEffect<T extends Entity> implements Serializable{
    

    private T entity;
    private Map<Statut, Integer> effectsStatut;
    private int[] statChanges;
    private ArrayList<Statut> listStatut;


    public int getDurationEffect(Statut statut){
        return this.effectsStatut.get(statut);
    }

    public StatutEffect(T entity) {
        this.entity = entity;
        this.effectsStatut = new HashMap<Statut, Integer>();
        this.listStatut = new ArrayList<>();
        this.statChanges = new int[Statut.values().length];
        for (int i = 0; i < statChanges.length; i++){
            statChanges[i] = 0;
            listStatut.add(Statut.values()[i]);
            effectsStatut.put(Statut.values()[i], 0);
        }
        
    }

    public int getEffectDuration(Statut statut) {
        return this.effectsStatut.get(statut);
    }

    public void resetEffectDuration(Statut statut){
        this.effectsStatut.put(statut, statut.getDuration());
    }

    public void downEffectDurationAllTurnEffect(){
        List<Statut> listStatut = new ArrayList<>();
        listStatut.addAll(this.effectsStatut.keySet());
        for (Statut statuts : listStatut) {
            if(statuts.getIsTurn()){
                int duration = this.effectsStatut.get(statuts);
                if(duration>0){this.effectsStatut.put(statuts, duration-1);}
            }
        }
    }

    public void downEffectDuration(Statut statut){
        int duration = this.effectsStatut.get(statut);
        if(duration>0){this.effectsStatut.put(statut, duration-1);}
    }


    public void runEffect(Entity monster){
            if(effectsStatut.get(Statut.POISON) > 0 ){
                this.poison(monster);
            }if(effectsStatut.get(Statut.BURN) > 0 ){
                this.burn(monster);
            }if(effectsStatut.get(Statut.DRAIN) > 0 ){
                this.drain(monster);
            }
            if(effectsStatut.get(Statut.RESAD) > 0 ){
                this.resAD();;
            }
            if(effectsStatut.get(Statut.RESAP) > 0 ){
                this.resAP();;
            }
            if(effectsStatut.get(Statut.RAGE) > 0 ){
                this.rage();;
            }if(effectsStatut.get(Statut.SANCTUARY) > 0 ){
                this.sanctuary();
            }
            downEffectDurationAllTurnEffect();
    }



    public void applyEffect(Statut statut){
        this.effectsStatut.put(statut, statut.getDuration());
    }

    private void poison(Entity caster){
        int changement = statChanges[listStatut.indexOf(Statut.POISON)];
        if(changement != 0){
            this.entity.setDefA(entity.getDefA() + changement);
            statChanges[listStatut.indexOf(Statut.POISON)] = 0;
        }
        changement = (int)0.05*caster.getDmgP();
        statChanges[listStatut.indexOf(Statut.POISON)] = changement;
        int dmg = (int)(0.1*caster.getDmgP());
        this.entity.damageTaken(0, dmg, caster);
        System.out.println("Vous avez fait :" + dmg + " de poison");
    }

    private void burn(Entity caster){
        int dmg = (int)(0.5*caster.getDmgP());
        this.entity.damageTaken(0, dmg, caster);
    }

    private void drain(Entity caster){
        int dmg = (int)(0.5*caster.getDmgP());
        this.entity.damageTaken(0, dmg, caster);
        caster.healTaken(dmg);
    }

    public void caut(int healTaken){
        if(this.effectsStatut.get(Statut.CAUT) > 0){
            this.entity.healTaken((int)healTaken/2);
        }else{
            this.entity.healTaken(healTaken);
        }
    }

    private void resAD(){
        int changement = statChanges[listStatut.indexOf(Statut.RESAD)];
        if(changement != 0){
            this.entity.setDefA(entity.getDefA() - changement);
            statChanges[listStatut.indexOf(Statut.RESAD)] = 0;
        }
        changement = (int)(0.1*entity.getDefA());
        statChanges[listStatut.indexOf(Statut.RESAD)] = changement;
        this.entity.setDefA(this.entity.getDefA() + changement);
    }

    private void resAP(){
        int changement = statChanges[listStatut.indexOf(Statut.RESAP)];
        if(changement != 0){
            this.entity.setDefP(entity.getDefP() - changement);
            statChanges[listStatut.indexOf(Statut.RESAP)] = 0;
        }
        changement = (int)(0.1*entity.getDefP());
        statChanges[listStatut.indexOf(Statut.RESAP)] = changement;
        this.entity.setDefP(this.entity.getDefP() + changement);
    }

    private void rage(){
        int changement = statChanges[listStatut.indexOf(Statut.RAGE)];
        if(changement != 0){
            this.entity.setDmgA(entity.getDmgA() - changement);
            statChanges[listStatut.indexOf(Statut.RAGE)] = 0;
        }
        changement = (int)(0.1*entity.getDmgA());
        statChanges[listStatut.indexOf(Statut.RAGE)] = changement;
        this.entity.setDmgA(this.entity.getDmgA() + changement);
    }

    private void sanctuary(){
        int heal = (int)(this.entity.getDmgP()*1.5);
        this.caut(heal);
    }
    


}
