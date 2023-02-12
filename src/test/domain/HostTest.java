package domain;

import ba.unsa.etf.rpr.domain.Host;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    /**
     * tests constructor
     */
    @Test
    public void testConstructor() {
        Host user = new Host("Niko Nikic", "007", "nnikic1@etf.unsa.ba");
        assertEquals("Niko Nikic", user.getName());
        assertEquals("007", user.getNumber());
        assertEquals("nnikic1@etf.unsa.ba", user.getEmail());

    }
    /**
     * tests toString method
     */
    @Test
    public void testToString(){
        Host user = new Host("Niko Nikic", "007", "nnikic1@etf.unsa.ba");
        String output =  "Host{" +
                "id=-1"  +
                ", name='Niko Nikic"  + '\'' +
                ", number='007\"" + '\'' +
                ", email='nnikic1@etf.unsa.ba"  + '\'' +
                '}';
        assertEquals(output, user.toString());
    }

    /**
     * tests Equals method
     */
    @Test
    public void testEquals(){
        Host user1 = new Host("Niko Nikic", "007", "nnikic1@etf.unsa.ba");
        Host user2 = new Host("Niko Nikic", "007", "nnikic1@etf.unsa.ba");
        assertTrue(user1.equals(user2));
    }


}
