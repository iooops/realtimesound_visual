import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class realtimesound_visual extends PApplet {



Minim minim;
AudioInput in;

public void setup() {
  size(800, 600, P2D);
  
  minim = new Minim(this);
  
  in = minim.getLineIn();
}

public void draw() {
  background(0);
  stroke(255);

  strokeWeight(2);
  float a = 0;
  float angle = (2*PI) / 200;
  int step = in.bufferSize() / 200;
  for(int i=0; i < in.bufferSize() - step; i+=step) {
    float x = 400 + cos(a) * (1000 * in.mix.get(i) + 150);
    float y = 300 + sin(a) * (1000 * in.mix.get(i) + 150);
    float x2 = 400 + cos(a + angle) * (1000 * in.mix.get(i+step) + 150);
    float y2 = 300 + sin(a + angle) * (1000 * in.mix.get(i+step) + 150);
    line(x,y,x2,y2);
    a += angle;
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "realtimesound_visual" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
