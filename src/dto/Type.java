package dto;

import java.util.ArrayList;
import java.util.HashMap;

public class Type {
    private String typeName;
    private ArrayList<String> attributes;

    public Type(String typeName, ArrayList<String> attributes) {
        this.typeName = typeName;
        this.attributes = attributes;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeName='" + typeName + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
