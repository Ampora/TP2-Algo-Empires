package aplicacion;

import java.awt.Point;

public abstract class Entidad{
    private int vida;
	private Point tama�o;
	
	public Entidad(int vida) {
		this.vida = vida;
	}
	public int vida() {
    	return this.vida;
    }
	public Point verTama�o() {
		return this.tama�o;
	}
}