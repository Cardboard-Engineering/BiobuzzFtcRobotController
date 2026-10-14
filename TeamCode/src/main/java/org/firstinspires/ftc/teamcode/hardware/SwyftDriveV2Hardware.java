package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SwyftDriveV2Hardware implements IDriveHardware {
	private final DcMotor frontLeft;
	private final DcMotor frontRight;
	private final DcMotor backLeft;
	private final DcMotor backRight;

	public SwyftDriveV2Hardware(HardwareMap hardwareMap) {
		frontLeft = hardwareMap.get(DcMotor.class, "front_left_wheel");
		frontRight = hardwareMap.get(DcMotor.class, "front_right_wheel");
		backLeft = hardwareMap.get(DcMotor.class, "back_left_wheel");
		backRight = hardwareMap.get(DcMotor.class, "back_right_wheel");

		frontRight.setDirection(DcMotor.Direction.REVERSE);
		backRight.setDirection(DcMotor.Direction.FORWARD);

		frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
		frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
		backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
		backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	}

	@Override
	public void drive(float x, float y, float rx) {
		float denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1.0f);
		frontLeft.setPower((y + x + rx) / denominator);
		frontRight.setPower((y - x + rx) / denominator);
		backLeft.setPower((y - x - rx) / denominator);
		backRight.setPower((y + x - rx) / denominator);
	}
}
