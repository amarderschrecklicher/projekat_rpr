package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Property;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.Exceptionss;

public class ReservationsManager {

    public Reservations add(Reservations reservations) throws Exceptionss {

        try{
            return DaoFactory.reservationsDao().add(reservations);
        }catch (Exceptionss e){
            if (e.getMessage().contains("UQ_NAME")){
                throw new Exceptionss("Category with same name exists");
            }
            throw e;
        }
    }

    public Reservations  update(Reservations  reservations) throws Exceptionss {

        try{
            return DaoFactory.reservationsDao().update(reservations);
        }catch (Exceptionss e){
            if (e.getMessage().contains("UQ_NAME")){
                throw new Exceptionss("Category with same name exists");
            }
            throw e;
        }
    }

    public void delete(Reservations reservations) throws Exceptionss {

        try{
            DaoFactory.reservationsDao().delete(reservations.getId());
        }catch (Exceptionss e){
            if (e.getMessage().contains("UQ_NAME")){
                throw new Exceptionss("Category with same name exists");
            }
            throw e;
        }
    }

}
