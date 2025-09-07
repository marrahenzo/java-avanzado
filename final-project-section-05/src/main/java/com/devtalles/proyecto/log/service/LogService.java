package com.devtalles.proyecto.log.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devtalles.proyecto.log.model.LogEntry;
import com.devtalles.proyecto.log.util.LogParser;

public class LogService {

    public List<LogEntry> parseLogFile(String filePath) {
        try {
            return Files.lines(Path.of(filePath))
                .map(LogParser::parseLogEntry)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return List.of();
        }
    }
}
