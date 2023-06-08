package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @Test
    public void testProperName() {
        assertTrue(Regex.properName("Bob"));
        assertTrue(Regex.properName("Smith"));
        assertTrue(Regex.properName("Joey"));
        assertFalse(Regex.properName("bob"));
        assertFalse(Regex.properName("smiTh"));
        assertFalse(Regex.properName(""));
        assertFalse(Regex.properName(null));
        assertFalse(Regex.properName("1Bob"));
    }

    @Test
    public void testInteger() {
        assertTrue(Regex.integer("12"));
        assertTrue(Regex.integer("43.23"));
        assertTrue(Regex.integer("-34.5"));
        assertTrue(Regex.integer("+98.7"));
        assertTrue(Regex.integer("0"));
        assertTrue(Regex.integer("0.0230"));
        assertFalse(Regex.integer("023"));
        assertFalse(Regex.integer(".23"));
        assertFalse(Regex.integer(""));
        assertFalse(Regex.integer(null));
        assertFalse(Regex.integer("12..3"));
    }

    @Test
    public void testAncestor() {
        assertTrue(Regex.ancestor("father"));
        assertTrue(Regex.ancestor("mother"));
        assertTrue(Regex.ancestor("great-great-grandmother"));
        assertTrue(Regex.ancestor("great-great-great-grandfather"));
        assertFalse(Regex.ancestor("father_great-grandfather"));
        assertFalse(Regex.ancestor("mother_great-great-grandmother"));
        assertFalse(Regex.ancestor("great-great-grandpa"));
        assertFalse(Regex.ancestor(""));
        assertFalse(Regex.ancestor(null));
        assertFalse(Regex.ancestor("grandfather-great-father"));
    }
}
