package com.example.icandle;

public final class IcandleCrashLibrary {
    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private IcandleCrashLibrary() {
        throw new AssertionError("No instances.");
    }
}
