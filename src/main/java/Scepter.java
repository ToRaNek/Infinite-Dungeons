import java.io.Serializable; 

public enum Scepter implements Equipement, Serializable{


    SCEPTER_POISON("Sceptre de Poison", 5, 0,0,0, Statut.POISON),
    SCEPTER_FIRE("Sceptre de feu", 5,0 ,0 ,0, Statut.BURN);

    private String name;
    private int AD;
    private int AP;
    private int penA;
    private int penP;
    private Statut statut;

    Scepter(String name, int degatPhy, int degatMag, int penA, int penP, Statut statut) {
        this.name = name;
        this.AD = degatPhy;
        this.AP = degatMag;
        this.penA = penA;
        this.penP = penP;
        this.statut = statut;
    }

    @Override
    public String getName() {
        return this.name;
    }


    public Statut getStatut() {
        return this.statut;
    }




    
}
