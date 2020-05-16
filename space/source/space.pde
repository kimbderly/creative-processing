Star[] stars = new Star[500];
float speed;

void setup() {
  size(1200, 800);
  for (int i = 0; i < stars.length; i++) {
    stars[i] = new Star();
  }
}

void draw() {
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
