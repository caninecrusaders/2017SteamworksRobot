package org.usfirst.frc4980.SteamworksAliceRobot2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearLeft extends CommandGroup {

    public AutoGearLeft() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	//addParallel(new AutoDriveForward(2450, 0.5));
    	addSequential(new AutoDriveForward(2450, 0.5));
    	addSequential(new TurnClockwise(400, 0.5)); //turn clockwise
    	addSequential(new AutoDriveForward(1000, 0.5));
    	addParallel(new GearLeanOut());
    }
}
