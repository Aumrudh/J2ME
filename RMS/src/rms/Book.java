/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javax.microedition.midlet.*; 
import javax.microedition.lcdui.*; 
import javax.microedition.io.*; 
import javax.microedition.rms.*; 
import java.io.*; 

/**
 * @author Aumrudh
 */
public class Book extends MIDlet implements CommandListener { 
 private RecordStore rs = null; 
 private RecordEnumeration re = null; 
 static final String records = "Bookstore"; 
 public Form form; 
 public Command insert,search, delete,viewBook, update,exit,back; 
 public Displayable d; 
 public Display display; 
 public TextField textfield1, textfield2, textfield3,textfield4; 
 public StringItem s1, s2, s3, s4, s5; 
 public Book() { 
    display = Display.getDisplay(this); 
    
    form = new Form("BookStore"); 
    
    textfield1 = new TextField("Book ID :", "", 200, TextField.ANY); 
    textfield2 = new TextField("Book Name :", "", 200, TextField.ANY); 
    textfield3 = new TextField("Author_Name :", "", 200, TextField.ANY); 
    textfield4 = new TextField("Book Category :", "", 200, TextField.ANY); 
    
    form.append(textfield1); 
    form.append(textfield2); 
    form.append(textfield3); 
    form.append(textfield4); 
    
    insert = new Command("Insert", Command.OK, 1); 
    search = new Command("Search", Command.OK, 1); 
    delete = new Command("Delete", Command.OK, 1); 
    viewBook = new Command("Display", Command.OK, 1); 
    update = new Command("Update", Command.OK, 1); 
    exit = new Command("Exit", Command.EXIT, 1); 
    back = new Command("Back", Command.BACK, 1); 
    
    s1 = new StringItem("", ""); 
    s2 = new StringItem("", ""); 
    s3 = new StringItem("", ""); 
    s4 = new StringItem("", ""); 
    s5 = new StringItem("", ""); 
    
    form.append(s1); 
    form.append(s2); 
    form.append(s3); 
    form.append(s4); 
    form.append(s5); 
    
    form.addCommand(insert); 
    form.addCommand(search); 
    form.addCommand(delete); 
    form.addCommand(update); 
    form.addCommand(viewBook); 
    form.addCommand(exit); 
    form.addCommand(back); 
    
    form.setCommandListener(this); 
 } 
 public void startApp() { 
    openRecStore(); 
    display.setCurrent(form); 
 } 
 
 public void pauseApp() {} 
 
 public void destroyApp(boolean unconditional) { 
    notifyDestroyed(); 
 } 
 public void commandAction(Command cmd, Displayable d) { 
    
    if (cmd == insert) { 
        int bid =Integer.parseInt(textfield1.getString()); 
        String book = (textfield2.getString());
        String author = (textfield3.getString());
        String jour = (textfield4.getString());
    
        clearString(); 
        insert(bid, book,author,jour); 
    }
    else if (cmd == delete) { 
        int bid =Integer.parseInt(textfield1.getString()); 
        clearString(); 
        delete(bid); 
    }
    else if (cmd == search) { 
        String book = (textfield2.getString());
        clearString(); 
        searchBook(book); 
    } 
    else if (cmd == viewBook) { 
        clearString(); 
        viewBook(); 
    } 
    else if (cmd == exit) { 
        clearString(); 
        closeRecStore(); 
        destroyApp(false); 
        notifyDestroyed(); 
    } 
    else if (cmd == update) { 
        int bid =Integer.parseInt(textfield1.getString()); 
        String book = (textfield2.getString());
        String author = (textfield3.getString());
        String jour = (textfield4.getString());
        clearString(); 
        updateBookStore(bid, book,author,jour); 
        viewBook(); 
    } 
 } 
 public void clearString() { 
    s1.setText(""); 
    s2.setText(""); 
    s3.setText(""); 
    s4.setText(""); 
    s5.setText("");
    textfield1.setString("");
    textfield2.setString("");
    textfield3.setString("");
    textfield4.setString("");
 } 
 public void openRecStore() { 
    try { 
        rs = RecordStore.openRecordStore(records, true); 
    }
    catch (Exception e) { 
        System.out.println("opening error" + e);
    } 
 } 
 public void closeRecStore() { 
    try { 
       rs.closeRecordStore(); 
    }
    catch (Exception e) { 
        System.out.println("closing error" + e);
    } 
 } 
 public void deleteRecStore() {  //delete whole
    try { 
        closeRecStore(); 
        rs.deleteRecordStore(records); 
        s3.setText("All the records,Deleted!!"); 
    }
    catch (Exception e) { 
        e.printStackTrace(); 
        s3.setText("Error"); 
    } 
 } 
 public void insert(int bid, String book,String author,String jour) { 
    int recId; 
    ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
    DataOutputStream outputStream = new DataOutputStream(baos); 
    try{ 
        outputStream.writeInt(bid); 
        outputStream.writeUTF(book); 
        outputStream.writeUTF(author); 
        outputStream.writeUTF(jour);  
    }
    catch (IOException ioe) { 
        System.out.println(ioe); 
    } 
    byte[] b = baos.toByteArray(); 
    try { 
        recId = rs.addRecord(b, 0, b.length); 
        s2.setText("Inserted Successfully"); 
    } 
    catch (RecordStoreException rse) { 
        System.out.println(rse); 
        rse.printStackTrace(); 
        s2.setText("Not inserted"); 
    } 
 } 
  
