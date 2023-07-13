package e2e.utils;

import org.junit.jupiter.api.Assertions;

public class Assertion {
    public void shouldBeEqual(String actual, String expected) {
        Assertions.assertEquals(actual, expected);
    }

    public void shouldBeDifferent(String actual, String expected) {
        Assertions.assertNotEquals(actual, expected);
    }

    public void shouldBeTrue(Boolean actual_boolean) {
        Assertions.assertTrue(actual_boolean);
    }

    public void shouldBeFalse(Boolean actual_boolean) {
        Assertions.assertFalse(actual_boolean);
    }

}
