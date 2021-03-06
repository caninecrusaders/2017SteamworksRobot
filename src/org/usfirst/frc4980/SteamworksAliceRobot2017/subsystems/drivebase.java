// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4980.SteamworksAliceRobot2017.subsystems;

import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;
import org.usfirst.frc4980.SteamworksAliceRobot2017.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class drivebase extends Subsystem {
		private final CANTalon backRightMotor = RobotMap.drivebasebackRightMotor;
	    private final CANTalon backLeftMotor = RobotMap.drivebasebackLeftMotor;
	    private final CANTalon frontLeftMotor = RobotMap.drivebasefrontLeftMotor;
	    private final CANTalon frontRightMotor = RobotMap.drivebasefrontRightMotor;
	    private final RobotDrive robotDrive41 = RobotMap.drivebaseRobotDrive41;
	    
	    double shakeSpeed = 0.7;
	    double bakeSpeed = 0.7;
		double counter = 0.0;
		public boolean invert = false;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
//    private final SpeedController backRightMotor = RobotMap.drivebasebackRightMotor;
//    private final SpeedController backLeftMotor = RobotMap.drivebasebackLeftMotor;
//    private final SpeedController frontLeftMotor = RobotMap.drivebasefrontLeftMotor;
//    private final SpeedController frontRightMotor = RobotMap.drivebasefrontRightMotor;
//    private final RobotDrive robotDrive41 = RobotMap.drivebaseRobotDrive41;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new driveMecanum());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void shake() {
    	
    	RobotMap.drivebasebackLeftMotor.set(shakeSpeed);
    	RobotMap.drivebasebackRightMotor.set(-shakeSpeed);
    	//RobotMap.drivebasebackLeftMotor2.set(shakeSpeed);
    	//RobotMap.drivebasebackRightMotor2.set(-shakeSpeed);
    	RobotMap.drivebasefrontLeftMotor.set(shakeSpeed);
    	RobotMap.drivebasefrontRightMotor.set(-shakeSpeed);
    	if(counter>=8) {
    		counter = 0.0;
    		shakeSpeed = shakeSpeed*-1.0;
    	}
    	counter++;
    }
    public void bake() {
    	RobotMap.drivebasebackLeftMotor.set(bakeSpeed);
    	RobotMap.drivebasebackRightMotor.set(bakeSpeed);
    	//RobotMap.drivebasebackLeftMotor2.set(bakeSpeed);
    	//RobotMap.drivebasebackRightMotor2.set(bakeSpeed);
    	RobotMap.drivebasefrontLeftMotor.set(bakeSpeed);
    	RobotMap.drivebasefrontRightMotor.set(bakeSpeed);
    	if(counter>=8) {
    		counter = 0.0;
    		bakeSpeed = bakeSpeed*-1.0;
    	}
    	counter++;
    }
    public void driveForward( double speed){
    		RobotMap.drivebasebackLeftMotor.set(speed);
        	RobotMap.drivebasebackRightMotor.set(speed);
        	//RobotMap.drivebasebackLeftMotor2.set(speed);
        	//RobotMap.drivebasebackRightMotor2.set(speed);
        	RobotMap.drivebasefrontLeftMotor.set(speed);
        	RobotMap.drivebasefrontRightMotor.set(speed);
    }
    public void driveStop(){
    	double speed = 0.0;
		RobotMap.drivebasebackLeftMotor.set(speed);
    	RobotMap.drivebasebackRightMotor.set(speed);
    	//RobotMap.drivebasebackLeftMotor2.set(speed);
    	//RobotMap.drivebasebackRightMotor2.set(speed);
    	RobotMap.drivebasefrontLeftMotor.set(speed);
    	RobotMap.drivebasefrontRightMotor.set(speed);
}
    public void strafe(double speed){
    	if(speed>0.0){
    		//strafe right
    		RobotMap.drivebasebackLeftMotor.set(-speed);
        	RobotMap.drivebasebackRightMotor.set(speed);
        	//RobotMap.drivebasebackLeftMotor2.set(-speed);
        	//RobotMap.drivebasebackRightMotor2.set(speed);
        	RobotMap.drivebasefrontLeftMotor.set(speed);
        	RobotMap.drivebasefrontRightMotor.set(-speed);
    	} else {
    		//strafe left
    		RobotMap.drivebasebackLeftMotor.set(speed);
        	RobotMap.drivebasebackRightMotor.set(-speed);
        	//RobotMap.drivebasebackLeftMotor2.set(speed);
        	//RobotMap.drivebasebackRightMotor2.set(-speed);
        	RobotMap.drivebasefrontLeftMotor.set(-speed);
        	RobotMap.drivebasefrontRightMotor.set(speed);
    	}
    	
    }
    public void rotate(double speed) {
    	RobotMap.drivebasebackLeftMotor.set(speed);
    	RobotMap.drivebasebackRightMotor.set(-speed);
    	//RobotMap.drivebasebackLeftMotor2.set(speed);
    	//RobotMap.drivebasebackRightMotor2.set(-speed);
    	RobotMap.drivebasefrontLeftMotor.set(speed);
    	RobotMap.drivebasefrontRightMotor.set(-speed);
    }
    
    //Current Time = t
    //Start Value = b
    //Change in value = c
    //Duration = d
    public double easeIn(double t, double b, double c, double d) {
	   t = t/d;
	   return c*t*t+b;
   }
    
    public double easeOut(double t, double b, double c, double d){
    	t=t/d;
    	return -c*t*(t-2.0)+b;
    }
    public double easeInOut(double t, double b, double c, double d){
    	t/=d/2.0;
    	if(t<1){
    		return c/2.0*t*t+b;
    	}
    	return -c/2.0*((--t)*(t-2)-1)+b;
    }
    
}

