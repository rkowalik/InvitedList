package InvitedList;

import java.io.Serializable;

public class Invited implements Serializable {
    public enum InvitedType {
        ADULT, ADULT_WITH_COMPANION, CHILD, CHILD_AS_ADULT
    }
    
    //public enum Fami
    
    private String name;
    private InvitedType type;
    
    private final static String [] inviterTypesDescriptions = {"osoba dorosła", 
        "dorosły z os. towarzyszącą", "dziecko liczone jako dorosły", "dziecko"};

    public Invited(String name, InvitedType type) {
        this.name = name;
        this.type = type;
    }
    
    /* Copy Constructor */
    public Invited(Invited inv) {
        this(inv.getName(), inv.getType());
    }
    
    public static InvitedType getTypeByDescription(String description) {
        if (description.equals(inviterTypesDescriptions[0])) {
            return InvitedType.ADULT;
        }
        if (description.equals(inviterTypesDescriptions[1])) {
            return InvitedType.ADULT_WITH_COMPANION;
        }
        if (description.equals(inviterTypesDescriptions[2])) {
            return InvitedType.CHILD_AS_ADULT;
        }
        if (description.equals(inviterTypesDescriptions[3])) {
            return InvitedType.CHILD;
        }
        throw new IllegalArgumentException("Invalid description: " + description);
        //return null;
    }
    
    public String getDescription() {
        if (type == InvitedType.ADULT) {
            return inviterTypesDescriptions[0];
        }
        if (type == InvitedType.ADULT_WITH_COMPANION) {
            return inviterTypesDescriptions[1];
        }
        if (type == InvitedType.CHILD_AS_ADULT) {
            return inviterTypesDescriptions[2];
        }
        if (type == InvitedType.CHILD) {
            return inviterTypesDescriptions[3];
        }
        throw new IllegalArgumentException("Invalid Inviter's type.");
    }

    public static String[] getInviterTypesDescriptions() {
        return inviterTypesDescriptions;
    }

    public InvitedType getType() {
        return type;
    }

    public void setType(InvitedType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public String toString() {
        return "Imię: " + name + ", typ: " + type; 
        
//        StringBuilder s = new StringBuilder();
//        String req;
//        if (isRequired) req = "[wymagana]";
//        else req = "[opcjonalna]";
//        
//        String result =  String.format("%-30s %-20s %2d dorosłych %2d dzieci", 
//                surname, req, adultsQty, childrenQty);
//        
//        System.out.println(result);
//        return result;
        
//        for (int i = surname.length(); i < 30; ++i) {
//            
//        }
        
//        return String.format("%30s %14s %2d dorosłych %2d dzieci", surname,
//                req, adultsQty, childrenQty);
        
        
        
//        String name = String.format("%30s", surname); 
//        s.append(name);
//        System.out.println(s.toString());
//        if (isRequired) {
//            s.append("    [wymagana]");
//        }
//        else {
//            s.append("    [opcjonalna]");
//        }
//        s.append(": " + adultsQty + " dorosłych i " + childrenQty + " dzieci.");
//        return s.toString();
    }
    
}
