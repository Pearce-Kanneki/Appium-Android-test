package appium

import Utily
import org.junit.Assert
import org.junit.Test

class HomeTest: BaseTest() {

    @Test
    fun clickNotValueButton_changerPage_returnNotValue() {
        with(appDriver) {

            findElementByXPath("${Utily.xPathName}android.view.View/android.view.View[3]/android.widget.Button").click()
            findElementByXPath("${Utily.xPathName}android.view.View/android.view.View[2]").also {
                Assert.assertEquals(it.text, "Not Value")
            }
        }
    }

    @Test
    fun clickValueButton_changerPage_returnValue() {
        val testValue = "Bit"
        with(appDriver) {

            findElementByXPath("${Utily.xPathName}android.view.View/android.widget.EditText").sendKeys(testValue)
            findElementByXPath("${Utily.xPathName}android.view.View/android.view.View[2]/android.widget.Button").click()
            findElementByXPath("${Utily.xPathName}android.view.View/android.view.View[2]").also {
                Assert.assertEquals(it.text, "Test: $testValue")
            }

        }
    }
}