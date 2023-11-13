package Tarea;
import Tarea.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;


public class Mundo{
    private int nivel;
    private int alto;
    private int ancho;
    private int enemigos;
    private List<List<Visible>> mapa;
    private List<Function<Integer, Item>> factory;
    private int playerX,playerY;
/**
* Mundo(int alto, int ancho, Jugador Player): Constructor de la clase Mundo. Inicializa las variables de instancia y genera el mapa inicial del juego.
* 
* @param alto: La altura del mapa del juego.
* @param ancho: El ancho del mapa del juego.
* @param Player: El jugador que estará jugando en este mundo.
*/
    Mundo(int alto, int ancho, Jugador Player) {
        this.nivel = 1;
        this.alto = alto;
        this.ancho = ancho;
        this.enemigos = 0;
        this.mapa = new ArrayList<>();
        this.playerX = 0;
        this.playerY = 0;
        this.factory = new ArrayList<>();
        factory.add(nivel -> new Arma('O', "Escudo de Titanes " + nivel, "Escudo", 2.4f * nivel, 2.4f * nivel));
        factory.add(nivel -> new Arma('/', "Espada Oscura " + nivel, "Espada", 3.3f * nivel, 2.6f * nivel));
        factory.add(nivel -> new Arma('D', "Arco Matadragones " + nivel, "Arco", 2.0f * nivel, 3.2f * nivel));
        factory.add(nivel -> new Arma('7', "Hacha Valkyria " + nivel, "Hacha", 3.0f * nivel, 1.5f * nivel));
        factory.add(nivel -> new Arma('I', "Baston Catalizador " + nivel, "Baston", 1.0f * nivel, 3.2f * nivel));
        factory.add(nivel -> new Equipamiento('A',"Amuleto de Guerra "+ nivel,"Amuleto", 2*nivel, 0*nivel));
        factory.add(nivel -> new Equipamiento('Á',"Amuleto del Sabio "+ nivel,"Amuleto", 0*nivel, 2*nivel));
        factory.add(nivel -> new Equipamiento('P',"Pechera de Diamante "+ nivel,"Armadura", 3*nivel, 1*nivel));    
        factory.add(nivel -> new Equipamiento('p',"Tunica Cósmica "+ nivel,"Armadura", 1*nivel, 3*nivel));
        factory.add(nivel -> new Equipamiento('B',"Botas Barbaricas "+ nivel,"Botas", 2*nivel, 0*nivel));    
        factory.add(nivel -> new Equipamiento('b',"Botas Runicas "+ nivel,"Botas", 0*nivel, 2*nivel));        

        generarMapa(Player);
    }

/**
* generarMapa(Jugador Player): Genera un nuevo mapa para el juego, colocando al Jugador en la posición 0,0 y a los Enemigos e Items en posiciones aleatorias.
* 
* @param Player: El jugador que estará jugando en este mundo.
*/
    private void generarMapa(Jugador Player) {
        mapa.clear();
        this.enemigos = 0;
        Random random = new Random();

        for (int i = 0; i < alto; i++) {
            List<Visible> fila = new ArrayList<>();
            for (int j = 0; j < ancho; j++) {
                double r = random.nextDouble();
                if(i == 0 && j == 0){
                    fila.add(null);
                    continue;
                }
                Visible entidad;

                if (r <= Math.min(0.05 + 0.01 * nivel, 0.20)) {
                    entidad = generarItemAleatorio();
                } else if (r <= Math.min(0.2 + 0.01 * nivel, 0.55)) {
                    entidad = new Enemigo(this.nivel);
                    this.enemigos++;
                } else {
                    entidad = null;
                }

                fila.add(entidad);
            }
            mapa.add(fila);
        }

        mapa.get(0).set(0, Player);
        
        if(this.enemigos <= 0){
            this.enemigos = 0;
            this.nuevoNivel(Player);
        }
    }

    public void mostrar() {
        for (List<Visible> fila : mapa) {
            for (Visible entidad : fila) {
                if (entidad == null) {
                    System.out.print(' ');
                } else {
                    System.out.print(entidad.getRepresentacion());
                }
            }
            System.out.println();
        }
    }

    
    public void nuevoNivel(Jugador Player) {
        nivel++;
        float hp = Player.getHp();
        Player.setHp(hp+50.0f+5.0f*(float)this.nivel); 
        this.enemigos = 0;
        generarMapa(Player);
    }
    
/**
* goTo(int dx, int dy): Mueve al jugador a una nueva posición en el mapa, si es posible. Si hay un enemigo en la nueva posición, el jugador ataca al enemigo. Si hay un item en la nueva posición, el jugador recoge el item.
* 
* @param dx: El cambio en la posición x del jugador.
* @param dy: El cambio en la posición y del jugador.
*/
    public void goTo(int dx, int dy){
        
        int x = this.playerX + dx;
        int y = this.playerY + dy;
        if(x>=0 && y>=0){
            if(x<this.alto && y<this.ancho){
                Visible entidad = mapa.get(x).get(y);
                Jugador player = (Jugador) mapa.get(this.playerX).get(this.playerY);
                if(entidad == null){
                    mapa.get(x).set(y, player);
                    mapa.get(this.playerX).set(this.playerY, null);
                    this.playerX = x;
                    this.playerY = y;
                }else if(entidad instanceof Item){
                    player.guardar((Item) entidad);
                    mapa.get(x).set(y, player);
                    mapa.get(this.playerX).set(this.playerY, null);
                    this.playerX = x;
                    this.playerY = y;
                }else if(entidad instanceof Enemigo){
                    Enemigo E = (Enemigo)entidad;
                    player.attack(E , player.calcularAtaque(player.playerSTR(),player.playerINT()));
                    if(E.getHp() <= 0){
                        mapa.get(x).set(y, player);
                        mapa.get(this.playerX).set(this.playerY, null);
                        this.playerX = x;
                        this.playerY = y;
                        this.enemigos--;
                        player.ganarXp(15);

                        if (this.enemigos == 0){
                            nuevoNivel(player);
                            this.playerY=0;
                            this.playerX=0;
                        }
                    }
                }
            }else{
                System.out.println("Movimiento invalido, estas saliendo del mapa");
            }
        }else{
            System.out.println("Movimiento invalido, estas saliendo del mapa");
        }
    }

/**
* generarItemAleatorio(): Genera un item aleatorio basado en el nivel actual del juego.
* 
* @return Item: El item generado aleatoriamente.
* 
*/
    public Item generarItemAleatorio(){
        Random random = new Random();
        int r = random.nextInt();
        r = Math.abs(r);
        r = r % this.factory.size();
        return factory.get(r).apply(nivel);
    }

/**
* getNivel(): Devuelve el nivel actual del juego.
* 
* @return int: El nivel actual del juego.
*/
    public int getNivel(){
        return this.nivel;
    }

/**
* cantEnemigos(): Devuelve la cantidad de enemigos restantes en el mapa actual.
* 
* @return int: La cantidad de enemigos restantes en el mapa actual.
*/
    public int cantEnemigos(){
        return this.enemigos;
    }
}
