import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class travel extends JFrame implements ActionListener{
	private JLabel l1,l2;// for text
	private JTextField t1,t2;//input/output
	private JCheckBox c1,c2,c3;
	private JRadioButton r1,r2,r3;
    private JButton b1,b2;
    private ButtonGroup gb = new ButtonGroup();//This limits the radio button to one option


    public travel(){
		super("Travel Company");//calls the JFrame constructor and names it Travel Company
        setLayout(new FlowLayout());

		//days
		l1 = new JLabel("Days: ");//instantiate l1
		add(l1);//add l1
		t1 = new JTextField(10);
		add(t1);

		//radio Buttons
		r1 = new JRadioButton("3 Stars - 100$");
		gb.add(r1);//add the radio buttons to select only one
        add(r1);
        r2 = new JRadioButton("4 Stars - 150$");
		gb.add(r2);
        add(r2);
        r3 = new JRadioButton("5 Stars - 200$");
		gb.add(r3);
        add(r3);

        //check boxes
        c1 = new JCheckBox("Car - $100");
        add(c1);
        c2 = new JCheckBox("Driver - $50");
        add(c2);
        c3 = new JCheckBox("Activities - $50");
        add(c3);

        //fees
        l2 = new JLabel("Fees: ");
		add(l2);
		t2 = new JTextField(10);
		t2.setEditable(false);//the user can't input the fees (it is not in the exam but we usually do it so we added it)
		add(t2);


		//buttons
		b1 = new JButton("Calculate");
		add(b1);
		b1.addActionListener(this);//we pass b1 to an event and call the actionPerformed
		b2 = new JButton("Cancel");
		add(b2);
        b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){// this is for b1 or b2
		double fees = 0;
        int days=0;

        //b1 calculate
        if(e.getSource() == b1){
			days = Integer.parseInt(t1.getText());//to change the string of the user input to INT for computation
		    if(r1.isSelected() == true){
		    	fees = days * 100;
		    }
		    else if(r2.isSelected() == true){
		    	fees = days * 150;
		    }
		    else if(r3.isSelected() == true){
				fees = days * 200;
		    }

			if(c1.isSelected() == true){
		        fees+=100;
		    }
		    if(c2.isSelected() == true){
		        fees+=50;
		    }
		    if(c3.isSelected() == true){
		        fees+=50;
		    }

		    t2.setText("$" + String.valueOf(fees));//output the results on the screen
    	}//end of b1 event

		//b2 event
    	else if(e.getSource() == b2){
			//text
			t1.setText("");
		    t2.setText("");

		    //radio button
		    gb.clearSelection();

			//checkbox
		    c1.setSelected(false);
		    c2.setSelected(false);
            c3.setSelected(false);

		}//end of b2


	}// end of actionPerformed


}//end of class
///////////////////////////////////////////////////////////////////////////////////////////////
public class travelGUI{
	public static void main(String[] args) {
		travel f = new travel();
		f.setSize(190,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}//end of main
}//end of class
