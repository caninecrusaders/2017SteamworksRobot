package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;
import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shake extends Command {
	double speed = 0.9;
	double counter = 0.0;
    public Shake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Joystick j = Robot.oi.getJoystick1();
    	boolean bake = false;
    	if(j.getIsXbox()){
    	bake = j.getRawAxis(3)>0.25;
    	} else {
    		bake = j.getRawButton(3);
    	}
    	if (bake){
    		RobotMap.drivebasebackLeftMotor.set(speed);
        	RobotMap.drivebasebackRightMotor.set(speed);
        	//RobotMap.drivebasebackLeftMotor2.set(speed);
        	//RobotMap.drivebasebackRightMotor2.set(speed);
        	RobotMap.drivebasefrontLeftMotor.set(speed);
        	RobotMap.drivebasefrontRightMotor.set(speed);
        	
    	} else {
    		RobotMap.drivebasebackLeftMotor.set(speed);
        	RobotMap.drivebasebackRightMotor.set(-speed);
        	//RobotMap.drivebasebackLeftMotor2.set(speed);
        	//RobotMap.drivebasebackRightMotor2.set(-speed);
        	RobotMap.drivebasefrontLeftMotor.set(speed);
        	RobotMap.drivebasefrontRightMotor.set(-speed);
    	}
    	
    	if(counter>=8) {
    		counter = 0.0;
    		speed = speed*-1.0;
    	}
    	counter++;
  
    	
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
