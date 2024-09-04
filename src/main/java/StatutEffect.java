package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatutEffect<T extends Entity> {
    

    private T entity;
    private Map<Statut, Integer> effectsStatut;

    public StatutEffect(T entity) {
        this.entity = entity;
        this.effectsStatut = new HashMap<Statut, Integer>();
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



}
