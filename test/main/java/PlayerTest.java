package main.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.jupiter.api.BeforeEach;

public class PlayerTest {
    


    Player p1, p2;

    @BeforeEach
    public void initialize() {
        p1 = new Player("Player1", 100, Classes.PALADIN);
    }

    @Test
    public void testGold() {


        assertEquals(0, p1.getGold());
        p1.addGold(10);
        assertEquals(10, p1.getGold());

    }


}
