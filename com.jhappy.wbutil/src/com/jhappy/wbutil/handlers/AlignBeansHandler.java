package com.jhappy.wbutil.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;

import com.jhappy.wbutil.jdt.NonVisualBeanSorter;

/**
 * 
 */
public class AlignBeansHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

	    IEditorPart editor = HandlerUtil.getActiveEditor(event);
	    if (!(editor instanceof ITextEditor)) return null;

	    ITextEditor textEditor = (ITextEditor) editor;
	
	    IJavaElement element = JavaUI.getEditorInputJavaElement(textEditor.getEditorInput());
	    if (element instanceof ICompilationUnit) {
	    	
	        ICompilationUnit cu = (ICompilationUnit) element;

	        // Delegate the sorting and formatting logic to the JDT-based sorter
	        NonVisualBeanSorter.sort(cu);

	    }
	    return null;
	}

}
