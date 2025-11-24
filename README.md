# 📱 KernelQuiz

<div align="center">
  
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)

**Aplicación educativa de preguntas y respuestas para Android**

[Características](#-características) • [Instalación](#-instalación) • [Uso](#-uso) • [Documentación](#-documentación) • [Licencia](#-licencia)

</div>

---

## 📖 Descripción

KernelQuiz es una aplicación educativa de trivia diseñada para evaluar conocimientos mediante un sistema interactivo de preguntas y respuestas. Los usuarios pueden registrarse, seleccionar diferentes categorías de preguntas y obtener puntuaciones basadas en su desempeño.

### 🎯 Características Principales

- ✅ **Sistema de autenticación** - Registro e inicio de sesión de usuarios
- 📚 **Múltiples categorías** - Diferentes temas de preguntas
- 🎮 **Sistema de intentos** - Hasta 4 intentos por pregunta con puntuación decreciente
- 🏆 **Puntuación inteligente** - 100, 75, 50, 25 puntos según el intento
- 📊 **Progreso por categoría** - Visualiza tu desempeño en cada área
- 💾 **Persistencia de sesión** - Mantén tu sesión activa
- 📱 **Interfaz Material Design** - Diseño moderno y atractivo
- 📈 **Estadísticas detalladas** - Historial y resultados por categoría
- 📳 **Feedback háptico** - Vibración en respuestas incorrectas
- ℹ️ **Información de la app** - Pantalla "Acerca de" con detalles del desarrollador

---

## 🛠️ Tecnologías

- **Lenguaje:** Java
- **Plataforma:** Android (API 24+)
- **Base de datos:** SQLite
- **UI:** Material Design 3, CardView
- **Arquitectura:** Modelo-Vista con Activities
- **Build System:** Gradle (Kotlin DSL)

---

## 📦 Instalación

### Prerrequisitos

- Android Studio Arctic Fox o superior
- JDK 21
- Android SDK API 34
- Dispositivo Android o emulador con API 24+

### Pasos de instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/JeisonAmellSanez/KernelQuiz.git
   cd KernelQuiz
   ```

2. **Abrir en Android Studio**
   - File → Open → Seleccionar la carpeta del proyecto

3. **Sincronizar Gradle**
   - Android Studio sincronizará automáticamente
   - O manualmente: File → Sync Project with Gradle Files

4. **Compilar y ejecutar**
   - Conectar un dispositivo Android o iniciar un emulador
   - Presionar el botón Run (▶️)

### Compilar APK desde terminal

**APK Debug:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\openjdk\jdk-21.0.8"
.\gradlew.bat assembleDebug
```

**APK Release:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\openjdk\jdk-21.0.8"
.\gradlew.bat assembleRelease
```

El APK se generará en: `app/build/outputs/apk/`

---

## 🎮 Uso

### Primera vez

1. **Registro**
   - Abre la aplicación
   - Toca "Registrarse"
   - Completa el formulario con usuario y contraseña
   - Presiona "Crear cuenta"

2. **Inicio de sesión**
   - Ingresa tus credenciales
   - La sesión se mantendrá activa automáticamente

### Jugar

1. **Seleccionar categoría**
   - Desde la pantalla de bienvenida, toca "Iniciar Quiz"
   - Selecciona una categoría de las disponibles

2. **Responder preguntas**
   - Lee cada pregunta cuidadosamente
   - Selecciona una de las opciones
   - Tienes hasta 4 intentos por pregunta
   - La puntuación disminuye con cada intento:
     - 1er intento: 100 puntos
     - 2do intento: 75 puntos
     - 3er intento: 50 puntos
     - 4to intento: 25 puntos

3. **Ver resultados**
   - Al finalizar, verás tu puntuación total
   - Revisa tu desempeño por categoría
   - Puedes reintentar o ver tu progreso histórico

### Otras funciones

- **Ver progreso:** Accede a tus estadísticas desde el menú principal
- **Acerca de:** Consulta información sobre la aplicación y el desarrollador
- **Cerrar sesión:** Disponible desde la pantalla de bienvenida

---

## 📱 Capturas de Pantalla

<!--
Añade capturas de pantalla de tu aplicación aquí:
-->

```
[Login] [Categorías] [Quiz] [Resultados]
```

> 📝 **Nota:** Agrega capturas de pantalla en la carpeta `screenshots/` para mostrar la interfaz

---

## 🗂️ Estructura del Proyecto

```
KernelQuiz/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/quizso/
│   │       │   ├── model/              # Modelos de datos
│   │       │   │   ├── Question.java
│   │       │   │   ├── AnswerOption.java
│   │       │   │   ├── Category.java
│   │       │   │   └── CategoryScore.java
│   │       │   ├── utils/              # Utilidades
│   │       │   │   ├── DBHelper.java
│   │       │   │   ├── SessionManager.java
│   │       │   │   └── QuestionBank.java
│   │       │   ├── LoginActivity.java
│   │       │   ├── RegisterActivity.java
│   │       │   ├── WelcomeActivity.java
│   │       │   ├── CategorySelectionActivity.java
│   │       │   ├── QuizActivity.java
│   │       │   ├── ResultActivity.java
│   │       │   ├── AboutActivity.java
│   │       │   └── CategoryProgressActivity.java
│   │       └── res/                    # Recursos
│   │           ├── layout/             # Layouts XML
│   │           ├── values/             # Strings, colores, estilos
│   │           └── drawable/           # Imágenes e iconos
│   └── build.gradle.kts
├── build.gradle.kts
├── DOCUMENTACION.md                    # Documentación técnica completa
└── README.md                           # Este archivo
```

---

## 📚 Documentación

Para información técnica detallada, consulta:

- **[DOCUMENTACION.md](DOCUMENTACION.md)** - Documentación técnica completa
  - Arquitectura de la aplicación
  - Estructura de base de datos
  - Flujo de navegación
  - Sistema de puntuación
  - Configuración y compilación
  - Solución de problemas

---

## 🔧 Configuración

### SDK Requirements

```kotlin
minSdk = 24      // Android 7.0 Nougat
targetSdk = 34   // Android 14
compileSdk = 34
```

### Permisos

```xml
<uses-permission android:name="android.permission.VIBRATE" />
```

---

## 🤝 Contribuir

Las contribuciones son bienvenidas. Para cambios importantes:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add: nueva característica'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

---

## 🐛 Reportar Problemas

Si encuentras algún bug o tienes una sugerencia, por favor abre un [issue](https://github.com/JeisonAmellSanez/KernelQuiz/issues).

---

## 📈 Roadmap

### Futuras implementaciones

- [ ] Migración a Kotlin
- [ ] Arquitectura MVVM
- [ ] Room Database
- [ ] API REST para preguntas dinámicas
- [ ] Modo multijugador
- [ ] Sistema de rankings global
- [ ] Más categorías de preguntas
- [ ] Modo oscuro
- [ ] Internacionalización (i18n)
- [ ] Sistema de logros y badges
- [ ] Compartir resultados en redes sociales

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

---

## 👨‍💻 Autor

**Jeison Amell**  

- GitHub: [@JeisonAmellSanez](https://github.com/JeisonAmellSanez)

---

## 🙏 Agradecimientos

- Comunidad de Android Developers
- Material Design Team
- Documentación de SQLite
- Stack Overflow Community

---

## 📞 Contacto

Para preguntas, sugerencias o colaboraciones:

- **Email:** amelljeison@gmail.com
- **GitHub:** [Issues](https://github.com/JeisonAmellSanez/KernelQuiz/issues)

---

<div align="center">

**⭐ Si te gusta este proyecto, dale una estrella en GitHub ⭐**

Desarrollado con ❤️ por **Jeison Amell**

© 2025 KernelQuiz. Todos los derechos reservados.

</div>
