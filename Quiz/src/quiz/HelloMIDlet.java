/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Aumrudh
 */
public class HelloMIDlet extends MIDlet implements CommandListener {
    
 // private boolean midletPaused = false;
  private Display display;
  private Form f,f1,f2,f3,fin;
  private Command exit, choose,start,back,finish,done;
  private ChoiceGroup topic,q1,q2,q3,q4;
  private Gauge g1;
  private Ticker t1;
  private TextField tf1,tf2;
  private StringItem st;
  public int count=0;

//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Form form;
    private StringItem stringItem;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
        display = Display.getDisplay(this);
        
        st=new StringItem("Total correct answers","0");
        
        topic = new ChoiceGroup("Select Topic", Choice.EXCLUSIVE);
        topic.append("OS", null);
        topic.append("DS", null);
        
        tf1=new TextField("Name","",20,TextField.ANY);
        tf2=new TextField("Dept","",20,TextField.ANY);
        
        start = new Command("Start", Command.SCREEN, 1);
        back = new Command("Back", Command.BACK, 1);
        exit = new Command("Exit", Command.EXIT, 1);
        choose = new Command("Choose", Command.SCREEN, 1);  
        finish = new Command("Finish Test", Command.OK, 1); 
        done = new Command("Close", Command.OK, 1); 
        
        t1 = new Ticker("Quiz");
        
        g1=new Gauge("Difficilty",true,10,1);
        
        q1=new ChoiceGroup("Which of the following windows does not have a start button?",Choice.EXCLUSIVE);
        q1.append("Windows XP",null);
        q1.append("Windows 7",null);
        q1.append("Windows 8",null);
        q1.append("Windows 10",null);
        
        q3=new ChoiceGroup("Which of the following is not an operating system?",Choice.EXCLUSIVE);
        q3.append("Windows",null);
        q3.append("Linux",null);
        q3.append("Oracle",null);
        q3.append("DOS",null);
        
        q2=new ChoiceGroup("Which one of the following is the process of inserting an element in the stack?",Choice.EXCLUSIVE);
        q2.append("Insert",null);
        q2.append("Add",null);
        q2.append("Push",null);
        q2.append("Append",null);
        
        q4=new ChoiceGroup("Which one of the following is the size of int arr[9] assuming that int is of 4 bytes?",Choice.EXCLUSIVE);
        q4.append("9",null);
        q4.append("18",null);
        q4.append("35",null);
        q4.append("36",null);
 }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
}//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {
//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        String label = command.getLabel();
        if (command==choose) {
          System.out.println("Hi "+(topic.getSelectedIndex()));    
         // if( "OS".equals(topic.getString(topic.getSelectedIndex()))){
            if(0==topic.getSelectedIndex()){
            System.out.print("os");
            display.setCurrent(f2);
          }
       //   else if( "DS".equals(topic.getString(topic.getSelectedIndex()+2))){
           else if(1==topic.getSelectedIndex()){  
          System.out.print("DS");
             display.setCurrent(f3);
          }
        } 
        else if (label.equals("Exit")){
           exitMIDlet();
        }
        else if(label.equals("Back")){
            display.setCurrent(f1);
        }
        else if(command==start){
            display.setCurrent(f1);
        }
        else if(command==finish){
            if(displayable==f2){
                if(q1.getSelectedIndex()==2){
                    count+=1;
                }
                if(q3.getSelectedIndex()==2){
                    count+=1;
                }
            }
            else if(displayable==f3){
                if(q2.getSelectedIndex()==2){
                    count+=1;
                }
                if(q4.getSelectedIndex()==3){
                    count+=1;
                }
                
            }
            st.setText(String.valueOf(count));
            fin.append(st);
            display.setCurrent(fin);
        }
        else if(command==done){
            exitMIDlet();
        }
        if (displayable == form) {//GEN-BEGIN:|7-commandAction|1|19-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|19-preAction
                // write pre-action user code here
exitMIDlet();//GEN-LINE:|7-commandAction|2|19-postAction
                // write post-action user code here
}//GEN-BEGIN:|7-commandAction|3|7-postCommandAction
        }//GEN-END:|7-commandAction|3|7-postCommandAction
        // write post-action user code here
}//GEN-BEGIN:|7-commandAction|4|
//</editor-fold>//GEN-END:|7-commandAction|4|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {
//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
}//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|18-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
form = new Form("Welcome", new Item[]{getStringItem()});//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
}//GEN-BEGIN:|14-getter|2|
        return form;
    }
//</editor-fold>//GEN-END:|14-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|16-getter|0|16-preInit
    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
//GEN-END:|16-getter|0|16-preInit
            // write pre-init user code here
stringItem = new StringItem("Hello", "Hello, World!");//GEN-LINE:|16-getter|1|16-postInit
            // write post-init user code here
}//GEN-BEGIN:|16-getter|2|
        return stringItem;
    }
//</editor-fold>//GEN-END:|16-getter|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        f = new Form("Welcome");
        f.append(tf1);
        f.append(tf2);
        f.setTicker(t1);
        f.addCommand(start);
        f.addCommand(back);
        f.setCommandListener(this);
        
        f1 = new Form("Topic");
        f1.append(topic);
        f1.addCommand(exit);
        f1.addCommand(back);
        f1.addCommand(choose);
        f1.setCommandListener(this);
        
        f2=new Form("OS");  
        f2.append(q1);  
        f2.append(q3);
        f2.addCommand(back);
        f2.addCommand(finish);
        f2.setCommandListener(this);
        
        f3=new Form("DS");
        f3.append(q2);
        f3.append(q4);
        f3.addCommand(back);        
        f3.addCommand(finish);
        f3.setCommandListener(this);
        
        fin=new Form("Result");
        fin.append(g1);
        fin.addCommand(exit);
        fin.addCommand(done);
        fin.setCommandListener(this);
        
        display.setCurrent(f);
        
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
     //   midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}
