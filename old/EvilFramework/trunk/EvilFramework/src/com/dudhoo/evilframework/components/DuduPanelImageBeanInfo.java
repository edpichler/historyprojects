/*
 * DuduPanelImageBeanInfo.java
 *
 * Created on 12 de Janeiro de 2006, 00:08
 */

package com.dudhoo.evilframework.components;

import java.beans.*;

/**
 * @author dudu
 */
public class DuduPanelImageBeanInfo extends SimpleBeanInfo {
    
    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( com.dudhoo.evilframework.components.DuduPanelImage.class , null );//GEN-HEADEREND:BeanDescriptor
        
        // Here you can add code for customizing the BeanDescriptor.
        
        return beanDescriptor;         }//GEN-LAST:BeanDescriptor
    
    
    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_actionMap = 1;
    private static final int PROPERTY_alignmentX = 2;
    private static final int PROPERTY_alignmentY = 3;
    private static final int PROPERTY_ancestorListeners = 4;
    private static final int PROPERTY_autoscrolls = 5;
    private static final int PROPERTY_background = 6;
    private static final int PROPERTY_backgroundSet = 7;
    private static final int PROPERTY_border = 8;
    private static final int PROPERTY_bounds = 9;
    private static final int PROPERTY_colorModel = 10;
    private static final int PROPERTY_component = 11;
    private static final int PROPERTY_componentCount = 12;
    private static final int PROPERTY_componentListeners = 13;
    private static final int PROPERTY_componentOrientation = 14;
    private static final int PROPERTY_componentPopupMenu = 15;
    private static final int PROPERTY_components = 16;
    private static final int PROPERTY_containerListeners = 17;
    private static final int PROPERTY_cursor = 18;
    private static final int PROPERTY_cursorSet = 19;
    private static final int PROPERTY_debugGraphicsOptions = 20;
    private static final int PROPERTY_displayable = 21;
    private static final int PROPERTY_doubleBuffered = 22;
    private static final int PROPERTY_dropTarget = 23;
    private static final int PROPERTY_enabled = 24;
    private static final int PROPERTY_focusable = 25;
    private static final int PROPERTY_focusCycleRoot = 26;
    private static final int PROPERTY_focusCycleRootAncestor = 27;
    private static final int PROPERTY_focusListeners = 28;
    private static final int PROPERTY_focusOwner = 29;
    private static final int PROPERTY_focusTraversable = 30;
    private static final int PROPERTY_focusTraversalKeys = 31;
    private static final int PROPERTY_focusTraversalKeysEnabled = 32;
    private static final int PROPERTY_focusTraversalPolicy = 33;
    private static final int PROPERTY_focusTraversalPolicyProvider = 34;
    private static final int PROPERTY_focusTraversalPolicySet = 35;
    private static final int PROPERTY_font = 36;
    private static final int PROPERTY_fontSet = 37;
    private static final int PROPERTY_foreground = 38;
    private static final int PROPERTY_foregroundSet = 39;
    private static final int PROPERTY_graphics = 40;
    private static final int PROPERTY_graphicsConfiguration = 41;
    private static final int PROPERTY_height = 42;
    private static final int PROPERTY_hierarchyBoundsListeners = 43;
    private static final int PROPERTY_hierarchyListeners = 44;
    private static final int PROPERTY_ignoreRepaint = 45;
    private static final int PROPERTY_image = 46;
    private static final int PROPERTY_inheritsPopupMenu = 47;
    private static final int PROPERTY_inputContext = 48;
    private static final int PROPERTY_inputMap = 49;
    private static final int PROPERTY_inputMethodListeners = 50;
    private static final int PROPERTY_inputMethodRequests = 51;
    private static final int PROPERTY_inputVerifier = 52;
    private static final int PROPERTY_insets = 53;
    private static final int PROPERTY_keyListeners = 54;
    private static final int PROPERTY_layout = 55;
    private static final int PROPERTY_lightweight = 56;
    private static final int PROPERTY_locale = 57;
    private static final int PROPERTY_location = 58;
    private static final int PROPERTY_locationOnScreen = 59;
    private static final int PROPERTY_managingFocus = 60;
    private static final int PROPERTY_maximumSize = 61;
    private static final int PROPERTY_maximumSizeSet = 62;
    private static final int PROPERTY_minimumSize = 63;
    private static final int PROPERTY_minimumSizeSet = 64;
    private static final int PROPERTY_mouseListeners = 65;
    private static final int PROPERTY_mouseMotionListeners = 66;
    private static final int PROPERTY_mousePosition = 67;
    private static final int PROPERTY_mouseWheelListeners = 68;
    private static final int PROPERTY_name = 69;
    private static final int PROPERTY_nextFocusableComponent = 70;
    private static final int PROPERTY_opaque = 71;
    private static final int PROPERTY_optimizedDrawingEnabled = 72;
    private static final int PROPERTY_paintingTile = 73;
    private static final int PROPERTY_parent = 74;
    private static final int PROPERTY_peer = 75;
    private static final int PROPERTY_preferredSize = 76;
    private static final int PROPERTY_preferredSizeSet = 77;
    private static final int PROPERTY_propertyChangeListeners = 78;
    private static final int PROPERTY_registeredKeyStrokes = 79;
    private static final int PROPERTY_requestFocusEnabled = 80;
    private static final int PROPERTY_rootPane = 81;
    private static final int PROPERTY_showing = 82;
    private static final int PROPERTY_size = 83;
    private static final int PROPERTY_toolkit = 84;
    private static final int PROPERTY_toolTipText = 85;
    private static final int PROPERTY_topLevelAncestor = 86;
    private static final int PROPERTY_transferHandler = 87;
    private static final int PROPERTY_treeLock = 88;
    private static final int PROPERTY_UI = 89;
    private static final int PROPERTY_UIClassID = 90;
    private static final int PROPERTY_valid = 91;
    private static final int PROPERTY_validateRoot = 92;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 93;
    private static final int PROPERTY_vetoableChangeListeners = 94;
    private static final int PROPERTY_visible = 95;
    private static final int PROPERTY_visibleRect = 96;
    private static final int PROPERTY_width = 97;
    private static final int PROPERTY_x = 98;
    private static final int PROPERTY_y = 99;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[100];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", com.dudhoo.evilframework.components.DuduPanelImage.class, "getAccessibleContext", null );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", com.dudhoo.evilframework.components.DuduPanelImage.class, "getActionMap", "setActionMap" );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", com.dudhoo.evilframework.components.DuduPanelImage.class, "getAlignmentX", "setAlignmentX" );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", com.dudhoo.evilframework.components.DuduPanelImage.class, "getAlignmentY", "setAlignmentY" );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getAncestorListeners", null );
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", com.dudhoo.evilframework.components.DuduPanelImage.class, "getAutoscrolls", "setAutoscrolls" );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", com.dudhoo.evilframework.components.DuduPanelImage.class, "getBackground", "setBackground" );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isBackgroundSet", null );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", com.dudhoo.evilframework.components.DuduPanelImage.class, "getBorder", "setBorder" );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", com.dudhoo.evilframework.components.DuduPanelImage.class, "getBounds", "setBounds" );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", com.dudhoo.evilframework.components.DuduPanelImage.class, "getColorModel", null );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", com.dudhoo.evilframework.components.DuduPanelImage.class, null, null, "getComponent", null );
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", com.dudhoo.evilframework.components.DuduPanelImage.class, "getComponentCount", null );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getComponentListeners", null );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", com.dudhoo.evilframework.components.DuduPanelImage.class, "getComponentOrientation", "setComponentOrientation" );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", com.dudhoo.evilframework.components.DuduPanelImage.class, "getComponentPopupMenu", "setComponentPopupMenu" );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", com.dudhoo.evilframework.components.DuduPanelImage.class, "getComponents", null );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getContainerListeners", null );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", com.dudhoo.evilframework.components.DuduPanelImage.class, "getCursor", "setCursor" );
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isCursorSet", null );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", com.dudhoo.evilframework.components.DuduPanelImage.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", com.dudhoo.evilframework.components.DuduPanelImage.class, "isDisplayable", null );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", com.dudhoo.evilframework.components.DuduPanelImage.class, "isDoubleBuffered", "setDoubleBuffered" );
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", com.dudhoo.evilframework.components.DuduPanelImage.class, "getDropTarget", "setDropTarget" );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", com.dudhoo.evilframework.components.DuduPanelImage.class, "isEnabled", "setEnabled" );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFocusable", "setFocusable" );
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFocusCycleRoot", "setFocusCycleRoot" );
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", com.dudhoo.evilframework.components.DuduPanelImage.class, "getFocusCycleRootAncestor", null );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getFocusListeners", null );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFocusOwner", null );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFocusTraversable", null );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", com.dudhoo.evilframework.components.DuduPanelImage.class, null, null, "getFocusTraversalKeys", "setFocusTraversalKeys" );
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", com.dudhoo.evilframework.components.DuduPanelImage.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", com.dudhoo.evilframework.components.DuduPanelImage.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" );
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" );
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFocusTraversalPolicySet", null );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", com.dudhoo.evilframework.components.DuduPanelImage.class, "getFont", "setFont" );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isFontSet", null );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", com.dudhoo.evilframework.components.DuduPanelImage.class, "getForeground", "setForeground" );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isForegroundSet", null );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", com.dudhoo.evilframework.components.DuduPanelImage.class, "getGraphics", null );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", com.dudhoo.evilframework.components.DuduPanelImage.class, "getGraphicsConfiguration", null );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", com.dudhoo.evilframework.components.DuduPanelImage.class, "getHeight", null );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getHierarchyBoundsListeners", null );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getHierarchyListeners", null );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", com.dudhoo.evilframework.components.DuduPanelImage.class, "getIgnoreRepaint", "setIgnoreRepaint" );
            properties[PROPERTY_image] = new PropertyDescriptor ( "image", com.dudhoo.evilframework.components.DuduPanelImage.class, null, "setImage" );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInheritsPopupMenu", "setInheritsPopupMenu" );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInputContext", null );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInputMap", null );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInputMethodListeners", null );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInputMethodRequests", null );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInputVerifier", "setInputVerifier" );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", com.dudhoo.evilframework.components.DuduPanelImage.class, "getInsets", null );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getKeyListeners", null );
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", com.dudhoo.evilframework.components.DuduPanelImage.class, "getLayout", "setLayout" );
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", com.dudhoo.evilframework.components.DuduPanelImage.class, "isLightweight", null );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", com.dudhoo.evilframework.components.DuduPanelImage.class, "getLocale", "setLocale" );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", com.dudhoo.evilframework.components.DuduPanelImage.class, "getLocation", "setLocation" );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", com.dudhoo.evilframework.components.DuduPanelImage.class, "getLocationOnScreen", null );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", com.dudhoo.evilframework.components.DuduPanelImage.class, "isManagingFocus", null );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", com.dudhoo.evilframework.components.DuduPanelImage.class, "getMaximumSize", "setMaximumSize" );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isMaximumSizeSet", null );
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", com.dudhoo.evilframework.components.DuduPanelImage.class, "getMinimumSize", "setMinimumSize" );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isMinimumSizeSet", null );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getMouseListeners", null );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getMouseMotionListeners", null );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", com.dudhoo.evilframework.components.DuduPanelImage.class, "getMousePosition", null );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getMouseWheelListeners", null );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", com.dudhoo.evilframework.components.DuduPanelImage.class, "getName", "setName" );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", com.dudhoo.evilframework.components.DuduPanelImage.class, "getNextFocusableComponent", "setNextFocusableComponent" );
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", com.dudhoo.evilframework.components.DuduPanelImage.class, "isOpaque", "setOpaque" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", com.dudhoo.evilframework.components.DuduPanelImage.class, "isOptimizedDrawingEnabled", null );
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", com.dudhoo.evilframework.components.DuduPanelImage.class, "isPaintingTile", null );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", com.dudhoo.evilframework.components.DuduPanelImage.class, "getParent", null );
            properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", com.dudhoo.evilframework.components.DuduPanelImage.class, "getPeer", null );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", com.dudhoo.evilframework.components.DuduPanelImage.class, "getPreferredSize", "setPreferredSize" );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", com.dudhoo.evilframework.components.DuduPanelImage.class, "isPreferredSizeSet", null );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getPropertyChangeListeners", null );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", com.dudhoo.evilframework.components.DuduPanelImage.class, "getRegisteredKeyStrokes", null );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", com.dudhoo.evilframework.components.DuduPanelImage.class, "isRequestFocusEnabled", "setRequestFocusEnabled" );
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", com.dudhoo.evilframework.components.DuduPanelImage.class, "getRootPane", null );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", com.dudhoo.evilframework.components.DuduPanelImage.class, "isShowing", null );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", com.dudhoo.evilframework.components.DuduPanelImage.class, "getSize", "setSize" );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", com.dudhoo.evilframework.components.DuduPanelImage.class, "getToolkit", null );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", com.dudhoo.evilframework.components.DuduPanelImage.class, "getToolTipText", "setToolTipText" );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", com.dudhoo.evilframework.components.DuduPanelImage.class, "getTopLevelAncestor", null );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", com.dudhoo.evilframework.components.DuduPanelImage.class, "getTransferHandler", "setTransferHandler" );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", com.dudhoo.evilframework.components.DuduPanelImage.class, "getTreeLock", null );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", com.dudhoo.evilframework.components.DuduPanelImage.class, "getUI", "setUI" );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", com.dudhoo.evilframework.components.DuduPanelImage.class, "getUIClassID", null );
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", com.dudhoo.evilframework.components.DuduPanelImage.class, "isValid", null );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", com.dudhoo.evilframework.components.DuduPanelImage.class, "isValidateRoot", null );
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", com.dudhoo.evilframework.components.DuduPanelImage.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", com.dudhoo.evilframework.components.DuduPanelImage.class, "getVetoableChangeListeners", null );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", com.dudhoo.evilframework.components.DuduPanelImage.class, "isVisible", "setVisible" );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", com.dudhoo.evilframework.components.DuduPanelImage.class, "getVisibleRect", null );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", com.dudhoo.evilframework.components.DuduPanelImage.class, "getWidth", null );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", com.dudhoo.evilframework.components.DuduPanelImage.class, "getX", null );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", com.dudhoo.evilframework.components.DuduPanelImage.class, "getY", null );
        }
        catch( IntrospectionException e) {}//GEN-HEADEREND:Properties
        
        // Here you can add code for customizing the properties array.
        
        return properties;         }//GEN-LAST:Properties
    
    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_ancestorListener = 0;
    private static final int EVENT_componentListener = 1;
    private static final int EVENT_containerListener = 2;
    private static final int EVENT_focusListener = 3;
    private static final int EVENT_hierarchyBoundsListener = 4;
    private static final int EVENT_hierarchyListener = 5;
    private static final int EVENT_inputMethodListener = 6;
    private static final int EVENT_keyListener = 7;
    private static final int EVENT_mouseListener = 8;
    private static final int EVENT_mouseMotionListener = 9;
    private static final int EVENT_mouseWheelListener = 10;
    private static final int EVENT_propertyChangeListener = 11;
    private static final int EVENT_vetoableChangeListener = 12;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[13];
    
            try {
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorMoved", "ancestorRemoved"}, "addAncestorListener", "removeAncestorListener" );
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentHidden", "componentMoved", "componentResized", "componentShown"}, "addComponentListener", "removeComponentListener" );
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" );
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" );
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" );
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" );
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"caretPositionChanged", "inputMethodTextChanged"}, "addInputMethodListener", "removeInputMethodListener" );
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyPressed", "keyReleased", "keyTyped"}, "addKeyListener", "removeKeyListener" );
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mouseEntered", "mouseExited", "mousePressed", "mouseReleased"}, "addMouseListener", "removeMouseListener" );
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" );
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" );
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" );
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" );
        }
        catch( IntrospectionException e) {}//GEN-HEADEREND:Events
        
        // Here you can add code for customizing the event sets array.
        
        return eventSets;         }//GEN-LAST:Events
    
    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_action0 = 0;
    private static final int METHOD_add1 = 1;
    private static final int METHOD_addNotify2 = 2;
    private static final int METHOD_addPropertyChangeListener3 = 3;
    private static final int METHOD_applyComponentOrientation4 = 4;
    private static final int METHOD_areFocusTraversalKeysSet5 = 5;
    private static final int METHOD_bounds6 = 6;
    private static final int METHOD_checkImage7 = 7;
    private static final int METHOD_computeVisibleRect8 = 8;
    private static final int METHOD_contains9 = 9;
    private static final int METHOD_countComponents10 = 10;
    private static final int METHOD_createImage11 = 11;
    private static final int METHOD_createToolTip12 = 12;
    private static final int METHOD_createVolatileImage13 = 13;
    private static final int METHOD_deliverEvent14 = 14;
    private static final int METHOD_disable15 = 15;
    private static final int METHOD_dispatchEvent16 = 16;
    private static final int METHOD_doLayout17 = 17;
    private static final int METHOD_enable18 = 18;
    private static final int METHOD_enableInputMethods19 = 19;
    private static final int METHOD_findComponentAt20 = 20;
    private static final int METHOD_firePropertyChange21 = 21;
    private static final int METHOD_getActionForKeyStroke22 = 22;
    private static final int METHOD_getBounds23 = 23;
    private static final int METHOD_getClientProperty24 = 24;
    private static final int METHOD_getComponentAt25 = 25;
    private static final int METHOD_getComponentZOrder26 = 26;
    private static final int METHOD_getConditionForKeyStroke27 = 27;
    private static final int METHOD_getDefaultLocale28 = 28;
    private static final int METHOD_getFontMetrics29 = 29;
    private static final int METHOD_getInsets30 = 30;
    private static final int METHOD_getListeners31 = 31;
    private static final int METHOD_getLocation32 = 32;
    private static final int METHOD_getMousePosition33 = 33;
    private static final int METHOD_getPopupLocation34 = 34;
    private static final int METHOD_getPropertyChangeListeners35 = 35;
    private static final int METHOD_getSize36 = 36;
    private static final int METHOD_getToolTipLocation37 = 37;
    private static final int METHOD_getToolTipText38 = 38;
    private static final int METHOD_gotFocus39 = 39;
    private static final int METHOD_grabFocus40 = 40;
    private static final int METHOD_handleEvent41 = 41;
    private static final int METHOD_hasFocus42 = 42;
    private static final int METHOD_hide43 = 43;
    private static final int METHOD_imageUpdate44 = 44;
    private static final int METHOD_insets45 = 45;
    private static final int METHOD_inside46 = 46;
    private static final int METHOD_invalidate47 = 47;
    private static final int METHOD_isAncestorOf48 = 48;
    private static final int METHOD_isFocusCycleRoot49 = 49;
    private static final int METHOD_isLightweightComponent50 = 50;
    private static final int METHOD_keyDown51 = 51;
    private static final int METHOD_keyUp52 = 52;
    private static final int METHOD_layout53 = 53;
    private static final int METHOD_list54 = 54;
    private static final int METHOD_locate55 = 55;
    private static final int METHOD_location56 = 56;
    private static final int METHOD_lostFocus57 = 57;
    private static final int METHOD_minimumSize58 = 58;
    private static final int METHOD_mouseDown59 = 59;
    private static final int METHOD_mouseDrag60 = 60;
    private static final int METHOD_mouseEnter61 = 61;
    private static final int METHOD_mouseExit62 = 62;
    private static final int METHOD_mouseMove63 = 63;
    private static final int METHOD_mouseUp64 = 64;
    private static final int METHOD_move65 = 65;
    private static final int METHOD_nextFocus66 = 66;
    private static final int METHOD_paint67 = 67;
    private static final int METHOD_paintAll68 = 68;
    private static final int METHOD_paintComponents69 = 69;
    private static final int METHOD_paintImmediately70 = 70;
    private static final int METHOD_postEvent71 = 71;
    private static final int METHOD_preferredSize72 = 72;
    private static final int METHOD_prepareImage73 = 73;
    private static final int METHOD_print74 = 74;
    private static final int METHOD_printAll75 = 75;
    private static final int METHOD_printComponents76 = 76;
    private static final int METHOD_putClientProperty77 = 77;
    private static final int METHOD_registerKeyboardAction78 = 78;
    private static final int METHOD_remove79 = 79;
    private static final int METHOD_removeAll80 = 80;
    private static final int METHOD_removeNotify81 = 81;
    private static final int METHOD_removePropertyChangeListener82 = 82;
    private static final int METHOD_repaint83 = 83;
    private static final int METHOD_requestDefaultFocus84 = 84;
    private static final int METHOD_requestFocus85 = 85;
    private static final int METHOD_requestFocusInWindow86 = 86;
    private static final int METHOD_resetKeyboardActions87 = 87;
    private static final int METHOD_reshape88 = 88;
    private static final int METHOD_resize89 = 89;
    private static final int METHOD_revalidate90 = 90;
    private static final int METHOD_scrollRectToVisible91 = 91;
    private static final int METHOD_setBounds92 = 92;
    private static final int METHOD_setComponentZOrder93 = 93;
    private static final int METHOD_setDefaultLocale94 = 94;
    private static final int METHOD_setImage95 = 95;
    private static final int METHOD_show96 = 96;
    private static final int METHOD_size97 = 97;
    private static final int METHOD_toString98 = 98;
    private static final int METHOD_transferFocus99 = 99;
    private static final int METHOD_transferFocusBackward100 = 100;
    private static final int METHOD_transferFocusDownCycle101 = 101;
    private static final int METHOD_transferFocusUpCycle102 = 102;
    private static final int METHOD_unregisterKeyboardAction103 = 103;
    private static final int METHOD_update104 = 104;
    private static final int METHOD_updateUI105 = 105;
    private static final int METHOD_validate106 = 106;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[107];
    
        try {
            methods[METHOD_action0] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class}));
            methods[METHOD_action0].setDisplayName ( "" );
            methods[METHOD_add1] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("add", new Class[] {java.awt.Component.class}));
            methods[METHOD_add1].setDisplayName ( "" );
            methods[METHOD_addNotify2] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("addNotify", new Class[] {}));
            methods[METHOD_addNotify2].setDisplayName ( "" );
            methods[METHOD_addPropertyChangeListener3] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
            methods[METHOD_addPropertyChangeListener3].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation4] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class}));
            methods[METHOD_applyComponentOrientation4].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet5] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("areFocusTraversalKeysSet", new Class[] {Integer.TYPE}));
            methods[METHOD_areFocusTraversalKeysSet5].setDisplayName ( "" );
            methods[METHOD_bounds6] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("bounds", new Class[] {}));
            methods[METHOD_bounds6].setDisplayName ( "" );
            methods[METHOD_checkImage7] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
            methods[METHOD_checkImage7].setDisplayName ( "" );
            methods[METHOD_computeVisibleRect8] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class}));
            methods[METHOD_computeVisibleRect8].setDisplayName ( "" );
            methods[METHOD_contains9] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("contains", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_contains9].setDisplayName ( "" );
            methods[METHOD_countComponents10] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("countComponents", new Class[] {}));
            methods[METHOD_countComponents10].setDisplayName ( "" );
            methods[METHOD_createImage11] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class}));
            methods[METHOD_createImage11].setDisplayName ( "" );
            methods[METHOD_createToolTip12] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("createToolTip", new Class[] {}));
            methods[METHOD_createToolTip12].setDisplayName ( "" );
            methods[METHOD_createVolatileImage13] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("createVolatileImage", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_createVolatileImage13].setDisplayName ( "" );
            methods[METHOD_deliverEvent14] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class}));
            methods[METHOD_deliverEvent14].setDisplayName ( "" );
            methods[METHOD_disable15] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("disable", new Class[] {}));
            methods[METHOD_disable15].setDisplayName ( "" );
            methods[METHOD_dispatchEvent16] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class}));
            methods[METHOD_dispatchEvent16].setDisplayName ( "" );
            methods[METHOD_doLayout17] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("doLayout", new Class[] {}));
            methods[METHOD_doLayout17].setDisplayName ( "" );
            methods[METHOD_enable18] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("enable", new Class[] {}));
            methods[METHOD_enable18].setDisplayName ( "" );
            methods[METHOD_enableInputMethods19] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("enableInputMethods", new Class[] {Boolean.TYPE}));
            methods[METHOD_enableInputMethods19].setDisplayName ( "" );
            methods[METHOD_findComponentAt20] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("findComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_findComponentAt20].setDisplayName ( "" );
            methods[METHOD_firePropertyChange21] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, Boolean.TYPE, Boolean.TYPE}));
            methods[METHOD_firePropertyChange21].setDisplayName ( "" );
            methods[METHOD_getActionForKeyStroke22] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
            methods[METHOD_getActionForKeyStroke22].setDisplayName ( "" );
            methods[METHOD_getBounds23] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class}));
            methods[METHOD_getBounds23].setDisplayName ( "" );
            methods[METHOD_getClientProperty24] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class}));
            methods[METHOD_getClientProperty24].setDisplayName ( "" );
            methods[METHOD_getComponentAt25] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getComponentAt", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_getComponentAt25].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder26] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class}));
            methods[METHOD_getComponentZOrder26].setDisplayName ( "" );
            methods[METHOD_getConditionForKeyStroke27] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class}));
            methods[METHOD_getConditionForKeyStroke27].setDisplayName ( "" );
            methods[METHOD_getDefaultLocale28] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getDefaultLocale", new Class[] {}));
            methods[METHOD_getDefaultLocale28].setDisplayName ( "" );
            methods[METHOD_getFontMetrics29] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class}));
            methods[METHOD_getFontMetrics29].setDisplayName ( "" );
            methods[METHOD_getInsets30] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getInsets", new Class[] {java.awt.Insets.class}));
            methods[METHOD_getInsets30].setDisplayName ( "" );
            methods[METHOD_getListeners31] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getListeners", new Class[] {java.lang.Class.class}));
            methods[METHOD_getListeners31].setDisplayName ( "" );
            methods[METHOD_getLocation32] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getLocation", new Class[] {java.awt.Point.class}));
            methods[METHOD_getLocation32].setDisplayName ( "" );
            methods[METHOD_getMousePosition33] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getMousePosition", new Class[] {Boolean.TYPE}));
            methods[METHOD_getMousePosition33].setDisplayName ( "" );
            methods[METHOD_getPopupLocation34] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getPopupLocation", new Class[] {java.awt.event.MouseEvent.class}));
            methods[METHOD_getPopupLocation34].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners35] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class}));
            methods[METHOD_getPropertyChangeListeners35].setDisplayName ( "" );
            methods[METHOD_getSize36] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getSize", new Class[] {java.awt.Dimension.class}));
            methods[METHOD_getSize36].setDisplayName ( "" );
            methods[METHOD_getToolTipLocation37] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class}));
            methods[METHOD_getToolTipLocation37].setDisplayName ( "" );
            methods[METHOD_getToolTipText38] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class}));
            methods[METHOD_getToolTipText38].setDisplayName ( "" );
            methods[METHOD_gotFocus39] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
            methods[METHOD_gotFocus39].setDisplayName ( "" );
            methods[METHOD_grabFocus40] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("grabFocus", new Class[] {}));
            methods[METHOD_grabFocus40].setDisplayName ( "" );
            methods[METHOD_handleEvent41] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("handleEvent", new Class[] {java.awt.Event.class}));
            methods[METHOD_handleEvent41].setDisplayName ( "" );
            methods[METHOD_hasFocus42] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("hasFocus", new Class[] {}));
            methods[METHOD_hasFocus42].setDisplayName ( "" );
            methods[METHOD_hide43] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("hide", new Class[] {}));
            methods[METHOD_hide43].setDisplayName ( "" );
            methods[METHOD_imageUpdate44] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_imageUpdate44].setDisplayName ( "" );
            methods[METHOD_insets45] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("insets", new Class[] {}));
            methods[METHOD_insets45].setDisplayName ( "" );
            methods[METHOD_inside46] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("inside", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_inside46].setDisplayName ( "" );
            methods[METHOD_invalidate47] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("invalidate", new Class[] {}));
            methods[METHOD_invalidate47].setDisplayName ( "" );
            methods[METHOD_isAncestorOf48] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class}));
            methods[METHOD_isAncestorOf48].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot49] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class}));
            methods[METHOD_isFocusCycleRoot49].setDisplayName ( "" );
            methods[METHOD_isLightweightComponent50] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class}));
            methods[METHOD_isLightweightComponent50].setDisplayName ( "" );
            methods[METHOD_keyDown51] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("keyDown", new Class[] {java.awt.Event.class, Integer.TYPE}));
            methods[METHOD_keyDown51].setDisplayName ( "" );
            methods[METHOD_keyUp52] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("keyUp", new Class[] {java.awt.Event.class, Integer.TYPE}));
            methods[METHOD_keyUp52].setDisplayName ( "" );
            methods[METHOD_layout53] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("layout", new Class[] {}));
            methods[METHOD_layout53].setDisplayName ( "" );
            methods[METHOD_list54] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("list", new Class[] {java.io.PrintStream.class, Integer.TYPE}));
            methods[METHOD_list54].setDisplayName ( "" );
            methods[METHOD_locate55] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("locate", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_locate55].setDisplayName ( "" );
            methods[METHOD_location56] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("location", new Class[] {}));
            methods[METHOD_location56].setDisplayName ( "" );
            methods[METHOD_lostFocus57] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class}));
            methods[METHOD_lostFocus57].setDisplayName ( "" );
            methods[METHOD_minimumSize58] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("minimumSize", new Class[] {}));
            methods[METHOD_minimumSize58].setDisplayName ( "" );
            methods[METHOD_mouseDown59] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_mouseDown59].setDisplayName ( "" );
            methods[METHOD_mouseDrag60] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_mouseDrag60].setDisplayName ( "" );
            methods[METHOD_mouseEnter61] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_mouseEnter61].setDisplayName ( "" );
            methods[METHOD_mouseExit62] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_mouseExit62].setDisplayName ( "" );
            methods[METHOD_mouseMove63] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_mouseMove63].setDisplayName ( "" );
            methods[METHOD_mouseUp64] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_mouseUp64].setDisplayName ( "" );
            methods[METHOD_move65] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("move", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_move65].setDisplayName ( "" );
            methods[METHOD_nextFocus66] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("nextFocus", new Class[] {}));
            methods[METHOD_nextFocus66].setDisplayName ( "" );
            methods[METHOD_paint67] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("paint", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_paint67].setDisplayName ( "" );
            methods[METHOD_paintAll68] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_paintAll68].setDisplayName ( "" );
            methods[METHOD_paintComponents69] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_paintComponents69].setDisplayName ( "" );
            methods[METHOD_paintImmediately70] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("paintImmediately", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_paintImmediately70].setDisplayName ( "" );
            methods[METHOD_postEvent71] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("postEvent", new Class[] {java.awt.Event.class}));
            methods[METHOD_postEvent71].setDisplayName ( "" );
            methods[METHOD_preferredSize72] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("preferredSize", new Class[] {}));
            methods[METHOD_preferredSize72].setDisplayName ( "" );
            methods[METHOD_prepareImage73] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class}));
            methods[METHOD_prepareImage73].setDisplayName ( "" );
            methods[METHOD_print74] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("print", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_print74].setDisplayName ( "" );
            methods[METHOD_printAll75] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("printAll", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_printAll75].setDisplayName ( "" );
            methods[METHOD_printComponents76] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_printComponents76].setDisplayName ( "" );
            methods[METHOD_putClientProperty77] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class}));
            methods[METHOD_putClientProperty77].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction78] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, Integer.TYPE}));
            methods[METHOD_registerKeyboardAction78].setDisplayName ( "" );
            methods[METHOD_remove79] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("remove", new Class[] {Integer.TYPE}));
            methods[METHOD_remove79].setDisplayName ( "" );
            methods[METHOD_removeAll80] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("removeAll", new Class[] {}));
            methods[METHOD_removeAll80].setDisplayName ( "" );
            methods[METHOD_removeNotify81] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("removeNotify", new Class[] {}));
            methods[METHOD_removeNotify81].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener82] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class}));
            methods[METHOD_removePropertyChangeListener82].setDisplayName ( "" );
            methods[METHOD_repaint83] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("repaint", new Class[] {Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_repaint83].setDisplayName ( "" );
            methods[METHOD_requestDefaultFocus84] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("requestDefaultFocus", new Class[] {}));
            methods[METHOD_requestDefaultFocus84].setDisplayName ( "" );
            methods[METHOD_requestFocus85] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("requestFocus", new Class[] {}));
            methods[METHOD_requestFocus85].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow86] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("requestFocusInWindow", new Class[] {}));
            methods[METHOD_requestFocusInWindow86].setDisplayName ( "" );
            methods[METHOD_resetKeyboardActions87] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("resetKeyboardActions", new Class[] {}));
            methods[METHOD_resetKeyboardActions87].setDisplayName ( "" );
            methods[METHOD_reshape88] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("reshape", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_reshape88].setDisplayName ( "" );
            methods[METHOD_resize89] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("resize", new Class[] {Integer.TYPE, Integer.TYPE}));
            methods[METHOD_resize89].setDisplayName ( "" );
            methods[METHOD_revalidate90] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("revalidate", new Class[] {}));
            methods[METHOD_revalidate90].setDisplayName ( "" );
            methods[METHOD_scrollRectToVisible91] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class}));
            methods[METHOD_scrollRectToVisible91].setDisplayName ( "" );
            methods[METHOD_setBounds92] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("setBounds", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}));
            methods[METHOD_setBounds92].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder93] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, Integer.TYPE}));
            methods[METHOD_setComponentZOrder93].setDisplayName ( "" );
            methods[METHOD_setDefaultLocale94] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("setDefaultLocale", new Class[] {java.util.Locale.class}));
            methods[METHOD_setDefaultLocale94].setDisplayName ( "" );
            methods[METHOD_setImage95] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("setImage", new Class[] {java.lang.String.class}));
            methods[METHOD_setImage95].setDisplayName ( "" );
            methods[METHOD_show96] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("show", new Class[] {}));
            methods[METHOD_show96].setDisplayName ( "" );
            methods[METHOD_size97] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("size", new Class[] {}));
            methods[METHOD_size97].setDisplayName ( "" );
            methods[METHOD_toString98] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("toString", new Class[] {}));
            methods[METHOD_toString98].setDisplayName ( "" );
            methods[METHOD_transferFocus99] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("transferFocus", new Class[] {}));
            methods[METHOD_transferFocus99].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward100] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("transferFocusBackward", new Class[] {}));
            methods[METHOD_transferFocusBackward100].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle101] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("transferFocusDownCycle", new Class[] {}));
            methods[METHOD_transferFocusDownCycle101].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle102] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("transferFocusUpCycle", new Class[] {}));
            methods[METHOD_transferFocusUpCycle102].setDisplayName ( "" );
            methods[METHOD_unregisterKeyboardAction103] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class}));
            methods[METHOD_unregisterKeyboardAction103].setDisplayName ( "" );
            methods[METHOD_update104] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("update", new Class[] {java.awt.Graphics.class}));
            methods[METHOD_update104].setDisplayName ( "" );
            methods[METHOD_updateUI105] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("updateUI", new Class[] {}));
            methods[METHOD_updateUI105].setDisplayName ( "" );
            methods[METHOD_validate106] = new MethodDescriptor ( com.dudhoo.evilframework.components.DuduPanelImage.class.getMethod("validate", new Class[] {}));
            methods[METHOD_validate106].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
        
        // Here you can add code for customizing the methods array.
        
        return methods;         }//GEN-LAST:Methods
    
    
    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx
    
    
//GEN-FIRST:Superclass
    
    // Here you can add code for customizing the Superclass BeanInfo.
    
//GEN-LAST:Superclass
    
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable
     * properties of this bean.  May return null if the
     * information should be obtained by automatic analysis.
     */
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }
    
    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean.  May return null if the
     * information should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will
     * belong to the IndexedPropertyDescriptor subclass of PropertyDescriptor.
     * A client of getPropertyDescriptors can use "instanceof" to check
     * if a given PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }
    
    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return  An array of EventSetDescriptors describing the kinds of
     * events fired by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }
    
    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return  An array of MethodDescriptors describing the methods
     * implemented by this bean.  May return null if the information
     * should be obtained by automatic analysis.
     */
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }
    
    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     * @return  Index of default property in the PropertyDescriptor array
     * 		returned by getPropertyDescriptors.
     * <P>	Returns -1 if there is no default property.
     */
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }
    
    /**
     * A bean may have a "default" event that is the event that will
     * mostly commonly be used by human's when using the bean.
     * @return Index of default event in the EventSetDescriptor array
     *		returned by getEventSetDescriptors.
     * <P>	Returns -1 if there is no default event.
     */
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }
}

