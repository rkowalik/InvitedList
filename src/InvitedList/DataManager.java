package InvitedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface DataManager {
    public InvitedManager getData();
    public boolean writeData(InvitedManager invManager);
}

class SerializeManager implements DataManager {
    
    private final String filePath;

    public SerializeManager(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
    }

    @Override
    public InvitedManager getData() {
        File f = new File(filePath);
        
        if (!f.exists()) {
            return new InvitedManager();
        }
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            
            return (InvitedManager) in.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializeManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SerializeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public boolean writeData(InvitedManager invManager) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(invManager);
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(SerializeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
