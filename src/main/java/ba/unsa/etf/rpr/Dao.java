package ba.unsa.etf.rpr;

import java.util.List;

/**
 * Root interface for all DAO classes
 *
 * @author Amar Tahirovic
 */
public interface Dao<spp> {

    spp getById(int id);

}