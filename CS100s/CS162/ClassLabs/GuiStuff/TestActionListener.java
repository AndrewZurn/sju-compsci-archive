import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class TestActionListener extends JFrame implements ActionListener 
{ 
        JButton A,B,C;                                            //We have a class with multiple buttons, a menu bar, 
        JMenuBar MyMenuBar;                               // some menus and some menu items 
        JMenu FileMenu,HelpMenu; 
        JMenuItem OpenFileItem,CloseFileItem,OpenHelpItem, 
                                CloseHelpItem; 
        JTextField Field1; 

        public static void main(String [] Args) 
        { 
                TestActionListener T=new TestActionListener(); 
                T.setVisible(true); 
        } 

        public TestActionListener() 
        { 
                A=new JButton("A");                            //Notice when we create "actionable" items we 
                A.addActionListener(this);                      // addActionListener(this). This says, use "this" 
                B=new JButton("B");                             // - the object of class TestActionListener - as 
                B.addActionListener(this);                      // an ActionListener. 
                C=new JButton("C"); 
                C.addActionListener(this); 
                MyMenuBar=new JMenuBar(); 
                FileMenu=new JMenu("File"); 
                HelpMenu=new JMenu("Help"); 
                MyMenuBar.add(FileMenu); 
                MyMenuBar.add(HelpMenu); 
                setJMenuBar(MyMenuBar); 
                OpenFileItem=new JMenuItem("Open File"); 
                OpenFileItem.addActionListener(this); 
                CloseFileItem=new JMenuItem("Close File"); 
                CloseFileItem.addActionListener(this); 
                FileMenu.add(OpenFileItem); 
                FileMenu.add(CloseFileItem); 
                OpenHelpItem=new JMenuItem("Open File Help"); 
                OpenHelpItem.addActionListener(this); 
                CloseHelpItem=new JMenuItem("Close File Help"); 
                CloseHelpItem.addActionListener(this); 
                HelpMenu.add(OpenHelpItem); 
                HelpMenu.add(CloseHelpItem); 
                Field1=new JTextField(12); 
                Field1.addActionListener(this); 
                Container Pane=getContentPane(); 
                Pane.add(A,"West"); 
                Pane.add(B,"Center"); 
                Pane.add(C,"East"); 
                Pane.add(Field1,"South"); 
                setSize(400,200); 
               addWindowListener(new WindowAdapter() 
              {  public void windowClosing(WindowEvent e) 
                    {  System.exit(0); 
                    } 
                 } ); 
        } 

        /** 
         * Notice that actionPerformed does all of the action definitions by using the "source" 
         * (that is, the part of the object that caused the event) and, then, by comparison 
         * determines which action should be taken. That is, if the source was A then whatever 
         * you wanted to do for action A should be taken. 
         */ 
        public void actionPerformed(ActionEvent e) 
        { 
                Object source=e.getSource(); 
                if(source==A) 
                { 
                  String s="";
                  for(int i=0;i<10;i++) {
                    s=s+"A";
                  }
                  Field1.setText(s);
                } 
                else if(source==B) 
                { 
                        Field1.setText("B Button"); 
                } 
                else if(source==C) 
                { 
                        Field1.setText("C Button"); 
                } 
                else if(source==OpenFileItem) 
                { 
                        Field1.setText("Open File"); 
                } 
                else if(source==CloseFileItem) 
                { 
                        Field1.setText("Close File"); 
                } 
                else if(source==OpenHelpItem) 
                { 
                        Field1.setText("Open Help"); 
                } 
                else if(source==CloseHelpItem) 
                { 
                        Field1.setText("Close Help"); 
                } 
                else if(source==Field1) {
                  Field1.setText("Don't mess with me");
                }
        } 
} 
  
