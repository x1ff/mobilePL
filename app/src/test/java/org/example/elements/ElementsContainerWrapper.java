package org.example.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Container;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;

/**
 * Abstract class for wrap SelenideElement and prove some common methods.
 *
 */
public abstract class ElementsContainerWrapper implements Container {
    @Self
    SelenideElement self;

    public void assertText(String expectedText) {
        self.shouldBe(visible).shouldHave(Condition.text(expectedText));
    }

    public void assertVisible() {
        self.shouldBe(visible);
    }

    public void assertDissapear() {
        self.should(disappear);
    }

    public String getText() {
        return self.getText();
    }

    public boolean isDisplayed() {
        return self.isDisplayed();
    }

    public void checkTextContains(String expected) {
        self.should(Condition.text(expected));
    }
}
