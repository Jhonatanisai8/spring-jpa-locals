package com.jhonatan.springdatajpa.editor;

import java.beans.PropertyEditorSupport;

public class ConvertCapEditor
        extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}
