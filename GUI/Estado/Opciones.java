package Estado;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Opciones extends JPanel implements ActionListener{
		private ArrayList<JButton> botones= new ArrayList<JButton>();
		private JButton sav = new JButton("Guardar"), rest = new JButton("Restablecer");
		private JCheckBox box1,box2;
		private Choice choi1, choi2;
		private RandomAccessFile file;
		private int code[]={38 ,40, 37, 39, 32, 10, 80, 81, 87};
		private String musica[]={"Mario", "Escenario1", "Escenario2"}; 
		private String personaje[]={"Pers1", "Pers2", "Pers3"};

	public Opciones(){
		JPanel l=new JPanel(), r=new JPanel();
		l.setLayout(new GridLayout(14,1,10,10));
		r.setLayout(new GridLayout(14,1,10,10));
		box1 = new JCheckBox();
		box2 = new JCheckBox();
		choi1 = new Choice();
		for (String m : musica){
			choi1.add(m);
		}
		choi2 = new Choice();
		for (String p : personaje){
			choi2.add(p);
		}

		String lab[]={"Pantalla Completa", "Sonido General", "Musica", "Personaje", "Arriba",
		"Abajo", "Mov Izquierda", "Mov Derecha", "Disparo", "Iniciar", "Pausar", 
		"Efectos de Sonido", "Musica de fondo"};
		try{
				file=new RandomAccessFile("GUI/Datos/conf.txt","rw");
				file.seek(0);
				for (int i=0;i<9;i++){
					
					code[i]=file.readInt();
				}
			
				box1.setSelected(Boolean.valueOf(file.readLine().replaceAll("\0","")));
				box2.setSelected(Boolean.valueOf(file.readLine().replaceAll("\0","")));
	
				choi1.select(musica[file.readInt()]);
				choi2.select(personaje[file.readInt()]);

			}catch(Exception e){System.out.println("Error al importar el archivo " + e.getMessage());}
		
		for(int c : code){
			botones.add(new JButton((char)c+""));
		}

		for(String txt : lab){
			l.add(new JLabel(txt));
		}
		
		r.add(box1);		
		r.add(box2);

		r.add(choi1);
		r.add(choi2);

		for (JButton btn: botones){
			btn.addActionListener(this);
			r.add(btn);	
		}

		sav.addActionListener(this);		
		l.add(sav);
		rest.addActionListener(this);
		r.add(rest);       

		add(l);
		add(r);
	}

	public void actionPerformed(ActionEvent evt){
		for(JButton btn: botones){//Acciones de los botones
			if(evt.getActionCommand()==btn.getActionCommand()){
            	btn.setBackground(Color.GREEN);
          		//pos = bot;
            	KeyListener tecla = new KeyListener(){
            		public void keyTyped (KeyEvent ke){}
            		public void keyPressed (KeyEvent ke){
            			//KeyCodes[pos+4] = ke.getKeyCode();
            		}
            		public void keyReleased (KeyEvent ke){
            			btn.setText(String.valueOf(ke.getKeyChar()));
            		}
            	};
            	btn.addKeyListener(tecla);
        	}
        	//bot++;
		}

		if(evt.getActionCommand()==sav.getActionCommand()){//Guardar
			for(int i=0;i<9;i++){
           		botones.get(i).setBackground(null);
           		if(rest.getBackground()!=Color.RED){
           			code[i]=botones.get(i).getText().charAt(0);	
				}
			}
			try{
				file=new RandomAccessFile("GUI/Datos/conf.txt","rw");
				
				file.seek(0);

				for(int c : code){
					file.writeInt(c);		
				}
				file.writeChars(box1.isSelected()+"\n");
				file.writeChars(box2.isSelected()+"\n");
				file.writeInt(choi1.getSelectedIndex());
				file.writeInt(choi2.getSelectedIndex());
			}
			catch(Exception e){System.out.println("Error al importar el archivo" + e.getMessage());}
			
			rest.setBackground(null);
		}
		if(evt.getActionCommand()==rest.getActionCommand()){
			String prueba[]={"up", "down", "left", "right", " ", "<E>", "p", "q", "w"};
			int ti[]={38 ,40, 37, 39, 32, 10, 80, 81, 87};
			for(int i=0;i<botones.size();i++){
				code[i]=ti[i];
				botones.get(i).setText(prueba[i]);		
			}
			box1.setSelected(false);
			box2.setSelected(false);
			choi1.select("Tema1");
			choi2.select("Pers1");
			rest.setBackground(Color.RED);
		}
	}
	public int getBoton(int index){
		return code[index];
	} 
	public boolean getBoxScreen(){  
		return box1.isSelected();
	}
	public boolean getBoxSound(){ 
		return box2.isSelected(); 
	}
	public int getMusic(){ 
		return choi1.getSelectedIndex(); 
	}
	public int getCharacter(){ 
		return choi2.getSelectedIndex();
	}
}