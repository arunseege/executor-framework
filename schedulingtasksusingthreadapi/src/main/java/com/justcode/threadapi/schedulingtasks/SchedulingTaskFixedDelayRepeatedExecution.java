package com.justcode.threadapi.schedulingtasks;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.justcode.threadapi.schedulingtasks.tasks.ScheduledTaskA;
import com.justcode.threadapi.schedulingtasks.utils.TimeUtils;

/**
 * Hello world!
 *
 */
public class SchedulingTaskFixedDelayRepeatedExecution 
{
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

    public static void main( String[] args ) throws InterruptedException
    {
    	String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		Timer timer = new Timer("Timer-Thread", false);
		Date currentTime = new Date();
		Date scheduledTime = TimeUtils.getFutureTime(currentTime, 3000);/*scheduled time from current time at which
		thread is scheduled to run*/
		System.out.println("[" + currentThreadName + "] Current time : " + dateFormatter.format(currentTime));
		long intervalMillis = 2000;
		timer.schedule(new ScheduledTaskA(1000), scheduledTime, intervalMillis);
		
		System.out.println("[" + currentThreadName + "] Task-1 first-run scheduled for " +
				dateFormatter.format(scheduledTime) + " and then repeatedly at an interval of every " +
				intervalMillis/1000 + " seconds!");
		
		long delayMillis = 4000;
		long intervalMillis2 = 2000;
		
		timer.schedule(new ScheduledTaskA(1000), delayMillis, intervalMillis2);
		
		System.out.println("[" + currentThreadName + "] Task-2 first run scheduled " + delayMillis/1000 +
				" seconds after " + dateFormatter.format(currentTime) + " and then repeatedly at an interval of every " +
				intervalMillis2/1000 + " seconds!");
		
		TimeUnit.MILLISECONDS.sleep(16000);
		System.out.println("[" + currentThreadName + "] CANCELLING THE TIMER NOW ...");
		timer.cancel();
		
			System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
