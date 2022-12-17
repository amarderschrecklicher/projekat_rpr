package ba.unsa.etf.rpr.dao;

import java.util.List;

/**
 * Root interface for all DAO classes
 *
 * @author Amar Tahirovic
 */
public interface Dao<spp> {

    spp getById(int id);

    spp add(spp item);

    spp update(spp item);

    void delete(int id);

    List<spp> getall();






}