 private void viewBook() { 
    int flag=0;
    try{ 
        int bid; 
        String book,author,jour; 
        String result = new String(""); 
        re = rs.enumerateRecords(null, null, false); 
        while (re.hasNextElement()) { 
            int id = re.nextRecordId(); 
            ByteArrayInputStream bais = new ByteArrayInputStream(rs.getRecord(id)); 
            DataInputStream inputStream = new DataInputStream(bais); 
            try { 
                bid = inputStream.readInt(); 
                book = inputStream.readUTF(); 
                author = inputStream.readUTF(); 
                jour = inputStream.readUTF(); 
                //System.out.println(bid + " = " + book + " = " + author +); 
                result += "Book Number:" + bid + " " + "Book Name:" + book + " " + "Author Name:" + author + " " + "Journel:" + jour + "\n"; 
            }
            catch (EOFException eofe) { 
                flag=1;
                System.out.println(eofe); 
            } 
        }
        if(flag==1)
            s1.setText("No Books Found");
        s1.setText(result); 
    } 
    catch (Exception ioe) { 
        System.out.println(ioe); 
        s1.setText("No Books Found");
    } 
 } 
 
 private void updateBookStore(int bid, String book,String author,String jour) { 
    ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
    DataOutputStream outputStream = new DataOutputStream(baos); 
    try { 
        int res1; 
        String res2,res3,res4; 
        String result = new String(""); 
        re = rs.enumerateRecords(null, null, false); 
        while (re.hasNextElement()) { 
            int id = re.nextRecordId(); 
            ByteArrayInputStream bais = new ByteArrayInputStream(rs.getRecord(id)); 
            DataInputStream inputStream = new DataInputStream(bais); 
            try { 
                res1 = inputStream.readInt(); 
                res2 = inputStream.readUTF(); 
                res3 = inputStream.readUTF();
                res4 = inputStream.readUTF();
                System.out.println(res1 + " " + res2); 
                if (res1 == bid) { 
                    try { 
                        outputStream.writeInt(bid); 
                        outputStream.writeUTF(book); 
                        outputStream.writeUTF(author);
                        outputStream.writeUTF(jour);                        
                        } 
                    catch (IOException ioe) { 
                        System.out.println(ioe); 
                        ioe.printStackTrace(); 
                    } 
                    byte[] b = baos.toByteArray(); 
                    try{ 
                        rs.setRecord(id, b, 0, b.length); 
                        s4.setText("Modified Successfully"); 
                    }
                    catch (RecordStoreException rse) { 
                        System.out.println(rse); 
                        rse.printStackTrace(); 
                        s4.setText("Not Modified"); 
                    } 
                } 
            }
            catch (EOFException eofe) { 
                System.out.println(eofe); 
           } 
        } 
    } 
    catch (Exception rse) { 
        System.out.println(rse); 
        rse.printStackTrace(); 
    } 
 } 
 private void searchBook(String book) { 
    try { 
        int  res1, id; 
        String res2,res3,res4,result=""; 
        int found = 0; 
        re = rs.enumerateRecords(null, null, false); 
        while (re.hasNextElement()) { 
            id = re.nextRecordId(); 
            ByteArrayInputStream bais = new ByteArrayInputStream(rs.getRecord(id)); 
            DataInputStream inputStream = new DataInputStream(bais); 
            try { 
                res1 = inputStream.readInt(); 
                res2 = inputStream.readUTF(); 
                res3 = inputStream.readUTF(); 
                res4 = inputStream.readUTF(); 
                if (res2.equals(book)) { 
                    found = 1; 
                    //System.out.println(res1 + " = " + res2 + " = " + r); 
                    result = "Book Number:" + res1 + " " + "Book Name:" + res2 + " " + "Author Name:" + res3 + " " + "Journel:" + res4 + "\n"; 
                    s5.setText("Book Found.\n" + result); 
                    break; 
                } 
            } 
            catch (EOFException eofe) { 
                System.out.println(eofe); 
                eofe.printStackTrace(); 
            } 
        } 
        if (found == 1){}
        else { 
            s5.setText("Book not found!!"); 
        } 
    } 
    catch (Exception rse) { 
        System.out.println(rse); 
        rse.printStackTrace(); 
        s5.setText("Error"); 
    }
 } 
 private void delete(int bid) { 
    try { 
        int res1, r; 
        String res2; 
        re = rs.enumerateRecords(null, null, false); 
        while (re.hasNextElement()) { 
            int id = re.nextRecordId(); 
            ByteArrayInputStream bais = new ByteArrayInputStream(rs.getRecord(id)); 
            DataInputStream inputStream = new DataInputStream(bais); 
            try { 
                res1 = inputStream.readInt(); 
                res2 = inputStream.readUTF(); 
                r = inputStream.readInt(); 
                if (res1 == bid) { 
                    rs.deleteRecord(id); 
                    break; 
                }                
            }
            catch (EOFException eofe) { 
                System.out.println(eofe); 
                eofe.printStackTrace(); 
            } 
        } 
        s3.setText("Book deleted"); 
    } 
    catch (Exception rse) { 
        rse.printStackTrace(); 
        s3.setText("Error"); 
    } 
 } 
} 


