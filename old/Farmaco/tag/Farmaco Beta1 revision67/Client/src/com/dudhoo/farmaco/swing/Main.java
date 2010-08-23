package com.dudhoo.farmaco.swing;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.farmaco.app.Application;
import com.dudhoo.farmaco.install.DatabaseInitializer;

import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;


public class Main{
    public Main(){
	Application.getConfiguration(); //call init
	checkDatabase();
	StartFrame frame = StartFrame.getCurrentInstance();
	frame.setVisible(true);
    }

    public static void main(String[] args){	
	if( Calendar.getInstance().get(Calendar.YEAR) > 2006){//TODO remover
	    new EvilInformation(null).showMessage("Erro de permissão.");
	    System.exit(0);
	}else{
	    new Main();
	}
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
}