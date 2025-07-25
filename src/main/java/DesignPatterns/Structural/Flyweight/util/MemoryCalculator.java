// File: util/MemoryCalculator.java
package DesignPatterns.Structural.Flyweight.util;

public class MemoryCalculator {
    /**
     * Prints and return an estimate of total memory usage.
     *
     * @param label            A description for this calculation.
     * @param instanceCount    Number of instances sharing the same size.
     * @param bytesPerInstance Size in bytes per instance.
     */
    public static double calculate(String label, long instanceCount, int bytesPerInstance) {
        long totalBytes = instanceCount * (long) bytesPerInstance;
        double totalMB = totalBytes / (1024.0 * 1024.0);
        System.out.printf(
            "%s: %,d instances × %,d bytes = %.3f MB%n",
            label, instanceCount, bytesPerInstance, totalMB
        );
        return Math.round(totalMB * 1000.0) / 1000.0;
    }
}
/**
 * Standard Format Specifiers for Java (System.out.printf/String.format).
 *
 * **General Specifiers**
 * %d       : Integer (decimal).                               Example: 123
 * %,d      : Integer with thousands separator.                Example: 1,234
 * %f       : Floating-point (default: 6 decimal places).      Example: 123.456789
 * %.Nf     : Floating-point with N decimal places.           Example (%.2f): 123.46
 * %,f      : Floating-point with thousands separator.         Example: 1,234.567890
 * %e       : Floating-point in scientific notation (lowercase). Example: 1.234568e+02
 * %E       : Floating-point in scientific notation (uppercase). Example: 1.234568E+02
 * %g       : General format (compact scientific/decimal).     Example: 0.0000123 → 1.23e-5
 * %x       : Integer as hexadecimal (lowercase).              Example: 7b for 123
 * %X       : Integer as hexadecimal (uppercase).              Example: 7B for 123
 * %o       : Integer in octal (base 8).                       Example: 173 for 123
 * %s       : String.                                          Example: "Hello World"
 * %c       : Character.                                       Example: 'A', 'z', '1'
 * %b       : Boolean.                                         Example: true, false
 * %n       : Platform-independent newline.                   Example: Newline (\n or \r\n)
 * %%       : Literal %.                                       Example: %
 *
 * **Optional Modifiers**
 * %N       : Right-aligned integer, minimum width N.          Example (%10d): "       123"
 * %-N      : Left-aligned integer, minimum width N.           Example (%-10d): "123       "
 * %0N      : Integer/float, zero-padded to width N.           Example (%010d): "0000000123"
 * %,.Nf    : Floating-point with separator, N decimals.       Example: 1,234.46
 * %(       : Encloses negative numbers in parentheses.        Example (%(d): "(1234)"
 * %#x/%o   : Hexadecimal/Octal with prefix (0x, 0).           Example (%#x): "0x7b"
 */