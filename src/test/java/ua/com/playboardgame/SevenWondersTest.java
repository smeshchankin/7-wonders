package ua.com.playboardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SevenWondersTest {
    @Test void appHasAGreeting() {
        SevenWonders game = new SevenWonders();
        assertNotNull(game.init(), "app should have an init method");
    }
}
