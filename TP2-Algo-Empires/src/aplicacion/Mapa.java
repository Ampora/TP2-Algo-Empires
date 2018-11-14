package aplicacion;

import java.awt.Point;
import java.util.*;


public class Mapa {
	
	private HashMap<Point, Entidad> grilla;
	private Integer ancho;
	private Integer alto;

	public Mapa(Integer ancho, Integer alto) {
		this.grilla = new HashMap<Point, Entidad>();
		this.ancho = ancho;
		this.alto = alto;
	}
	
	private boolean verificarCoordenadas(Point coordenadas, Point tama�o) {
		Point menorCoordenada = coordenadas;
		Integer mayorAlto = (int) (menorCoordenada.getX() + tama�o.getX());
		Integer mayorAncho = (int) (menorCoordenada.getY() + tama�o.getY());
		Point mayorCoordenada = new Point(mayorAlto, mayorAncho);
		Boolean mayorQueCero = menorCoordenada.getX() >= 0 && menorCoordenada.getY() >= 0;
		Boolean menorQueFinDelMapa = mayorCoordenada.getX() < this.ancho && mayorCoordenada.getY() < this.alto;
		return(mayorQueCero && menorQueFinDelMapa);
	}

	public void colocar(Point coordenadas, Entidad entidad) {
		Point tama�oDeLaEntidad = entidad.verTama�o();
		if(!this.verificarCoordenadas(coordenadas, tama�oDeLaEntidad)) {
			return;/*crear error*/
		}
		int coordenadaEnX = (int)coordenadas.getX();
		int coordenadaEnY = (int)coordenadas.getY();
		for(int i = 0; i<(int)tama�oDeLaEntidad.getX(); i++) {
			for(int j = 0; j<(int)tama�oDeLaEntidad.getY(); j++) {
				this.grilla.put(new Point(coordenadaEnX + i,coordenadaEnY +j), entidad);	//la esquina inferior izquierda de la entidad se coloca en la posicion seleccionada
			}
		}
	}

	public boolean estaOcupado(Point coordenadas) {
		return this.grilla.containsKey(coordenadas);
	}
}
