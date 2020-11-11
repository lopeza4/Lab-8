import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{


JTextField field; 
JButton guessButton;
JButton playAgainButton;
JLabel jlabPrompt, jlabContents1, jlabContents2;
int randomNum;

GuessingGame(){
JFrame frame = new JFrame ("Guessing Game");
frame.setLayout(new FlowLayout());
frame.setSize(240, 120);


Random r = new Random();
randomNum = r.nextInt(101)+1;




field = new JTextField(10);
field.setActionCommand("myTF");
field.addActionListener(this);

guessButton = new JButton("Guess");
playAgainButton = new JButton("Play Again");
guessButton.addActionListener(this);
playAgainButton.addActionListener(this);

jlabPrompt = new JLabel("Enter your guess:");
jlabContents1 = new JLabel("");
jlabContents2 = new JLabel("");

frame.add(jlabPrompt);
frame.add(field);
frame.add(guessButton);
frame.add(jlabContents1);
frame.add(jlabContents2);
frame.add(playAgainButton);

frame.setVisible(true);
  
}


public void actionPerformed(ActionEvent ae) { 
    
    if(ae.getActionCommand().equals("Guess")) { 
      int user_guess = Integer.parseInt(field.getText());
      jlabContents2.setText("You guessed number " + user_guess);
      
      if (user_guess > randomNum){
          jlabContents1.setText("Too high, guess lower");
      }
      else if (user_guess < randomNum) {
        jlabContents1.setText("Too low, guess higher");
      }

      else {
         jlabContents1.setText("You got it ");
      }
      }   

     else if (ae.getActionCommand().equals("Play Again")){
       Random r = new Random();
       randomNum = r.nextInt(101)+1;
       field.setText("");
       jlabContents1.setText("");
       jlabContents2.setText("");
     }

     else {
        jlabContents1.setText("You pressed Enter. Please press the Guess button");
        
     }
  } 


} 

