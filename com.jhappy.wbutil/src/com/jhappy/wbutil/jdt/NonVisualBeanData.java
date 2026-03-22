package com.jhappy.wbutil.jdt;

import org.eclipse.jdt.core.dom.FieldDeclaration;

/**
 * A data transfer object (DTO) that holds information about a WindowBuilder Non-Visual Bean.
 * This class links the Java field name with its corresponding AST node for layout processing.
 */
public class NonVisualBeanData {

    /**
     * The identifier of the Java field (e.g., "myListModel").
     */
    public String fieldName;

    /**
     * The AST node representing the field declaration in the source code.
     * This is used to locate and update the @wbp.nonvisual Javadoc tag.
     */
    public FieldDeclaration node;

    /**
     * Default constructor.
     */
    public NonVisualBeanData() {
    }

    /**
     * Constructs a new bean data object with the specified field name and node.
     * * @param fieldName The name of the Java field.
     * @param node The AST FieldDeclaration node.
     */
    public NonVisualBeanData(String fieldName, FieldDeclaration node) {
        this.fieldName = fieldName;
        this.node = node;
    }
}