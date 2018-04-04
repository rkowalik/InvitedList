package InvitedList;

import java.io.Serializable;

public class Invited implements Serializable {
    public enum InvitedType {
        ADULT, ADULT_WITH_COMPANION, CHILD, CHILD_AS_ADULT
    }
    
    //public enum Fami
    
    private String name;
    private InvitedType type;
    
    private final static String [] invitedTypesDescriptions = {"osoba dorosła", 
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
        if (description.equals(invitedTypesDescriptions[0])) {
            return InvitedType.ADULT;
        }
        if (description.equals(invitedTypesDescriptions[1])) {
            return InvitedType.ADULT_WITH_COMPANION;
        }
        if (description.equals(invitedTypesDescriptions[2])) {
            return InvitedType.CHILD_AS_ADULT;
        }
        if (description.equals(invitedTypesDescriptions[3])) {
            return InvitedType.CHILD;
        }
        throw new IllegalArgumentException("Invalid description: " + description);
        //return null;
    }
    
    public String getDescription() {
        if (type == InvitedType.ADULT) {
            return invitedTypesDescriptions[0];
        }
        if (type == InvitedType.ADULT_WITH_COMPANION) {
            return invitedTypesDescriptions[1];
        }
        if (type == InvitedType.CHILD_AS_ADULT) {
            return invitedTypesDescriptions[2];
        }
        if (type == InvitedType.CHILD) {
            return invitedTypesDescriptions[3];
        }
        throw new IllegalArgumentException("Invalid Inviter's type.");
    }

    public static String[] getInvitedTypesDescriptions() {
        return invitedTypesDescriptions;
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
    }
    
}
