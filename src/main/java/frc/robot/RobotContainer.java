// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import com.ctre.phoenix6.swerve.SwerveRequest;
import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import pabeles.concurrency.IntOperatorTask.Max;

@Logged
public class RobotContainer {

  CommandSwerveDrivetrain dt = TunerConstants.createDrivetrain();
  SwerveLogger logger = new SwerveLogger(dt);
  CommandXboxController driverController = new CommandXboxController(0);
  private double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
  private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max
                                                                                    // angular velocity

  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
      .withDeadband(MaxSpeed * 0.1)
      .withRotationalDeadband(MaxAngularRate * 0.1)
      .withDriveRequestType(DriveRequestType.OpenLoopVoltage);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    dt.setDefaultCommand(dt.applyRequest(
        () -> drive.withVelocityX(-driverController.getLeftY() * MaxSpeed)
            .withVelocityY(-driverController.getLeftX() * MaxSpeed)
            .withRotationalRate(-driverController.getRightX() * MaxAngularRate)));

    driverController.povDown().onTrue(dt.runOnce(() -> dt.seedFieldCentric()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
