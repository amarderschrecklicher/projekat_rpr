package domain;

import ba.unsa.etf.rpr.business.PropertyManager;
import ba.unsa.etf.rpr.dao.PropertyDAO;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.exceptions.Exceptionss;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
public class PropertyTest {
    private PropertyManager manager;

    @Mock
    private PropertyDAO dao;
    public Property property= new Property("Garden","House",12,
    3,1,"Miami",true,250);

    /**
     * tests method add
     * @throws Exceptionss in case of an error
     */
    @Test
    public void addTest() throws Exceptionss {
        dao.add(property);
        verify(dao).add(property);
    }

}
