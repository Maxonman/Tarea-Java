package Tarea;
import Tarea.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Jugador extends Personaje{
    private String nombre;
    private int xp;
    private List<Item> inventario;
    private Map<String, Equipamiento> equipamiento;
    private Arma arma;

/**
 * Jugador(String nombre): Constructor de la clase Jugador. Inicializa las variables de instancia y agrega una espada básica al inventario del jugador.
 * 
 * @param nombre: El nombre del jugador.
 */
    Jugador(String nombre) {
    	super();
        this.nombre = nombre;
        this.xp = 0;
        this.inventario = new ArrayList<>();
        this.equipamiento = new HashMap<>();
        this.arma = new Arma('/',"Espada Basica","Espada", 2f, 2f);
        this.inventario.add(this.arma);

    }

    public char getRepresentacion(){
		return 'J';
	}


    public void ganarXp(int xp) {
        this.xp += xp;
        if(this.xp >= 100){
        	this.xp = 0;
        	this.setNivel(this.getNivel() + 1);
            this.curar(30);
        }
	}

	public void equipar(Arma arma) {
    	this.arma = arma;
    }


    public void equipar(Equipamiento equipamiento) {
        this.equipamiento.put(equipamiento.getTipo(), equipamiento);
    }

/**
 * guardar(Item item): Agrega un nuevo item al inventario del jugador.
 * @param item: El item que se agregará al inventario.
 */
    public void guardar(Item item){
        this.inventario.add(item);
    }
/**
 * getArma(): Devuelve la arma actual del jugador.
 * 
 * @return Arma: La arma actual del jugador.
 */
    public Arma getArma(){
        return this.arma;
    }
/**
 * imprimirInventario(): Imprime el inventario actual del jugador en la consola.
 */
    public void imprimirInventario() {
    System.out.println("\n\nInventario del jugador:");
    for (Item item : inventario) {
        System.out.println("- " + item.getRepresentacion() + " \"" +  item.getNombre() + "\" " + "tipo "+item.getTipo());
    
        }
    }
/**
 * getNombre(): Devuelve el nombre del jugador.
 * 
 * @return String: El nombre del jugador.
 */
    public String getNombre(){
        return this.nombre;
    }
/**
 * setNombre(String nombre): Establece un nuevo nombre para el jugador.
 * 
 * @param nombre: El nuevo nombre para el jugador.
 */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
/**
 * getXp(): Devuelve la experiencia actual del jugador.
 * 
 * @return int: La experiencia actual del jugador.
 */
    public int getXp(){
        return this.xp;
    }
/**playerSTR(): Calcula y devuelve la fuerza total del jugador, incluyendo la fuerza de todos los equipamientos.
 * 
 * @return int: La fuerza total del jugador.
 */
    public int playerSTR() {
        int totalStrength = 0;

        for (Equipamiento equip : equipamiento.values()) {
            totalStrength += equip.getStr();
        }

        return totalStrength;
    }
/**playerINT(): Calcula y devuelve la inteligencia total del jugador, incluyendo la inteligencia de todos los equipamientos.
 * 
 * @return int: La inteligencia total del jugador.
 */
    public int playerINT() {
        int totalIntelligence = 0;

        for (Equipamiento equip : equipamiento.values()) {
            totalIntelligence += equip.getInt();
        }

        return totalIntelligence;
    }

/**
 * imprimirEquipamiento(): Imprime el equipamiento actual del jugador en la consola.
 */
    public void imprimirEquipamiento() {
    System.out.println("Equipamiento:");
    for (Equipamiento equip : equipamiento.values()) {
        System.out.println("- Tipo: " + equip.getTipo());
        System.out.println("  Nombre: " + equip.getNombre());
        System.out.println("  Fuerza: " + equip.getStr());
        System.out.println("  Inteligencia: " + equip.getInt());
    }
}


/**
 * buscarItemPorNombre(String nombre): Busca un item en el inventario del jugador por su nombre.
 * 
 * @param nombre: El nombre del item que se buscará.
 * 
 * @return Item: El item encontrado, o null si no se encontró ningún item con ese nombre.
 */
    public Item buscarItemPorNombre(String nombre) {
        for (Item item : inventario) {
            String name = item.getNombre();
            if (name.equals(nombre)) {

                return item;
            }
        }
        System.out.println("No se ha encontrado el objeto en tu inventario");
        return null;
    }
    
    public float calcularAtaque(int intelligence, int strength){

        return 3*this.getNivel()+this.arma.calcularAtaque(strength, intelligence);
    }


}


    
