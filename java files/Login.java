import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.*;
import java.lang.*;
import java.util.List;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {
    static final Object wait = new Object();
    public String type1;
    public String name;
    public boolean flag;
    public JFrame f;
    public JLabel l1,l2,l3;
    public JTextField t1,t2;
    public JButton b;
    List<List<String>> userList=new ArrayList<List<String>>();

    public void LoginWindow() {
        flag=false;
        try{
            File myObj = new File("D:/Assignments/SER 515/Design patterns/BuyerInfo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                List<String> ll=new ArrayList<String>();
                String data = myReader.nextLine();
                String[] parts=data.split(":");
                ll.add("buyer");
                ll.add(parts[0]);
                ll.add(parts[1]);
                userList.add(ll);
            }
            myReader.close();
            File myObj1 = new File("D:/Assignments/SER 515/Design patterns/SellerInfo.txt");
            Scanner myReader1 = new Scanner(myObj);
            while (myReader1.hasNextLine()) {
                List<String> ll=new ArrayList<String>();
                String data = myReader1.nextLine();
                String[] parts=data.split(":");
                ll.add("seller");
                ll.add(parts[0]);
                ll.add(parts[1]);
                userList.add(ll);
            }
            myReader1.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        f=new JFrame("PTBS");
        l1=new JLabel("Login");
        l1.setBounds(450,10, 200,200);
        l2=new JLabel("Username");
        l2.setBounds(420,150, 100,30);
        l3=new JLabel("Password");
        l3.setBounds(420,200, 100,30);


        t1=new JTextField("");
        t1.setBounds(520,150, 100,20);
        t2=new JTextField("");
        t2.setBounds(520,200, 100,20);

        b=new JButton("login");
        b.setBounds(520,250,100, 20);
        f.add(t1);
        f.add(t2);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(b);
        f.setSize(1000,1000);
        b.addActionListener(this);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        String user=t1.getText();
        String pass=t2.getText();
        for (List<String> list : userList)
        {
            if((list.get(1).equals(user) && (list.get(2)).equals(pass)))
            {
                this.type1=list.get(0);
                this.flag=true;
                this.name=list.get(1);
            }
        }
        f.dispose();
        synchronized (wait) {
            wait.notify();
        }
    }
    public void waitTime(){
        //wait
        try {
            synchronized (wait) {
                wait.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
