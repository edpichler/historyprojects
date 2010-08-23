package com.geolocation;

import java.lang.String;

privileged aspect Address_Roo_ToString {
    
    public String Address.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Descricao: ").append(getDescricao());
        return sb.toString();
    }
    
}
