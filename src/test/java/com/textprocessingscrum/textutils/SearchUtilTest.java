package com.textprocessingscrum.textutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class SearchUtilTest {

    @InjectMocks
    private SearchUtil searchUtil;

    @Test
    void testSearch_caseSensitive() {
        List<List<Integer>> positions = searchUtil.search("regex", "regex", true);
        assertFalse(positions.isEmpty(), "Positions list should not be empty");
        assertEquals(1, positions.size(), "There should be one match");
        assertEquals(0, positions.getFirst().get(0).intValue(), "Start index should be 0");
        assertEquals(5, positions.getFirst().get(1).intValue(), "End index should be 4");
    }

    @Test
    void testSearch_caseInsensitive() {
        List<List<Integer>> positions = searchUtil.search("regex", "regex", false);
        assertFalse(positions.isEmpty(), "Positions list should not be empty");
        assertEquals(1, positions.size(), "There should be one match");
        assertEquals(0, positions.getFirst().get(0).intValue(), "Start index should be 0");
        assertEquals(5, positions.getFirst().get(1).intValue(), "End index should be 4");
    }

    @Test
    void testSearch_noMatches() {
        List<List<Integer>> positions = searchUtil.search("regex", "text", true);
        assertTrue(positions.isEmpty(), "Positions list should be empty");
    }
}