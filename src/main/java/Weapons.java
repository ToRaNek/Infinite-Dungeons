import java.io.Serializable;

    public enum Weapons implements Equipement, Serializable {
        EPEE("Epée", 10, 0,0,0),
        DAGUE("Dague", 5, 0,0,0),
        BAGUETTE("Baguette", 0, 5,0,0),
        GRIMOIRE("Grimoire", 0, 10,0,0),
        MASSUE("Massue", 7, 0,0,0),
        SCEPTRE("Sceptre", 0, 7,0,0),
        ARBALET("Arbalète", 6, 0,0,0),
        ARC("Arc", 8,0,0,0),
        EXCALIBUR ("Excalibur", 6 ,6,0,0),
        LANCE("Lance", 9, 0,0,0);

        private String name;
        private int AD;
        private int AP;
        private int penA;
        private int penP;
       
        Weapons(String name, int degatPhy, int degatMag, int penA, int penP) {
            this.name = name;
            this.AD = degatPhy;
            this.AP = degatMag;
            this.penA = penA;
            this.penP = penP;
        }

        public int getPenA() {
            return penA;
        }
        public int getPenP() {
            return penP;
        }
        public String toString(){
            return name;
        }

        public String getName() {
            return name;
        }

        public int getAD() {
            return (int) (AD*(0.08*Main.difficulty));
        }

        public int getAP() {
            return (int) (AP*(0.08*Main.difficulty));
        }
}