package com.jhappy.wbutil.constants;

/**
 * Constants used for plug-in preference keys and property pages.
 * Defines the layout parameters for aligning Non-Visual Beans in the WindowBuilder editor.
 */
public class PreferenceConstants {

    /** * The starting X-coordinate for the first bean icon.
     */
    public static final String P_START_X = "startX";

    /** * The starting Y-coordinate for the first bean icon.
     */
    public static final String P_START_Y = "startY";

    /** * The horizontal spacing (gap) between bean icons.
     */
    public static final String P_GAP_X = "gapX";

    /** * The vertical spacing (gap) between rows of bean icons.
     */
    public static final String P_GAP_Y = "gapY";

    /** * The maximum number of icons to display per row before wrapping to the next line.
     */
    public static final String P_ROWS = "rows";
    
    /** * Key for sorting strategy (e.g., by field name or by class name). */
    public static final String P_SORT_BY = "sortBy";

    public static final String V_SORT_BY_NAME = "name";
    public static final String V_SORT_BY_CLASS = "class";
}