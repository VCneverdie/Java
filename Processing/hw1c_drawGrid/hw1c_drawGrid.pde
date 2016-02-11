void setup()
{
  background(255);
  size(800, 800);
}
// Draw grid.
int n = 100; // n can be changed to any value to draw a n * n grid.
void draw()
{
  background(255);
  for (int x = 0; x < width; x += width / n)
    line(x, 0, x, height);
  for (int y = 0; y < height; y += height / n)
    line(0, y, width, y);
}
// when press mouse button, number of n changes.
void mousePressed(){
  if (mouseButton == LEFT)
    n /= 2;
  else
    n = 2;
}