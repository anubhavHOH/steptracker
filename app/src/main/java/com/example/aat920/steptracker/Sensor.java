package com.example.aat920.steptracker;

/**
 * Created by aat920 on 5/29/16.
 */
public class Sensor {

    private Sensor rightToe;
    private Sensor rightThumbBone;
    private Sensor rightMiddleFinger;
    private Sensor rightSmallFinger;
    private Sensor leftToe;
    private Sensor leftThumbBone;
    private Sensor leftMiddleFiner;
    private Sensor leftSmallFinger;
    private MainActivityLauncher imageSetter;

    public Sensor getRightToe() {
        return rightToe;
    }

    public void setRightToe(Sensor rightToe) {
        this.rightToe = rightToe;
        imageSetter.setSensorImg(135,275,0,50,50);
    }

    public Sensor getRightThumbBone() {
        return rightThumbBone;
    }

    public void setRightThumbBone(Sensor rightThumbBone) {
        this.rightThumbBone = rightThumbBone;
        imageSetter.setSensorImg(135,275,0,50,50);

    }

    public Sensor getRightMiddleFinger() {
        return rightMiddleFinger;
    }

    public void setRightMiddleFinger(Sensor rightMiddleFinger) {
        this.rightMiddleFinger = rightMiddleFinger;
        imageSetter.setSensorImg(135,275,0,50,50);

    }

    public Sensor getRightSmallFinger() {
        return rightSmallFinger;
    }

    public void setRightSmallFinger(Sensor rightSmallFinger) {
        this.rightSmallFinger = rightSmallFinger;
        imageSetter.setSensorImg(135,275,0,50,50);

    }

    public Sensor getLeftToe() {
        return leftToe;
    }

    public void setLeftToe(Sensor leftToe) {
        this.leftToe = leftToe;
        imageSetter.setSensorImg(135,275,0,50,50);

    }

    public Sensor getLeftThumbBone() {
        return leftThumbBone;
    }

    public void setLeftThumbBone(Sensor leftThumbBone) {
        this.leftThumbBone = leftThumbBone;
        imageSetter.setSensorImg(135,275,0,50,50);

    }

    public Sensor getLeftMiddleFiner() {
        return leftMiddleFiner;
    }

    public void setLeftMiddleFiner(Sensor leftMiddleFiner) {
        this.leftMiddleFiner = leftMiddleFiner;
        imageSetter.setSensorImg(135,275,0,50,50);

    }

    public Sensor getLeftSmallFinger() {
        return leftSmallFinger;
    }

    public void setLeftSmallFinger(Sensor leftSmallFinger) {
        this.leftSmallFinger = leftSmallFinger;
        imageSetter.setSensorImg(135,275,0,50,50);

    }
}
