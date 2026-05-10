# mobilePL
PL MobileTesting IPR

## Run Appium tests (Java application) JUint5 virtual devices
1. Создайте в корене проэкта директорию apk и разместите в ней apk файл
2. Создайте переменную окружения с именем  APK_DIR, укажите в ней абсолютный путь до директории
3. Используя application-template.properties создайте application.properties, укажите верные логин, пароль
4. Запустите сервер апиум
```appium```
5. Запустите эмулятор и посмотрете udid

```adb devices```
6. Измените udid в application.properties

7. Чистим старое
```gradle :app:clean```
8. Запускаем тесты
```gradle :app:test --rerun```
9. Смотрим  allure report
```allure serve app/build/allure-results```

## Run UiAtomator2 tests (Android empty project) JUint4 real device
1. Подключите устройство
2. Добавьте устройство (Running devices -> Add Device)
3. Используя application-template.properties создайте application.properties, укажите верные логин, пароль
4. Установите приложение
5. Чистим старое
```gradle :emptyapp:clean```
5. Запускаем тесты
```gradle :emptyapp:connectedDebugAndroidTest```
6. Смотрим  allure report
```allure serve emptyapp/build/allure-results```
7. 
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
