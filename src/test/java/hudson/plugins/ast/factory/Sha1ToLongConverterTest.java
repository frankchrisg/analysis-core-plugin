package hudson.plugins.ast.factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import hudson.plugins.analysis.ast.Ast;
import hudson.plugins.analysis.ast.Sha1ToLongConverter;

/**
 * Tests the class {@link Ast}.
 *
 * @author Ullrich Hafner
 */
public class Sha1ToLongConverterTest {
    /** Verifies if the SHA1 values are correctly converted to a long value. */
    @Test
    public void shouldConvertSha1ToLong() {
        verify("0000000010101010101010101010101010101010", 0x111111111111111L);
        verify("00000000e0e0e0e0e0e0e0e0e0e0e0e0e0e0e0e0", 0xeeeeeeeeeeeeeeeL);
        verify("00000000f0f0f0f0f0f0f0f0f0f0f0f0f0f0f0f0", 0xfffffffffffffffL);
    }

    private void verify(final String sha1, final long expected) {
        Sha1ToLongConverter converter = new Sha1ToLongConverter();

        assertEquals(expected, converter.toLong(sha1));
    }
}