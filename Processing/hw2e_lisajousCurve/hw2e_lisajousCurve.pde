/*
 *@author: Ying Cui
 *First the step of t starts at 0.1. It's very sparse.
 *Then I make t smaller with everytime you press the left button of mouse.
 *We can see the clear Lisajous Curve with mouse pressing.
 */

void setup()
{
  size(600, 600);
  background(255);
}

float step = 0.1;
void draw()
{
  translate(width/2, height/2);
  scale(width/2, -height/2); // the max value of two direction are both 1.
  strokeWeight(0);
  for (float t = 0; t < 2 * PI; t += step)
  {
    float x = cos(13 * t);
    float y = cos(15 * t);
    point(x, y);
  }
}

void mousePressed()
{
  if (mouseButton == LEFT)
      step /= 10;
}