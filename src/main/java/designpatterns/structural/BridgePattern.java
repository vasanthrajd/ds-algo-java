package designpatterns.structural;

public class BridgePattern {
    public static void main(String[] args) {
        System.out.println("========== BRIDGE PATTERN - UNIVERSAL REMOTE ==========\n");

        // Create devices (Implementations)
        Device samsungTV = new TV("Samsung Smart TV");
        Device sonyTV = new TV("Sony Bravia");
        Device jblRadio = new Radio("JBL Tune");
        Device boseTheatre = new HomeTheatre("Bose 5.1");
        Device jblSpeaker = new BluetoothDevice("JBL Flip 6", "Speaker");
        Device sonyHeadphones = new BluetoothDevice("Sony WH-1000XM5", "Headphones");

        // Create different types of remotes (Abstractions)
        System.out.println("--- BASIC REMOTE with Samsung TV ---");
        BasicRemote basicRemote = new BasicRemote(samsungTV);
        basicRemote.powerOn();
        basicRemote.volumeUp();
        basicRemote.volumeUp();

        // Same remote, different device
        System.out.println("\n--- BASIC REMOTE switched to Radio ---");
        basicRemote.setDevice(jblRadio);
        basicRemote.powerOn();
        basicRemote.volumeUp();

        // Advanced remote with more features
        System.out.println("\n--- ADVANCED REMOTE with Home Theatre ---");
        AdvancedRemote advancedRemote = new AdvancedRemote(boseTheatre);
        advancedRemote.powerOn();
        advancedRemote.volumeUp();
        advancedRemote.channelUp();
        advancedRemote.mute();

        // Same advanced remote, different device
        System.out.println("\n--- ADVANCED REMOTE switched to Sony TV ---");
        advancedRemote.setDevice(sonyTV);
        advancedRemote.powerOn();
        advancedRemote.channelUp();

        // Smart remote with voice control
        System.out.println("\n--- SMART REMOTE (Alexa) with Bluetooth Speaker ---");
        SmartRemote alexaRemote = new SmartRemote(jblSpeaker, "Alexa");
        alexaRemote.voiceCommand("Turn on the speaker");
        alexaRemote.voiceCommand("Volume up");
        alexaRemote.setScene("Movie Night");

        // Same smart remote, different device
        System.out.println("\n--- SMART REMOTE (Alexa) switched to Headphones ---");
        alexaRemote.setDevice(sonyHeadphones);
        alexaRemote.voiceCommand("Turn on headphones");

        // Another smart remote with different assistant
        System.out.println("\n--- SMART REMOTE (Google) with Samsung TV ---");
        SmartRemote googleRemote = new SmartRemote(samsungTV, "Google Assistant");
        googleRemote.voiceCommand("Turn on the TV");
        googleRemote.setScene("Gaming");

        System.out.println("\n========== DEMO COMPLETED ==========");

        System.out.println("\n\n========== KEY INSIGHTS ==========");
        System.out.println("✓ We can vary REMOTES (Basic, Advanced, Smart) independently");
        System.out.println("✓ We can vary DEVICES (TV, Radio, Theatre, Bluetooth) independently");
        System.out.println("✓ Any remote can work with any device through the bridge");
        System.out.println("✓ Adding new remote types doesn't affect devices");
        System.out.println("✓ Adding new devices doesn't affect remote types");
    }
}


interface Device {
    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
    void setChannel(int channel);
    String getDeviceInfo();
    boolean isEnabled();
}

class TV implements Device  {

    private String model;
    private boolean on = false;
    private int volume = 10;
    private int channel = 1;

    public TV(String model) {
        this.model = model;
    }

    @Override
    public void powerOn() {
        on = true;
        System.out.println(model + " TV is switched ON");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println(model + " TV is switched OFF");
    }

