package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;
import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveMecanumCartesian extends Command {

    public driveMecanumCartesian() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Joystick j = Robot.oi.joystick;
		AHRS ahrs = Robot.ahrs;
		double x, y, z;
		double deadZone = 0.1;
		double deadZoneZ = 0.25;
		double maxOutput = 0.8;
		x = j.getX();
		y = -j.getY();
		z = j.getTwist();
		
		if (Math.abs(x) < deadZone) {
			x = 0.0;
		}
		if (Math.abs(y) < deadZone) {
			y = 0.0;
		}
		if (Math.abs(z) < deadZoneZ) {
			z = 0.0;
		}
		// Robot.ahrs.getAngle()
		//RobotMap.drivebaseRobotDrive41.setMaxOutput(maxOutput);
		RobotMap.drivebaseRobotDrive41.mecanumDrive_Cartesian(x, y, z, Robot.ahrs.getAngle());

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
