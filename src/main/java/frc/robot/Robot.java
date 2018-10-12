//Created by Akli Amrous 
//October 2018
//Abstract: Main class for Rosie, the team's t-shirt cannon
//Define the Primary attributes of the program Such as defining the joysticks
//Motor controllers / encoders = talon velocity units ticks/100 ms ticks being raw output
//PID will be defined in a seperate file subsystem which will be imported as such
//TODO GET REAL VALUES OF THE Motor Controllers, Joysticks, and set shooter
package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.*;

import java.awt.Button;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Robot extends IterativeRobot{

  //Initialize drive, motor controllers, and sensors

      //Front Group
      WPI_TalonSRX frontLeft = new WPI_TalonSRX(1);
      WPI_TalonSRX frontRight = new WPI_TalonSRX(2);
      

      //Joysticks
      Joystick ljoy = new Joystick(0);
      Joystick rjoy = new Joystick(1);


      //Back Group
      WPI_TalonSRX backLeft = new WPI_TalonSRX(3);
      WPI_TalonSRX backRight = new WPI_TalonSRX(4);
      SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeft,backLeft);
      SpeedControllerGroup m_right = new SpeedControllerGroup(backRight,frontRight);

      //Define the Shooter
      TalonSRX shooter = new TalonSRX(5);
      
      //Define Drive
      DifferentialDrive drive = new DifferentialDrive( m_left, m_right);
    
    
  @Override
  public void robotInit(){

     

      
      

  }


  @Override
  public void robotPeriodic(){
    
  }


  @Override
  public void autonomousInit(){

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
    drive.tankDrive(ljoy.getY(), rjoy.getY());

    if(ljoy.getRawButtonPressed(1)){

      shooter.set(ControlMode.PercentOutput, 1.0);

    }

    

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {



  }
}
