package InvitedList;

import java.util.ArrayList;

public class InvitersStatistics {
    private int adultSum, adultWithCompSum, childSum, childAsAdultSum;
    private final InvitersManager invManager;
    
    public InvitersStatistics(InvitersManager invManager) {
        this.invManager = invManager;
    }
    
    public void calculate() {
        adultSum = 0; adultWithCompSum = 0; childAsAdultSum = 0; childSum = 0;
        ArrayList<Family> families = invManager.getFamilies();
        
        for(Family fam : families) {
            adultSum += fam.getAdultSum();
            adultWithCompSum += fam.getAdultWithCompSum();
            childAsAdultSum += fam.getChildAsAdultSum();
            childSum += fam.getChildSum();
        }
        
//        this.adultsCost = unitAdultCost * (adultSum + adultWithCompSum * 2);        
//        this.childrenCost = unitChildCost * childrenSum;
        //this.allCost = adultsCost + childrenCost; 
    }

    public int getAdultSum() {
        return adultSum;
    }

    public int getAdultWithCompSum() {
        return adultWithCompSum;
    }

    public int getChildSum() {
        return childSum;
    }

    public int getChildAsAdultSum() {
        return childAsAdultSum;
    }
    
    
}
