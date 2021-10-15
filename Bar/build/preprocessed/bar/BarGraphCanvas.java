package bar;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public class BarGraphCanvas extends Canvas{
 
 private int[] dataset1,dataset2;
 private int maxX,maxY;
 private int width,height,deltaX,deltaY;

 public BarGraphCanvas(int[] dataset1,int[] dataset2,int maxX,int maxY){
  this.dataset1 = dataset1;
  this.dataset2 = dataset2;

  this.maxX = maxX;
  this.maxY = maxY;
 }

 public void paint(Graphics g){

  int barwidth = 15;  
  width = getWidth();
  height = getHeight();

  deltaX = width/(maxX+1);
 
  deltaY = height/maxY;
 
  g.setColor(0,255,255);
  g.fillRect(0,0,width,height);

  g.setColor(0,50,0);
  g.drawLine(0,0,0,height-1);
  g.drawLine(0,height-1,width,height-1);
  int j=0;
  for(int i = 0; j <= maxY; i++,j+=10)
   g.drawString((""+j+""),0,height-(i*deltaY*10+10),Graphics.TOP|Graphics.LEFT);

  for(int i = 0;i < maxX+1; i++){
   g.drawString((" "+dataset1[i]+""),10+i*deltaX,height-(deltaY*dataset1[i]+10),Graphics.TOP|Graphics.RIGHT);
   g.fillRect(10+i*deltaX,height -deltaY*dataset1[i],barwidth,deltaY*dataset1[i]);
   }
  g.setColor(255,0,0);
 
 }

}