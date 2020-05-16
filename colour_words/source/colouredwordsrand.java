import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import javax.swing.*; 
import java.util.Random; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class colouredwordsrand extends PApplet {




String input;
int r,g,b;
Random rand = new Random();

public void setup(){
  
  textSize(50);
}

public void draw(){
  int pos_x = 40;
  int pos_y = 40;
  //println(pos_x);
  background(247, 250, 249);
  input = JOptionPane.showInputDialog("colourise");
  try{
  for(int i = 0; i < input.length(); i++){
    //println(pos_x,i, input.charAt(i), Character.isWhitespace(input.charAt(i)));
    if(Character.isWhitespace(input.charAt(i)) || !Character.isLetter(input.charAt(i))){
      noFill();
      noStroke();
      rect(pos_x,pos_y,30,30);
      pos_x += 30;
    }else{
    r = rand.nextInt();
    g = rand.nextInt();
    b = rand.nextInt();
    println(r,g,b);
    fill(r, g, b);
    stroke(r, g, b);
    rect(pos_x,pos_y,30,30);
    pos_x += 30;
    }
    if(pos_x > 1120){
      pos_x = 40;
      pos_y += 40;
    }
  }
  fill(10,10,10);
  rect(40, 700, 100, 50);
  fill(255,255,255);
  textSize(12);
  text("colour again", 55, 730);
  noLoop();
    }catch(NullPointerException e){
      input = JOptionPane.showInputDialog("colourise");
  }
}

public void mousePressed(){
  if(mouseX >= 40 && mouseX <= 140 && mouseY >= 700 && mouseY <= 750){
    redraw();
  }
}
  public void settings() {  size(1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "colouredwordsrand" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
