import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class to_be_heard extends PApplet {

PFont font;
public void setup() {
  
  background(0xffFFF1CE);
  font = createFont("HoeflerText-Black", 15);
  textFont(font);
}
String input = "";
String msg = "Loneliness does not come from having no people about one, but from being unable to communicate the things that seem important to oneself, or from holding certain views which others find inadmissible. Once the writer in every individual comes to life, we are in for an age of universal deafness and lack of understanding. As you type, you find the inability to communicate. What were you trying to say?";
int i = 0;
int j = 0;
int text_x = 60;
int text_y = 40;
int input_x = 60;
int input_y;
int loop = 1;
public void draw() {
  if (keyPressed ==  true) {  
    if (i < msg.length()) {
      fill(0xff0A2E79);
      text(msg.charAt(i), text_x, text_y);
      //println(msg.charAt(i), i, text_x, text_y, loop);
      delay(25);      
      text_x += textWidth(msg.charAt(i));
      i++;
      }

    if (text_x > 836) {
      loop++;
      text_x = 60;
      text_y = loop * 40;
    }
  }

  if (i == msg.length() && key == ENTER) {
    loop+= 3;
    input_y = loop * 40;
    for (j =0; j < input.length(); j++) {
      //fill(255);
      text(input.charAt(j), input_x, input_y);
      input_x += textWidth(input.charAt(j));
      if (input_x > 836) {
        loop++;
        input_x = 60;
        input_y = loop * 40;
      }
    }
    noLoop();
  }
}


public void keyPressed() {
  input = input + key;
}
  public void settings() {  size(1000, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "to_be_heard" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
