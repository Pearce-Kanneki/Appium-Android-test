package appium

import Utily
import org.junit.Test

class ListTest: BaseTest() {

    @Test
    fun clickAddButton_ListAddItem() {
        with(appDriver) {

            findElementByXPath(Utily.TAB_LIST_NAME).click()
            findElementByAndroidUIAutomator(findText("Title 10"))
            findElementByXPath(Utily.LIST_ADD_BUTTON).click()
            findElementByAndroidUIAutomator(findText("New Title 11"))

        }
    }

    private fun findText(value: String): String {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                "scrollIntoView(new UiSelector().text(\"$value\").instance(0));"
    }
}