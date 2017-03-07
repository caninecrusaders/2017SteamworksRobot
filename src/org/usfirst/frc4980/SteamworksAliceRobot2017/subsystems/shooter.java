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
	public double startingRPM = 500;//2300
	public double speedRPM = startingRPM;
	private double speedStep = 20.0;
	public double speedRPMTest = 1.0;
	
	
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
    	double speed = getCalculatedRPM();
    	double minRPMs= 2500;
    	double maxRPMs = 5000;
    	if(speed<minRPMs){
    		speed = minRPMs;
    	}
    	if(speed>maxRPMs){
    		speed = maxRPMs;
    	}
    	RobotMap.shootershooterMotor.changeControlMode(TalonControlMode.Speed);
    	RobotMap.shootershooterMotor.set(speed);
//    	RobotMap.shooterGate.set(isShooting);
//    	if(isShooting){
//    		RobotMap.shooterGate2.set(false);
//    		RobotMap.shooterGate.set(true);
//    	}else{
//    		
//    		RobotMap.shooterGate2.set(true);
//    		RobotMap.shooterGate.set(false);
//    	}
    	 SmartDashboard.putNumber("shooterSpeed",RobotMap.shootershooterMotor.getSpeed());
    	 SmartDashboard.putNumber("shooterEncPosition",RobotMap.shootershooterMotor.getEncPosition());
    	 SmartDashboard.putNumber("shooterEncVelocity",RobotMap.shootershooterMotor.getEncVelocity());
    	 SmartDashboard.putNumber("shooterRPM",speed);
    }
    public double getRange(){
    	double range;
    	double scaledVoltage;
    	double average = RobotMap.rangeFinder.getAverageVoltage();
   	 	scaledVoltage = 5.0/1024.0;
   	 	range = 5*(average/scaledVoltage); //Range in mm
   	 	
   	 	return range;

    }  public double getRangeInches(){
    	double range;
    	double scaledVoltage;
    	double average = RobotMap.rangeFinder.getAverageVoltage();
   	 	scaledVoltage = 5.0/1024.0;
   	 	range = 5*(average/scaledVoltage); //Range in mm
   	 	range/=25.4;
   	 	return range;

    }
    public double getCalculatedRPM(){
    	double x = getRangeInches();
    	double RPM = 0.170455*Math.pow(x,4)-1.90657*Math.pow(x, 3)+2.25379*Math.pow(x, 2)+108.14*x+2770.36;
    	SmartDashboard.putNumber("Calculated RPMs",RPM);
    	return RPM;
    }
    public void shootByTest(){
    	RobotMap.shootershooterMotor.changeControlMode(TalonControlMode.Speed);
    	RobotMap.shootershooterMotor.set(speedRPMTest);
    	SmartDashboard.putNumber("shooterSpeed",RobotMap.shootershooterMotor.getSpeed());
    	SmartDashboard.putNumber("shooterRPM Test",speedRPMTest);
    	   
    }
    public void shooterStop(){
    	speedRPM = 0;
    	RobotMap.shootershooterMotor.changeControlMode(TalonControlMode.Speed);
    	RobotMap.shootershooterMotor.set(speedRPM);
    	RobotMap.shooterGate2.set(true);
		RobotMap.shooterGate.set(false);

    	
    }
    public void shooterTestUp(){
    	speedRPMTest += speedStep;
    }
    public void shooterTestDown(){
    	speedRPMTest -= speedStep;
    }
    
    
}

