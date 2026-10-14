package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.hardware.IDriveHardware;
import org.firstinspires.ftc.teamcode.hardware.SwyftDriveV2Hardware;

@TeleOp(name="Drive TeleOp")
@SuppressWarnings("unused")
public class DriveTeleOp extends LinearOpMode {
	@Override
	public void runOpMode() {
		telemetry.addData("Status", "Initialising");
		telemetry.update();

		Gamepad gamepad = gamepad1;

		IDriveHardware driveHardware = new SwyftDriveV2Hardware(hardwareMap);

		telemetry.addData("Status", "Waiting for start");
		telemetry.update();

		waitForStart();

		telemetry.addData("Status", "Starting");
		telemetry.update();

		while (opModeIsActive()) {
			driveHardware.drive(gamepad.left_stick_x, gamepad.left_stick_y, gamepad.right_stick_x);

			telemetry.addData("Status", "Running");
			telemetry.update();
		}
	}
}
