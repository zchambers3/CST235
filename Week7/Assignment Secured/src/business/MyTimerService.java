package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {
	
	@Resource
	TimerService timerService;
	
    /*
     * Default constructor for timer service. 
     */
    public MyTimerService() {
    }
    
    // method to create a logger for the MyTimerService
    private static final Logger logger = Logger.getLogger("business.MyTimerService");
	
    
    //Creation of a scheduled Timeout method taking in a time as a argument
    
	// @Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="*",
    //  dayOfMonth="*", month="*", year="*", info="MyTimer")	
    //private void scheduledTimeout(final Timer t) {
    //    logger.info("@Schedule called at: " + new java.util.Date());
    //}
	
	// Method to set a timer with a input of a long variable.
	public void setTimer(long interval) {
		timerService.createTimer(interval, "My Timer");
	}
	
	// Method to create a timer with a programmed time
	@Timeout
	public void programmicTimer(Timer timer) {
		logger.info("Programmic Timer @: " + new java.util.Date());
	}
}