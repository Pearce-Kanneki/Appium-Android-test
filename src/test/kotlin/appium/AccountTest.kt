package appium

import Utily
import org.junit.Assert
import org.junit.Test

class AccountTest: BaseTest() {

    @Test
    fun setUserData_submit_showUserName() {
        with(appDriver) {

            findElementByXPath(Utily.TAB_ACCOUNT_NAME).click()

            findElementByXPath(Utily.ACCOUNT_ACCOUNT_EDITTEXT).sendKeys("root")
            findElementByXPath(Utily.ACCOUNT_PASSWORD_EDITTEXT).sendKeys("abc123")

            findElementByXPath(Utily.ACCOUNT_BUTTON).click()
            findElementByXPath(Utily.ACCOUT_CONTEXT_TEXT).also {
                Assert.assertEquals(it.text, "登入使用者: Root")
            }
        }
    }
}