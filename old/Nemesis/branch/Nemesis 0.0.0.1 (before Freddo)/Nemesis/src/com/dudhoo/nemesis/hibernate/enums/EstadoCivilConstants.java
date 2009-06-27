package com.dudhoo.nemesis.hibernate.enums;

public enum EstadoCivilConstants{
    
    CASADO,
    SOLTEIRO,
    VIUVO,
    AMASIADO,
    ;

    public static EstadoCivilConstants valueOf(int numero){
	switch(numero){
	    case 1:
		{
		    return EstadoCivilConstants.SOLTEIRO;
		}
	    case 2:
		{
		    return EstadoCivilConstants.CASADO;

		}
	    case 3:
		{
		    return EstadoCivilConstants.VIUVO;

		}
	    case 4:
		{
		    return EstadoCivilConstants.AMASIADO;

		}
	}
	return null;
    }


    public String toString(){
	switch(this){
	    case CASADO:
		{
		    return "Casado";

		}

	    case SOLTEIRO:
		{
		    return "Solteiro";

		}
	    case VIUVO:
		{
		    return "Viúvo";

		}
	    case AMASIADO:
		{
		    return "Amasiado";

		}
	}
	return null;
    }

    /**
     * Retorna o valor correspondente para ser guardado no banco de dados
     * */
    public int getValue(){
	switch(this){

	    case SOLTEIRO:
		{
		    return 1;
		}
	    case CASADO:
		{
		    return 2;
		}

	    case VIUVO:
		{
		    return 3;
		}
	    case AMASIADO:
		{
		    return 4;
		}
	    default:
		{
		    return 1;
		}

	}
    }
}