    @Override
    public void volumeUp() {
        if (on && volume < 100) {
            volume++;
            System.out.println(model + " TV Volume " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (on && volume > 1) {
            volume--;
            System.out.println(model + " TV Volume " + volume);
        }
    }

    @Override
    public void setChannel(int channel) {
        if (channel < 11 && channel>1)
            System.out.println(model + " TV Channel Set to " + channel);
    }

    @Override
    public String getDeviceInfo() {
        return model+ "_ Device Info";
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

class Radio implements Device {
    private String model;
    private boolean on = false;
    private int volume = 5;
    private double frequency = 98.5;

    public Radio(String model) {
        this.model = model;
    }

    @Override
    public void powerOn() {
        on = true;
        System.out.println(model + " Radio is now ON");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println(model + " Radio is now OFF");
    }

    @Override
    public void volumeUp() {
        if (on && volume < 50) {
            volume++;
            System.out.println(model + " Radio volume: " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (on && volume > 0) {
            volume--;
            System.out.println(model + " Radio volume: " + volume);
        }
    }

    @Override
    public void setChannel(int channel) {
        if (on) {
            this.frequency = 88.0 + (channel * 0.2);
            System.out.println(model + " Radio frequency: " + frequency + " FM");
        }
    }

    @Override
    public String getDeviceInfo() {
        return model + " Radio";
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

// Concrete Implementation: Home Theatre
class HomeTheatre implements Device {
    private String model;
    private boolean on = false;
    private int volume = 20;
    private String input = "HDMI1";

    public HomeTheatre(String model) {
        this.model = model;
    }

    @Override
    public void powerOn() {
        on = true;
        System.out.println(model + " Home Theatre is now ON");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println(model + " Home Theatre is now OFF");
    }

    @Override
    public void volumeUp() {
        if (on && volume < 100) {
            volume += 2;
            System.out.println(model + " Home Theatre volume: " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (on && volume > 0) {
            volume -= 2;
            System.out.println(model + " Home Theatre volume: " + volume);
        }
    }

    @Override
    public void setChannel(int channel) {
        if (on) {
            input = "HDMI" + channel;
            System.out.println(model + " Home Theatre input: " + input);
        }
    }

    @Override
    public String getDeviceInfo() {
        return model + " Home Theatre";
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

// Concrete Implementation: Bluetooth Device
class BluetoothDevice implements Device {
    private String model;
    private String deviceType;
    private boolean on = false;
    private boolean connected = false;
    private int volume = 15;

    public BluetoothDevice(String model, String deviceType) {
        this.model = model;
        this.deviceType = deviceType;
    }

    @Override
    public void powerOn() {
        on = true;
        connected = true;
        System.out.println(model + " Bluetooth " + deviceType + " is ON and connected");
    }

    @Override
    public void powerOff() {
        on = false;
        connected = false;
        System.out.println(model + " Bluetooth " + deviceType + " is OFF");
    }

    @Override
    public void volumeUp() {
        if (on && volume < 30) {
            volume++;
            System.out.println(model + " Bluetooth volume: " + volume);
        }
    }

    @Override
    public void volumeDown() {
        if (on && volume > 0) {
            volume--;
            System.out.println(model + " Bluetooth volume: " + volume);
        }
    }

    @Override
    public void setChannel(int channel) {
        if (on) {
            System.out.println(model + " Bluetooth: Track " + channel);
        }
    }

    @Override
    public String getDeviceInfo() {
        return model + " Bluetooth " + deviceType;
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void powerOn();
    public abstract void powerOff();
    public abstract void volumeUp();
    public abstract void volumeDown();

    public void setDevice(Device device) {
        this.device = device;
        System.out.println("\n=== Remote switched to: " + device.getDeviceInfo() + " ===");
    }
}

class BasicRemote extends RemoteControl {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.print("Basic Remote: ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Basic Remote: ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print("Basic Remote: ");
        device.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.print("Basic Remote: ");
        device.volumeDown();
    }
}

// Refined Abstraction: Advanced Remote with extra features
class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void powerOn() {
        System.out.print("Advanced Remote: ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Advanced Remote: ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print("Advanced Remote: ");
        device.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.print("Advanced Remote: ");
        device.volumeDown();
    }

    // Advanced features
    public void mute() {
        System.out.println("Advanced Remote: Muting " + device.getDeviceInfo());
        for (int i = 0; i < 5; i++) {
            device.volumeDown();
        }
    }

    public void channelUp() {
        if (device.isEnabled()) {
            System.out.println("Advanced Remote: Channel Up");
            // Simplified channel change
            device.setChannel(5);
        }
    }
}

// Refined Abstraction: Smart Remote with voice control
class SmartRemote extends RemoteControl {
    private String voiceAssistant;

    public SmartRemote(Device device, String voiceAssistant) {
        super(device);
        this.voiceAssistant = voiceAssistant;
    }

    @Override
    public void powerOn() {
        System.out.print("Smart Remote (" + voiceAssistant + "): ");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.print("Smart Remote (" + voiceAssistant + "): ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print("Smart Remote (" + voiceAssistant + "): ");
        device.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.print("Smart Remote (" + voiceAssistant + "): ");
        device.volumeDown();
    }

    // Smart features
    public void voiceCommand(String command) {
        System.out.println("\n" + voiceAssistant + " processing: '" + command + "'");
        if (command.toLowerCase().contains("turn on")) {
            powerOn();
        } else if (command.toLowerCase().contains("volume up")) {
            volumeUp();
            volumeUp();
        }
    }

    public void setScene(String scene) {
        System.out.println("Smart Remote: Activating " + scene + " scene");
        powerOn();
        device.setChannel(1);
    }
}

// Demo