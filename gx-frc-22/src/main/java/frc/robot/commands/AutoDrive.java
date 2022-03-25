// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase {
  private double throttle;
  private double turn;
  private long time;
  private long timeout;

  /** Creates a new AutoTest. */
  public AutoDrive(double throttle, double turn, long time, long timeout) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain.getInstance());

    this.throttle = throttle;
    this.turn = turn;
    this.time = time;
    this.timeout = timeout;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putBoolean("Finished", false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveTrain.getInstance().autoDrive(throttle, turn, time, timeout); // Time is in MS
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Finished", true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
