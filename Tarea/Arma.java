package Tarea;
import Tarea.*;
public class Arma extends Item{
    private float mul_str;
    private float mul_int;
    private String tipo;
/**
 * Arma(char representacion, String nombre, String tipo , float mul_str, float mul_int): Constructor de la clase Arma. Inicializa las variables de instancia y hereda de la clase Item.
 * 
 * @param representacion: El carácter que representa la arma en el juego.
 * @param nombre: El nombre de la arma.
 * @param tipo: El tipo de la arma.
 * @param mul_str: El multiplicador de fuerza de la arma.
 * @param mul_int: El multiplicador de inteligencia de la arma.
 */
    Arma(char representacion, String nombre, String tipo , float mul_str, float mul_int) {
        super(representacion, nombre, tipo);
        this.mul_str = mul_str;
        this.mul_int = mul_int;
        
    }

    public float calcularAtaque(int strength, int intelligence) {
        float dmg = strength*mul_str + intelligence*mul_int;
        return dmg;
    }


}