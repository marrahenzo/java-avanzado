package com.devtalles.proyecto.log.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.devtalles.proyecto.log.model.LogEntry;

public class LogParser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Optional<LogEntry> parseLogEntry(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length != 5) {
                return Optional.empty();
            }
            LocalDateTime timestamp = LocalDateTime.parse(parts[0].trim(), formatter);
            String user = parts[1].trim();
            String action = parts[2].trim();
            int statusCode = Integer.parseInt(parts[3].trim());
            int responseTimeMs = Integer.parseInt(parts[4].trim());
            LogEntry entry = new LogEntry(timestamp, user, action, statusCode, responseTimeMs);
            return Optional.of(entry);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
