package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.swerve.SwerveDrivetrain;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.epilogue.NotLogged;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

@Logged
public class SwerveLogger {
    @NotLogged
    SwerveDrivetrain dt;

    TalonFX frontLeftDrive, frontRightDrive, backLeftDrive, backRightDrive;
    TalonFX frontLeftSteer, frontRightSteer, backLeftSteer, backRightSteer;

    public SwerveLogger(SwerveDrivetrain dt) {
        this.dt = dt;

        frontLeftDrive = (TalonFX) dt.getModule(0).getDriveMotor();
        frontRightDrive = (TalonFX) dt.getModule(1).getDriveMotor();
        backLeftDrive = (TalonFX) dt.getModule(2).getDriveMotor();
        backRightDrive = (TalonFX) dt.getModule(3).getDriveMotor();

        frontLeftSteer = (TalonFX) dt.getModule(0).getSteerMotor();
        frontRightSteer = (TalonFX) dt.getModule(1).getSteerMotor();
        backLeftSteer = (TalonFX) dt.getModule(2).getSteerMotor();
        backRightSteer = (TalonFX) dt.getModule(3).getSteerMotor();
    }

}
