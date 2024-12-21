package org.firstinspires.ftc.teamcode;



import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

@Config
@TeleOp(name="armTest")
public class armTest extends OpMode {

    //pid
    ServoImplEx s1;

    public static double score = .05;
    public static double pickup =.36;

    @Override
    public void init() {

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        s1 = (ServoImplEx) hardwareMap.get(Servo.class, "arm");
        s1.setPwmRange(new PwmControl.PwmRange(505, 2495));




    }

    @Override
    public void loop() {

        //winch

        if (gamepad1.dpad_down) {
            s1.setPosition(pickup);
        }
        if (gamepad1.dpad_up) {
            s1.setPosition(score);
        }



        telemetry.addData("Run time", getRuntime());
        telemetry.addData("1", "test");
        telemetry.update();
    }
}

