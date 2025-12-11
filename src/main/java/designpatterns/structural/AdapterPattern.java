package designpatterns.structural;

public class AdapterPattern {
    public static void main(String[] args) {
        LegacyConnector legacyConnector = new LegacyConnector();
        AdapterToOldDB adapterToOldDB = new AdapterToOldDB(legacyConnector);
        adapterToOldDB.connectToDb();


    }
}

interface Connector {
    void connectToLegacyDb();
}

class LegacyConnector implements Connector {

    @Override
    public void connectToLegacyDb() {
        System.out.println("Connected to the Legacy DB ");
    }
}

class NewAgeConnector {

    public void connectToDataBase() {
        System.out.println("Connect to Database with high thread pools");
    }
}

class AdapterToOldDB {
    LegacyConnector legacyConnector;
    public AdapterToOldDB(LegacyConnector legacyConnector) {
        legacyConnector = legacyConnector;
    }

    public void connectToDb() {
        legacyConnector.connectToLegacyDb();
    }
}