package org.usfirst.frc4980.SteamworksAliceRobot2017.subsystems;

import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;
import org.usfirst.frc4980.SteamworksAliceRobot2017.commands.GearLeanIn;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new GearLeanIn());
    }
    public void leanOut() {
    	RobotMap.gearSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void leanIn(){
    	RobotMap.gearSolenoid.set(DoubleSolenoid.Value.kReverse);

    }
}

