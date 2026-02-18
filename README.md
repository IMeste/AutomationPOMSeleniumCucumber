# 🚀 Proyecto de Automatización – Selenium + Cucumber + POM

Este repositorio contiene un framework de automatización basado en Selenium, Cucumber y Page Object Model (POM).  
Incluye manejo de ambientes dinámicos, configuración centralizada y ejecución simple desde consola o IDE.

![CI](https://github.com/IMeste/AutomationPOMSeleniumCucumber/actions/workflows/ci.yml/badge.svg)

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
      /pages
      /utils
  /test
    /java
      /drivers
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
*(Estas ya están en el `pom.xml`, es solo informativo)*

- Selenium WebDriver
- Cucumber Java
- WebDriverManager
- Allure + Cucumber JVM

---

## ▶️ Ejecución del proyecto

### Valores por defecto

Si no se especifican parámetros al ejecutar Maven:
- **environment**: `qa`
- **browser**: el definido en el archivo `properties`
- Se ejecutan **todos los escenarios**
- **No** se levanta Allure automáticamente

------------------------------------------------------------------------

### Ejecución básica

    mvn test
- Ejecuta todos los tests
- No limpia resultados previos
- No genera reporte de Allure

---
    mvn clean verify
- Limpia resultados previos
- Ejecuta todos los tests
- Genera resultados de Allure en la carpeta target/allure-results
- Levanta el servidor de Allure, abriendo una pestaña en tu navegador con el reporte

------------------------------------------------------------------------

### Ejecución por ambiente

    mvn test -Denvironment=desa
    mvn clean verify -Denvironment=desa

> Nota: actualmente solo existe configuración para `qa`.

------------------------------------------------------------------------

### Ejecución por tag de Cucumber

    mvn test "-Dcucumber.filter.tags=@PrioridadAlta"
    mvn clean verify "-Dcucumber.filter.tags=@PrioridadAlta"

------------------------------------------------------------------------

### Ejecución combinada (tag + ambiente)

    mvn test "-Dcucumber.filter.tags=@PrioridadAlta" -Denvironment=desa
    mvn clean verify "-Dcucumber.filter.tags=@PrioridadAlta" -Denvironment=desa

------------------------------------------------------------------------

### Ejecución indicando navegador

El navegador puede enviarse como variable al ejecutar Maven.

    mvn test -Dbrowser=firefox
    mvn test "-Dcucumber.filter.tags=@PrioridadAlta" -Dbrowser=firefox
    mvn clean verify "-Dcucumber.filter.tags=@PrioridadAlta" -Denvironment=qa -Dbrowser=chrome

Navegadores soportados: - `chrome` - `firefox` - `chromium`

------------------------------------------------------------------------

### Ejecución local

Simular PR → develop (suite `@pr`)

    mvn clean test -Denvironment=qa -Dbrowser=chrome "-Dcucumber.filter.tags=@pr and not (@wip or @flaky)"

Simular PR → main (suite `@release`)

    mvn clean test -Denvironment=qa -Dbrowser=chrome "-Dcucumber.filter.tags=@release and not (@wip or @flaky)"

Ejecuta toda la suite (excluye `@wip` y `@flaky`)

    mvn clean test -Denvironment=qa -Dbrowser=chrome "-Dcucumber.filter.tags=not (@wip or @flaky)"

------------------------------------------------------------------------

### Reportes Allure

    mvn allure:serve
- Levanta un servidor local de Allure 
- Utiliza los resultados existentes en target/allure-results

---
    mvn allure:report
- Genera un reporte estático en la carpeta target/site
- El reporte puede abrirse directamente desde el archivo index.html
- No requiere levantar un servidor Allure
- Útil para compartir reportes y almacenarlos como artefactos

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

## 🔁 Integración Continua (CI)

Este proyecto ejecuta automáticamente la totalidad de los tests
mediante **GitHub Actions** en cada Pull Request hacia `develop` o `main`.

- Si los tests fallan, el PR no puede ser mergeado.
- Si los tests pasan, el merge queda habilitado.
- Se ejecutan los tests en múltiples navegadores mediante una matriz


- PR hacia `develop`: ejecuta escenarios con `@pr` (excluye `@wip` y `@flaky`)
- PR hacia `main`: ejecuta escenarios con `@release` (excluye `@wip` y `@flaky`)

---

## 📌 Versionado

Este repositorio utiliza tags para marcar cambios importantes:

- `v0.1` → Versión inicial sin refactor completo.
- `v0.2` → Refactor total + estructura del framework.
- `v0.3` → Mejoras de configuración y documentación
- `v0.4` → Refactor de steps
- `v0.5` → Centralización de acciones y validaciones del framework
