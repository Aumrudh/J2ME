package ball;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class BallGame extends MIDlet {
    private Display display;
    private CanvasKey canvas;
    private String keyValue = null;
    private int translateX = 100;
    private int translateY = 120;

    public BallGame() {
        display = Display.getDisplay(this);
        canvas  = new CanvasKey(this);
    }        
    public void startApp() {
       // Canvas canvas = new CanvasKey();
        display = Display.getDisplay(this);
        display.setCurrent(canvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    private void exitMIDlet() {
        destroyApp(true);
    }
class CanvasKey extends Canvas implements CommandListener{
      private Command exit;
      private Font font;
      private String message = "";
      private BallGame midlet;
      int i=0;

  public CanvasKey(BallGame midlet){
      this.midlet = midlet;
      exit = new Command("Exit", Command.EXIT, 1);
    addCommand(exit);
    setCommandListener(this);
 // font = Font.getFont(Font.FACE_PROPORTIONAL, 
   //Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
  }
  
protected void keyPressed(int keyCode){   

  keyValue = getKeyName(keyCode); 
  message = keyValue;
  if(keyValue.equals("Right")){
      translateX+=10; 
      run();
  }
  if(keyValue.equals("Left")){
      translateX-=10;
      run();
  }
  if(keyValue.equals("Up")){
      translateY-=10;
      run();
  }
  if(keyValue.equals("Down")){
      translateY+=10;
      run();
  }
   if(translateX == 200 || translateY == 250 ||translateX == 0 || translateY == 0 ){
    i+=1;
    translateX=100;
    translateY=120;
    run();
    System.out.println("Game over :");
    if(i==3){
    destroyApp(false);
      notifyDestroyed();
    }
    //y end 255 x end 200
  }
   System.out.println("TransX  :"+translateX +"   TransY  :"+translateY);
  
    

}
public void run(){
    repaint();
}

  public void rpaint(Graphics g){
  int width = getWidth();
  int height = getHeight();

  
  //g.fillRect(0, 0, 10, 10);
  g.setColor(255,255, 255);
  g.drawRect(15,10,width-35, height-40);
  g.setColor(0, 0, 255);
  
  //g.setFont(font);
  //int xco = g.getTranslateX();
  //int yco = g.getTranslateY();
  g.translate(translateX+50,translateY+50);
  g.drawArc(translateX, translateY, 40, 40, 0, 360);
  g.fillArc(translateX,translateY, 40,40, 0, 360);
  //int x = width / 2;
  //int y = height / 2;
 // repaint(); 
  
 // g.drawString(message, x, y, Graphics.BASELINE | Graphics.HCENTER);
 // g.drawArc(x, y, xco+10,yco-40,0,360);
  }
   protected void paint(Graphics g){
  g.setColor(255, 255, 255);
  g.drawRect(15,10,getWidth()-35, getHeight()-40);
  g.drawRect(10,10,getWidth()-35, getHeight()-40);
  g.fillRect(0, 0, getWidth(), getHeight());
  if (keyValue != null){
  g.setColor(255, 0, 0);
  //g.drawString(keyValue, getWidth()/2, getHeight()/2,  Graphics.TOP | Graphics.HCENTER);

  g.drawArc(translateX,translateY, 40, 40, 0, 360);
  g.fillArc(translateX,translateY, 40,40, 0, 360);
    
  }
  }

        public void commandAction(Command c, Displayable d) {
            if (c == exit)
            midlet.exitMIDlet();
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
  }
}

