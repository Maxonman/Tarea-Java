package Tarea;
import Tarea.*;

public class Enemigo extends Personaje{

	private float danio;
/**
 * Enemigo(int nivel): Constructor de la clase Enemigo. Inicializa las variables de instancia y establece la salud y el daño en función del nivel.
 * 
 * @param nivel: El nivel del enemigo.
 */
	Enemigo(int nivel){
		super();
		this.setHp(5*nivel);
		this.danio = 5*nivel;
	}

/**
 * recibirDanio(float Rdanio, Personaje atacante): Reduce la salud del enemigo en función del daño recibido y luego ataca al atacante.
 * 
 * @param Rdanio: La cantidad de daño que el enemigo recibe.
 * @param atacante: El personaje que está atacando.
 */
	public void recibirDanio(float Rdanio, Personaje atacante){
		super.recibirDanio(Rdanio, atacante);
		this.attack(atacante,this.danio);
	}

	public char getRepresentacion(){
		return 'E';
	}
}