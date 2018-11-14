package aplicacion;

import java.awt.Point;

public class Plaza extends Edificio{
    private int vida;
	private Point tama�o;

    public Plaza() {
        super(450);
        this.tama�o = new Point(2,2);
    }

    @Override
    public int vida() {
        return this.vida;
    }
    
    @Override
    public Point verTama�o() {
    	return this.tama�o;
    }

    @Override
    public Unidad reclutar_unidad(Unidad unidad) {
        Unidad nueva_unidad = unidad.crear_unidad();
        /*aca estaria el posicionamiento en el terreno de la unidad*/
        return nueva_unidad;
    }
    
}
