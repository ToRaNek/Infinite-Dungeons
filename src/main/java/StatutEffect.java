package main.java;

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

    public StatutEffect(T entity) {
        this.entity = entity;
        this.effectsStatut = new HashMap<Statut, Integer>();
        this.listStatut = new ArrayList<>();
        this.statChanges = new int[Statut.values().length];
        for (int i = 0; i < statChanges.length; i++){
            statChanges[i] = 0;
            listStatut.add(Statut.values()[i]);
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


    public void runEffect(Statut statut){
        // fonction qui servira à activer les effets
    }

    private void poison(Entity caster){
        int changement = statChanges[listStatut.indexOf(Statut.POISON)];
        if(changement != 0){
            this.entity.setDefA(entity.getDefA() + changement);
            statChanges[listStatut.indexOf(Statut.POISON)] = 0;
        }else{
            this.effectsStatut.put(Statut.POISON, Statut.POISON.getDuration());
        }
        changement = (int)0.05*caster.getDmgP();
        statChanges[listStatut.indexOf(Statut.POISON)] = changement;
        int dmg = (int)0.1*caster.getDmgP();
        this.entity.damageTaken(0, dmg, caster);
    }



}
