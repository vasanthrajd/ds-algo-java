package designpatterns.solid;

public class InterfaceSegragationPrinciple {
    public static void main(String[] args) {
        SmartBulb smartBulb = new SmartBulb();
        smartBulb.switchOn();
        smartBulb.setBrightness(10);
        smartBulb.switchOff();
        Radio radio = new Radio();
        radio.switchOn();
        radio.setVolume(100);
        radio.switchOff();
    }
}

interface Switchable {
    void switchOn();
    void switchOff();
}

interface Dimmable {
    void setBrightness(int level);
}

interface VolumeControllable  {
    void setVolume(int level);
}

class SmartBulb implements Switchable, Dimmable {

    @Override
    public void setBrightness(int level) {
        System.out.println("Set the Brightness to the level == " + level);
    }

    @Override
    public void switchOn() {
        System.out.println("Switch On the Light ");
    }

    @Override
    public void switchOff() {
        System.out.println("Switch Off the Light" );
    }
}

class Radio implements Switchable, VolumeControllable {

    @Override
    public void switchOn() {
        System.out.println("Switch On the Radio ");
    }

    @Override
    public void switchOff() {
        System.out.println("Switch Off the Radio ");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Set Volume to the Level == " + level);
    }
}