package com.people;

import java.lang.String;

privileged aspect Individual_Roo_ToString {
    
    public String Individual.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Address: ").append(getAddress()).append(", ");
        sb.append("Sex: ").append(getSex());
        return sb.toString();
    }
    
}
