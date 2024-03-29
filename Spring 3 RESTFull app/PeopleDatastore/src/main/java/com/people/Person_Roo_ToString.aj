package com.people;

import java.lang.String;

privileged aspect Person_Roo_ToString {
    
    public String Person.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Address: ").append(getAddress());
        return sb.toString();
    }
    
}
