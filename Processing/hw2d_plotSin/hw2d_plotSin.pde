/*
 *@author: Ying Cui
 *The graph starts at the left middle of windows.
 */

void setup()
{
  size(600, 600);
}

void draw()
{
  translate(0, height/2);
  scale(width/(10*PI), -height/2);
  strokeWeight(0.05);
  float dx = 10 * PI / width;
  for (float x = 0; x < 10 * PI; x += dx)
  {
    float y = sin(x) + 1/3 * sin(3*x) + 1/5 * sin(5*x) + 1/7 * sin(7*x) + 1/9 * sin(9*x);
    point(x, y);
  }
}