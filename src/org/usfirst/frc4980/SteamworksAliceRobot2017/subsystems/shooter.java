package org.usfirst.frc4980.SteamworksAliceRobot2017.subsystems;

import org.usfirst.frc4980.SteamworksAliceRobot2017.Robot;
import org.usfirst.frc4980.SteamworksAliceRobot2017.RobotMap;
import org.usfirst.frc4980.SteamworksAliceRobot2017.commands.shooterMotorOff;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class shooter extends Subsystem {
	public boolean isShooting = false;
	public double startingRPM = 2300;
	public double speedRPM = startingRPM;
	private double speedStep = 20.0;
	
	//private final CANTalon shooterMotor = RobotMap.shootershooterMotor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
    	RobotMap.shootershooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	RobotMap.shootershooterMotor.configEncoderCodesPerRev(2048);
    	RobotMap.shootershooterMotor.setVoltageRampRate(12);
      	RobotMap.shootershooterMotor.reverseSensor(false);
      	RobotMap.shootershooterMotor.configNominalOutputVoltage(0, 0);
      	RobotMap.shootershooterMotor.configPeakOutputVoltage(12, -12);
      	RobotMap.shootershooterMotor.setProfile(0);
      	RobotMap.shootershooterMotor.setF(0.1097);
      	RobotMap.shootershooterMotor.setP(0.22);
      	RobotMap.shootershooterMotor.setI(0);
      	RobotMap.shootershooterMotor.setD(0);
        // Set the default command for a subsystem here.
        setDefaultCommand(new shooterMotorOff());
    }
    public void shootByDistance() {
    	double speed = getRange();
    	double minRPMs= 500;
    	if(speed<minRPMs){
    		speed = minRPMs;
    	}
    	RobotMap.shootershooterMotor.changeControlMode(TalonControlMode.Speed);
    	RobotMap.shootershooterMotor.set(speed);
    	RobotMap.shooterGate.set(isShooting);
    	if(isShooting){
    		RobotMap.shooterGate2.set(false);
    		RobotMap.shooterGate.set(true);
    	}else{
    		
    		RobotMap.shooterGate2.set(true);
    		RobotMap.shooterGate.set(false);
    	}
    	 SmartDashboard.putNumber("shooterSpeed",RobotMap.shootershooterMotor.getSpeed());
    	 SmartDashboard.putNumber("shooterEncPosition",RobotMap.shootershooterMotor.getEncPosition());
    	 SmartDashboard.putNumber("shooterEncVelocity",RobotMap.shootershooterMotor.getEncVelocity());
    	 SmartDashboard.putNumber("shooterRPM",speed);
    }
    public double getRange(){
    	double range;
    	double scaledVoltage;
    	double average = RobotMap.rangeFinder.getAverageValue();
   	 	SmartDashboard.putNumber("Range Finder Average",average);
   	 	scaledVoltage = 5.0/1024;
   	 	range = 5*(average/scaledVoltage); //Range in mm
   	 	
   	 	return range;

    }
    public void shootByTest(){
    	RobotMap.shootershooterMotor.changeControlMode(TalonControlMode.Speed);
    	RobotMap.shootershooterMotor.set(speedRPM);
    	SmartDashboard.putNumber("shooterSpeed",RobotMap.shootershooterMotor.getSpeed());
    	SmartDashboard.putNumber("shooterRPM",speedRPM);
    	   
    }
    public void shooterStop(){
    	speedRPM = 0;
    	RobotMap.shootershooterMotor.changeControlMode(TalonControlMode.Speed);
    	RobotMap.shootershooterMotor.set(speedRPM);
    	RobotMap.shooterGate2.set(true);
		RobotMap.shooterGate.set(false);

    	
    }
    public void shooterTestUp(){
    	speedRPM += speedStep;
    }
    public void shooterTestDown(){
    	speedRPM -= speedStep;
    }
    
    
}

