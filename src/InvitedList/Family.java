package InvitedList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


public class Family implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Invited> invitedList;
    private String surname;
    private boolean required, profitable;
    private int adultSum, adultWithCompSum, childSum, childAsAdultSum;
    
    public Family() {
        invitedList = new ArrayList();
    }
    
    public void addInvited (Invited inv) {
        invitedList.add(inv);
        calculateInvitedQty();
    }
    
    public void removeInvited(int index) {
        invitedList.remove(index);
        calculateInvitedQty();
    }
    
    public String getInvitedNames() {
        StringBuilder sb = new StringBuilder();
        for(Invited inv : invitedList) {
            sb.append(inv.getName() + ", ");
        }
        return sb.toString();
    }
    
    public void calculateInvitedQty() {
        adultSum = 0; adultWithCompSum = 0; childSum = 0; childAsAdultSum = 0;
        
        for (Invited inv : invitedList) {
            Invited.InvitedType type = inv.getType();
            if (type == Invited.InvitedType.ADULT) {
                ++adultSum;
            }
            if (type == Invited.InvitedType.ADULT_WITH_COMPANION) {
                ++adultWithCompSum;
            }
            if (type == Invited.InvitedType.CHILD_AS_ADULT) {
                ++childAsAdultSum;
            }
            if (type == Invited.InvitedType.CHILD) {
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
        return "Family{" + "inviters=" + invitedList + ", surname=" + surname + ", required=" + required + ", profitable=" + profitable + '}';
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
        return invitedList;
    }

    public void setInviters(ArrayList<Invited> inviters) {
        this.invitedList = inviters;
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
