package com.devtalles.proyecto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.devtalles.proyecto.log.model.LogEntry;
import com.devtalles.proyecto.log.model.LogSummary;
import com.devtalles.proyecto.log.service.LogProcessorTask;
import com.devtalles.proyecto.log.service.LogService;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Iniciando análisis de logs...");

        File logsFolder = new File("logs");
        File[] logFiles = logsFolder.listFiles((dir, name) -> name.endsWith(".log"));

        if (logFiles == null || logFiles.length == 0) {
            System.out.println(
                    "⚠️ No se encontraron archivos .log en la carpeta 'logs'. Asegúrate de crearla y poner archivos dentro.");
            return;
        }

        LogService logService = new LogService();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<LogSummary>> futures = new ArrayList<>(logFiles.length);

        for (File logFile : logFiles) {
            List<LogEntry> logEntries = logService.parseLogFile(logFile.getAbsolutePath());
            LogProcessorTask task = new LogProcessorTask(logEntries);
            futures.add(executorService.submit(task));
        }

        futures.stream()
                .forEach(future -> {
                    try {
                        var summary = future.get();
                        System.out.println(summary + "\n");
                    } catch (Exception e) {
                        System.err.println("Error al obtener el resumen: " + e.getMessage());
                    }
                });

    }
}