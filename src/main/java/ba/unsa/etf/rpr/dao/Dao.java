package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.Exceptionss;
import ba.unsa.etf.rpr.exceptions.Izuzeci;

import java.util.List;

/**
 * Root interface for all DAO classes
 *
 * @author Amar Tahirovic
 */
public interface Dao<spp> {

    spp getById(int id) throws Izuzeci, Exceptionss;

    spp add(spp item) throws Exceptionss;

    spp update(spp item) throws Exceptionss;

    void delete(int id) throws Exceptionss;

    List<spp> getall();






}