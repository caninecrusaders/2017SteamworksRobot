package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import java.util.Date;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveForward extends Command {
	Date startTime;
	double commandDuration = 3000; //milliseconds
	double speed = 0.5;
    public AutoDriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    }
    public AutoDriveForward(double durationMS, double speedIn){
    	requires(Robot.drivebase);
    	speed = speedIn;
    	commandDuration = durationMS; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = new Date();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentSpeed = speed;
    	Date now = new Date();
    	double d = commandDuration/2.0;
    	double b = 0.0;
    	double c = speed;
    	double t = now.getTime()-startTime.getTime();
//    	if(t<=d){
//    		currentSpeed = Robot.drivebase.easeIn(t, b, c, d);
//    	} else if(t>d){
//    		currentSpeed = Robot.drivebase.easeOut(commandDuration-t, speed, -speed, d);
//    	}
    	currentSpeed = Robot.drivebase.easeInOut(t, b, c, commandDuration);
    	if(t>commandDuration){
    		currentSpeed = 0.0;
    	}
    	
    	 //Current Time = t
        //Start Value = b
        //Change in value = c
        //Duration = d
    	 Robot.drivebase.driveForward(currentSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Date now = new Date();
    	double t = now.getTime()-startTime.getTime();
    	if(t>=commandDuration){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	 Robot.drivebase.driveStop();	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
