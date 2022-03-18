// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.AutoTest;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain autoSubsystem = DriveTrain.getInstance();

  private final AutoTest autoCommand = new AutoTest();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton intakeIn = new JoystickButton(OI.getInstance().getController(), 1);
    JoystickButton intakeOut = new JoystickButton(OI.getInstance().getController(), 3);
    JoystickButton armUp = new JoystickButton(OI.getInstance().getController(), 0);
    JoystickButton armDown = new JoystickButton(OI.getInstance().getController(), 2);
    JoystickButton test = new JoystickButton(OI.getInstance().getController(), 5);

    /*
    intakeIn.whenHeld(new PositionArm(0.07));
    intakeOut.whenHeld(new PositionArm(-0.07));
    armUp.whenPressed(new ArmUp(10, 500000));
    armDown.whenPressed(new ArmUp(-10, 500000));
    test.whenPressed(new Test());
    */
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
