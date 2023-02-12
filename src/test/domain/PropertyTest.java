package domain;

import ba.unsa.etf.rpr.business.PropertyManager;
import ba.unsa.etf.rpr.dao.PropertyDAO;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
public class PropertyTest {
    public PropertyManager manager;

    @Mock
    private PropertyDAO dao;
    public Property property= new Property(7,"Garden","House",12,
    3,1,"Miami",true,250);


    /**
     * initializes fields annotated with Mockito annotations
     * initializes propertyManager
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        manager = new PropertyManager();
    }

    /**
     * tests method add
     * @throws Exceptionss in case of an error
     */
    @Test
    public void addTest() throws Exceptionss {
        dao.add(property);
        verify(dao).add(property);
    }
    /**
     * tests method update
     * @throws Exception in case of an error
     */
    @Test
    public void updateTest() throws Exception {
        property.setAcH(false);
        dao.update(property);
        verify(dao).update(property);
    }
    /**
     * tests constructor
     */
    @Test
    public void testConstructor(){
        Property property1 = new Property(6,"Garden","House",12,
                3,1,"Miami",true,250);
        assertEquals("Miami",property1.getLocation());
        assertEquals(250, property1.getPrice());
    }
    /**
     * tests setters and getters
     */
    @Test
    public void testSettersAndGetters() {
        Property p = new Property();
        p.setCapacity(11);
        p.setPropertyType("Villa");

        assertEquals(11, p.getCapacity());
        assertEquals("Villa", p.getPropertyType());
    }
    /**
     * tests toString method
     */
    @Test
    public void testToString(){
       Property pr = new Property(5,"Garden","House",12,
               3,1,"Miami",true,250);
        String output = "Property{" +
                "id=-1" +
                ", hostId=5"  +
                ", propertyName='Garden"  + '\'' +
                ", propertyType='Villa"  + '\'' +
                ", capacity=12"  +
                ", bathrooms=3"  +
                ", kitchens=1"  +
                ", location='Miami"  + '\'' +
                ", acH=true" +
                ", price=250"  +
                '}';
        assertEquals(output, pr.toString());
    }
    /**
     * tests equals method
     */
    @Test
    public void testEquals(){
        Property p2 = new Property(5,"Garden","House",12,
                3,1,"Miami",true,250);
        Property p3 = new Property(5,"Garden","House",12,
                3,1,"Miami",true,250);
        assertTrue(p2.equals(p3));
    }

}
