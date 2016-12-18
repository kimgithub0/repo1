
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
 
public class Clock extends JFrame {
 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel clockLabel;
     
    private String time;
    private String _hours;
    private String _minutes;
    private String _seconds;
     
    private String myHour;
    private String myMin;
    private String mySec;
     
    int alarmHour;
    int alarmMinute;
    int alarmSecond ;
     
    private ClockAlarm myClock;
    private JTextArea textArea_hrs;
    private JTextArea textArea_min;
    private JTextArea textArea_sec;
     
    
 
    /**
     * Create the frame.
     */
    public Clock() {
        myClock = new ClockAlarm(Clock.this);
        myClock.execute();//execute the Clock 
         
        setTitle("Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 330, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
         
        JButton btnAlarm = new JButton("Set");
        btnAlarm.setFont(new Font("Arial", Font.BOLD, 24));
        btnAlarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                 
                /**
                 * Gets 3 different values from the textAreas
                 */
                  
                myHour = new String (textArea_hrs.getText());
                myMin = new String (textArea_min.getText());
                mySec = new String (textArea_sec.getText());
                 
                /**
                 * Transform the 3 values from the textAreas to Integer
                 */
                  
                 
                int _alarmHour = Integer.parseInt(myHour);
                int _alarmMinute = Integer.parseInt(myMin);
                int _alarmSecond = Integer.parseInt(mySec);
                 
                /**
                 * Set the alarm from the textArea values
                 */
 
                alarmHour = _alarmHour;
                alarmMinute = _alarmMinute;
                alarmSecond = _alarmSecond;
                 
                myClock.setBoolean(true);
                 
                 
                myClock.setAlarm(alarmHour, alarmMinute, alarmSecond); // set the alarm
                 
                System.out.println("Alarm set at: " + alarmHour +":"+ alarmMinute + ":" + alarmSecond); // shows on the console what time the alarm has been set up
                 
                 
                
            }
        });
        btnAlarm.setBounds(220, 90, 80, 40);
        contentPane.add(btnAlarm);
         
        clockLabel = new JLabel("");
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 50));
        clockLabel.setBounds(0, 0, 310, 90);
        contentPane.add(clockLabel);
         
        textArea_hrs = new JTextArea();
        textArea_hrs.setFont(new Font("Arial", Font.BOLD, 30));
        textArea_hrs.setBounds(6, 90, 38, 40);
        contentPane.add(textArea_hrs);
                        
        textArea_min = new JTextArea();
        textArea_min.setFont(new Font("Arial", Font.BOLD, 30));
        textArea_min.setBounds(76, 90, 38, 40);
        contentPane.add(textArea_min);
        
        textArea_sec = new JTextArea();
        textArea_sec.setFont(new Font("Arial", Font.BOLD, 30));
        textArea_sec.setBounds(146, 90, 38, 40);
        contentPane.add(textArea_sec);
         
     
         
        JLabel lblHrs = new JLabel("Ω√");
        lblHrs.setBounds(50, 100, 61, 16);
        contentPane.add(lblHrs);
         
        JLabel lblMin = new JLabel("∫–");
        lblMin.setBounds(120, 100, 61, 16);
        contentPane.add(lblMin);
         
        JLabel lblSec = new JLabel("√ ");
        lblSec.setBounds(190, 100, 61, 16);
        contentPane.add(lblSec);
    }
     
    public void setTime(int hour, int minutes, int seconds){
         
        /**
         * this method makes the clock work on the ClockLabel
         */
         
        _hours=Integer.toString(hour);
        _minutes=Integer.toString(minutes);
        _seconds=Integer.toString(seconds);
         
        /**
         * the if help to put a 0 if it is necessary
         */
         
        if(hour < 10){
                
               _hours = "0" + _hours;
           }
            
           if(minutes < 10)
           {
               _minutes = "0" + _minutes;
           }
           if(seconds < 10)
           {
               _seconds = "0" + _seconds;
           }
         
        time = _hours + ":" +   _minutes + ":" + _seconds;
         
        clockLabel.setText(time); //Paint the clock on the ClockLabel
         
    }
     
    public void invokeAlarm(){
        /**
         * Changes the color of the background when the alarm starts
         */
        Color d = new Color((float) Math.random(), (float) Math.random(),(float) Math.random());
        contentPane.setBackground(d);
        textArea_hrs.setText("");
        textArea_min.setText("");
        textArea_sec.setText("");
         
         
    }
}