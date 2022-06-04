package org.javastudy.documents.util;

import static java.lang.Math.round;

public final class AnalysesUtil {
    private AnalysesUtil() {}

    public static short calculateRatio(long count, long totalCount) {
        return (short) round(count * 100.0 / totalCount);
    }
}
