package com.dudhoo.farmacopedia.web.key;

import com.dudhoo.farmacopedia.web.hibernate.FarmacopediaKey;

import java.text.Format;

import java.text.MessageFormat;

import java.util.Date;
import java.util.Formatter;

public class KeyGenerator {
    int max = 90;

    public KeyGenerator() {
    }

    public FarmacopediaKey generateKey(Date inicio, int dias) {
        if (dias > max) {
            throw new IllegalArgumentException("Dias need to be less than " + 
                                               max + " days");
        }
        
        long primeiraparte = (int)(Math.random() * 6667);            
        long segundaparte = inicio.getTime() * primeiraparte;
        long terceiraParte = dias * 7 * primeiraparte;
        long quartaparte = (segundaparte / terceiraParte ) / primeiraparte   ;
        
        
        String primeira = Long.toHexString(primeiraparte)  + "K"; //random
        String segunda = Long.toHexString(segundaparte) + "K";
        String terceira = Long.toHexString(terceiraParte) + "K";
        String quarta = Long.toHexString(quartaparte);
        
        //String quarto = "" + (prefix4 + (inicio.getTime() * prefix4) + ultimaParte); //soma dos 3 divido pelo do meio
        return new FarmacopediaKey(primeira + segunda + terceira + quarta);
    }

}
