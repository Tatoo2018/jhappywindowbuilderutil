/*
 * Copyright (c) 2026 JHAPPY
 * Licensed under the MIT License. See LICENSE file in the project root for full license information.
 */
package com.jhappy.wbutil.jdt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
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
 */
public class NonVisualBeanSorter {

    public static void sort(ICompilationUnit unit) {
        // ... (ASTの解析・ソートロジックは既存のまま) ...

        ASTParser parser = ASTParser.newParser(AST.getJLSLatest());
        parser.setSource(unit);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        List<NonVisualBeanData> beans = extractNonVisualBeansComment(cu);
        if (beans.isEmpty()) return;

        IProject project = unit.getJavaProject().getProject();
        ScopedPreferenceStore prefStore = new ScopedPreferenceStore(new ProjectScope(project), Activator.PLUGIN_ID);

        // Sorting Logic based on preferences
        String sortBy = prefStore.getString(PreferenceConstants.P_SORT_BY);
        if (sortBy == null || sortBy.isEmpty()) sortBy = PreferenceConstants.V_SORT_BY_NAME;

        if (PreferenceConstants.V_SORT_BY_CLASS.equals(sortBy)) {
            beans.sort(Comparator.comparing(b -> {
                Type type = b.node.getType();
                return type != null ? type.toString() : "";
            }));
        } else {
            beans.sort(Comparator.comparing(b -> b.fieldName));
        }

        // 設定の取得 (cols から rows に読み替えます)
        int startX = getPref(prefStore, PreferenceConstants.P_START_X, 10);
        int startY = getPref(prefStore, PreferenceConstants.P_START_Y, 700);
        int gapX = getPref(prefStore, PreferenceConstants.P_GAP_X, 190);
        int gapY = getPref(prefStore, PreferenceConstants.P_GAP_Y, 45);
        int rows = getPref(prefStore, PreferenceConstants.P_ROWS, 10); // 折り返し行数

        IEditorPart editorpart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

        if (editorpart instanceof ITextEditor textEditor) {
            IDocument doc = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());

            if (doc != null) {
                IRewriteTarget target = textEditor.getAdapter(IRewriteTarget.class);
                try {
                    if (target != null) target.beginCompoundChange();

                    MultiTextEdit multiEdit = new MultiTextEdit();

                    for (int i = 0; i < beans.size(); i++) {
                        // ★ 行数（rows）に基づいた新しい計算式
                        // i / rows = 現在の列番号
                        // i % rows = 現在の行番号
                        int nx = startX + (i / rows) * gapX;
                        int ny = startY + (i % rows) * gapY;

                        NonVisualBeanData bean = beans.get(i);
                        Javadoc javadoc = bean.node.getJavadoc();

                        int offset = javadoc.getStartPosition();
                        int length = javadoc.getLength();

                        String oldComment = doc.get(offset, length);
                        String newComment = oldComment.replaceAll("location=\\d+,\\d+", "location=" + nx + "," + ny);

                        if (!oldComment.equals(newComment)) {
                            multiEdit.addChild(new ReplaceEdit(offset, length, newComment));
                        }
                    }

                    if (multiEdit.hasChildren()) {
                        multiEdit.apply(doc);
                    }

                } catch (MalformedTreeException | BadLocationException e) {
                    Activator.logError("Failed to replace non-visual bean comment", e);
                } finally {
                    if (target != null) target.endCompoundChange();
                }
            }
        }
    }

    // ... (以下 extractNonVisualBeansComment と getPref は既存のまま) ...
    private static List<NonVisualBeanData> extractNonVisualBeansComment(CompilationUnit cu) {
        List<NonVisualBeanData> beans = new ArrayList<>();
        cu.accept(new ASTVisitor() {
            @Override
            public boolean visit(FieldDeclaration node) {
                Javadoc javadoc = node.getJavadoc();
                if (javadoc != null && javadoc.toString().contains("@wbp.nonvisual")) {
                    VariableDeclarationFragment frag = (VariableDeclarationFragment) node.fragments().get(0);
                    String fieldName = frag.getName().getIdentifier();
                    beans.add(new NonVisualBeanData(fieldName, node));
                }
                return true;
            }
        });
        return beans;
    }

    private static int getPref(ScopedPreferenceStore store, String key, int defaultValue) {
        int val = store.getInt(key);
        return (val == 0) ? defaultValue : val;
    }
}