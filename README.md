# 🚀 Proyecto de Automatización – Selenium + Cucumber + POM

Este repositorio contiene un framework de automatización basado en Selenium, Cucumber y Page Object Model (POM).  
Incluye manejo de ambientes dinámicos, configuración centralizada y ejecución simple desde consola o IDE.

---

## ✨ Características principales

- **Selenium + WebDriver**
- **Cucumber**
- **Arquitectura POM**
- `ConfigReader` y `EnvironmentManager` para cargar propiedades según ambiente.
- Soporte para `-Denvironment=` en runtime.
- Hooks para iniciar/cerrar navegador.
- Steps limpios y reutilizables.

---

## 🏗️ Estructura del proyecto

```
/src
  /main
    /java
      /config
      /drivers
      /pages
      /utils
  /test
    /java
      /hooks
      /runners
      /steps
      /support
  /resources
    /config
    /environment
    /features
```
---

## 🛠️ Requisitos del proyecto

Para ejecutar este framework necesitas lo siguiente:

### **Software**
- **JDK 18** (Amazon Corretto o equivalente)
- **IntelliJ IDEA** (Community o Ultimate)
- **Maven 3.8+** instalado y configurado en el PATH
- **Chrome / ChromeDriver** compatibles entre sí
- **Allure Commandline** (para generar y abrir reportes)

### **Plugins necesarios en IntelliJ**
- **Cucumber for Java**
- **Gherkin**
- **Maven** (incluido por defecto)
- **Gradle** (incluido por defecto, no requerido para este proyecto)

### **Dependencias principales**
*(Estas ya están en tu `pom.xml`, es solo informativo)*

- Selenium WebDriver
- Cucumber Java
- WebDriverManager
- Allure + Cucumber JVM

---

## ▶️ Ejecución del proyecto

### Ejecución por ambiente
```
mvn test -Denvironment=qa    // No levanta el reporte de Allure, solo ejecuta las pruebas
mvn test verify -Denvironment=qa    // Levanta el reporte de Allure
mvn test -Denvironment=dev // No implementado
mvn test -Denvironment=prod // No implementado
```

### Ejecución por tag de Cucumber
```
mvn test -Dcucumber.filter.tags="@PrioridadAlta"    // No levanta el reporte de Allure, solo ejecuta las pruebas
mvn test verify -Dcucumber.filter.tags="@PrioridadAlta"    // Levanta el reporte de Allure
```

---

## 🛠️ Configuración de ambientes

Los archivos `.properties` se encuentran en:

```
/src/test/resources/environment/
```

Ejemplo:
```properties
qa.properties
dev.properties // No implementado
prod.properties // No implementado
```
## 🛠️ Configuración del archivo properties

El archivo `properties` permite configurar el comportamiento de la aplicación con los siguientes campos:

### Campos disponibles

| Campo | Descripción | Valores posibles | Valor por defecto |
|-------|-------------|------------------|-------------------|
| `base.url` | Define la URL base de la web | Cualquier URL válida | `https://www.saucedemo.com` |
| `browser` | Define el navegador a utilizar | `chrome` - Navegador Chrome<br>`chromium` - Navegador Chromium<br>`firefox` - Navegador Firefox | `chrome` |
| `take.screenshot` | Define cuándo tomar capturas de pantalla | `all` - En todos los pasos<br>`failed` - Solo si el escenario falla<br>`none` - No tomar capturas | `all` |
| `timeout` | Define el tiempo de espera en segundos | Número entero positivo | `10` |
| `headless` | Define si se ejecuta sin interfaz gráfica | `true` - No se levanta el navegador (headless)<br>`false` - Si se levanta el navegador | `true` |

### Ejemplo de configuración
```properties
# Define la url base de la web
base.url=https://www.saucedemo.com

# Define el navegador a utilizar
#  - chrome         ? navegador Chrome
#  - chromium       ? navegador Chromium
#  - firefox        ? navegador Firefox
browser=chrome

# Define cuándo tomar capturas de pantalla:
#  - all     ? en todos los pasos
#  - failed  ? solo si el escenario falla
#  - none    ? no tomar capturas
take.screenshot=all

# Define el tiempo de espera
timeout=10

# Define si se levantara el navegador o no
#  - false  ? Si se levantara
#  - true   ? No se levantara
headless=true
```
---

## ⚡ Componentes principales

### **EnvironmentManager**
Encargado de obtener el ambiente actual y entregar el archivo `.properties` correcto.

### **ConfigReader**
Lee los valores del archivo `.properties` activo.

### **Hooks**
Inicializan y cierran el navegador automáticamente.

### **Page Objects**
Abstracción de páginas para mantener el código limpio.

---

## 📝 Reporting

- **Cucumber Report**
- **Allure Report**

---

## 📌 Versionado

Este repositorio utiliza tags para marcar cambios importantes:

- `v0.1` → Versión inicial sin refactor completo.
- `v0.2` → Refactor total + estructura profesional del framework.
