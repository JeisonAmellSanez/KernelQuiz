# 📱 KernelQuiz - Documentación Técnica

## 📋 Información del Proyecto

**Nombre:** KernelQuiz  
**Versión:** 1.0  
**Desarrollado por:** Cipa los ingenieros  
**Autor:** Jeison Amell  
**Fecha:** Noviembre 2025  
**Plataforma:** Android  

---

## 🎯 Descripción General

KernelQuiz es una aplicación educativa diseñada para evaluar conocimientos mediante un sistema de preguntas y respuestas interactivo. La aplicación permite a los usuarios registrarse, iniciar sesión, seleccionar categorías y responder preguntas con un sistema de puntuación detallado.

---

## 🏗️ Arquitectura de la Aplicación

### Patrón de Arquitectura
- **Modelo:** Modelo-Vista (MV) con Activities
- **Base de datos:** SQLite con DBHelper
- **Gestión de sesiones:** SessionManager para persistencia de login

### Estructura de Paquetes

```
com.example.quizso/
├── model/
│   ├── Question.java
│   ├── AnswerOption.java
│   ├── Category.java
│   └── CategoryScore.java
├── utils/
│   ├── DBHelper.java
│   ├── SessionManager.java
│   └── QuestionBank.java
├── LoginActivity.java
├── RegisterActivity.java
├── WelcomeActivity.java
├── CategorySelectionActivity.java
├── CategoryProgressActivity.java
├── QuizActivity.java
├── ResultActivity.java
├── AboutActivity.java
└── MainActivity.java
```

---

## 📱 Activities (Pantallas)

### 1. LoginActivity
**Propósito:** Pantalla de inicio de sesión  
**Funcionalidades:**
- Validación de credenciales
- Navegación a registro
- Persistencia de sesión con SharedPreferences

### 2. RegisterActivity
**Propósito:** Registro de nuevos usuarios  
**Funcionalidades:**
- Validación de campos
- Creación de cuenta en base de datos
- Navegación automática post-registro

### 3. WelcomeActivity
**Propósito:** Pantalla principal después del login  
**Funcionalidades:**
- Saludo personalizado al usuario
- Navegación a categorías
- Opción de cerrar sesión
- Acceso a información "Acerca de"

### 4. CategorySelectionActivity
**Propósito:** Selección de categoría de quiz  
**Funcionalidades:**
- Listado de categorías disponibles
- Visualización de descripción de cada categoría
- Navegación a QuizActivity con categoría seleccionada

### 5. CategoryProgressActivity
**Propósito:** Visualización de progreso por categoría  
**Funcionalidades:**
- Estadísticas de desempeño
- Historial de intentos
- Puntajes por categoría

### 6. QuizActivity
**Propósito:** Pantalla principal del quiz  
**Funcionalidades:**
- Presentación de preguntas
- Sistema de múltiple opción
- Hasta 4 intentos por pregunta
- Sistema de puntuación (100, 75, 50, 25 puntos)
- Feedback inmediato (correcto/incorrecto)
- Vibración en respuestas incorrectas
- Progreso visual

### 7. ResultActivity
**Propósito:** Mostrar resultados finales  
**Funcionalidades:**
- Puntuación total
- Desglose por categoría
- Porcentaje de aciertos
- Opción de reintentar
- Navegación a progreso

### 8. AboutActivity ⭐ **(Nueva)**
**Propósito:** Información sobre la aplicación y desarrollador  
**Funcionalidades:**
- Información del desarrollador (Cipa los ingenieros - Jeison Amell)
- Características de la aplicación
- Versión de la app
- Copyright

---

## 💾 Base de Datos

### DBHelper.java
**Motor:** SQLite  
**Versión:** 1

#### Tablas

**1. users**
```sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)
```

**2. scores**
```sql
CREATE TABLE scores (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    category_id INTEGER,
    score INTEGER,
    total_questions INTEGER,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(id)
)
```

**3. questions**
```sql
CREATE TABLE questions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    category_id INTEGER,
    question_text TEXT NOT NULL,
    difficulty TEXT,
    FOREIGN KEY(category_id) REFERENCES categories(id)
)
```

**4. categories**
```sql
CREATE TABLE categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT UNIQUE NOT NULL,
    description TEXT,
    icon TEXT
)
```

---

## 🎨 Diseño UI/UX

### Tema y Colores
- **Tema base:** Material Design 3
- **Colores principales:** 
  - Primary: Color principal de la app
  - Surface: Fondos de cards
  - Background: Fondo general

### Componentes Utilizados
- MaterialButton
- CardView
- LinearLayout
- ScrollView
- TextView con estilos personalizados
- ImageButton

### Layouts

1. **activity_login.xml** - Pantalla de inicio de sesión
2. **activity_register.xml** - Registro de usuarios
3. **activity_welcome.xml** - Bienvenida con botones de acción
4. **activity_category_selection.xml** - Grid de categorías
5. **activity_category_progress.xml** - Estadísticas
6. **activity_quiz.xml** - Interfaz del quiz
7. **activity_result.xml** - Resultados finales
8. **activity_about.xml** ⭐ - Información de la app

---

## 🔧 Características Técnicas

### Permisos Requeridos
```xml
<uses-permission android:name="android.permission.VIBRATE" />
```

