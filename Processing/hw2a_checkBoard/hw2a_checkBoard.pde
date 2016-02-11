/*
 *@author: Ying Cui
 *After clicking on the board, it will be checked by a red circle.
 */
void setup()
{
  size(600, 600);
  frameRate(200);
}

final int N = 8;
float mx = -100;
float my = -100;
void draw()
{
  final int BOX = width/N;
  final float SMALLCIRCLE = BOX * 0.618;
  color WHITE = color(255);
  color BLACK = color(0);
  boolean bx = false;
  // draw the checkboard
  for (int y = 0; y < height; y += BOX)
  {
    bx = !bx;
    for (int x = 0; x < width; x += BOX)
    {
      fill(bx ? BLACK : WHITE);
      noStroke();
      rect(x, y, BOX, BOX);
      bx = !bx;
    }
  }
  // draw a red circle by click
  for (int i = 0; i < N; i++)
  {
    if (mx >= i * BOX && mx < (i+1) * BOX)
      mx = (i + 0.5) * BOX;
    if (my >= i * BOX && my < (i+1) * BOX)
      my = (i + 0.5) * BOX;
    fill(0, 0, 0, 0); // make it like a ring
    stroke(255, 0, 0);
    strokeWeight(2);
    ellipse(mx, my, SMALLCIRCLE, SMALLCIRCLE);
  }
}

void mouseClicked()
{
  if (mouseButton == LEFT)
  {
     mx = mouseX;
     my = mouseY;
  }
}