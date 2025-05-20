package org.example.elements;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;

public class TextBlock extends ElementsContainerWrapper {


    public void assertText(String expectedText) {
        self.shouldBe(visible).shouldHave(Condition.text(expectedText));
    }

}
