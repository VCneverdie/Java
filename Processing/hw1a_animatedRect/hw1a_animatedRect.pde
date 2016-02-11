/**
  *@author: Ying Cui
 */

void setup()
{
  size(600,600);
}
int x = 0;
int y = 0;
int speed = 3;
int vx = speed;
int vy = 0;
void draw()
{
  background(7, 54, 66); // the color scheme of solarized can protect eyes.
  fill(133, 153, 0);
  //fill (R,G,B, TRANSPARENT10OR)
//rect like window
//rect
// trial patically
  stroke(147, 161, 161);
  strokeWeight(2);
  rect(x, y, 100, 100);
  x = x + vx;
  y = y + vy;
  if (x > 499)
  {
    vx = 0;
    vy = speed;
  }
  if (y > 499)
  {
    vy = 0;
    vx = -speed;
  }
  if (x < 1)
  {
    vx = 0;
    vy = -speed;
  }
  if (y < 0)
  {
    y = 0;
    vy = 0;
    vx = speed;
  }  
}