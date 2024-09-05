public enum MobType {
    LICH("LICH-art.utf.ans"),
    SKELETON("SKELETON-art.utf.ans"),
    SLIME("SLIME-art.utf.ans"),
    WOLF("WOLF.ans"),
    ZOMBIE("ZOMBIE-art.utf.ans");

    
    
    private String path;
    private MobType(String path) {
        this.path = path;
    } 


    public String getPath(){
        return this.path;
    }
}
