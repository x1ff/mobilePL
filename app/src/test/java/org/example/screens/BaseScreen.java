package org.example.screens;


import com.codeborne.selenide.Selenide;


public abstract class BaseScreen {

    protected BaseScreen() {
        Selenide.page(this);
    }

    public abstract void assertVisibleElements();

}
