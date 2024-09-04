package main.java;

public enum Statut {
    POISON("Poison", 3, true, false,true, "Empoisonne la cible lui faisant des dégâts (10% de l'AttM du lanceur) pendant 3 tours et réduit ses résistance (5% de l'AttM du lanceur)"),
    BURN("Brulure",5,true, false,true, "Brule la cible en lui infligeant des dégâts pendant 5 tours (25% de l'AttM du lanceur)"),
    DRAIN("Drain", 3, true,false,true, "Fait des dégats à la cible pendant 3 tours (10% de l'AttM du lanceur) et régénère 100% des dégâts au lanceur"),
    CAUT("Cautérisé", 3, true, false,true, "Réduit de 50% les soins de la cible pendant 3 tours"),
    RESAD("Boost résistance physique", 3, true, true,true, "Boost la résitance physique de 10% de la cible"),
    RESAP("Boost résistance magique", 3, true, true,true, "Boost la résitance magique de 10% de la cible"),
    RAGE("Furie", 3, true, true,true, "La cible rentre en furie et augmente son AttP de 10%"),
    SANCTUARY("Sanctuaire", 2, true, true,true, "La cible ne peut plus attaquer mais ce soigne de 150% de son attM"),
    SWIFT("Rapidité", 1, true, true, false,"La cible à 50% de chance d'éviter la prochaine attaque"),
    CRITIC("Critique", 1, true, true,false, "La cible à 50% de chance d'avoir une attaque faisant 150% de dégats la prochaine fois");

        private String name;
        private int duration;
        private boolean vision;
        private boolean positive;
        private String desc;
        private boolean isturn;

    Statut(String name, int duration, boolean vision, boolean positive, boolean isturn, String desc){
        this.name = name;
        this.duration = duration;
        this.vision = vision;
        this.positive = positive;
        this.desc = desc;
    }

    public int getDuration() {
        return duration;
    }
    public String getDesc() {
        return desc;
    }
    public String getName() {
        return name;
    }
    public boolean getVision(){
        return this.vision;
    }
    public boolean getPositive(){
        return this.positive;
    }
    public boolean getIsTurn(){
        return this.isturn;
    }
    
}
