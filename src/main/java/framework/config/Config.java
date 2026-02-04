package framework.config;

public class Config {
    // Reads a system property with a fallback default.
    public static String get(String key, String defaultValue) {
        // Always prefer CI/system properties, but allow local defaults.
        String v = System.getProperty(key);
        return (v == null || v.isBlank()) ? defaultValue : v;
    }

    // Reads a required system property and fails fast if missing.
    public static String required(String key) {
        // Failing fast makes CI failures obvious and debuggable.
        String v = System.getProperty(key);
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException("Missing required system property: " + key);
        }
        return v;
    }
}
