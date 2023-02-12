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
import static org.mockito.Mockito.verify;
public class PropertyTest {
    private PropertyManager manager;

    @Mock
    private PropertyDAO dao;
    public Property property= new Property("Garden","House",12,
    3,1,"Miami",true,250);


    /**
     * initializes fields annotated with Mockito annotations
     * initializes roomManager
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
        Property property1 = new Property("Garden","House",12,
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

}
