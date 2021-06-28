package common;

public class Config {
    /**
     * Specify the browser  and planform for test:
     * CHROME_WINDOWS
     * MOZILA_WINDOWS
     * */
    public static final String BROWSER_AND_PLATFORM = "CHROME_WINDOWS"; //Выбор драйвера
    /** Clean browser cookies after each iteration */
    public static final Boolean CLEAR_COOKIES = true; //Если переменная true, то они будут отчищены (public class BaseTest)
    /** To keep  the browser open affter all scenario/teasts */
    public static final Boolean HOLD_BROWSER_OPEN = false; // Ессли переменная будет true - то браузер не закрывается.
    /** Clear the directory with the screen before starting the build */
    public static final Boolean CLEAR_REPORTS_DIR = true;
}
