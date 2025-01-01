package Graficos;

import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.sound.sampled.Clip;
import java.awt.Font;
//import GUI.Main.Knightmare;
import Graficos.*;

public class Recursos {

    public static BufferedImage button1;
    public static BufferedImage button2;
    public static BufferedImage knightmare;

    public static Font fuenteG;
    public static Font fuenteM;
    public static Font fuenteP;

    public static void init(){

        //Fuentes
        fuenteG = Cargador.cargarFuente("GUI/Main/Main//Multimedia/MSX-Screen0.ttf",50);
        fuenteM = Cargador.cargarFuente("GUI/Main/Main//Multimedia/MSX-Screen0.ttf", 200);
        fuenteP = Cargador.cargarFuente("GUI/Main/Main//Multimedia/MSX-Screen0.ttf", 14);

        

        //Imagenes
        knightmare = Cargador.cargarImagen("GUI/Main/Main/Multimedia/knightmare.jpeg");
      //  k_foto = Cargador.cargarImagen("/Multimedia/26992e8f-10dc-4308-96c7-94aa28ae12da.jpg");
        //letterButton1 = Cargador.cargarImagen("/Multimedia/botones/grey_button08.png");
       // letterButton2 = Cargador.cargarImagen("/Multimedia/botones/grey_button09.png");
        button1 = Cargador.cargarImagen("/Multimedia/grey_button00.png");
        button2 = Cargador.cargarImagen("/Multimedia/grey_button01.png");
        //emptyButton = Cargador.cargarImagen("/Multimedia/botones/grey_box.png");
        //leftArrow = Cargador.cargarImagen("/Multimedia/botones/grey_sliderLeft.png");
        //rightArrow = Cargador.cargarImagen("/Multimedia/botones/grey_sliderRight.png");
        //field = Cargador.cargarImagen("/Multimedia/botones/grey_button04.png");
       // Mapa1 = Cargador.cargarImagen("/Multimedia/Mapas/Mapa1.jpg");

       // vida = Cargador.cargarImagen("/Multimedia/personajes/corazon.png");

        //flecha = Cargador.cargarImagen("/Multimedia/Armas/Flecha.png");
       // flechaIncendiaria = Cargador.cargarImagen("/Multimedia/Armas/FlechaIncendiaria.png");
       // bolaFuego = Cargador.cargarImagen("/Multimedia/Armas/BolaDeFuego.png");
       // boomerang1 = Cargador.cargarImagen("/Multimedia/Armas/Boomerang1.png");

    }
}
