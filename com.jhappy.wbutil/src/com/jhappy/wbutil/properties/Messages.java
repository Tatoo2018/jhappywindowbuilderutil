package com.jhappy.wbutil.properties;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "com.jhappy.wbutil.properties.messages"; //$NON-NLS-1$

    public static String MainPropertyPage_startX;
    public static String MainPropertyPage_startY;
    public static String MainPropertyPage_gapX;
    public static String MainPropertyPage_gapY;
    public static String MainPropertyPage_cols;
    public static String MainPropertyPage_sortBy;
    public static String MainPropertyPage_sortByName;
    public static String MainPropertyPage_sortByClass;

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}