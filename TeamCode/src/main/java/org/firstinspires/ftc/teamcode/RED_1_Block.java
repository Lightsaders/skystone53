package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "RED_1_Block")
@Disabled
public class RED_1_Block extends Auto_Methods {

    @Override
    public void runOpMode() throws InterruptedException {

        // init robot
        initCompBot();
        waitForStart();

        if (opModeIsActive() && !isStopRequested()) {
            turnClamp("PAR", 250);
            clamp("OPEN", 250);
            straightDriveEncoder(0.2, 106, 3);
            skystoneColorScan("RED");
            telemetry.addLine("Skystone position: " + positionSkystone);
            telemetry.update();
            switch (positionSkystone) {
                case "WALL":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(.2, -9, 1.5);
                        strafeDriveEncoder(1, 15, "LEFT",3);
                        actuator.setPower(1);//TODO use method created
                        sleep(400);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.2, -30, 1);
                        turnEncoder(.4, 95, "C",3);
                        straightDriveEncoder(0.6, 200, 1);
                        clamp("OPEN", 250);
                        straightDriveEncoder(.5, -65, 1);
                    }
                    break;
                case "MIDDLE":
                    if (!isStopRequested() && opModeIsActive()) {
                        strafeDriveEncoder(1, 15, "RIGHT",3);
                        actuator.setPower(1);//TODO use method created
                        sleep(300);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.2, -30, 1);
                        turnEncoder(.4, 95, "C",3);
                        straightDriveEncoder(0.6, 170, 1.5);
                        clamp("OPEN", 250);
                        straightDriveEncoder(.5, -65, 1);
                    }
                    break;
                case "BRIDGE":
                    if (!isStopRequested() && opModeIsActive()) {
                        strafeDriveEncoder(1, 35, "RIGHT",3);
                        actuator.setPower(1);//TODO use method created
                        sleep(300);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.2, -30, 1.5);
                        turnEncoder(.4, 95, "C",3);
                        straightDriveEncoder(0.2, 150, 3);
                        clamp("OPEN", 250);
                        straightDriveEncoder(.5, -40, 1);
                    }
                    break;
            }
        }
    }
}