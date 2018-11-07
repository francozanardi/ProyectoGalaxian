package Obstaculo;

import visitor.Visitor;



public abstract class Barricada extends Obstaculo
{
	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
	
}