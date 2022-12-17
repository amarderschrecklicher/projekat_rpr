package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public class PropertyDaoSQLImpl implements PropertyDAO{
    @Override
    public Property getById(int id) {
        return null;
    }

    @Override
    public Property add(Property item) {
        return null;
    }

    @Override
    public Property update(Property item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Property> getall() {
        return null;
    }

    @Override
    public boolean hasAC(Property property) {
        return false;
    }

    @Override
    public double pricePerNight(Property property) {
        return 0;
    }

    @Override
    public boolean isAvailable(Property property, Date d) {
        return false;
    }
}
