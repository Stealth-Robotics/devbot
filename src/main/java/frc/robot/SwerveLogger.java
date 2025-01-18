package frc.robot;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.swerve.SwerveDrivetrain;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.epilogue.NotLogged;

@Logged
public class SwerveLogger {
    @NotLogged
    SwerveDrivetrain<TalonFX, TalonFX, CANcoder> dt;

    TalonFX frontLeftDrive, frontRightDrive, backLeftDrive, backRightDrive;
    TalonFX frontLeftSteer, frontRightSteer, backLeftSteer, backRightSteer;

    public SwerveLogger(SwerveDrivetrain<TalonFX, TalonFX, CANcoder> dt) {
        this.dt = dt;

        frontLeftDrive = dt.getModule(0).getDriveMotor();
        frontRightDrive = dt.getModule(1).getDriveMotor();
        backLeftDrive = dt.getModule(2).getDriveMotor();
        backRightDrive = dt.getModule(3).getDriveMotor();

        frontLeftSteer = dt.getModule(0).getSteerMotor();
        frontRightSteer = dt.getModule(1).getSteerMotor();
        backLeftSteer = dt.getModule(2).getSteerMotor();
        backRightSteer = dt.getModule(3).getSteerMotor();
    }

}
