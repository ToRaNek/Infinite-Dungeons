package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    


    Player p1, p2;

    @BeforeEach
    public void initialize() {
        p1 = new Player("Player1", 100, Classes.PALADIN);
    }

    @Test
    public void testGold() {


        assertEquals(15, p1.getGold());
        p1.addGold(10);
        assertEquals(25, p1.getGold());
        p1.addGold(0);
        assertEquals(25, p1.getGold());


    }

    @Test
    public void testClass()  {

        assertEquals(Classes.PALADIN.getPenMag(), p1.getPenP());
        assertEquals(Classes.PALADIN.getPenPhy(), p1.getPenA());

        assertEquals(Classes.PALADIN.getSpeed(), p1.getSpeed());

        
    
    }


}
