package enums;

public enum BrowserType {
    CHROME,
    FIREFOX;

    public static BrowserType from(String raw) {
        if (raw == null) return CHROME;
        String v = raw.trim().toUpperCase();
        try {
            return BrowserType.valueOf(v);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                    "Browser no soportado: '" + raw + "'. Soportados: " + java.util.Arrays.toString(values())
            );
        }
    }
}