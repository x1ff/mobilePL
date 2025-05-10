package org.example.elements;

import static com.codeborne.selenide.Condition.visible;

public class TextInput extends ElementsContainerWrapper {
    public void type(String text) {
        self.shouldBe(visible).sendKeys(text);
    }

}
