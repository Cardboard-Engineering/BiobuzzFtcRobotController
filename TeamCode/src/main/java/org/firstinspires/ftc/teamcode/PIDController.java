package org.firstinspires.ftc.teamcode;

public class PIDController {
	private final float mKP;
	private final float mKI;
	private final float mKD;
	private final float mMin;
	private final float mMax;

	private float mIntegral;
	private float mLastError;

	public PIDController(float kp, float ki, float kd, float min, float max) {
		mKP = kp;
		mKI = ki;
		mKD = kd;
		mMin = min;
		mMax = max;
	}

	public float update(float current, float target, float dt) {
		float error = target - current;
		float p = mKP * error;
		mIntegral += error * dt;
		float i = mKI * mIntegral;
		float d = mKD * (error - mLastError) / dt;
		mLastError = error;
		return Math.max(Math.min(p + i  + d, mMax), mMin);
	}
}