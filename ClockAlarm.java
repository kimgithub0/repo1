
import java.util.Calendar;
import java.util.List;
 
import javax.swing.SwingWorker;
 
public class ClockAlarm extends SwingWorker<Void, Void>{
     
    Clock clock;
    private int time_hours;
    private int time_minutes;
    private int time_seconds;
    private int alarm_hours;
    private int alarm_minutes;
    private int alarm_seconds;
    private boolean alarm;
     
    public ClockAlarm(Clock gui){
         
        clock = gui;
    }
     
    @Override
    protected Void doInBackground() throws Exception {
         
        while(isCancelled() == false)
        {
            /**
             * This If check if the numbers form the textAreas match the current time so activates the Alarm
             */
            if(time_hours == alarm_hours && time_minutes == alarm_minutes && time_seconds == alarm_seconds && alarm == true){
                 
                clock.invokeAlarm();          
                 
            }
        this.publish();
        Thread.sleep(1000);
        }
 
        return null;
    }
     
     
    protected void process(List<Void> chunks) {
         
        /**
         * Gets the time from the computer that the program is running
         */
         
        Calendar myTime = Calendar.getInstance();
        time_hours = myTime.get(Calendar.HOUR_OF_DAY);
        time_minutes = myTime.get(Calendar.MINUTE);
        time_seconds = myTime.get(Calendar.SECOND);
          
        clock.setTime(time_hours, time_minutes, time_seconds);
         
 
    }
     
     
    public void setAlarm(int hours, int minutes, int second){
        alarm_hours = hours;
        alarm_minutes = minutes;
        alarm_seconds = second;
    }
     
    public void setBoolean(boolean Alarm){
        alarm = Alarm;
    }
     
 
}