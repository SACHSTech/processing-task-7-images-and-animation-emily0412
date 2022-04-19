import processing.core.PApplet;
import processing.core.PImage; // import the PImage library

public class Sketch extends PApplet {
	
	PImage imgSpace; // declare a global image variable
  PImage imgUFO;
  PImage imgPlanet;

  float ufoX = 200;
  float ufoY = 100;

  float moveVariableX = 2;
  float moveVariableY = 2;

  float circleX = 0;
  float circleY = 100;
  float circleAngle = 0;

  public void settings() {
	
    size(825, 600);
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgSpace = loadImage("spaceBack.jpg");
    imgSpace.resize(imgSpace.width/2, imgSpace.height/2); // resize background

    imgUFO = loadImage("ufo.png");
    imgUFO.resize(imgUFO.width/6, imgUFO.height/6); //resize UFO
  }

  
  public void draw() {
	  
    image(imgSpace, 0, 0);

    // planet
    fill(255, 191, 179);
    noStroke();
    ellipse(circleX, circleY, 100, 100);
    circleX = circleX += 1;
    circleY = circleY + sin(circleAngle)*2; // wave form
    circleAngle += PI/120;
    // edge detection
    if(circleX < 0 || circleX > width) {
      circleX = 0;
    }
    if(circleY < 0 || circleY > height) {
      circleY = 100;
    }

    // ufo
    image(imgUFO, ufoX, ufoY);
    ufoX += moveVariableX;
    ufoY += moveVariableY;
    //bounce off left and right
    if(ufoX < 0 || ufoX > width - 200) {
      moveVariableX = moveVariableX * -1;
    }
    // bounce off top and bottom
    if(ufoY < -15 || ufoY > height - 150) {
      moveVariableY = moveVariableY * -1;
    }

  }
  
}