import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

class AppiumTest {

    lateinit var appDriver: AndroidDriver<MobileElement>

    fun getAppiumDriver(): AndroidDriver<MobileElement> {

        val capabilities = DesiredCapabilities().apply {
            setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID)
            setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 29")
            setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
            setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2)
            setCapability(MobileCapabilityType.APP, "/Users/kannekichen/Desktop/app.apk")
        }
        return AndroidDriver(URL("http://127.0.0.1:4723/wd/hub"), capabilities)
    }

    @Before
    fun setUp() {
        appDriver = getAppiumDriver()
    }

    @After
    fun tearDown() {
        appDriver.quit()
    }

//    @Test
//    fun testAppium() {
//        with(appDriver) {
//            manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) //設定每個動作的最長等待時間
//            findElementById("button").click() //進入MainActivity後透過ID尋找button元件並呼叫click點擊
//            //進入ListActivity後利用xpath抓取RecyclerView裡的元件(請參閱Day25的說明明
//            val userList = findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout\n")
//            //我們click第一個item
//            userList[0].click()
//            //進入DetailActivity後抓取editText並輸入God
//            findElementById("editText").sendKeys("God")
//            //找到Button元件點擊
//            findElementById("button").click()
//            //最後用assertEquals方式判斷textView裡的字串是不是跟預期一樣。
//            assertEquals(findElementById("textView").text, "God is level 10")
//        }
//    }

    @Test
    fun testAppChangerPage() {
        with(appDriver) {
            manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) //設定每個動作的最長等待時間

            findElementByXPath("${Utily.xPathName}android.view.View[3]/android.widget.Button").click()
            findElementByXPath("${Utily.xPathName}android.view.View[2]").also {
                assertEquals(it.text, "Not Value")
            }
        }
    }
}