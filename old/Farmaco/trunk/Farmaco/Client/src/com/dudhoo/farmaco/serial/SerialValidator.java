package com.dudhoo.farmaco.serial;

import com.dudhoo.farmaco.app.Application;

import java.util.Date;

import org.apache.log4j.Logger;

public class SerialValidator {

    private Logger log = Logger.getLogger(SerialValidator.class);

    public SerialValidator() {
    }

    /**
     * Retorna se o serial no xml é ainda válido
     * */
    public boolean isAindaValidoSerial(){
        try{
            String serial = Application.getConfiguration()
                .getString(Application.APP_SERIAL);
            return validaSerialDigitado(serial);
        }catch(Exception ex){
            log.error(ex);
            return false;
        }
    }

    public boolean validaSerialDigitado(String ser) throws Exception {        
        String split[] = ser.split("K");
        
        long primeira = Long.parseLong(split[0], 16);
        long segunda = Long.parseLong(split[1], 16);        
        long terceira = Long.parseLong(split[2], 16);
        long quarta = Long.parseLong(split[3], 16);
        if(quarta != ((segunda / terceira) / primeira)){
            return false;
        }
        
        Date now = new Date();
        Date init = getInitDate(ser);
        Date fim = getFimDate(ser);
        boolean expirado = now.before(init) || now.after(fim);
        return !expirado;
    }

    public void saveNewSerial(String serial) {
        Application.getConfiguration().setProperty(Application.APP_SERIAL, serial);
    }

    private Date getInitDate(String ser) throws Exception{
        String split[] = ser.split("K");
        
        String first4 = split[0];
        String meio = split[1];

        long random = Long.parseLong(first4,16);

        long longInic = Long.parseLong(meio, 16) / random ;
        Date inicial = new Date(longInic);
        return inicial;
    }

    private Date getFimDate(String ser) throws Exception{
        String split[] = ser.split("K");
        
        String first4 = split[0];
        String last9  = split[2];
        String meio = split[1];

        long random = Long.parseLong(first4, 16);

        long longInic = Long.parseLong(meio, 16) / random ;

        long longFim  = Long.parseLong(last9, 16) / 7 / random;

        Date diaFinal = new Date(longInic + (longFim * 24 * 60* 60 * 1000) );
        return diaFinal;

    }
}
