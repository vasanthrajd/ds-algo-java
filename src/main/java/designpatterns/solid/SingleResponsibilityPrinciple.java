package designpatterns.solid;

/**
 * The class should have only one reason to change or a single responsibility
 */
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        SRPReader srpReader = new SRPReader("./resource/read.csv");
        SRPWriter srpWriter = new SRPWriter("./resource/write.csv");
        srpWriter.write(srpReader.read());

        //** Above two objects does the job of reading and writing to the file.
        //** Reading with additional capability can be included and we can have a Interface Segregation Principle to expose the single functionality
    }
}
class SRPReader {
    String filePath;
    public SRPReader(String filePath) {
        this.filePath = filePath;
    }

    String read() {
        System.out.println("SRP Reader =>> reading from the File " + this.filePath);
        return "Read from the File";
    }
}

class SRPWriter {
    String writeToFile;
    public SRPWriter(String writePath) {
        this.writeToFile = writePath;
    }

    void write(String content) {
        System.out.println("SRP Writer =>> Writing the content " + content +" to the File " + this.writeToFile);
    }
}


