/*
 *@author: Ying Cui
 *@param: x and y are the coordinate of the shape;
 *@param d: the size ratio of new one and old one;
 *@param level: the iteration times.
 */

void setup()
{
  size(600, 600);
  background(0);
  stroke(255);
  noFill();
  frameRate(1);
  translate(300, 300);
}
// one triangle creates two other triangels.
void saveKoch(float x, float y, float d, int level)
{
  pushMatrix(); // use push and pop save images into matrix stack
  translate(x, y);
  translate(-d/2, d/3*sin(PI/3));
  kochCurve(d, level);
  translate(d, 0);
  rotate(-2 * PI/3);
  kochCurve(d, level);
  translate(d, 0);
  rotate(-2 * PI/3);
  kochCurve(d, level);
  popMatrix();
}

void kochCurve(float x, int level)
{
  if (level < 0)
    return;
   beginShape();
   vertex(0, 0);
   vertex(x/3, 0);
   vertex(x/2, x/3*sin(PI/3));
   vertex(2*x/3, 0);
   vertex(x, 0);
   endShape();
   level--;
   kochCurve(x/3, level);
   pushMatrix();
   translate(x/3, 0);
   rotate(PI/3);
   kochCurve(x/3, level);
   translate(x/3, 0);
   rotate(-2 * PI/3);
   kochCurve(x/3, level);
   translate(x/3, 0);
   rotate(PI/3);
   kochCurve(x/3, level);
   popMatrix();
}

int level = 0;
void draw()
{
   saveKoch(width/2, height/2, width * 0.7, level);
   level++;
   if (level > 7)
   {
     level = 0;
     background(0);
   }
}