/**
 *@author: Ying Cui
 */

void setup()
{
  size(600, 600);
}
float x = 25;
float y = 25;
float vx = 5;
float vy = 0;
void draw()
{
  background(0);
  noStroke();
  // random color
  int r = (int)random(255);
  int g = (int)random(255);
  int b = (int)random(255);
  fill(r, g, b);
  
  ellipse(x, y, 50, 50);
  x = x + vx;
  y = y + vy;
  float rx = random(10);
  float ry = random(10);
  if (x > 575)
  {
    vx = -rx;
    vy = ry;
  }
  if (y > 575)
  {
    vy = -ry;
  }
  if (x < 25)
  {
    x = 25;
    vx = rx;
    vy = ry;
  }
  if (y < 25)
  {
    y = 25;
    vy = ry;
    vx = rx;
  } 
}