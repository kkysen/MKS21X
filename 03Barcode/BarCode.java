public class Barcode implements Comparable<Barcode>, Cloneable {
    
    private static final HashMap<Integer, String> ENCODING = new HashMap<>(10);
    static {
        ENCODING.put(0, "||:::");
        ENCODING.put(1, ":::||");
        ENCODING.put(2, "::|:|");
        ENCODING.put(3, "::||:");
        ENCODING.put(4, ":|::|");
        ENCODING.put(5, ":|:|:");
        ENCODING.put(6, ":||::");
        ENCODING.put(7, "|:::|");
        ENCODING.put(8, "|::|:");
        ENCODING.put(9, "|:|::");
    }
    
    private final String zip;
    private int zipCode;
    private int checkDigit;
    private final String toString;
    
    public Barcode(String zip) {
        if (zip.length() != 5) {
            throw new IllegalArgumentException("length must be 5; given: " + zip.length());
        }
        this.zip = zip;
        checkDigit = 0;
        StringBuilder sb = new StringBuilder("|");
        for (int i = 0; i < zip.length(); i++) {
            char digit = zip.charAt(i);
            if (digit < '0' || digit > '9') {
                throw new IllegalArgumentException("zip must be all digits; found " + digit + " at index " + i);
            }
            checkDigit += (int) digit - '0';
            sb.append(ENCODING.get(digitVal));
        }
        checkDigit %= 10;
        zipCode = Integer.parseInt(zip);
        zipCode = zipCode * 10 + checkDigit;
        sb.append(ENCODING.get(checkDigit));
        sb.append("|");
        toString = sb.toString();
    }
    
    // for cloning
    private Barcode(Barcode other) {
        zip = other.zip;
        zipCode = other.zipCode;
        checkDigit = other.checkDigit;
        toString = other.toString;
    }
    
    public Barcode clone() {
        return new Barcode(this);
    }
    
    private int checkSum() {
        return checkDigit;
    }
    
    public String toString() {
        return toString;
    }
    
    public int compareTo(Barcode other) {
        return zipCode - other.zipCode;
    }
    
}
