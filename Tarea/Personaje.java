package Tarea;
import Tarea.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje implements Visible{

	private float hp;
	private int nivel;
/**
 * Personaje(): Constructor de la clase Personaje. Inicializa las variables de instancia hp y nivel.
 */
	Personaje(){
		this.hp = 100;
		this.nivel = 1;

	}

	public char getRepresentacion(){
		return 'O';
	}

	public void recibirDanio(float danio, Personaje atacante){
		this.hp=this.hp-danio;
	}

    public float calcularAtaque(){
    	float danio = this.nivel * 3;
    	return danio;
    }
/**
 * getNivel(): Devuelve el nivel actual del personaje.
 * 
 * @return int: El nivel actual del personaje.
 */
	public int getNivel() {
	    return this.nivel;
	}
/**setNivel(int Nuevo_nivel): Establece un nuevo nivel para el personaje.
 * 
 * @param Nuevo_nivel: El nuevo nivel para el personaje.
 */
	public void setNivel(int Nuevo_nivel) {
		this.nivel = Nuevo_nivel;
	}
/**
 * getHp(): Devuelve la salud actual del personaje.
 * 
 * @return float: La salud actual del personaje.
 */
	public float getHp(){
		return this.hp;
	}


/**
 * attack(Personaje target, float danio): Ataca a otro personaje, infligiendo daño.
 * 
 * @param target: El personaje objetivo que será atacado.
 * @param danio: La cantidad de daño que se infligirá.
 */
	public void attack(Personaje target, float danio){
		target.recibirDanio(danio, this);
		
	}
/**
 * setHp(float nuevaHp): Establece una nueva cantidad de salud para el personaje.
 * 
 * @param nuevaHp: La nueva cantidad de salud para el personaje.
 */
	public void setHp(float nuevaHp){
		this.hp = nuevaHp;
	} 
/**
 * curar(float heal): Aumenta la salud del personaje en función de la cantidad de curación recibida.
 * 
 * @param heal: La cantidad de salud que el personaje recibe.
 */
	public void curar(float heal){
		this.hp = this.hp + heal;
	}
}	

