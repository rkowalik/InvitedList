package InvitedList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


public class Family implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Invited> inviters;
    private String surname;
    private boolean required, profitable;
    private int adultSum, adultWithCompSum, childSum, childAsAdultSum;
    
    public Family() {
        inviters = new ArrayList();
    }
    
    public void addInviter (Invited inviter) {
        inviters.add(inviter);
        calculateInvitersQty();
    }
    
    public void removeInviter(int index) {
        inviters.remove(index);
        calculateInvitersQty();
    }
    
    public String getInvitersNames() 
    
    public void calculateInvitersQty() {
        adultSum = 0; adultWithCompSum = 0; childSum = 0; childAsAdultSum = 0;
        
        for (Invited inv : inviters) {
            Invited.InviterType type = inv.getType();
            if (type == Invited.InviterType.ADULT) {
                ++adultSum;
            }
            if (type == Invited.InviterType.ADULT_WITH_COMPANION) {
                ++adultWithCompSum;
            }
            if (type == Invited.InviterType.CHILD_AS_ADULT) {
                ++childAsAdultSum;
            }
            if (type == Invited.InviterType.CHILD) {
                ++childSum;
            }
        }
    }
    
    public static Comparator<Family> SurnameComparator = new Comparator<Family>() {
        @Override
        public int compare(Family f1, Family f2) {
            return f1.getSurname().toLowerCase().compareTo(f2.getSurname().toLowerCase());
        }
    };

    @Override
    public String toString() {
        return "Family{" + "inviters=" + inviters + ", surname=" + surname + ", required=" + required + ", profitable=" + profitable + '}';
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isProfitable() {
        return profitable;
    }

    public void setProfitable(boolean profitable) {
        this.profitable = profitable;
    }
    
    // Ilość osób liczonych jak dorośli
    public int getAdultCostQty() {
        return adultSum + (adultWithCompSum * 2) + childAsAdultSum;
    }

    public ArrayList<Invited> getInviters() {
        return inviters;
    }

    public void setInviters(ArrayList<Invited> inviters) {
        this.inviters = inviters;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
