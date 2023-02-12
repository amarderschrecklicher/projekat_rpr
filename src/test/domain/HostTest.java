package domain;

import ba.unsa.etf.rpr.domain.Host;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HostTest {

    /**
     * tests setters and getters in User
     */
    @Test
    public void testSettersAndGetters() {
        Host host = new Host();
        host.setName("Ibrahim Ibrahimovic");
        host.setNumber("061 222 333");
        host.setEmail("ibb@etf.unsa.ba");


        assertEquals("Ibrahim Ibrahimovic", host.getName());
        assertEquals("061 222 333", host.getNumber());
        assertEquals("ibb@etf.unsa.ba", host.getEmail());

    }
}