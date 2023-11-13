package Tarea;
import Tarea.*;

public class Equipamiento extends Item  {
    private String tipo;
    private int strength;
    private int intelligence;
/**
 * Equipamiento(char representacion, String nombre, String tipo, int strength, int intelligence): Constructor de la clase Equipamiento. Inicializa las variables de instancia y hereda de la clase Item.
 * 
 * @param representacion: El carácter que representa el equipamiento en el juego.
 * @param nombre: El nombre del equipamiento.
 * @param tipo: El tipo del equipamiento.
 * @param strength: La fuerza que proporciona el equipamiento.
 * @param intelligence: La inteligencia que proporciona el equipamiento.
 */
    Equipamiento(char representacion, String nombre, String tipo, int strength, int intelligence) {
        super(representacion, nombre, tipo);
        this.strength = strength;
        this.intelligence = intelligence;
    }
/**
 * getStr(): Devuelve la fuerza que proporciona el equipamiento.
 *
 * @return int: La fuerza que proporciona el equipamiento. 
 */
    public int getStr(){
        return this.strength;
    }
/**
 * getInt(): Devuelve la inteligencia que proporciona el equipamiento.
 *
 * @return int: La inteligencia que proporciona el equipamiento. 
 */
    public int getInt(){
        return this.intelligence;
    }


}
