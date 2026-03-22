package com.jhappy.wbutil;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.jhappy.wbutil.constants.PreferenceConstants;

public class PreferenceInitializer extends AbstractPreferenceInitializer {
    @Override
    public void initializeDefaultPreferences() {
      
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        store.setDefault(PreferenceConstants.P_START_X, 10);
        store.setDefault(PreferenceConstants.P_START_Y, 700);
        store.setDefault(PreferenceConstants.P_GAP_X, 150);
        store.setDefault(PreferenceConstants.P_GAP_Y, 30);
        store.setDefault(PreferenceConstants.P_COLS, 5);
        store.setDefault(PreferenceConstants.P_SORT_BY, PreferenceConstants.V_SORT_BY_NAME);
    }
}