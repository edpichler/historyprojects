package com.geolocation;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Address_Roo_Configurable {
    
    declare @type: Address: @Configurable;
    
}
