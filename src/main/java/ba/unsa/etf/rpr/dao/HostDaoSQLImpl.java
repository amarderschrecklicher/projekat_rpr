package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HostDaoSQLImpl extends AbstractDao<Host> implements HostDAO {
    public HostDaoSQLImpl() {
        super("Host");
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
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id",object.getId());
        row.put("name",object.getName());
        row.put("number",object.getNumber());
        row.put("e-mail",object.getEmail());
        return row;
    }


    @Override
    public boolean searchHost(Host host) throws Exceptionss {
        List<Host> l =this.getAll();
        for(Host x:l)if(x.getName().equals(host.getName())  && x.getNumber().equals(host.getNumber()))return true;
        return false;
    }
    @Override
    public Host getByNumber(String number) throws Exceptionss {
       return executeQueryUnique("SELECT * FROM Host WHERE HostNumber = ?", new Object[]{number});
    }
}