### SDK Mínimo
- **minSdk:** 24 (Android 7.0)
- **targetSdk:** 34 (Android 14)
- **compileSdk:** 34

### Dependencias Principales
```gradle
// AndroidX
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

// Material Design
implementation 'com.google.android.material:material:1.11.0'

// CardView
implementation 'androidx.cardview:cardview:1.0.0'
```

---

## 🎮 Funcionalidades Principales

### Sistema de Puntuación
- **1er intento:** 100 puntos
- **2do intento:** 75 puntos
- **3er intento:** 50 puntos
- **4to intento:** 25 puntos
- **Sin acierto:** 0 puntos

### Sistema de Feedback
- ✅ Respuesta correcta: Color verde + Continuar
- ❌ Respuesta incorrecta: Color rojo + Vibración + Nuevo intento
- 📊 Progreso visual con barra de progreso
- 🎯 Hasta 4 intentos por pregunta

### Gestión de Sesión
- Persistencia con SharedPreferences
- Auto-login si hay sesión activa
- Logout seguro con limpieza de datos

---

## 📂 Archivos de Configuración

### AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.quizso">

    <uses-permission android:name="android.permission.VIBRATE" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/Theme.QuizSO">
        
        <activity android:name=".LoginActivity" android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        
        <activity android:name=".RegisterActivity" />
        <activity android:name=".WelcomeActivity" />
        <activity android:name=".CategorySelectionActivity" />
        <activity android:name=".CategoryProgressActivity" />
        <activity android:name=".QuizActivity" />
        <activity android:name=".ResultActivity" />
        <activity android:name=".AboutActivity" />
    </application>
</manifest>
```

### build.gradle.kts (app)
```kotlin
plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.quizso"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quizso"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
```

---

## 🚀 Compilación y Distribución

### Compilar APK Debug
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\openjdk\jdk-21.0.8"
.\gradlew.bat assembleDebug
```
**Ubicación:** `app/build/outputs/apk/debug/app-debug.apk`

### Compilar APK Release
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\openjdk\jdk-21.0.8"
.\gradlew.bat assembleRelease
```
**Ubicación:** `app/build/outputs/apk/release/app-release-unsigned.apk`

### Instalar en Dispositivo
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\openjdk\jdk-21.0.8"
.\gradlew.bat installDebug
```

---

## 🔍 Solución de Problemas

### Error: JAVA_HOME not set
**Solución:**
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\openjdk\jdk-21.0.8"
```

### Error: No connected devices
**Solución:**
1. Iniciar emulador desde Android Studio
2. Conectar dispositivo físico con USB debugging activado
3. Verificar con: `adb devices`

### Error: Build failed
**Solución:**
```powershell
.\gradlew.bat clean
.\gradlew.bat build
```

---

## 📊 Flujo de Navegación

```
LoginActivity
    ├─> RegisterActivity ─> WelcomeActivity
    └─> WelcomeActivity
            ├─> CategorySelectionActivity ─> QuizActivity ─> ResultActivity
            │                                                       └─> CategoryProgressActivity
            ├─> AboutActivity
            └─> Logout ─> LoginActivity
```

---

## 🔐 Seguridad

### Autenticación
- Contraseñas almacenadas en SQLite (⚠️ sin hash - mejorar en producción)
- Validación de campos en registro
- Sesión persistente con tokens simples

### Recomendaciones de Mejora
1. Implementar hash de contraseñas (BCrypt, Argon2)
2. Usar Room en lugar de SQLite directo
3. Implementar tokens JWT para sesiones
4. Agregar validación de email
5. Implementar recuperación de contraseña

---

## 📈 Mejoras Futuras

### Funcionalidades Propuestas
- [ ] Modo multijugador
- [ ] Rankings globales
- [ ] Más categorías de preguntas
- [ ] Sistema de logros/insignias
- [ ] Modo offline completo
- [ ] Compartir resultados en redes sociales
- [ ] Modo oscuro/claro
- [ ] Internacionalización (i18n)
- [ ] Estadísticas avanzadas con gráficos
- [ ] Tutorial interactivo

### Mejoras Técnicas
- [ ] Migrar a Kotlin
- [ ] Implementar arquitectura MVVM
- [ ] Usar Room para base de datos
- [ ] Implementar ViewModel y LiveData
- [ ] Agregar pruebas unitarias
- [ ] Implementar inyección de dependencias (Hilt/Dagger)
- [ ] Usar Retrofit para API futura
- [ ] Implementar Work Manager para tareas en background

---

## 📞 Contacto y Soporte

**Desarrollador:** Jeison Amell  
**Organización:** Cipa los ingenieros  
**Año:** 2025  

---

## 📝 Licencia

© 2025 KernelQuiz. Todos los derechos reservados.

---

## 📚 Referencias

- [Android Developers Documentation](https://developer.android.com/)
- [Material Design Guidelines](https://m3.material.io/)
- [SQLite Documentation](https://www.sqlite.org/docs.html)
- [Gradle Build Tool](https://gradle.org/)

---

## 🎓 Créditos

**Aplicación desarrollada por:**
- **Cipa los ingenieros**
- **Jeison Amell**

**Tecnologías utilizadas:**
- Android SDK
- Java
- SQLite
- Material Design 3
- Gradle

---

**Última actualización:** Noviembre 14, 2025  
**Versión del documento:** 1.0
