package org.example.pagefactory;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.impl.ElementFinder;
import com.codeborne.selenide.impl.SelenidePageFactory;
import com.codeborne.selenide.impl.WebElementSource;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.screens.BaseScreen;
import org.openqa.selenium.By;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class SearchContextPageFactory extends SelenidePageFactory {
    private final Constructor<ElementFinder> elementFinderConstructor;
    {
        try {
            elementFinderConstructor = ElementFinder.class.getDeclaredConstructor(
                    Driver.class,
                    WebElementSource.class,
                    By.class,
                    int.class
            );
            elementFinderConstructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public <PageObjectClass, T extends PageObjectClass> PageObjectClass page(Driver driver, T pageObject) {
        Type[] types = pageObject.getClass().getGenericInterfaces();
        initElements(driver, getSearchContext(pageObject, driver), pageObject, types);
        return pageObject;
    }


    private WebElementSource getSearchContext(Object page, Driver driver) {
        Class<?> klass = page.getClass();
        if (!BaseScreen.class.isAssignableFrom(klass) || !klass.isAnnotationPresent(AndroidFindBy.class)) return null;
        AndroidFindBy annotation = klass.getAnnotation(AndroidFindBy.class);
        By by = transformAndroidFindByToBy(annotation);
        try {
            return elementFinderConstructor.newInstance(driver, null, by, 0);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Transforms a AndroidFindBy annotation to a By locator.
     *
     * @param findBy The FindBy annotation which should be transformed to a By locator.
     * @return The locator which was created from the given parameter.
     **/
    public By transformAndroidFindByToBy(AndroidFindBy findBy) {
        if (findBy == null) {
            return null;
        } else if (findBy.id() != null && !findBy.id().isEmpty()) {
            return By.id(findBy.id());
        } else if (findBy.xpath() != null && !findBy.xpath().isEmpty()) {
            return By.xpath(findBy.xpath());
        } else if (findBy.className() != null && !findBy.className().isEmpty()) {
            return By.className(findBy.className());
        } else if (findBy.tagName() != null && !findBy.tagName().isEmpty()) {
            return By.tagName(findBy.tagName());
        }

        throw new IllegalArgumentException("AndroidFindBy could not be mapped to By: " + findBy.toString());
    }
}
