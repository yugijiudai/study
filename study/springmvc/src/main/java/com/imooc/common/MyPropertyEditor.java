package com.imooc.common;

import com.imooc.entity.SpringUser;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-22
 */
public class MyPropertyEditor extends PropertyEditorSupport {



    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SpringUser springUser = new SpringUser();
        String[] textArray = text.split(",");
        springUser.setName(textArray[0]);
        springUser.setAge(Integer.parseInt(textArray[1]));
        this.setValue(springUser);
    }

    public static void main(String[] args) {
        MyPropertyEditor myPropertyEditor = new MyPropertyEditor();
        myPropertyEditor.setAsText("tom,22");
        System.out.println(myPropertyEditor.getValue());
    }
}
