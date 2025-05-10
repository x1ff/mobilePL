package org.example.elements;


import com.codeborne.selenide.Condition;

/**
 * Custom element to represent buttons
 */
public class Button extends ElementsContainerWrapper {
    public void click() {
        self.shouldBe(Condition.visible).click();
    }
}
