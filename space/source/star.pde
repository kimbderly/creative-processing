class Star {
  float x, y, z, prev_z;
  float r, b, g;
  Star() {
    x = random(-width/2, width/2);
    y = random(-height/2, height/2);
    z = random(width/2);
    prev_z = z;
  }

  void update() {
    z = z - speed;

    if (z < 1) {
      z = width/2;
      x = random(-width/2, width/2);
      y = random(-height/2, height/2);
      prev_z = z;
    }
  }

  void show() {
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
