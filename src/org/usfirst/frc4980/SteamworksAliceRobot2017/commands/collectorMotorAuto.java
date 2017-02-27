package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;
import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class collectorMotorAuto extends Command {

    public collectorMotorAuto() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick j = Robot.oi.joystick;
    	double x = j.getX();
  	    double y  = -j.getY();
        double z  = j.getTwist(); 
        double maxSpeed = 1.0;
        double minSpeed = 0.5;
        double speed = y;
        if(speed< 0.0){
        	speed = 0.0;
        } else if(speed< minSpeed){
        	speed = minSpeed;
        } else if (speed>maxSpeed){
        	speed = maxSpeed;
        }
        RobotMap.collectorCollectorMotor.set(speed);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
