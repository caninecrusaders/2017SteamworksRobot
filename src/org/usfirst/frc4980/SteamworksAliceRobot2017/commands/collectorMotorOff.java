package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class collectorMotorOff extends Command {

    public collectorMotorOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
    }
}
