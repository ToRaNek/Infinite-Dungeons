package main.java;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class UtilsTest {
    
    File file;
    String path =  System.getProperty("user.dir") + File.separator + "res" + File.separator + "test" +  File.separator + "test.utf.ans"  + File.separator;

    public static void main(String[] args) throws IOException{
        File f = new  File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "mobs" + File.separator + "ansi" +  File.separator + "LICH-art.utf.ans"  + File.separator);
        Utils.printAnsi(f);
    }


    Player player;
    Combat combat;
    
    @BeforeEach
    public void initialize() {
        player = new Player("Player1", 100, Classes.BERSERKER);
        combat = new Combat(Mob.randomNewMob(5), player);
    }


    @Test
    public void testSaveGame() {
        Utils.saveGame(combat);
    }

    @Test
    public void testLoadGames() {
        List<Combat> combats = Utils.loadGames();
        System.out.println(combats.size());
        Combat c = combats.get(combats.size()-1);
        System.out.println(c.getPlayer().getName());
        System.out.println(c.getMonstre().getName());

    }
    
}
