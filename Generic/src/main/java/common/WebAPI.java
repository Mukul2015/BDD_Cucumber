package common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import reporting.TestLogger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WebAPI {
    // Config Class
    /**
     * **************************************************
     * ********** Start Of Reporting Utilities **********
     * **************************************************
     * **************************************************
     * */
    //ExtentReport
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) throws Exception {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }
        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
//            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
//            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
           // String screenshotPath = captureScreenshotPath(driver, result.getName());
            //To add it in the extent report
            //logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            //captureScreenshot(driver, result.getName());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(captureScreenshot(driver, result.getName())));
        }
        driver.close();
        //driver.quit();
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(logger);
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(yyMMddHHmmssZ)");
        //DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + " " + df.format(date) + ".png";
        try {
            FileUtils.copyFile(file, new File(fileName));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return fileName;
    }

    public static String captureScreenshotPath(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + " " + dateName + ".png";
        try {
            FileUtils.copyFile(file, new File(fileName));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return fileName;
    }

    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }


    public static WebDriver driver = null;
    public static String browserStack_userName = "dety3";
    public static String browserStack_accesskey = "vJdjFiR7mhifEJCFg8NT";
    public static String sauceLabs_userName = "akter008";
    public static String sauceLabs_accesskey = "9ff10309-cb96-45ad-ba2b-73679041145d";
    public static final String browserStack_URL = "https://" + browserStack_userName + ":" + browserStack_accesskey + "@hub-cloud.browserstack.com/wd/hub";
    // public static final String sauceLabs_URL = "https://" + sauceLabs_userName + ":" + sauceLabs_accesskey + "@ondemand.saucelabs.com:80/wd/hub";
    public static final String sauceLabs_URL = "https://" + sauceLabs_userName + ":" + sauceLabs_accesskey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";


    public void openBrowser(String url) throws MalformedURLException {
        setUp(false,"browserStack","windows","10","chrome","89",url);
    }

    @Parameters({"useCloudEnv", "cloudEnvName", "OS", "osVersion", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(boolean useCloudEnv, String cloudEnvName, String os, String osVersion, String browserName, String browserVersion, String url) throws MalformedURLException {
        if (useCloudEnv == true) {
            if (cloudEnvName.equalsIgnoreCase("browserStack")) {
                getCloudDriver(cloudEnvName, browserStack_userName, browserStack_accesskey, os, osVersion, browserName, browserVersion);
            } else if (cloudEnvName.equalsIgnoreCase("sauceLabs")) {
                getCloudDriver(cloudEnvName, sauceLabs_userName, sauceLabs_accesskey, os, osVersion, browserName, browserVersion);
            }
        } else {
            getLocalDriver(os, browserName);
            // getLocalDriverAutomatically(os, browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Navigate to URL
        driver.get(url);
    }
    /**
     * Chromium Command Line Arguments
     * https://peter.sh/experiments/chromium-command-line-switches/
     * */
    /**
     * https://chercher.tech/java/chrome-firefox-options-selenium-webdriver
     *
     * */

    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/mac/chromedriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            if (os.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/mac/chromedriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver(options); }
            else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            //options.setHeadless(true);
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--private");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            if (os.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/BrowserDriver/mac/geckodriver");
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/BrowserDriver/windows/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.ie.driver", "../Generic/BrowserDriver/windows/IEDriverServer.exe");
            }
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            if (os.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.safari.driver", "../Generic/BrowserDriver/mac/safari");
            }
            driver = new SafariDriver();
        }
        return driver;
    }
    public WebDriver getLocalDriverAutomatically(String os, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("OS X")) {
                WebDriverManager.chromedriver().setup();
            } else if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.chromedriver().setup();
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            if (os.equalsIgnoreCase("OS X")) {
                WebDriverManager.chromedriver().setup();
            } else if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.chromedriver().setup();
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("OS X")) {
                WebDriverManager.firefoxdriver().setup();
            } else if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/BrowserDriver/windows/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            if (os.equalsIgnoreCase("windows")) {
                WebDriverManager.iedriver().setup();
            }
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            if (os.equalsIgnoreCase("OS X")) {
                // WebDriverManager.safari().setup();
            }
            driver = new SafariDriver();
        }
        return driver;
    }
    public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {
        // Set these values in your capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browserName);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", os);
        caps.setCapability("os_version", osVersion);
        if (envName.equalsIgnoreCase("sauceLabs")) {
            driver = new RemoteWebDriver(new URL(sauceLabs_URL), caps);
        } else if (envName.equalsIgnoreCase("browserStack")) {
            caps.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL(browserStack_URL), caps);
        }
        return driver;
    }
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void waitFor(int seconds) throws InterruptedException {
        // Wait 5 seconds
        Thread.sleep(1000 * seconds);
    }
    // Helper Method
    // Our code should be dynamic and reusable

    public void clickOnElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.className(locator)).click();
            } catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {
                    try {
                        driver.findElement(By.xpath(locator)).click();
                    } catch (Exception ex4) {
                        driver.findElement(By.linkText(locator)).click();
                    }

                }
            }
        }
    }
    public void clickOnElement2(String locator) {
//        if (locator== "id"){
//            driver.findElement(By.id(locator)).click();
//        } else if ()

        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.className(locator)).click();
            } catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {
                    try {
                        driver.findElement(By.xpath(locator)).click();
                    } catch (Exception ex4) {
                        driver.findElement(By.linkText(locator)).click();
                    }

                }
            }
        }
    }

    public void typeOnElement(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).sendKeys(value);
            } catch (Exception ex1) {
                driver.findElement(By.id(locator)).sendKeys(value);
            }

        }
    }
    // Useful for @FindBy Approach
    public void typeOnElement1(WebElement locator, String value) {
        try {
            locator.sendKeys(value);
        } catch (Exception ex) {
            locator.sendKeys(value);
        }
    }
    // Useful for @FindBy Approach: Best based on performance
    public void typeOnElement2(WebElement locator, String value) {
        locator.sendKeys(value);
    }

    public static void typeOnElementNEnter(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    public static void typeOnElementNEnter(String locator, String value, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver1.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver1.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver1.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }
    public void clearField(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(String locator, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            try {
                driver1.findElement(By.xpath(locator)).click();
            } catch (Exception ex2) {
                driver1.findElement(By.id(locator)).click();
            }
        }
    }
    public void typeOnInputField(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.id(locator)).sendKeys(value);
        }
    }
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }


    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }
    public static List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<>();
        List<String> text = new ArrayList<>();
        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }
    public static List<String> getTextFromWebElements(String locator, WebDriver driver1) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver1.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }
    public static List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }
    public static List<WebElement> getListOfWebElementsByCss(String locator, WebDriver driver1) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver1.findElements(By.cssSelector(locator));
        return list;
    }

    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }


    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }
    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }
    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByXpath1(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenShots.png"));
    }

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }
    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    //Handling New Tabs
    public static WebDriver handleNewTab(WebDriver driver1) {
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(1));
        return driver1;
    }
    public static WebDriver handleNewTab1(WebDriver driver1) {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String>it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        return driver1;
    }
    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
        boolean value = driver1.findElement(By.cssSelector(locator)).isDisplayed();
        return value;
    }
    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }
    // Customer Made Helper Methods for Amex.com
    public void brokenLink() throws IOException {
        //Step:1-->Get the list of all the links and images
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total number of links and images--------->>> " + linksList.size());

        //Step:2-->Iterate linksList: exclude all links/images which does not have any href attribute
        List<WebElement> activeLinks = new ArrayList<WebElement>();
        for (int i = 0; i < linksList.size(); i++) {
            //System.out.println(linksList.get(i).getAttribute("href"));
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript") && (!linksList.get(i).getAttribute("href").contains("mailto")))) {
                activeLinks.add(linksList.get(i));
            }
        }
        System.out.println("Total number of active links and images-------->>> " + activeLinks.size());

        //Step:3--> Check the href url, with http connection api
        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "--------->>> " + response);
        }
    }
    public void inputValueInTextBoxByWebElement(WebElement webElement, String value) {
        webElement.sendKeys(value + Keys.ENTER);
    }

    public void clearInputBox(WebElement webElement) {
        webElement.clear();
    }

    public String getTextByWebElement(WebElement webElement) {
        String text = webElement.getText();
        return text;
    }
    public void getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        System.out.println(" my test suite started at this time --> " + formatter.format(date));
    }
    // --------------------- EDIT BOX / TYPE -----------------------
    public void typeByXpath1(String loc, String val) {
        driver.findElement(By.xpath(loc)).clear();
        driver.findElement(By.xpath(loc)).sendKeys(val);
    }
    public void typeByCss1(String loc, String val) {
        driver.findElement(By.cssSelector(loc)).clear();
        driver.findElement(By.cssSelector(loc)).sendKeys(val);
    }
    public void typeById(String loc, String val) {
        driver.findElement(By.id(loc)).sendKeys(val);
    }

    public void typeByName(String loc, String val) {
        driver.findElement(By.name(loc)).sendKeys(val);
    }

    // ------------------- CLICK -----------------
    public void clickByXpath1(String loc) {
        driver.findElement(By.xpath(loc)).click();
    }

    public void clickByCss(String loc) {
        driver.findElement(By.cssSelector(loc)).click();
    }

    public void clickById(String loc) {
        driver.findElement(By.id(loc)).click();
    }

    public void clickByName(String loc) {
        driver.findElement(By.name(loc)).click();
    }

    public void clickByLinkText(String loc) {
        driver.findElement(By.linkText(loc)).click();
    }

    // ---------------- RADIO BUTTON
    public void assertEqualByXpath(String loc, String expValue) {
        String act = driver.findElement(By.xpath(loc)).getText();
        // act is coming from Domain -- the one developer build and release
        String exp = expValue; // exp is coming from Requirement or Mock-up
        Assert.assertEquals(act, exp);
    }
    // Slider Handlaing
    // https://stackoverflow.com/questions/15171745/how-to-slidemove-slider-in-selenium-webdriver

    public void waitTimeExplicit(String locator) {
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    public void waitTimeUsingFluent(String locator) {
        // Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 30 seconds")
                .ignoring(NoSuchElementException.class);
    }
    public void clickOnElement1(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).click();
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).click();
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).click();
                        }
                    }
                }
            }
        }
    }
    public void typeOnElement1(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).sendKeys(value);
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).sendKeys(value);
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).sendKeys(value);
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).sendKeys(value);
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).sendKeys(value);
                        }
                    }
                }
            }
        }
    }
    public void clickOnLink(String locator) {
        try {
            driver.findElement(By.linkText(locator)).click();
        } catch (Exception ex) {
            driver.findElement(By.partialLinkText(locator)).click();
        }
    }
    public void getTitle() {
        TestLogger.log("Get Title ");
        driver.getTitle();
    }
    public void clearField1(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).clear();
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).clear();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).clear();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).clear();
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).clear();
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).clear();
                        }
                    }
                }
            }
        }
    }
    public String getCurrentUrl() {
        TestLogger.log("Get Current URL ");
        String url = driver.getCurrentUrl();
        return url;
    }
    public static String getText(WebElement webElement, String webElementName) {
        TestLogger.log("Getting Text from " + webElementName);
        String actualText = webElement.getText();
        TestLogger.log("Actual text: " + actualText);
        return actualText;
    }
    public static void selectByIndex( WebElement element, int i){
        Select select = new Select(element);
        TestLogger.log("Select option at index " + i);
        select.selectByIndex(i);
        TestLogger.log("Selected option at index " + i);

    }
}









