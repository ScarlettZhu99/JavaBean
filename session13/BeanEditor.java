
package session13;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Haiping Zhu
 */
public class BeanEditor extends JFrame {
    private JTextArea a1,a2;
    private JTextField t1,t2;
    private String Firstname,Lastname;
    public BeanEditor(Object obj) {
        super("Bean Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        Container c = getContentPane();
        JPanel p = new JPanel();
        c.add(p, BorderLayout.CENTER);
        p.setLayout(new GridLayout(2, 2));
        // write your loop here
        //       p.add( ..)
        a1=new JTextArea("First Nane:");
        a2=new JTextArea("Last Nane:");
        t1=new  JTextField();
         t2=new  JTextField();
        p.add(a1);
        p.add(t1);
        p.add(a2);
        p.add(t2);
        
        t1.addActionListener(new FirstNameListener());
        t2.addActionListener(new LastNameListener());
        
        
        setVisible(true);
    }
    class FirstNameListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
          Firstname=t1.getText();
          try {    
              ChangeFirstName(Firstname);
          } catch (Exception ex) {
              Logger.getLogger(BeanEditor.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    
    class LastNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Lastname=t2.getText();
            try {
                ChangeLastName(Lastname);
            } catch (Exception ex) {
                Logger.getLogger(BeanEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public static void ChangeFirstName(String fString) throws Exception{
        String className = "session13.JavaBean2";
        Class c = Class.forName(className);
        Constructor constructor = c.getConstructor();
        Object obj = constructor.newInstance();
        Method m = c.getMethod("setFirstName", java.lang.String.class);
        m.invoke(obj, fString);
        System.out.println(fString+" ");
        
    }
    public static void ChangeLastName(String lString)throws Exception{
        String className = "session13.JavaBean2";
        Class c = Class.forName(className);
        Constructor constructor = c.getConstructor();
        Object obj = constructor.newInstance();
        Method m = c.getMethod("setLastName", java.lang.String.class);
        m.invoke(obj, lString);
        System.out.println(" "+lString);
    }
    
    
    
    
    
    public static  void main(String[] args)throws Exception {
        new BeanEditor(new JavaBean2());
        
    }
}