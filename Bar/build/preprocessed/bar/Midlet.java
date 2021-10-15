/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Sriram
 */
public class Midlet extends MIDlet implements CommandListener {
    private Form form;
    private Display display;
    private BarGraphCanvas bargraph;
    private Command next;
    private int dataset2[],dataset1[];
    private double d2[]=new double[]{1.2,5.6,8,9};
    private int maxX,maxY;
    private TextField t1,t2,t3,t4;
    public Midlet(){
        display = Display.getDisplay(this);
        form=new Form("CGPA");
        t1 = new TextField("Sem 1 :", "", 200, TextField.ANY); 
        form.append(t1); 
        t2 = new TextField("Sem 2 :", "", 200, TextField.ANY); 
        form.append(t2); 
        t3 = new TextField("Sem 3 :", "", 200, TextField.ANY); 
        form.append(t3); 
        t4 = new TextField("Sem 4 :", "", 200, TextField.ANY); 
        form.append(t4); 
        next = new Command("See Bar Graph", Command.OK, 1); 
        form.addCommand(next);
        form.setCommandListener(this);       
    }
    public void startApp(){
     display = Display.getDisplay(this);
     display.setCurrent(form);
    }
    public  void pauseApp(){}
    public void destroyApp(boolean unconditional){}

    public void commandAction(Command c, Displayable d) {
        if(c==next){
            display = Display.getDisplay(this);
            dataset2 = new int[]{1,2,3,4,5,6,7,8,9,10};
            dataset1 = new int[]{Integer.parseInt(t1.getString()),Integer.parseInt(t2.getString()),Integer.parseInt(t3.getString()),Integer.parseInt(t4.getString())};
            
            maxX = Math.max(dataset1.length,dataset2.length)-1;
            maxY = 0;
            
            for(int i = 0; i<dataset2.length; i++)
                maxY = Math.max(maxY,dataset2[i]);
            maxY += 10;
            
            bargraph = new BarGraphCanvas(dataset1,dataset2,maxX,maxY);
            display.setCurrent(bargraph);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
