package appium

import Utily
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.remote.MobilePlatform
import org.junit.After
import org.junit.Before
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit

open class BaseTest {

    lateinit var appDriver: AndroidDriver<MobileElement>

    private fun getAppiumDriver(): AndroidDriver<MobileElement> {
        with(DesiredCapabilities()) {

            setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID)
            setCapability(MobileCapabilityType.DEVICE_NAME, Utily.DEVICE_NAME)
            setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true)
            setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2)
            setCapability(MobileCapabilityType.APP, Utily.APK_PATH)

            return AndroidDriver(URL(Utily.APPIUM_URL), this)
        }
    }

    @Before
    fun setUp() {
        appDriver = getAppiumDriver()
        appDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) //設定每個動作的最長等待時間
    }

    @After
    fun tearDown() {
        appDriver.quit()
    }
}