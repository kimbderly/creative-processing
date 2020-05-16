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

public class space extends PApplet {

Star[] stars = new Star[500];
float speed;

public void setup() {
  
  for (int i = 0; i < stars.length; i++) {
    stars[i] = new Star();
  }
}

public void draw() {
  speed = map(mouseX, 0, width, 0, 30);
  if (mousePressed) {
    background(255);
  } else {
    background(0);
  }

  translate(width/2, height/2);
  for (int i = 0; i < stars.length; i++) {
    stars[i].update();
    stars[i].show();
  }
}
class Star {
  float x, y, z, prev_z;
  float r, b, g;
  Star() {
    x = random(-width/2, width/2);
    y = random(-height/2, height/2);
    z = random(width/2);
    prev_z = z;
  }

  public void update() {
    z = z - speed;

    if (z < 1) {
      z = width/2;
      x = random(-width/2, width/2);
      y = random(-height/2, height/2);
      prev_z = z;
    }
  }

  public void show() {
    r = random(255);
    g = random(255);
    b = random(255);
    fill(r, g, b);
    noStroke();
    float xpos =  map(x/z, 0, 1, 0, width/2);
    float ypos = map(y/z, 0, 1, 0, height/2);
    float radius = map(z, 0, width/2, 25, 0);
    ellipse(xpos, ypos, radius, radius);

    float prev_x = map(x/prev_z, 0, 1, 0, width/2);
    float prev_y = map(y/prev_z, 0, 1, 0, height/2);
    prev_z = z;
    stroke(r, g, b);
    line(prev_x, prev_y, xpos, ypos);
  }
}
  public void settings() {  size(1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "space" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
