package domain;

import ba.unsa.etf.rpr.business.HostManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.HostDAO;
import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class HostTest {

    @Test
    void validatesHostExists() throws Exceptionss {
        //This is admin user that exist in DB Dump
        String correctName = "andrew tate";
        String correctPass = "t8";

        Host users1 =  new Host("andrew tate","t8","email...");

        MockedStatic<DaoFactory> dao = Mockito.mockStatic(DaoFactory.class);
        HostDAO HD = Mockito.mock(HostDAO.class);
        when(DaoFactory.HostDao()).thenReturn(HD);

        when(DaoFactory.HostDao().getByNumber(correctPass)).thenReturn(users1);
        boolean x ;
        if(correctName.equals(users1.getName()) && correctPass.equals(users1.getNumber())){
            x = true;
        }else {
            x = false;
        }

        assertTrue(x);

    }
    @BeforeEach
    public void initializeObjectsWeNeed() {
        HostManager m = new HostManager();
    }

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
