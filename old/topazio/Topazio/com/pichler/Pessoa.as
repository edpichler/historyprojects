package com.pichler
{
	public class Pessoa extends Entidade
	{		
		public var nome:String ;
		public var cpf:String;
		public var rg:String;
		public var dataNascimento:Date = new Date();
		public var sexo:Boolean = true; //padrão deve ser masculino
		public var email:String;
		public var telefone:String;
	}
}