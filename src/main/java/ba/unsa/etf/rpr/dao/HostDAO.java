package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Host;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

public interface HostDAO extends Dao<Host> {

boolean searchHost(Host host) throws Exceptionss;

Host getByNumber(String number)throws Exceptionss;

}
