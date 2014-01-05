import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.*;


public class CalculatorMenu extends JFrame {
	private JLabel messageLabel;
	private JMenuBar dormMenuBar;
	private JMenu  mealMenu;
	private JMenu dormMenu;
	private JRadioButtonMenuItem allenHall;
	private JRadioButtonMenuItem pikeHall;
	private JRadioButtonMenuItem fathingHall;
	private JRadioButtonMenuItem universitySuites;
	
	private JRadioButtonMenuItem sevenMeals;
	private JRadioButtonMenuItem fourteenMeals;
	private JRadioButtonMenuItem unlimitedMeals;
	
	private JLabel totalLabel;
	private JTextField totalField;
	private final int SEVEN_MEALS = 560;
	private final int FOURTEEN_MEALS = 1095;
	private final int UNLIMITED_MEALS = 1500;
	
	private final int ALLEN_HALL = 1500;
	private final int PIKE_HALL = 1600;
	private final int FARTHING_HALL = 1200;
	private final int UNIVERSITY_SUITES = 1800;
	
	private int dormPrice;
	private int mealPrice;
	
public CalculatorMenu(){
	
	setTitle("Dorm and Dinner Pricing");
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	messageLabel = new JLabel("Use The Text menu to find Prices");
	messageLabel.setPreferredSize(new Dimension(400,200));
	add(messageLabel, BorderLayout.CENTER);
	buildMenuBar();
	
	
	JPanel resultsPanel=new JPanel();
	totalLabel= new JLabel("Total cost: ");
	totalField= new JTextField(10);
	totalField.setEditable(false);
	resultsPanel.add(totalLabel);
	resultsPanel.add(totalField);
	add(resultsPanel,BorderLayout.SOUTH);
	
	pack();
	setVisible(true);
	
	

}
private void buildMenuBar(){
	dormMenuBar = new JMenuBar();
	
	buildMealMenu();
	buildDormMenu();
	
	dormMenuBar.add(dormMenu);
	dormMenuBar.add(mealMenu);
	
	setJMenuBar(dormMenuBar);
}
private void buildDormMenu() {
	allenHall = new JRadioButtonMenuItem("Allen Hall",true);
	allenHall.setMnemonic(KeyEvent.VK_A);
	allenHall.addActionListener(new RadioButtonListener());
	
	pikeHall = new JRadioButtonMenuItem("Pike Hall");
	pikeHall.setMnemonic(KeyEvent.VK_P);
	pikeHall.addActionListener(new RadioButtonListener());
	
	fathingHall = new JRadioButtonMenuItem("Fathing Hall");
	fathingHall.setMnemonic(KeyEvent.VK_F);
	fathingHall.addActionListener(new RadioButtonListener());
	
	universitySuites = new JRadioButtonMenuItem("University Suites");
	universitySuites.setMnemonic(KeyEvent.VK_T);
	universitySuites.addActionListener(new RadioButtonListener());
	
	ButtonGroup dormGroup = new ButtonGroup();
	dormGroup.add(allenHall);
	dormGroup.add(pikeHall);
	dormGroup.add(fathingHall);
	dormGroup.add(universitySuites);
	dormMenu = new JMenu("Dorms");
	
	dormMenu.add(allenHall);
	dormMenu.add(pikeHall);
	dormMenu.add(fathingHall);
	dormMenu.add(universitySuites);
}
private void buildMealMenu(){
	
	
	sevenMeals = new JRadioButtonMenuItem("Seven Meals",true);
	sevenMeals.setMnemonic(KeyEvent.VK_S);
	sevenMeals.addActionListener(new RadioButtonListener());
	fourteenMeals = new JRadioButtonMenuItem("Fourteen Meals");
	fourteenMeals.setMnemonic(KeyEvent.VK_F);
	fourteenMeals.addActionListener(new RadioButtonListener());
	unlimitedMeals = new JRadioButtonMenuItem("Unlimited Meals");
	unlimitedMeals.setMnemonic(KeyEvent.VK_U);
	unlimitedMeals.addActionListener(new RadioButtonListener());
	
	ButtonGroup group = new ButtonGroup();
	group.add(sevenMeals);
	group.add(fourteenMeals);
	group.add(unlimitedMeals);
	mealMenu = new JMenu("Meals");
	mealMenu.add(sevenMeals);
	mealMenu.add(fourteenMeals);
	mealMenu.add(unlimitedMeals);
	
}
private class RadioButtonListener implements ActionListener{

	

	
	public void actionPerformed(ActionEvent e) {
		if (allenHall.isSelected())
			dormPrice = ALLEN_HALL;
		else if(pikeHall.isSelected())
			dormPrice = PIKE_HALL;
		else if (fathingHall.isSelected())
			dormPrice = FARTHING_HALL;
		else if (universitySuites.isSelected())
			dormPrice = UNIVERSITY_SUITES;
		
		if(sevenMeals.isSelected())
			mealPrice = SEVEN_MEALS;
		else if (fourteenMeals.isSelected())
			mealPrice = FOURTEEN_MEALS;
		else if (unlimitedMeals.isSelected())
			mealPrice = UNLIMITED_MEALS;
		
		int totalCost = dormPrice + mealPrice;
		totalField.setText("$" + Integer.toString(totalCost));
	}
	
}
public static void main(String[] args){
	new CalculatorMenu();
}
}
