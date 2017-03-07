package org.usfirst.frc4980.SteamworksAliceRobot2017.subsystems;

import org.usfirst.frc4980.SteamworksAliceRobot2017.commands.ShooterGateClose;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterGate extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShooterGateClose());
    }
}

