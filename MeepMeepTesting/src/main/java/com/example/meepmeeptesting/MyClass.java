package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(90));
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)

                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 10)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(9, -60, Math.toRadians(90)))
                .splineTo(new Vector2d(0, -33), Math.toRadians(90))
                .strafeTo(new Vector2d(36, -33))
                .strafeTo(new Vector2d(36, -10))
                .strafeTo(new Vector2d(48, -10))
                .strafeTo(new Vector2d(48, -52))
                .strafeTo(new Vector2d(48, -10))
                .strafeTo(new Vector2d(48, -10))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}