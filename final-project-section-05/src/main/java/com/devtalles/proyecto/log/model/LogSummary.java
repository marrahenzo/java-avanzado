package com.devtalles.proyecto.log.model;

import java.util.Map;
import java.util.Set;

public class LogSummary {
    private int totalEntries;
    private int errorCount;
    private Set<String> uniqueUsers;
    private double averageResponseTime;
    private Map<Integer, Long> errorCountByCode;

    public LogSummary(int totalEntries, int errorCount, Set<String> uniqueUsers, double averageResponseTime, Map<Integer, Long> errorCountByCode) {
        this.totalEntries = totalEntries;
        this.errorCount = errorCount;
        this.uniqueUsers = uniqueUsers;
        this.averageResponseTime = averageResponseTime;
        this.errorCountByCode = errorCountByCode;
    }

    public String toString() {
        return "LogSummary{" +
                "totalEntries=" + totalEntries +
                ", errorCount=" + errorCount +
                ", uniqueUsers=" + uniqueUsers +
                ", averageResponseTime=" + averageResponseTime + "ms" +
                ", errorCountByCode=" + errorCountByCode +
                '}';
    }
}
