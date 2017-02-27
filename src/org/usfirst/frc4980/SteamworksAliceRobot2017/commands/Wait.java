package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	double m_timeout = 1.0;

    public Wait() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public Wait(double timeOutSec){
    	m_timeout = timeOutSec;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(m_timeout);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
