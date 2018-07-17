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
public class SchedulingTaskForOneTimeExecution 
{
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

    public static void main( String[] args ) throws InterruptedException
    {
    	String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		Timer timer = new Timer("Timer-Thread", false);
		Date currentTime = new Date();
		Date scheduledTime = TimeUtils.getFutureTime(currentTime, 5000);/*scheduled time from current time at which at which
		thread is scheduled to run*/
		System.out.println("[" + currentThreadName + "] Current time : " + dateFormatter.format(currentTime));
		timer.schedule(new ScheduledTaskA(8000), scheduledTime);// 8000 rep. how long it to run 		
		System.out.println("[" + currentThreadName + "] Task-1 scheduled for running at SPECIFIED TIME : " +
				dateFormatter.format(scheduledTime));
		
		/*=========================================================================*/
		
		long delayTime =10000;
		ScheduledTaskA task2 = new ScheduledTaskA(4000);
		timer.schedule(task2, delayTime);
		System.out.println("[" + currentThreadName + "] Task-2 scheduled to run"+delayTime/1000+" seconds INITIAL_DELAY after the current timei.e at.."+
		dateFormatter.format(task2.scheduledExecutionTime()));
		
		//*******************************************************************************************//
		
				long delayMillis2 = 12000;
				ScheduledTaskA task3 = new ScheduledTaskA(0);
				
				timer.schedule(task3, delayMillis2);
				
				System.out.println("[" + currentThreadName + "] Task-3 scheduled to run " + delayMillis2/1000 +
						" seconds INITIAL-DELAY after current-time i.e. at " + dateFormatter.format(
						new Date(task3.scheduledExecutionTime())));
				
		//*******************************************************************************************//
				
			Date scheduledTime2 = TimeUtils.getFutureTime(currentTime, 30000);
			ScheduledTaskA task4 = new ScheduledTaskA(0);
			
			timer.schedule(task4, scheduledTime2);
			
			System.out.println("[" + currentThreadName + "] Task-4 scheduled for running at SPECIFIED TIME : " +
					dateFormatter.format(new Date(task4.scheduledExecutionTime())));
			
			task4.cancel();
			//*******************************************************************************************//
			
			TimeUnit.MILLISECONDS.sleep(32000);
			System.out.println("[" + currentThreadName + "] CANCELLING THE TIMER NOW ...");
			timer.cancel();
			
			System.out.println("[" + currentThreadName + "] Main thread ends here...");
    }
}
