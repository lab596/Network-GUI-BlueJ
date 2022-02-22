import java.util.ArrayList;

import javax.swing.*;

import java.awt.event.*;

// New event listener that monitors changing values for components

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Allows me to format the numbers

import java.text.NumberFormat;

// Allows me to edit borders on panels

import javax.swing.border.*;

/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class Post extends JFrame 
{
    String username;  // username of the post's author
    long timestamp;
    
    JRadioButton Event, Message, Photo;
    JButton Submit, Show;
    JTextField Author,MessageP;
    JLabel label1,label2;
    JTextArea textArea1;
    
    
    public Post(){
        
        // Define the size of the frame
        
        this.setSize(350, 400);
                
        // Opens the frame in the middle of the screen
        
        this.setLocationRelativeTo(null);
        
        // Define how the frame exits (Click the Close Button)
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        // Define the title for the frame
                
        this.setTitle("Network Feeds");
        
        JPanel thePanel = new JPanel();
        ListenForButton lForButton = new ListenForButton();
        
        // Creates radio buttons with default labels
        
        Event = new JRadioButton("Event");
        Message = new JRadioButton("Message");
        Photo = new JRadioButton("Photo");
        
        Event.addActionListener(lForButton);
        Message.addActionListener(lForButton);
        Photo.addActionListener(lForButton);

        
        // Creates a group that will contain radio buttons
        // You do this so that when 1 is selected the others
        // are deselected
        
        ButtonGroup operation = new ButtonGroup();
        
        // Add radio buttons to the group
        
        operation.add(Event);
        operation.add(Message);
        operation.add(Photo);
        
        // Create a new panel to hold radio buttons
        
        JPanel operPanel = new JPanel();
        
        // Surround radio button panel with a border
        // You can define different types of borders
        // createEtchedBorder, createLineBorder, createTitledBorder
        // createLoweredBevelBorder, createRaisedBevelBorder
        
        Border operBorder = BorderFactory.createTitledBorder("Year");
        
        // Set the border for the panel
        
        operPanel.setBorder(operBorder);
        
        // Add the radio buttons to the panel
        
        operPanel.add(Event);
        operPanel.add(Message);
        operPanel.add(Photo);
        
        // Selects the add radio button by default
        
        //Freshman.setSelected(true);
        
        // Add the panel to the main panel
        // You don't add the group
        
        thePanel.add(operPanel);
        
        
        
                
        // The JPanel contains all of the components for your frame
                
        
        label1 = new JLabel("Author");
        
        thePanel.add(label1);
                
        // How to add a text field ----------------------
                
        Author = new JTextField("", 20);
                        
        thePanel.add(Author);
        
        MessageP = new JTextField("", 20);
        
        label2 = new JLabel("Message");
        
        this.setVisible(true);
        this.setResizable(false);
        /*
        if(Message.isSelected()){
            MessageP = new JTextField("", 20);
        
            label2 = new JLabel("Message");
            thePanel.add(label2);
                
            // How to add a text field ----------------------
                
            thePanel.add(MessageP);
          }
          */
         MessageP = new JTextField("", 20);
        
            label2 = new JLabel("Message");
            label2.setVisible(false);
            thePanel.add(label2);
                
            // How to add a text field ----------------------
            MessageP.setVisible(false); 
            thePanel.add(MessageP);
            
        Submit = new JButton("Submit");
                
        // Create an instance of ListenForEvents to handle events
                
                
        // Tell Java that you want to be alerted when an event
        // occurs on the button
                
        Submit.addActionListener(lForButton);
        Submit.setVisible(false);
        thePanel.add(Submit);
        
        Show = new JButton("Show");
                
        // Create an instance of ListenForEvents to handle events
                
                
        // Tell Java that you want to be alerted when an event
        // occurs on the button
                
        Show.addActionListener(lForButton);
        Show.setVisible(false);      
        thePanel.add(Show);
       
		
		// How to add a text area ----------------------
		
		textArea1 = new JTextArea(15, 20);
				
		// Set the default text for the text area
				
		textArea1.setText("Tracking Events\n");
				
		// If text doesn't fit on a line, jump to the next
		
		textArea1.setLineWrap(true);
		
		// Makes sure that words stay intact if a line wrap occurs
				
		textArea1.setWrapStyleWord(true);
		textArea1.setVisible(false);
				
		// Adds scroll bars to the text area ----------
				
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
		// Other options: VERTICAL_SCROLLBAR_ALWAYS, VERTICAL_SCROLLBAR_NEVER
				
		thePanel.add(scrollbar1);
	;
        
            
                
        if(Message.isSelected()){
            label2.setVisible(true);
            MessageP.setVisible(true);
            Submit.setVisible(true);
            Show.setVisible(true); 
          }
        this.add(thePanel);
    }
    
    /**
     * Constructor for objects of class Post.
     * 
     * @param author    The username of the author of this post.
     */
    public Post(String author)
    {
        username = author;
        timestamp = System.currentTimeMillis();

    }

    /**
     * Record one more 'Like' indication from a user.
     */
    //public void like()
    //{
        //likes++;
    //}

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    //public void unlike()
    //{
        //if (likes > 0) {
            //likes--;
        //}
    //}

    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    //public void addComment(String text)
    //{
        //comments.add(text);
    //}

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    
    public void display()
    {
        System.out.println(username);
        System.out.print(timeString(timestamp));
        
       
    }
    
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    private String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
    private class ListenForButton implements ActionListener{
        
        // This method is called when an event occurs
        
        public void actionPerformed(ActionEvent e){
                if(e.getSource() == Message){
                     label2.setVisible(true);
                     MessageP.setVisible(true);
                     Submit.setVisible(true);
                     Show.setVisible(true);
                     textArea1.setVisible(true);
                     
                  }
              }
          }   
}

