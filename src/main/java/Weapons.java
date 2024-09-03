package main.java;
    
    public enum Weapons implements Equipement {
        EPEE("Epée", 10, 0),
        DAGUE("Dague", 5, 5),
        BAGUETTE("Baguette", 0, 5),
        GRIMOIRE("Grimoire", 0, 10),
        MASSUE("Massue", 7, 0),
        SCEPTRE("Sceptre", 0, 7),
        ARBALET("Arbalète", 6, 0),
        ARC("Arc", 8,0),
        EXCALIBUR ("Excalibur", 6 ,6),
        LANCE("Lance", 9, 0);

        private String name;
        private int AD;
        private int AP; 

        Weapons(String name, int degatPhy, int degatMag) {
            this.name = name;
            this.AD = degatPhy;
            this.AP = degatMag;
        }

        public String getName() {
            return name;
        }

        public int getDegatPhy() {
            return AD;
        }

        public int getDegatMag() {
            return AP;
        }
}