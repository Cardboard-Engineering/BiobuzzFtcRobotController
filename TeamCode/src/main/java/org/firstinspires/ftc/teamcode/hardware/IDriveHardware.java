package org.firstinspires.ftc.teamcode.hardware;

public interface IDriveHardware {
	default void drive(float x, float y) {
		drive(x, y, 0.0f);
	}

	void drive(float x, float y, float rx);
}
