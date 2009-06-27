/*
 * MaskUtil.java
 *
 * Created on 9 de Fevereiro de 2006, 20:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.util;

import com.dudhoo.evilframework.swing.EvilError;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author duduzera
 */
public class MaskUtil {
    
    /** Creates a new instance of MaskUtil */
    public MaskUtil() {
    }
    
    public MaskFormatter getNewMaskFormatter(String s){
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            new EvilError(null, false, exc).setVisible(true);
        }
        return formatter;
    }
}
