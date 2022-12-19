package ba.unsa.etf.rpr.exceptions;

public class Exceptionss extends Exception{

public Exceptionss(String msg,Exception reason){
    super(msg,reason);
}

public Exceptionss(String msg){
    super(msg);
}
}