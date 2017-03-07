package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;
import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class climberClimb extends Command {

    public climberClimb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.climberRatchetServo.setAngle(160);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Joystick j = Robot.oi.joystick;
    	Joystick x = Robot.oi.xbox;
    	RobotMap.climberRatchetServo.setAngle(160);
    	double xboxSpeed = x.getRawAxis(2);
    	if(xboxSpeed<0.1){
    		xboxSpeed = 0.0;
    	}
    	if(xboxSpeed>0.0){
    		RobotMap.collectorCollectorMotor.set(xboxSpeed);
    	}else{
    		if(j.getRawButton(7)){
        		RobotMap.collectorCollectorMotor.set(1.0);
        	} else {
        		RobotMap.collectorCollectorMotor.set(0.0);
        	}

    	}
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.climberRatchetServo.setAngle(210);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
