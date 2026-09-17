package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Drive TeleOp")
public class DriveTeleOp extends LinearOpMode {
	@Override
	public void runOpMode() {
		telemetry.addData("Status", "Waiting for start");
		telemetry.update();

		waitForStart();

		while (opModeIsActive()) {
			telemetry.addData("Status", "Running");
			telemetry.update();
		}
	}
}
