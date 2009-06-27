package com.dudhoo.farmaco.swing;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.farmaco.app.Application;
import com.dudhoo.farmaco.install.DatabaseInitializer;

import com.dudhoo.farmaco.serial.SerialValidator;

import com.dudhoo.farmaco.swing.serial.JDialogSerial;

import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;


public class Main{
    public Main(){
	Application.getConfiguration(); //call init
        verificarSerial();
	checkDatabase();
	StartFrame frame = StartFrame.getCurrentInstance();        
        frame.setVisible(true);        
    }

    public static void main(String[] args){
        new Main();
    }

    private void checkDatabase(){
	DatabaseInitializer z = new DatabaseInitializer();
	try{
	    if(z.alreadyExists() == false){
		z.create();
	    }
	} catch(SQLException e){
	    new EvilError(null ,true, e).setVisible(true);;
	}
    }

    private void verificarSerial() {
        SerialValidator v = new SerialValidator();
        if(v.isAindaValidoSerial() == false){
            JDialogSerial j = new JDialogSerial();
            j.setVisible(true);
        }
    }
}