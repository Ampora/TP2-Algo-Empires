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
	
	private boolean verificarCoordenadas(Point coordenadas, Point tamaņo) {
		Point menorCoordenada = coordenadas;
		Integer mayorAlto = (int) (menorCoordenada.getX() + tamaņo.getX());
		Integer mayorAncho = (int) (menorCoordenada.getY() + tamaņo.getY());
		Point mayorCoordenada = new Point(mayorAlto, mayorAncho);
		Boolean mayorQueCero = menorCoordenada.getX() >= 0 && menorCoordenada.getY() >= 0;
		Boolean menorQueFinDelMapa = mayorCoordenada.getX() < this.ancho && mayorCoordenada.getY() < this.alto;
		return(mayorQueCero && menorQueFinDelMapa);
	}

	public void colocar(Point coordenadas, Entidad entidad) {
		Point tamaņoDeLaEntidad = entidad.verTamaņo();
		if(!this.verificarCoordenadas(coordenadas, tamaņoDeLaEntidad)) {
			return;/*crear error*/
		}
		int coordenadaEnX = (int)coordenadas.getX();
		int coordenadaEnY = (int)coordenadas.getY();
		for(int i = 0; i<(int)tamaņoDeLaEntidad.getX(); i++) {
			for(int j = 0; j<(int)tamaņoDeLaEntidad.getY(); j++) {
				this.grilla.put(new Point(coordenadaEnX + i,coordenadaEnY +j), entidad);	//la esquina inferior izquierda de la entidad se coloca en la posicion seleccionada
			}
		}
	}

	public boolean estaOcupado(Point coordenadas) {
		return this.grilla.containsKey(coordenadas);
	}
}
