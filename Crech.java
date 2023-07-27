
package ac.za.tut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Crech extends JFrame 
{
    private JLabel nameLabel, genderLabel;
    private JTextField nametextfield;
    private JRadioButton maleradiobutton, femaleradiobutton;
    private JTextArea displaytextarea;
    private JButton registerbutton, displaybutton;
    private ButtonGroup butngroupl;
    private JScrollPane scrollpane;
    private JPanel namepanel,genderpanel, buttonspanel, textareapanel, namegenderbuttonspanel, mainpanel;
    private ArrayList<kiddie> kids;

    public Crech() 
    {
        setTitle("Creche for your kiddie");
        setSize(400, 550);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        kids = new ArrayList<>();
        
        //labels
        nameLabel = new JLabel("Name:    ");
        genderLabel = new JLabel("Gender:    ");
        
        //textfield
        nametextfield = new JTextField(10);
        
        //radio buttons
        maleradiobutton = new JRadioButton("Male");
        femaleradiobutton = new JRadioButton("Female");
        
        //teext area
        displaytextarea = new JTextArea(20, 30);
        displaytextarea.setEditable(false);
        displaytextarea.setBorder(new LineBorder(Color.BLACK, 1));
        
        
        //buttons
        registerbutton = new JButton("Register kiddie");
        registerbutton.addActionListener(new register());
        
        
        displaybutton = new JButton("Display kiddies");
        displaybutton.addActionListener(new DisplayKiddiesBtnHandler());
        
        //
        butngroupl = new ButtonGroup();
        butngroupl.add(maleradiobutton);
        butngroupl.add(femaleradiobutton);       
        
        //scrool pane
        scrollpane = new JScrollPane(displaytextarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        //panels
        namepanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namepanel.add(nameLabel);
        namepanel.add(nametextfield);
        
        genderpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderpanel.add(genderLabel);
        genderpanel.add(maleradiobutton);
        genderpanel.add(femaleradiobutton);
        
        buttonspanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonspanel.add(registerbutton);
        buttonspanel.add(displaybutton);
        
        textareapanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textareapanel.add(scrollpane);
        
        namegenderbuttonspanel = new JPanel(new GridLayout(3,1));
        namegenderbuttonspanel.add(namepanel);
        namegenderbuttonspanel.add(genderpanel);
        namegenderbuttonspanel.add(buttonspanel);
        
        
        mainpanel = new JPanel(new BorderLayout());
        mainpanel.add(namegenderbuttonspanel, BorderLayout.NORTH);
        mainpanel.add(textareapanel, BorderLayout.SOUTH);
        
        add(mainpanel);
        
        pack();
        setVisible(true);
    }
    
    private class register implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
          String name = nametextfield.getText();
          String gender = "Male";
          
          if(femaleradiobutton.isSelected())
          {
              gender = "Female";
          }
          
          kiddie kid = new kiddie(name, gender);
          kids.add(kid);
          
          //set the fields to nothing
          nametextfield.setText("");
          butngroupl.clearSelection();
        }
    
    }
    
     private class DisplayKiddiesBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) 
{
            String name, gender, regKiddie = "";
            
            for(kiddie kiddie:kids)
	    {
                name = kiddie.getName();
                gender = kiddie.getGender();
                regKiddie = regKiddie + "\nName: " + name + "\nGender: " + gender + "\n";
            }
            
            displaytextarea.setText(regKiddie);
        }
    }    
}
