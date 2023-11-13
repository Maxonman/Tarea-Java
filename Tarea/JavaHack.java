package Tarea;
import Tarea.*;
import java.util.Scanner;

public class JavaHack {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		
		System.out.print("Ingrese el nombre de su personaje: ");
        String nombre = scanner.nextLine();
        Jugador Jugador1 = new Jugador(nombre);
        
        System.out.print("Alto del mundo: ");
        int alto = scanner.nextInt();
        System.out.print("Ancho del mundo: ");
        int ancho = scanner.nextInt();

        Mundo mundo = new Mundo(alto,ancho,Jugador1);

        scanner.nextLine();

        while (flag) {
        	if(Jugador1.getHp()<=0){
        		flag = false;
        		System.out.println("\n\nOh no, ¡has muerto! (>.<) Mejor suerte la próxima! (^.^)\n");
        		break;
        	}
        	System.out.println("...............................");
        	System.out.println("Nivel del mapa: "+ mundo.getNivel());
        	System.out.println("Cantidad de enemigos: "+ mundo.cantEnemigos()+"\n");
        	mundo.mostrar();
        	System.out.println("...............................");
        	System.out.println("\n...............................\n");
			System.out.println("Elige una opcion: ");
			System.out.println("1) Para ver tus estadisticas escribe \"stats\".");
			System.out.println("2) Para ver tu inventario escribe \"inv\".");
			System.out.println("3) Para equipar un objeto escribe \"equip\", luego escriba el nombre del objeto.");
			System.out.println("4) Para desplazarte por el mapa escribe \"Abajo\", \"Arriba\", \"Izquierda\", \"Derecha\".");
			System.out.println("5) Para terminar el juego escribe \"salir\".");
			String opcion = scanner.nextLine();

			if (opcion.equalsIgnoreCase("salir")) {
				flag = false;
			} else if (opcion.equalsIgnoreCase("stats")){
				System.out.println("\n\n---------Estadisticas----------");
				System.out.println("Nombre: "+ Jugador1.getNombre());
				System.out.println("Tiene: "+ Jugador1.getHp()+ " de HP");
				System.out.println("Es nivel "+Jugador1.getNivel());
				System.out.println("Cantidad de experiencia acumulada: "+ Jugador1.getXp());
				System.out.println("Arma Equipada:\n- " + "\"" + Jugador1.getArma().getNombre()+ "\"" +", tipo: " +Jugador1.getArma().getTipo() + " " + Jugador1.getArma().getRepresentacion());
				System.out.println("Su daño actual es de: "+ Jugador1.calcularAtaque(Jugador1.playerSTR(),Jugador1.playerINT()));
				System.out.println("Fuerza: "+Jugador1.playerSTR());
				System.out.println("Inteligencia: "+Jugador1.playerINT());
				Jugador1.imprimirEquipamiento();
			}else if (opcion.equalsIgnoreCase("inv")){
				Jugador1.imprimirInventario();
			}else if(opcion.equalsIgnoreCase("equip")){
				String NombreObjeto = scanner.nextLine();
				Item objeto = Jugador1.buscarItemPorNombre(NombreObjeto);
				if(objeto != null){
					if(objeto instanceof Arma){
						Jugador1.equipar((Arma) objeto);
						System.out.println("Arma equipada con exito!");
						System.out.println("Tu nuevo daño es: "+Jugador1.calcularAtaque(Jugador1.playerSTR(),Jugador1.playerINT()));
					}else{
						Jugador1.equipar((Equipamiento) objeto);
						System.out.println("Equipamiento equipado con exito!");
						System.out.println("Ahora tienes "+Jugador1.playerSTR()+" de Fuerza y "+ Jugador1.playerINT()+" de Inteligencia." );

					}
				}

			}else if(opcion.equalsIgnoreCase("Arriba")){
				mundo.goTo(-1,0);
			}else if(opcion.equalsIgnoreCase("Abajo")){
				mundo.goTo(1,0);
			}else if(opcion.equalsIgnoreCase("Derecha")){
				mundo.goTo(0,1);
			}else if(opcion.equalsIgnoreCase("Izquierda")){
				mundo.goTo(0,-1);
			}else{
				System.out.println("\n\nOpcion invalida.");
			}
		}
		scanner.close();
	}
}