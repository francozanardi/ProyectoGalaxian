package Obstaculo;

import visitor.Visitor;



public abstract class Destructible extends Obstaculo
{
	
	public void accept(Visitor col)
	{
		col.visit(this);
	}
	
}