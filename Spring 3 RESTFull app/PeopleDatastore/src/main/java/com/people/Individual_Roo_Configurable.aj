package com.people;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Individual_Roo_Configurable {
    
    declare @type: Individual: @Configurable;
    
}
