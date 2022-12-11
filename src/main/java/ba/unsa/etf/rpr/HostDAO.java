package ba.unsa.etf.rpr;

import java.util.List;

public interface HostDAO extends Dao<Host>{

    List<Host> searchByName(String name);

    List<Host> searchByNumber(String name);

}
