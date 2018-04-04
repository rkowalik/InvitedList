package InvitedList;

import java.io.Serializable;
import java.util.ArrayList;

public class InvitersManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Family> families;
    private float adultCost = 0, childCost = 0;
    
    
    
    public InvitersManager() {
        families = new ArrayList();
    }
    
    public void sortFamilies() {
        families.sort(Family.SurnameComparator);
    }
    
    public void addFamily(Family family) {
        families.add(family);
    }
    
    public void removeFamily(int index) {
        families.remove(index);
    }

    public InvitersManager(ArrayList<Family> families) {
        this.families = families;
    }

    public ArrayList<Family> getFamilies() {
        return families;
    }

    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }

    public float getAdultCost() {
        return adultCost;
    }

    public void setAdultCost(float adultCost) {
        this.adultCost = adultCost;
    }

    public float getChildCost() {
        return childCost;
    }

    public void setChildCost(float childCost) {
        this.childCost = childCost;
    }
    
    
    
    
}
