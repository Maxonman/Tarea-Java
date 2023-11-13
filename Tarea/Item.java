package Tarea;
import Tarea.*;

public abstract class Item implements Visible{
    private char representacion;
    private String nombre;
    private String tipo;

/**
 * Item(char representacion, String nombre, String tipo): Constructor de la clase abstracta Item. Inicializa las variables de instancia.
 * 
 * @param representacion: El carácter que representa el item en el juego.
 * @param nombre: El nombre del item.
 * @param tipo: El tipo del item.
 */
    Item(char representacion, String nombre, String tipo) {
        this.representacion = representacion;
        this.nombre = nombre;
        this.tipo = tipo;
    }
/**
 * getRepresentacion(): Devuelve la representación del item en el juego.
 * 
 * @return char: El carácter que representa al item en el juego.
 */
    public char getRepresentacion(){
        return this.representacion;
    }
/**
 * getNombre(): Devuelve el nombre del item.
 * 
 * @return String: El nombre del item.
 */
    public String getNombre(){
        return this.nombre;
    }
/**
 * getTipo(): Devuelve el tipo del item.
 * 
 * @return String: El tipo del item.
 */
    public String getTipo(){
        return this.tipo;
    }
}