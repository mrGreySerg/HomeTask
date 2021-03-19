package ru.sergGrey;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StringUnpackerTest {

    @Test
    public void whenOnlyLetters() {
        String input = "abcd";
        String unpacker = StringUnpacker.unpacker(input);
        String expected = "abcd";
        assertThat(unpacker, is(expected));
    }

    @Test
    public void whenExpectedDoubleRepeat() {
        String input = "2[abc]";
        String unpacker = StringUnpacker.unpacker(input);
        String expected = "abcabc";
        assertThat(unpacker, is(expected));
    }

    @Test
    public void whenDifferentValues() {
        String input = "2[abc]dd2[jp]";
        String unpacker = StringUnpacker.unpacker(input);
        String expected = "abcabcddjpjp";
        assertThat(unpacker, is(expected));
    }

    @Test
    public void whenTemplateIsValid() {
        String input = "3[abc]dd3[pp]";
        assertTrue(StringUnpacker.validate(input));
    }

    @Test
    public void whenTemplateIsNotValid() {
        String input = "a[bc]ff";
        assertFalse(StringUnpacker.validate(input));
    }
}