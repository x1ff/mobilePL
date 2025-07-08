# mobilePL
PL MobileTesting IPR

## Run a test using
1. Создайте в корене проэкта директорию apk и разместите в ней apk файл
2. Создайте переменную окружения с именем  APK_DIR, укажите в ней абсолютный путь до директории
3. Измените используя application-template.properties создайте application.properties, укажите верные логин, пароль
4. Запустите сервер апиум

```appium```

5. Запустите эмулятор и посмотрете udid

```adb devices```
6. Измените настройки в application.properties

7. Чистим старое
```gradle clean```
8. Запускаем тесты
   ```gradle test --rerun```
9. Переходим в build директорию
```cd app/build```
10. Смотрим  allure report
```allure serve```


## Appium inspector 
````
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2"
}
````

## Мысли из собрания 14.02.2025
Задвача написать фреймворк на Appium и UI Automator

gradle - так как для мавена что-то там устарело

appium  устанавливается через js npm

фейковое одностраничное приложение с пустым экраном и рядом тесты на UI Automator

## links

https://appium.io/docs/en/latest/quickstart/

https://appium.io/docs/en/latest/quickstart/test-java/

https://github.com/appium/java-client#add-appium-java-client-to-your-test-framework

https://developer.android.com/training/testing/other-components/ui-automator

Инспектор для аппиума - https://github.com/appium/appium-inspector

инспектор для UiAutomator (если не запустится тот uiautomatorviewer который входит в поставку студии) - https://github.com/tarcv/uiautomatorviewer-gradle

Selenide-appium
https://github.com/selenide/selenide/tree/main/modules/appium
