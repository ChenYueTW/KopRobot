package frc.robot.subsystems;

import frc.robot.MotorIds;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase{
    private final CANSparkMax armMotor1;
    private final CANSparkMax armMotor2;

    public ArmSubsystem() {
        this.armMotor1 = new CANSparkMax(MotorIds.Arm.Motor1, MotorType.kBrushless);
        this.armMotor2 = new CANSparkMax(MotorIds.Arm.Motor2, MotorType.kBrushless);

        this.armMotor1.setSmartCurrentLimit(30);
        this.armMotor2.setSmartCurrentLimit(30);
        
        this.armMotor1.setInverted(false);
        this.armMotor2.setInverted(false);

        this.armMotor1.setIdleMode(IdleMode.kBrake);
        this.armMotor2.setIdleMode(IdleMode.kBrake);
    }

    public void setDesiredStateBackward(double armSpeed) {
        this.armMotor1.set(armSpeed);
        SmartDashboard.putNumber("ArmBackward", armSpeed);
    }

    public void setDesiredStateForward(double armSpeed) {
        this.armMotor2.set(armSpeed);
        SmartDashboard.putNumber("ArmForward", armSpeed);
    }

    public void stopBackwardModule() {
        this.armMotor1.set(0);
    }

    public void stopForwardModule() {
        this.armMotor2.set(0);
    }
}