package com.example.restfuljpa.domain;

/**
 * Enumeration of the region of California.
 *
 */
public enum Region {
    Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");

    public static Region findByLabel(final String byLabel) {
        for (final Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel)) {
                return r;
            }
        }
        return null;
    }

    private String label;

    private Region(final String label) {
        this.label = label;
    }
}
