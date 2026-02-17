package support;

import org.junit.Assert;
import org.openqa.selenium.By;

public final class CustomAssertions {

    private CustomAssertions() {}

    public static void assertElementVisible(boolean actualCondition, By element, String elementName) {
        if (!actualCondition) {
            String message = String.format(
                    "[VALIDATION FAILED] Element: %s | Locator: %s | Expected: visible | Actual: not visible",
                    elementName,
                    element.toString()
            );
            Assert.fail(message);
        }
    }

    public static void assertEqualsText(String expected, By element, String actual, String elementName) {
        if (actual == null) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Locator: %s | Expected text: '%s' | Actual text: <NULL> (element not found or empty)",
                    elementName, element, expected
            ));
        }

        if (expected == null) {
            Assert.fail(String.format(
                    "[ASSERT CONFIG ERROR] Expected text is NULL for element: %s | Locator: %s",
                    elementName, element
            ));
        }

        if (!expected.equals(actual)) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Locator: %s | Expected text: '%s' | Actual text: '%s'",
                    elementName, element, expected, actual
            ));
        }
    }

    public static void assertEqualsUrl(String expected, String actual, String elementName) {
        if (!expected.equals(actual)) {
            String message = String.format(
                    "[VALIDATION FAILED] Element: %s | Expected url: '%s' | Actual url: '%s'",
                    elementName, expected, actual
            );
            Assert.fail(message);
        }
    }
}
