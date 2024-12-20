package com.textprocessingscrum.textutils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class MatcherUtilTest {

    @InjectMocks
    private MatcherUtil matcherUtil;


    @Test
    void testMatch_CaseSensitive() {
        boolean matchFound = matcherUtil.match("regex", "regex", true);
        assertTrue(matchFound, "Match should be found");
    }

    @Test
    void testMatch_CaseInSensitive() {
        boolean matchFound = matcherUtil.match("regex", "regex", false);
        assertTrue(matchFound, "Match should be found");
    }
}
