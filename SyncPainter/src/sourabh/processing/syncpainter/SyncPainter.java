package sourabh.processing.syncpainter;

import processing.core.*; 

public class SyncPainter extends PApplet {

//The MIT License (MIT) - See Licence.txt for details

//Copyright (c) 2013 Mick Grierson, Matthew Yee-King, Marco Gillies
public void setup()
{
  
  background((Math.random() < 0.5) ? 0 : 255);

}

public void draw()
{
// code that happens every frame
}

public void mouseDragged()
{
  float red = map(mouseX, 0, width, 0, 255); 
  float blue = map(mouseY, 0, height, 0, 255); 
  float green = dist(mouseX, mouseY, width/2, height/2);
  float speed = dist(pmouseX, pmouseY, mouseX, mouseY);
  float alpha = map(speed, 0, 20, 0, 10);
  float lineWidth = map(speed, 0, 10, 10, 1);
  lineWidth = constrain(lineWidth, 0, 10);
  
  noStroke();
  fill(0, alpha);
  //stroke(green, red, blue, 255);
  //stroke(red, green, blue, 255);
  stroke(green, blue, red, 255);
  strokeWeight(lineWidth); 
  brush(pmouseX, pmouseY,mouseX, mouseY,lineWidth);
// code that happens when the mouse moves
// with the button down
}

public void mousePressed()
{
// code that happens when the mouse button
// is pressed
}

public void mouseReleased()
{
// code that happens when the mouse button
// is released
}

public void brush(float x,float y, float px, float py, float lineWidth) {
  strokeWeight(lineWidth);
  line(px,py,x,y);
  line(width/2+((width/2)-px),py,width/2+((width/2)-x),y);
  line(px,height/2+((height/2)-py),x,height/2+((height/2)-y));
  line(width/2+((width/2)-px),height/2+((height/2)-py),width/2+((width/2)-x),height/2+((height/2)-y));
  line(width/2+((width/2)-py),width/2-((width/2)-px),width/2+((width/2)-y),width/2-((width/2)-x));
  line(height/2-((height/2)-py),width/2-((width/2)-px),height/2-((height/2)-y),width/2-((width/2)-x));
  line(width/2+((width/2)-py),height/2+((height/2)-px),width/2+((width/2)-y),height/2+((height/2)-x));
  line(width/2-((width/2)-py),height/2+((height/2)-px),width/2-((width/2)-y),height/2+((height/2)-x));
  return;
}


  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return displayHeight; }
}
