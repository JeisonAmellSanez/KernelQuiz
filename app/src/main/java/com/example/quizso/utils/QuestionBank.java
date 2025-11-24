package com.example.quizso.utils;

import com.example.quizso.model.Question;
import com.example.quizso.model.AnswerOption;
import com.example.quizso.model.Category;
import java.util.*;
import java.util.stream.Collectors;

public class QuestionBank {
    
    public static List<Question> getQuestions() {
        return getAllQuestions();
    }
    
    public static List<Question> getQuestionsByCategory(Category category) {
        if (category == Category.TODOS) {
            return getAllQuestions();
        }
        return getAllQuestions().stream()
                .filter(q -> q.getCategory() == category)
                .collect(Collectors.toList());
    }
    
    private static List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        // ==================== PROCESOS (20 preguntas) ====================
        questions.add(new Question(
                "¿Qué es un proceso en un sistema operativo?",
                Arrays.asList(
                        new AnswerOption("Un archivo de configuración", false),
                        new AnswerOption("Un programa en ejecución", true),
                        new AnswerOption("Un tipo de memoria caché", false),
                        new AnswerOption("Un dispositivo de entrada", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Cuál de los siguientes NO es un estado de un proceso?",
                Arrays.asList(
                        new AnswerOption("Listo", false),
                        new AnswerOption("Ejecutando", false),
                        new AnswerOption("Bloqueado", false),
                        new AnswerOption("Compilado", true)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un hilo (thread)?",
                Arrays.asList(
                        new AnswerOption("Un proceso independiente", false),
                        new AnswerOption("La unidad más pequeña de ejecución en un proceso", true),
                        new AnswerOption("Un tipo de archivo de sistema", false),
                        new AnswerOption("Un error de segmentación", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un proceso huérfano?",
                Arrays.asList(
                        new AnswerOption("Un proceso cuyo padre ha terminado", true),
                        new AnswerOption("Un proceso que consume mucha memoria", false),
                        new AnswerOption("Un virus informático", false),
                        new AnswerOption("Un proceso en estado bloqueado", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un proceso zombie?",
                Arrays.asList(
                        new AnswerOption("Un proceso que consume recursos excesivos", false),
                        new AnswerOption("Un proceso terminado pero aún en la tabla", true),
                        new AnswerOption("Un proceso infectado por malware", false),
                        new AnswerOption("Un proceso en modo kernel", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el kernel?",
                Arrays.asList(
                        new AnswerOption("La interfaz gráfica del usuario", false),
                        new AnswerOption("El núcleo del sistema operativo", true),
                        new AnswerOption("Un tipo de virus", false),
                        new AnswerOption("Un archivo de registro", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el modo usuario vs modo kernel?",
                Arrays.asList(
                        new AnswerOption("Diferentes interfaces gráficas", false),
                        new AnswerOption("Niveles de privilegio para ejecutar instrucciones", true),
                        new AnswerOption("Tipos de archivos", false),
                        new AnswerOption("Métodos de compresión", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un sistema monolítico?",
                Arrays.asList(
                        new AnswerOption("Un SO con kernel dividido en módulos", false),
                        new AnswerOption("Un SO donde el kernel es una sola unidad grande", true),
                        new AnswerOption("Un SO sin memoria virtual", false),
                        new AnswerOption("Un SO para dispositivos móviles", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el PCB (Process Control Block)?",
                Arrays.asList(
                        new AnswerOption("Estructura que almacena información del proceso", true),
                        new AnswerOption("Un tipo de memoria caché", false),
                        new AnswerOption("Protocolo de comunicación", false),
                        new AnswerOption("Un comando del sistema", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el context switch?",
                Arrays.asList(
                        new AnswerOption("Cambio de modo usuario a kernel", false),
                        new AnswerOption("Guardar estado de un proceso y cargar otro", true),
                        new AnswerOption("Intercambio de memoria", false),
                        new AnswerOption("Actualización del SO", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un daemon en Unix/Linux?",
                Arrays.asList(
                        new AnswerOption("Un proceso que se ejecuta en segundo plano", true),
                        new AnswerOption("Un tipo de archivo", false),
                        new AnswerOption("Un comando de terminal", false),
                        new AnswerOption("Un error del sistema", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es la multiprogramación?",
                Arrays.asList(
                        new AnswerOption("Varios usuarios usando el mismo programa", false),
                        new AnswerOption("Múltiples programas cargados en memoria simultáneamente", true),
                        new AnswerOption("Programas escritos en varios lenguajes", false),
                        new AnswerOption("Ejecutar el mismo programa varias veces", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el fork() en sistemas Unix?",
                Arrays.asList(
                        new AnswerOption("Dividir un archivo en partes", false),
                        new AnswerOption("Crear un proceso hijo duplicando el padre", true),
                        new AnswerOption("Terminar un proceso", false),
                        new AnswerOption("Cambiar prioridad de proceso", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un proceso en primer plano (foreground)?",
                Arrays.asList(
                        new AnswerOption("Proceso que interactúa con el usuario y tiene control del terminal", true),
                        new AnswerOption("Proceso con máxima prioridad", false),
                        new AnswerOption("Proceso visible en el escritorio", false),
                        new AnswerOption("Proceso del kernel", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es la syscall (llamada al sistema)?",
                Arrays.asList(
                        new AnswerOption("Solicitud de un programa al kernel para realizar operación", true),
                        new AnswerOption("Llamada telefónica del sistema", false),
                        new AnswerOption("Función de biblioteca", false),
                        new AnswerOption("Comando de terminal", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el time quantum en planificación?",
                Arrays.asList(
                        new AnswerOption("Tiempo asignado a un proceso en Round Robin", true),
                        new AnswerOption("Velocidad del procesador", false),
                        new AnswerOption("Tiempo de arranque del SO", false),
                        new AnswerOption("Intervalo de respaldo", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué hace la llamada exec() en Unix?",
                Arrays.asList(
                        new AnswerOption("Ejecuta comandos del shell", false),
                        new AnswerOption("Reemplaza el proceso actual con un nuevo programa", true),
                        new AnswerOption("Duplica un proceso", false),
                        new AnswerOption("Termina un proceso", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el PID (Process ID)?",
                Arrays.asList(
                        new AnswerOption("Identificador único numérico de un proceso", true),
                        new AnswerOption("Prioridad del proceso", false),
                        new AnswerOption("Puerto de comunicación", false),
                        new AnswerOption("Tipo de procesador", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es un proceso cooperativo?",
                Arrays.asList(
                        new AnswerOption("Proceso que puede afectar o ser afectado por otros procesos", true),
                        new AnswerOption("Proceso que ayuda al usuario", false),
                        new AnswerOption("Proceso que trabaja en red", false),
                        new AnswerOption("Proceso multihilo", false)
                ),
                Category.PROCESOS
        ));

        questions.add(new Question(
                "¿Qué es el IPC (Inter-Process Communication)?",
                Arrays.asList(
                        new AnswerOption("Mecanismo para que procesos intercambien datos", true),
                        new AnswerOption("Protocolo de internet", false),
                        new AnswerOption("Tipo de procesador", false),
                        new AnswerOption("Instrucción del CPU", false)
                ),
                Category.PROCESOS
        ));

        // ==================== MEMORIA (20 preguntas) ====================
        questions.add(new Question(
                "¿Qué es la memoria virtual?",
                Arrays.asList(
                        new AnswerOption("Memoria simulada en el disco duro", true),
                        new AnswerOption("Memoria RAM de alta velocidad", false),
                        new AnswerOption("Memoria de solo lectura", false),
                        new AnswerOption("Memoria del procesador", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la paginación?",
                Arrays.asList(
                        new AnswerOption("Dividir memoria en bloques de tamaño fijo", true),
                        new AnswerOption("Ordenar archivos en disco", false),
                        new AnswerOption("Comprimir datos", false),
                        new AnswerOption("Cifrar información", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la fragmentación interna?",
                Arrays.asList(
                        new AnswerOption("Espacio desperdiciado dentro de un bloque asignado", true),
                        new AnswerOption("Archivos borrados del disco", false),
                        new AnswerOption("Errores de memoria", false),
                        new AnswerOption("Caché del procesador", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la fragmentación externa?",
                Arrays.asList(
                        new AnswerOption("Espacio libre disperso entre bloques asignados", true),
                        new AnswerOption("Pérdida de datos", false),
                        new AnswerOption("Memoria corrupta", false),
                        new AnswerOption("Disco duro dañado", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la segmentación de memoria?",
                Arrays.asList(
                        new AnswerOption("Dividir memoria en segmentos lógicos de tamaño variable", true),
                        new AnswerOption("Particionar disco duro", false),
                        new AnswerOption("Comprimir archivos", false),
                        new AnswerOption("Encriptar datos", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el TLB (Translation Lookaside Buffer)?",
                Arrays.asList(
                        new AnswerOption("Caché para traducciones de direcciones virtuales", true),
                        new AnswerOption("Memoria RAM secundaria", false),
                        new AnswerOption("Búfer de entrada/salida", false),
                        new AnswerOption("Registro del procesador", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es un page fault?",
                Arrays.asList(
                        new AnswerOption("Acceso a página no presente en RAM", true),
                        new AnswerOption("Error de disco duro", false),
                        new AnswerOption("Fallo de CPU", false),
                        new AnswerOption("Virus informático", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo LRU (Least Recently Used)?",
                Arrays.asList(
                        new AnswerOption("Reemplaza la página menos recientemente usada", true),
                        new AnswerOption("Optimiza uso de CPU", false),
                        new AnswerOption("Ordena archivos", false),
                        new AnswerOption("Gestiona procesos", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el thrashing?",
                Arrays.asList(
                        new AnswerOption("Excesivo intercambio de páginas entre RAM y disco", true),
                        new AnswerOption("Velocidad máxima del CPU", false),
                        new AnswerOption("Limpieza de caché", false),
                        new AnswerOption("Modo de depuración", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la memoria caché?",
                Arrays.asList(
                        new AnswerOption("Memoria muy rápida entre CPU y RAM", true),
                        new AnswerOption("Memoria de almacenamiento permanente", false),
                        new AnswerOption("Memoria del disco", false),
                        new AnswerOption("Memoria virtual", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el working set de un proceso?",
                Arrays.asList(
                        new AnswerOption("Conjunto de páginas que usa actualmente", true),
                        new AnswerOption("Directorio de trabajo", false),
                        new AnswerOption("Conjunto de archivos abiertos", false),
                        new AnswerOption("Lista de procesos activos", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es swap space?",
                Arrays.asList(
                        new AnswerOption("Espacio en disco usado como memoria virtual", true),
                        new AnswerOption("Memoria RAM libre", false),
                        new AnswerOption("Espacio de caché", false),
                        new AnswerOption("Partición del sistema", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo FIFO en reemplazo de páginas?",
                Arrays.asList(
                        new AnswerOption("Reemplaza la página más antigua en memoria", true),
                        new AnswerOption("Ordena procesos por llegada", false),
                        new AnswerOption("Gestiona cola de impresión", false),
                        new AnswerOption("Organiza archivos", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la tabla de páginas?",
                Arrays.asList(
                        new AnswerOption("Estructura que mapea direcciones virtuales a físicas", true),
                        new AnswerOption("Lista de procesos en ejecución", false),
                        new AnswerOption("Índice de archivos", false),
                        new AnswerOption("Registro del kernel", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la memoria compartida?",
                Arrays.asList(
                        new AnswerOption("Región de memoria accesible por múltiples procesos", true),
                        new AnswerOption("Disco duro en red", false),
                        new AnswerOption("Caché del navegador", false),
                        new AnswerOption("Partición pública", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo del reloj (Clock) para reemplazo?",
                Arrays.asList(
                        new AnswerOption("Variante de FIFO con bit de referencia", true),
                        new AnswerOption("Sincronización de procesos", false),
                        new AnswerOption("Temporizador del sistema", false),
                        new AnswerOption("Planificador en tiempo real", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el dirty bit en paginación?",
                Arrays.asList(
                        new AnswerOption("Indica si una página fue modificada", true),
                        new AnswerOption("Marca archivos corruptos", false),
                        new AnswerOption("Señala errores de memoria", false),
                        new AnswerOption("Indica virus detectado", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es copy-on-write (COW)?",
                Arrays.asList(
                        new AnswerOption("Técnica que copia páginas solo al modificarlas", true),
                        new AnswerOption("Copiar archivos en segundo plano", false),
                        new AnswerOption("Respaldo automático", false),
                        new AnswerOption("Protección contra escritura", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es la localidad de referencia?",
                Arrays.asList(
                        new AnswerOption("Tendencia a acceder datos cercanos en tiempo/espacio", true),
                        new AnswerOption("Ubicación física del servidor", false),
                        new AnswerOption("Dirección IP local", false),
                        new AnswerOption("Ruta de archivo", false)
                ),
                Category.MEMORIA
        ));

        questions.add(new Question(
                "¿Qué es el MMU (Memory Management Unit)?",
                Arrays.asList(
                        new AnswerOption("Hardware que traduce direcciones virtuales a físicas", true),
                        new AnswerOption("Software de monitoreo", false),
                        new AnswerOption("Unidad de almacenamiento", false),
                        new AnswerOption("Módulo de red", false)
                ),
                Category.MEMORIA
        ));

        // ==================== ARCHIVOS (20 preguntas) ====================
        questions.add(new Question(
                "¿Cuál es la función del sistema de archivos?",
                Arrays.asList(
                        new AnswerOption("Gestionar la red", false),
                        new AnswerOption("Administrar procesos en segundo plano", false),
                        new AnswerOption("Organizar y almacenar archivos en dispositivos", true),
                        new AnswerOption("Controlar la impresora", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es un descriptor de archivo?",
                Arrays.asList(
                        new AnswerOption("Un ícono en el escritorio", false),
                        new AnswerOption("Una referencia usada por el SO para acceder a un archivo abierto", true),
                        new AnswerOption("Un tipo de compresión", false),
                        new AnswerOption("Un error de E/S", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es un inodo en sistemas Unix/Linux?",
                Arrays.asList(
                        new AnswerOption("Estructura que contiene metadatos de un archivo", true),
                        new AnswerOption("Un tipo de proceso del sistema", false),
                        new AnswerOption("Una partición del disco", false),
                        new AnswerOption("Un comando de terminal", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es el journaling en sistemas de archivos?",
                Arrays.asList(
                        new AnswerOption("Comprimir archivos automáticamente", false),
                        new AnswerOption("Registro de operaciones para recuperación ante fallos", true),
                        new AnswerOption("Crear respaldos diarios", false),
                        new AnswerOption("Escanear virus en archivos", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es FAT (File Allocation Table)?",
                Arrays.asList(
                        new AnswerOption("Sistema de archivos que usa tabla de asignación", true),
                        new AnswerOption("Protocolo de red", false),
                        new AnswerOption("Tipo de memoria", false),
                        new AnswerOption("Comando de terminal", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es ext4?",
                Arrays.asList(
                        new AnswerOption("Sistema de archivos de Linux", true),
                        new AnswerOption("Protocolo de internet", false),
                        new AnswerOption("Tipo de procesador", false),
                        new AnswerOption("Lenguaje de programación", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es NTFS (New Technology File System)?",
                Arrays.asList(
                        new AnswerOption("Sistema de archivos de Windows con seguridad avanzada", true),
                        new AnswerOption("Protocolo de transferencia", false),
                        new AnswerOption("Sistema operativo", false),
                        new AnswerOption("Base de datos", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es un hard link?",
                Arrays.asList(
                        new AnswerOption("Referencia directa al inodo de un archivo", true),
                        new AnswerOption("Conexión de red", false),
                        new AnswerOption("Cable físico", false),
                        new AnswerOption("Acceso directo de Windows", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es un soft link (symbolic link)?",
                Arrays.asList(
                        new AnswerOption("Archivo que apunta a ruta de otro archivo", true),
                        new AnswerOption("Conexión inalámbrica", false),
                        new AnswerOption("Archivo comprimido", false),
                        new AnswerOption("Archivo temporal", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué son los permisos rwx en Unix/Linux?",
                Arrays.asList(
                        new AnswerOption("Read, Write, Execute (Lectura, Escritura, Ejecución)", true),
                        new AnswerOption("Root, Window, Exit", false),
                        new AnswerOption("Run, Work, eXit", false),
                        new AnswerOption("Random, Write, Extra", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es la desfragmentación?",
                Arrays.asList(
                        new AnswerOption("Reorganizar fragmentos de archivos en disco para mejorar rendimiento", true),
                        new AnswerOption("Borrar archivos temporales", false),
                        new AnswerOption("Comprimir el disco duro", false),
                        new AnswerOption("Instalar actualizaciones", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es un directorio en sistemas de archivos?",
                Arrays.asList(
                        new AnswerOption("Archivo especial que contiene referencias a otros archivos", true),
                        new AnswerOption("Libro de direcciones", false),
                        new AnswerOption("Lista de contactos", false),
                        new AnswerOption("Tabla de procesos", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es el superbloque en sistemas de archivos?",
                Arrays.asList(
                        new AnswerOption("Estructura que contiene metadata del sistema de archivos", true),
                        new AnswerOption("Área de swap", false),
                        new AnswerOption("Partición de arranque", false),
                        new AnswerOption("Archivo del kernel", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es el mounting (montaje) de un sistema de archivos?",
                Arrays.asList(
                        new AnswerOption("Hacer accesible un sistema de archivos en el árbol de directorios", true),
                        new AnswerOption("Instalar un programa", false),
                        new AnswerOption("Conectar un cable", false),
                        new AnswerOption("Iniciar el sistema", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es una ruta absoluta?",
                Arrays.asList(
                        new AnswerOption("Ruta completa desde la raíz del sistema de archivos", true),
                        new AnswerOption("Ruta más corta", false),
                        new AnswerOption("Ruta sin errores", false),
                        new AnswerOption("Ruta encriptada", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es una ruta relativa?",
                Arrays.asList(
                        new AnswerOption("Ruta desde el directorio actual", true),
                        new AnswerOption("Ruta de red", false),
                        new AnswerOption("Ruta temporal", false),
                        new AnswerOption("Ruta compartida", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es el buffer cache?",
                Arrays.asList(
                        new AnswerOption("Área de memoria para cachear bloques de disco", true),
                        new AnswerOption("Memoria del navegador", false),
                        new AnswerOption("Espacio de swap", false),
                        new AnswerOption("Archivo temporal", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es la asignación contigua de archivos?",
                Arrays.asList(
                        new AnswerOption("Almacenar archivo en bloques consecutivos de disco", true),
                        new AnswerOption("Distribuir archivo en múltiples discos", false),
                        new AnswerOption("Comprimir archivos grandes", false),
                        new AnswerOption("Encriptar datos sensibles", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es la asignación enlazada de archivos?",
                Arrays.asList(
                        new AnswerOption("Cada bloque contiene puntero al siguiente bloque", true),
                        new AnswerOption("Archivos vinculados por red", false),
                        new AnswerOption("Archivos compartidos", false),
                        new AnswerOption("Archivos comprimidos", false)
                ),
                Category.ARCHIVOS
        ));

        questions.add(new Question(
                "¿Qué es la asignación indexada de archivos?",
                Arrays.asList(
                        new AnswerOption("Usar bloque índice que contiene punteros a bloques de datos", true),
                        new AnswerOption("Ordenar archivos alfabéticamente", false),
                        new AnswerOption("Crear base de datos", false),
                        new AnswerOption("Buscar archivos por nombre", false)
                ),
                Category.ARCHIVOS
        ));

        // ==================== PLANIFICACIÓN (20 preguntas) ====================
        questions.add(new Question(
                "¿Qué es la planificación (scheduling) en un SO?",
                Arrays.asList(
                        new AnswerOption("Asignar memoria a procesos", false),
                        new AnswerOption("Decidir qué proceso se ejecuta en la CPU", true),
                        new AnswerOption("Gestionar la entrada/salida", false),
                        new AnswerOption("Crear nuevos usuarios", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué algoritmo de planificación asigna turnos iguales a cada proceso?",
                Arrays.asList(
                        new AnswerOption("FCFS", false),
                        new AnswerOption("SJF", false),
                        new AnswerOption("Round Robin", true),
                        new AnswerOption("Prioridad", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué significa SJF en algoritmos de planificación?",
                Arrays.asList(
                        new AnswerOption("Super Jump Function", false),
                        new AnswerOption("Shortest Job First", true),
                        new AnswerOption("System Job Formatter", false),
                        new AnswerOption("Scheduled Jump Flow", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es la inanición (starvation) en planificación?",
                Arrays.asList(
                        new AnswerOption("Proceso que nunca obtiene CPU porque otros tienen mayor prioridad", true),
                        new AnswerOption("Memoria RAM llena", false),
                        new AnswerOption("Disco duro sin espacio", false),
                        new AnswerOption("CPU sobrecalentada", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es FCFS (First Come First Served)?",
                Arrays.asList(
                        new AnswerOption("Algoritmo que ejecuta procesos en orden de llegada", true),
                        new AnswerOption("Sistema de archivos", false),
                        new AnswerOption("Protocolo de red", false),
                        new AnswerOption("Tipo de memoria", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es la planificación por prioridad?",
                Arrays.asList(
                        new AnswerOption("Ejecutar procesos según su nivel de prioridad", true),
                        new AnswerOption("Ejecutar todos los procesos simultáneamente", false),
                        new AnswerOption("Ordenar archivos por tamaño", false),
                        new AnswerOption("Gestionar memoria", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es la planificación apropiativa (preemptive)?",
                Arrays.asList(
                        new AnswerOption("El SO puede interrumpir un proceso en ejecución", true),
                        new AnswerOption("Los procesos nunca son interrumpidos", false),
                        new AnswerOption("Asignar memoria dinámicamente", false),
                        new AnswerOption("Crear procesos hijos", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es la planificación no apropiativa (non-preemptive)?",
                Arrays.asList(
                        new AnswerOption("El proceso mantiene CPU hasta terminar o bloquearse", true),
                        new AnswerOption("El SO interrumpe constantemente", false),
                        new AnswerOption("No hay planificación", false),
                        new AnswerOption("Solo para sistemas embebidos", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el turnaround time?",
                Arrays.asList(
                        new AnswerOption("Tiempo total desde envío hasta terminación del proceso", true),
                        new AnswerOption("Tiempo de respuesta del usuario", false),
                        new AnswerOption("Tiempo de arranque", false),
                        new AnswerOption("Tiempo de compilación", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el waiting time en planificación?",
                Arrays.asList(
                        new AnswerOption("Tiempo que un proceso pasa esperando en la cola de listos", true),
                        new AnswerOption("Tiempo de ejecución", false),
                        new AnswerOption("Tiempo de E/S", false),
                        new AnswerOption("Tiempo de compilación", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el response time?",
                Arrays.asList(
                        new AnswerOption("Tiempo desde envío hasta primera respuesta", true),
                        new AnswerOption("Tiempo de terminación", false),
                        new AnswerOption("Tiempo de arranque", false),
                        new AnswerOption("Tiempo de apagado", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo SRTF (Shortest Remaining Time First)?",
                Arrays.asList(
                        new AnswerOption("Versión apropiativa de SJF", true),
                        new AnswerOption("Algoritmo de memoria", false),
                        new AnswerOption("Protocolo de red", false),
                        new AnswerOption("Sistema de archivos", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es la planificación multinivel?",
                Arrays.asList(
                        new AnswerOption("Múltiples colas con diferentes algoritmos", true),
                        new AnswerOption("Un solo nivel de prioridad", false),
                        new AnswerOption("Sistema de archivos jerárquico", false),
                        new AnswerOption("Memoria multinivel", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el aging en planificación?",
                Arrays.asList(
                        new AnswerOption("Incrementar gradualmente prioridad de procesos en espera", true),
                        new AnswerOption("Eliminar procesos antiguos", false),
                        new AnswerOption("Optimizar caché", false),
                        new AnswerOption("Limpiar memoria", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es un sistema operativo de tiempo real?",
                Arrays.asList(
                        new AnswerOption("SO que responde en tiempo predecible y acotado", true),
                        new AnswerOption("SO que solo funciona en servidores", false),
                        new AnswerOption("SO sin interfaz gráfica", false),
                        new AnswerOption("SO para videojuegos", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el convoy effect?",
                Arrays.asList(
                        new AnswerOption("Procesos cortos esperan tras proceso largo en FCFS", true),
                        new AnswerOption("Múltiples procesos ejecutándose", false),
                        new AnswerOption("Transferencia de datos", false),
                        new AnswerOption("Error de planificación", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el context switch overhead?",
                Arrays.asList(
                        new AnswerOption("Costo en tiempo de cambiar entre procesos", true),
                        new AnswerOption("Espacio de memoria extra", false),
                        new AnswerOption("Error del sistema", false),
                        new AnswerOption("Velocidad de CPU", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es la planificación garantizada?",
                Arrays.asList(
                        new AnswerOption("Garantizar tiempo de CPU equitativo entre usuarios", true),
                        new AnswerOption("Garantizar sin errores", false),
                        new AnswerOption("Garantizar máxima velocidad", false),
                        new AnswerOption("Garantizar seguridad", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo de lotería?",
                Arrays.asList(
                        new AnswerOption("Asignar CPU mediante sorteo ponderado de tickets", true),
                        new AnswerOption("Selección aleatoria simple", false),
                        new AnswerOption("Juego del sistema", false),
                        new AnswerOption("Generador de números", false)
                ),
                Category.PLANIFICACION
        ));

        questions.add(new Question(
                "¿Qué es el fair-share scheduling?",
                Arrays.asList(
                        new AnswerOption("Distribuir CPU entre grupos de usuarios equitativamente", true),
                        new AnswerOption("Compartir archivos", false),
                        new AnswerOption("Dividir disco", false),
                        new AnswerOption("Repartir memoria", false)
                ),
                Category.PLANIFICACION
        ));

        // ==================== CONCURRENCIA (20 preguntas) ====================
        questions.add(new Question(
                "¿Qué es el deadlock (interbloqueo)?",
                Arrays.asList(
                        new AnswerOption("Cuando dos o más procesos esperan recursos que posee el otro", true),
                        new AnswerOption("Cuando la CPU se sobrecalienta", false),
                        new AnswerOption("Cuando se llena el disco duro", false),
                        new AnswerOption("Cuando un proceso termina abruptamente", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es la sección crítica?",
                Arrays.asList(
                        new AnswerOption("Código que accede a recursos compartidos", true),
                        new AnswerOption("Una parte del disco duro", false),
                        new AnswerOption("El modo de seguridad del SO", false),
                        new AnswerOption("Un tipo de proceso zombie", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es un semáforo en sistemas operativos?",
                Arrays.asList(
                        new AnswerOption("Una señal de tráfico en la interfaz", false),
                        new AnswerOption("Mecanismo de sincronización para controlar acceso a recursos", true),
                        new AnswerOption("Un tipo de archivo de sistema", false),
                        new AnswerOption("Una herramienta de debugging", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es una condición de carrera (race condition)?",
                Arrays.asList(
                        new AnswerOption("Competencia por recursos de CPU", false),
                        new AnswerOption("Resultado depende del orden de ejecución de procesos concurrentes", true),
                        new AnswerOption("Proceso que ejecuta muy rápido", false),
                        new AnswerOption("Error de compilación", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Cuáles son las 4 condiciones para deadlock?",
                Arrays.asList(
                        new AnswerOption("Exclusión mutua, retención y espera, no apropiación, espera circular", true),
                        new AnswerOption("CPU, memoria, disco, red", false),
                        new AnswerOption("Lectura, escritura, ejecución, borrado", false),
                        new AnswerOption("Usuario, kernel, sistema, aplicación", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es un mutex?",
                Arrays.asList(
                        new AnswerOption("Mecanismo de exclusión mutua binario", true),
                        new AnswerOption("Tipo de proceso", false),
                        new AnswerOption("Sistema de archivos", false),
                        new AnswerOption("Protocolo de red", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es un monitor en programación concurrente?",
                Arrays.asList(
                        new AnswerOption("Estructura de sincronización de alto nivel con exclusión mutua", true),
                        new AnswerOption("Pantalla de computadora", false),
                        new AnswerOption("Programa de vigilancia", false),
                        new AnswerOption("Herramienta de depuración", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es el problema de los filósofos comensales?",
                Arrays.asList(
                        new AnswerOption("Ejemplo clásico de sincronización y deadlock", true),
                        new AnswerOption("Problema de red", false),
                        new AnswerOption("Error de memoria", false),
                        new AnswerOption("Bug de sistema", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es el problema productor-consumidor?",
                Arrays.asList(
                        new AnswerOption("Sincronización entre procesos que producen y consumen datos", true),
                        new AnswerOption("Problema de hardware", false),
                        new AnswerOption("Error de compilación", false),
                        new AnswerOption("Fallo de disco", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es el problema lectores-escritores?",
                Arrays.asList(
                        new AnswerOption("Sincronización de acceso compartido con lecturas/escrituras", true),
                        new AnswerOption("Error de E/S", false),
                        new AnswerOption("Problema de permisos", false),
                        new AnswerOption("Fallo de red", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es la exclusión mutua?",
                Arrays.asList(
                        new AnswerOption("Solo un proceso accede a recurso compartido a la vez", true),
                        new AnswerOption("Excluir procesos zombies", false),
                        new AnswerOption("Bloquear virus", false),
                        new AnswerOption("Cerrar aplicaciones", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es un spinlock?",
                Arrays.asList(
                        new AnswerOption("Lock que hace busy waiting consumiendo CPU", true),
                        new AnswerOption("Disco giratorio", false),
                        new AnswerOption("Proceso rotativo", false),
                        new AnswerOption("Error circular", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es la inversión de prioridad?",
                Arrays.asList(
                        new AnswerOption("Proceso de alta prioridad espera por uno de baja prioridad", true),
                        new AnswerOption("Cambiar orden alfabético", false),
                        new AnswerOption("Invertir bits", false),
                        new AnswerOption("Revertir cambios", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es el problema de la barbería?",
                Arrays.asList(
                        new AnswerOption("Ejemplo de sincronización con semáforos", true),
                        new AnswerOption("Error de interfaz", false),
                        new AnswerOption("Problema de red", false),
                        new AnswerOption("Fallo de hardware", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es un livelock?",
                Arrays.asList(
                        new AnswerOption("Procesos activos pero sin progresar", true),
                        new AnswerOption("Transmisión en vivo", false),
                        new AnswerOption("Bloqueo permanente", false),
                        new AnswerOption("Proceso activo", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué son las variables de condición?",
                Arrays.asList(
                        new AnswerOption("Mecanismo para esperar hasta que condición sea verdadera", true),
                        new AnswerOption("Variables del sistema", false),
                        new AnswerOption("Parámetros de configuración", false),
                        new AnswerOption("Constantes del programa", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es la atomicidad?",
                Arrays.asList(
                        new AnswerOption("Operación que se ejecuta completamente o no se ejecuta", true),
                        new AnswerOption("Operación muy rápida", false),
                        new AnswerOption("Operación molecular", false),
                        new AnswerOption("Operación del núcleo", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo del banquero?",
                Arrays.asList(
                        new AnswerOption("Algoritmo para evitar deadlock verificando estados seguros", true),
                        new AnswerOption("Sistema de pagos", false),
                        new AnswerOption("Gestión financiera", false),
                        new AnswerOption("Protocolo bancario", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es un sistema distribuido?",
                Arrays.asList(
                        new AnswerOption("Sistema que corre en múltiples computadoras interconectadas", true),
                        new AnswerOption("SO sin conexión a internet", false),
                        new AnswerOption("SO para una sola CPU", false),
                        new AnswerOption("Tipo de base de datos", false)
                ),
                Category.CONCURRENCIA
        ));

        questions.add(new Question(
                "¿Qué es el test-and-set?",
                Arrays.asList(
                        new AnswerOption("Instrucción atómica para implementar locks", true),
                        new AnswerOption("Prueba unitaria", false),
                        new AnswerOption("Configurar parámetros", false),
                        new AnswerOption("Testear hardware", false)
                ),
                Category.CONCURRENCIA
        ));

        // ==================== ENTRADA/SALIDA (20 preguntas) ====================
        questions.add(new Question(
                "¿Qué es DMA (Direct Memory Access)?",
                Arrays.asList(
                        new AnswerOption("Acceso directo a memoria sin intervención de CPU", true),
                        new AnswerOption("Un tipo de memoria RAM", false),
                        new AnswerOption("Un protocolo de red", false),
                        new AnswerOption("Un comando de terminal", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el buffering en E/S?",
                Arrays.asList(
                        new AnswerOption("Comprimir datos antes de escribir", false),
                        new AnswerOption("Almacenar temporalmente datos en memoria durante transferencia", true),
                        new AnswerOption("Encriptar información", false),
                        new AnswerOption("Borrar datos automáticamente", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el spooling?",
                Arrays.asList(
                        new AnswerOption("Técnica para gestionar trabajos de impresión en cola", true),
                        new AnswerOption("Resetear dispositivos de E/S", false),
                        new AnswerOption("Actualizar drivers", false),
                        new AnswerOption("Optimizar disco duro", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es una interrupción (interrupt)?",
                Arrays.asList(
                        new AnswerOption("Señal al CPU para atender evento urgente", true),
                        new AnswerOption("Corte de energía", false),
                        new AnswerOption("Error de programa", false),
                        new AnswerOption("Pausa de usuario", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el polling?",
                Arrays.asList(
                        new AnswerOption("CPU consulta periódicamente estado de dispositivo", true),
                        new AnswerOption("Encuesta de usuarios", false),
                        new AnswerOption("Votación del sistema", false),
                        new AnswerOption("Sincronización de red", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es un device driver?",
                Arrays.asList(
                        new AnswerOption("Software que controla un dispositivo de hardware", true),
                        new AnswerOption("Cable de conexión", false),
                        new AnswerOption("Puerto USB", false),
                        new AnswerOption("Placa madre", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el caching de E/S?",
                Arrays.asList(
                        new AnswerOption("Mantener datos frecuentes en memoria rápida", true),
                        new AnswerOption("Borrar archivos temporales", false),
                        new AnswerOption("Comprimir datos", false),
                        new AnswerOption("Encriptar información", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es la E/S asíncrona?",
                Arrays.asList(
                        new AnswerOption("Operación que no bloquea al proceso solicitante", true),
                        new AnswerOption("E/S con errores", false),
                        new AnswerOption("E/S muy rápida", false),
                        new AnswerOption("E/S en red", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es la E/S síncrona?",
                Arrays.asList(
                        new AnswerOption("Proceso espera hasta completar operación de E/S", true),
                        new AnswerOption("E/S en paralelo", false),
                        new AnswerOption("E/S automática", false),
                        new AnswerOption("E/S en tiempo real", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el vector de interrupciones?",
                Arrays.asList(
                        new AnswerOption("Tabla con direcciones de manejadores de interrupciones", true),
                        new AnswerOption("Lista de errores", false),
                        new AnswerOption("Array de datos", false),
                        new AnswerOption("Estructura de archivos", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el double buffering?",
                Arrays.asList(
                        new AnswerOption("Usar dos búferes alternadamente para E/S continua", true),
                        new AnswerOption("Duplicar datos", false),
                        new AnswerOption("Memoria doble", false),
                        new AnswerOption("Dos discos duros", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el scatter-gather en E/S?",
                Arrays.asList(
                        new AnswerOption("Leer/escribir datos desde/a múltiples ubicaciones de memoria", true),
                        new AnswerOption("Dispersar archivos", false),
                        new AnswerOption("Recopilar datos", false),
                        new AnswerOption("Fragmentar disco", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es RAID?",
                Arrays.asList(
                        new AnswerOption("Array redundante de discos independientes para rendimiento/confiabilidad", true),
                        new AnswerOption("Protocolo de red", false),
                        new AnswerOption("Sistema operativo", false),
                        new AnswerOption("Lenguaje de programación", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el prefetching en E/S?",
                Arrays.asList(
                        new AnswerOption("Cargar datos anticipadamente antes de ser solicitados", true),
                        new AnswerOption("Priorizar operaciones", false),
                        new AnswerOption("Verificar integridad", false),
                        new AnswerOption("Cifrar información", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el disk scheduling?",
                Arrays.asList(
                        new AnswerOption("Algoritmo para ordenar peticiones de acceso al disco", true),
                        new AnswerOption("Programar respaldos", false),
                        new AnswerOption("Agendar tareas", false),
                        new AnswerOption("Planificar procesos", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo SCAN en discos?",
                Arrays.asList(
                        new AnswerOption("Cabezal se mueve de extremo a extremo atendiendo peticiones", true),
                        new AnswerOption("Escanear virus", false),
                        new AnswerOption("Buscar archivos", false),
                        new AnswerOption("Analizar red", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo C-SCAN?",
                Arrays.asList(
                        new AnswerOption("SCAN circular que vuelve al inicio sin atender peticiones", true),
                        new AnswerOption("Escaneo de seguridad", false),
                        new AnswerOption("Compresión de datos", false),
                        new AnswerOption("Cifrado circular", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el algoritmo FCFS en discos?",
                Arrays.asList(
                        new AnswerOption("Atender peticiones en orden de llegada", true),
                        new AnswerOption("Optimizar acceso", false),
                        new AnswerOption("Priorizar E/S", false),
                        new AnswerOption("Balancear carga", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el seek time de un disco?",
                Arrays.asList(
                        new AnswerOption("Tiempo para mover cabezal a cilindro correcto", true),
                        new AnswerOption("Tiempo de búsqueda de archivos", false),
                        new AnswerOption("Tiempo de lectura", false),
                        new AnswerOption("Tiempo de espera", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        questions.add(new Question(
                "¿Qué es el rotational latency?",
                Arrays.asList(
                        new AnswerOption("Tiempo de espera a que sector llegue bajo cabezal", true),
                        new AnswerOption("Velocidad de rotación", false),
                        new AnswerOption("Latencia de red", false),
                        new AnswerOption("Retraso de CPU", false)
                ),
                Category.ENTRADA_SALIDA
        ));

        return questions;
    }
}
