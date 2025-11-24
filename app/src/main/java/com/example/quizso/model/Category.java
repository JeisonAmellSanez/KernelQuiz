package com.example.quizso.model;

public enum Category {
    TODOS("Todas las Categorías", "📚", "#6366F1"),
    PROCESOS("Procesos", "⚙️", "#8B5CF6"),
    MEMORIA("Gestión de Memoria", "💾", "#10B981"),
    ARCHIVOS("Sistemas de Archivos", "📁", "#F59E0B"),
    PLANIFICACION("Planificación", "📊", "#EF4444"),
    CONCURRENCIA("Concurrencia", "🔄", "#3B82F6"),
    ENTRADA_SALIDA("Entrada/Salida", "💿", "#EC4899");

    private final String displayName;
    private final String emoji;
    private final String color;

    Category(String displayName, String emoji, String color) {
        this.displayName = displayName;
        this.emoji = emoji;
        this.color = color;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getColor() {
        return color;
    }

    public String getFullName() {
        return emoji + " " + displayName;
    }
}
