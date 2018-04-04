package InvitedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager {
    
    private final String filePath;

    public DataManager(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
    }
    
    public InvitersManager getDataFromFile() throws IOException, ClassNotFoundException {
        File f = new File(filePath);
        
        if (!f.exists()) {
            return new InvitersManager();
        }
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (InvitersManager) in.readObject();
        }
    }
    
    public void writeDataToFile(InvitersManager invitersManager) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(invitersManager);
        }
    }
}
