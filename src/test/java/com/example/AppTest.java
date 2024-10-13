package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@DisplayName("Junit 5 Test cases")
public class AppTest {


    @Test
    @DisplayName("a blank string utils test")
    public void whenCalledisBlank_thenCorrect() {
        assertEquals(Boolean.TRUE, StringUtils.isBlank(" "));
        assertEquals("nikhi...", (StringUtils.abbreviate("nikhil sharma", 8)));
    }

    @Test
    public void whenCalledisEmpty_thenCorrect() {
        assertEquals(Boolean.TRUE, StringUtils.isEmpty(""));
    }

    
}
