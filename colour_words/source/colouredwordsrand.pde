import javax.swing.*;
import java.util.Random;

String input;
int r,g,b;
Random rand = new Random();

void setup(){
  size(1200, 800);
  textSize(50);
}

void draw(){
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

void mousePressed(){
  if(mouseX >= 40 && mouseX <= 140 && mouseY >= 700 && mouseY <= 750){
    redraw();
  }
}
