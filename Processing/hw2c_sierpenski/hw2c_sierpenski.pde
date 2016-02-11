/*
 *@author: Ying Cui
 */

void setup()
{
  size(600, 600);
  frameRate(1);
}

void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int level)
{
  if (level < 0)
    return;
  triangle(x1, y1, x2, y2, x3, y3);
  level--;
  sierpinski(x1, y1, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, y3, level);
  sierpinski((x1 + x2)/2, (y1 + y2)/2, x2, y2, (x2 + x3)/2, (y1 + y2)/2, level);
  sierpinski((x1 + x3)/2, y3, (x2 + x3)/2, (y1 + y2)/2, x3, y3, level);
}

int lev = 0;
void draw()
{
  sierpinski(0, height, width/2, 0, width, height, lev);
  lev++;
  if (lev > 8)
   lev = 0;
}