package Graficos.reproductor;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public enum FXPlayer {
   // musica
   Inicio("START.wav"),
   Mapa1("Mapa1sonidofondo.wav"),
   Mapa2("STAGE2.wav"),
   Fin("GAMEOVER.wav"),
   Mario("FondoMario.wav"),
   // efectos de sonido
   ENDING("ENDING.wav"),
   ENEMY1("ENEMY1.wav"),
   ENEMY2("ENEMY2.wav"),
   CRYSTAL("CRYSTAL.wav");
   
   public static enum Volume {
      MUTE, LOW, MEDIUM, HIGH
   }

   public static Volume volume = Volume.LOW;
   private Clip clip;

   FXPlayer(String wav) {
      try {
         URL url = this.getClass().getClassLoader().getResource("Graficos/reproductor/sonidos/"+wav);
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);

         clip = AudioSystem.getClip();
         clip.open(audioInputStream);
      } 
      catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
         System.out.println("1");
      } 
      catch (IOException e) {
         e.printStackTrace();
         System.out.println("2");
      } 
      catch (LineUnavailableException e) {
         e.printStackTrace();
         System.out.println("3");
      }
   }

   public boolean isRunning(){
      return clip.isRunning();
   }
   public void play() {
      if (volume != Volume.MUTE) {
         if (!clip.isRunning()){
         	clip.setFramePosition(0);
         	clip.start();
         }
      }
   }
   public void stop(){
      if (volume != Volume.MUTE) {
         if (clip.isRunning()){
            clip.setFramePosition(0);
            clip.stop();
         }
      }
   }
   public void loop(){
       if (volume != Volume.MUTE) {
         if (!clip.isRunning()){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
         }
      }
   }
 
   public static void init() {
      values();
   }
}