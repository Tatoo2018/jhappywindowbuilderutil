package com.jhappy.wbutil.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import com.jhappy.wbutil.Activator;
import com.jhappy.wbutil.constants.PreferenceConstants;

/**
 * Property page for configuring WindowBuilder Non-Visual Bean alignment settings.
 * This page allows users to define layout coordinates, spacing, and sorting strategies 
 * on a per-project basis.
 */
public class MainPropertyPage extends FieldEditorPreferencePage implements IWorkbenchPropertyPage {

    private IAdaptable element;

    public MainPropertyPage() {
        super(GRID);
    }

    @Override
    public void setElement(IAdaptable element) {
        this.element = element;
        IProject project = element.getAdapter(IProject.class);

        if (project != null) {
            setPreferenceStore(new ScopedPreferenceStore(new ProjectScope(project), Activator.PLUGIN_ID));
        }
    }

    @Override
    public IAdaptable getElement() {
        return element;
    }

    @Override
    protected void createFieldEditors() {
        // Layout Settings
        addField(new IntegerFieldEditor(PreferenceConstants.P_START_X, Messages.MainPropertyPage_startX, getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.P_START_Y, Messages.MainPropertyPage_startY, getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.P_GAP_X, Messages.MainPropertyPage_gapX, getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.P_GAP_Y, Messages.MainPropertyPage_gapY, getFieldEditorParent()));
        addField(new IntegerFieldEditor(PreferenceConstants.P_ROWS, Messages.MainPropertyPage_rows, getFieldEditorParent()));

        // Sorting Strategy Settings
        addField(new RadioGroupFieldEditor(
            PreferenceConstants.P_SORT_BY,
            Messages.MainPropertyPage_sortBy,
            1,
            new String[][] { 
                { Messages.MainPropertyPage_sortByName, PreferenceConstants.V_SORT_BY_NAME },
                { Messages.MainPropertyPage_sortByClass, PreferenceConstants.V_SORT_BY_CLASS } 
            },
            getFieldEditorParent()
        ));
    }
}