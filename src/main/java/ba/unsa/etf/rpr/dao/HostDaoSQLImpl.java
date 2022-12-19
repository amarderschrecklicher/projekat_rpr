package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class HostDaoSQLImpl extends AbstractDao<Host> implements HostDAO {
    public HostDaoSQLImpl() {
        super("Host");
    }

    @Override
    public Host getById(int id) {
        return null;
    }

    @Override
    public Host add(Host item) {
        return null;
    }

    @Override
    public Host update(Host item) {
        return null;
    }

    @Override
    public Host row2object(ResultSet rs) throws Exceptionss {
        try {
            Host q = new Host();
            q.setId(rs.getInt(1));
            q.setName(rs.getString(2));
            q.setNumber(rs.getString(3));
            return q;
        } catch (Exception e) {
            throw new Exceptionss(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Host object) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Host> getall() {
        return null;
    }
}
