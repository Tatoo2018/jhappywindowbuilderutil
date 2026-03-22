package com.jhappy.wbutil.jdt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.texteditor.ITextEditor;

import com.jhappy.wbutil.Activator;
import com.jhappy.wbutil.constants.PreferenceConstants;

/**
 * Provides functionality to sort WindowBuilder Non-Visual Beans.
 * Supports multiple sorting strategies such as by field name or class name 
 * based on project-specific preferences.
 */
public class NonVisualBeanSorter {

	/**
	 * 
	 * @param unit
	 */
	public static void sort(ICompilationUnit unit) {

		ASTParser parser = ASTParser.newParser(AST.getJLSLatest());
		parser.setSource(unit);
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		List<NonVisualBean> beans = extractNonVisualBeansComment(cu);
		
		//
		IProject project = unit.getJavaProject().getProject();
		ScopedPreferenceStore prefStore = new ScopedPreferenceStore(new ProjectScope(project), Activator.PLUGIN_ID);

		// sort
	    String sortBy = prefStore.getString(PreferenceConstants.P_SORT_BY);
	    if (sortBy == null || sortBy.isEmpty()) sortBy = PreferenceConstants.V_SORT_BY_NAME;

	    if (PreferenceConstants.V_SORT_BY_CLASS.equals(sortBy)) {
	        
	        beans.sort(Comparator.comparing(b -> {
	            Type type = b.data.node.getType();
	            return type != null ? type.toString() : "";
	        }));
	    } else {
	        
	        beans.sort(Comparator.comparing(b -> b.data.fieldName));
	    }
		

		int startX = getPref(prefStore, PreferenceConstants.P_START_X, 20);
		int startY = getPref(prefStore, PreferenceConstants.P_START_Y, 600);
		int gapX = getPref(prefStore, PreferenceConstants.P_GAP_X, 150);
		int gapY = getPref(prefStore, PreferenceConstants.P_GAP_Y, 50);
		int cols = getPref(prefStore, PreferenceConstants.P_COLS, 5);

		//
		IEditorPart editorpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (editorpart instanceof ITextEditor) {

			ITextEditor textEditor = (ITextEditor) editorpart;

			IDocument doc = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());

			if (doc != null) {
				IRewriteTarget target = textEditor.getAdapter(IRewriteTarget.class);

				try {

					target.beginCompoundChange();

					MultiTextEdit multiEdit = new MultiTextEdit();

					for (int i = 0; i < beans.size(); i++) {

						int nx = startX + (i % cols) * gapX;
						int ny = startY + (i / cols) * gapY;

						NonVisualBean bean = beans.get(i);
						Javadoc javadoc = bean.data.node.getJavadoc();

						int offset = javadoc.getStartPosition();
						int length = javadoc.getLength();

						String oldComment;

						oldComment = doc.get(offset, length);

						String newComment = oldComment.replaceAll("location=\\d+,\\d+", "location=" + nx + "," + ny);

						multiEdit.addChild(new ReplaceEdit(offset, length, newComment));

					}

					multiEdit.apply(doc);
				
				} catch (MalformedTreeException e) {
					Activator.logError("failed to replace non visual bean comment", e);
				} catch (BadLocationException e) {
					Activator.logError("failed to replace non visual bean comment", e);

				} finally {
					if (target != null) {
						target.endCompoundChange();
					}
						
				}
			}
		}

	}

	/**
	 * @param cu
	 * @return
	 */
	private static List<NonVisualBean> extractNonVisualBeansComment(CompilationUnit cu) {

		List<NonVisualBean> beans = new ArrayList<>();

		cu.accept(new ASTVisitor() {
			@Override
			public boolean visit(FieldDeclaration node) {
				Javadoc javadoc = node.getJavadoc();
				if (javadoc != null && javadoc.toString().contains("@wbp.nonvisual")) {
					VariableDeclarationFragment frag = (VariableDeclarationFragment) node.fragments().get(0);
					String fieldName = frag.getName().getIdentifier();
					beans.add(new NonVisualBean(fieldName, node));
				}
				return true;
			}
		});

		return beans;
	}

	/**
	 * 
	 * @param store
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	private static int getPref(ScopedPreferenceStore store, String key, int defaultValue) {
		int val = store.getInt(key);
		return (val == 0) ? defaultValue : val;
	}
}


/**
 * 
 */
class NonVisualBean {
	
	NonVisualBeanData data = new NonVisualBeanData();

	NonVisualBean(String name, FieldDeclaration node) {
		this.data.fieldName = name;
		this.data.node = node;
	}
}