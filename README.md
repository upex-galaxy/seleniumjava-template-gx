[![🤖CI Regression in QA🧪](https://github.com/upex-galaxy/selenium-java/actions/workflows/regression.yml/badge.svg)](https://github.com/galaxy/selenium-java/actions/workflows/regression.yml)

[![vscode-logo]][vscode-site] [![selenium-logo]][selenium-site] [![java-logo]][java-site]

# 🧪Testing Automation: Selenium 4 Java con Maven

![upexGX_seleniumjava](https://github.com/upex-galaxy/L1-seljava-demo/assets/91127281/3d5a98c8-7e2b-49ac-8390-4f97b4548628)

Este es un proyecto Oficial de UPEX para usar Selenium4 usando Java y Maven.

## INSTALACIÓN Y CÓMO EMPEZAR:

1. Asegurarse de tener instalado JAVA (versión 20) y MAVEN (versión 3 o superior).
2. Asegurarse de tener la variable de environment JAVA_HOME y MAVEN_HOME en la variable PATH del sistema.
3. Reiniciar VSCODE por si acaso, y verifica si tienes java v20 y Maven en VSCODE corriendo:

    ```bash
    java --version
    mvn --version
    ```

4. Para clonar el repositorio, ejecuta el siguiente comando:

    ```bash
    git clone https://github.com/upex-galaxy/L1-seljava-demo.git
    ```

5. Una vez descargado y dentro del Repo, automáticamente JAVA y MAVEN detectarán los paquetes para instalar las dependencias del archivo pom.xml, dado
   que el nombre del archivo del proyecto es igual al `<artifactId>` del archivo pom.xml. (Esto es importante)

6. [IMPORTANTE]: Recuerda ejecutar en la terminal el siguiente comando para compilar el proyecto y crear todos los correspondientes classpaths de los
   archivos del repo:

    ```bash
    mvn compile
    ```

7. Para comprobar que todo está instalado, EJECUTA el comando de pruebas E2E: <br> `mvn verify -Dheadless=true`<br>, lo cual ejecutará todas las
   pruebas activas Automatizadas de Selenium que tiene el repo (en modo headless, sin aparecer el navegador en pantalla). <br> **(Puedes detener esta
   ejecución de pruebas si te parece larga con Ctrl+C en la terminal)**

# EJECUCIÓN DE PRUEBAS CON SELENIUM

### En Visual Studio Code:

Para ejecutar las pruebas, abre Visual Studio Code y asegúrate de tener el Test Runner instalado. Si no lo tienes, puedes instalarlo desde la sección
de extensiones de Visual Studio Code.

Después, abre el archivo de prueba que deseas ejecutar y haz clic en el botón de "Run" que aparece al lado del nombre del archivo. Esto ejecutará
todas las pruebas dentro del archivo.

### En la Terminal:

Este proyecto utiliza un Plugin de Maven para correr las pruebas de Integración E2E. Para correr todas las pruebas, ejecuta el siguiente comando en la
terminal de VSCODE: del proyecto:

```bash
mvn verify
```

Para correr pruebas en modo HEADLESS (significa que no va abrir el navegador en tu pantalla y que las pruebas se estarán corriendo como en
background):

```bash
mvn verify -Dheadless=true
```

El comando `-D` de Maven se usa para declarar parámetros en la ejecución del comando, en este caso se usa un parámetro llamado "headless", cuyo
parámetro del sistema es usado en las configuraciones del archivo de DriverManager para las pruebas automatizadas de selenium, haciendo que cuando una
prueba se corra con este parámetro en la terminal, se pueda declarar el argumento `true` de headless para que las pruebas se corran sin abrir el
navegador, lo cual es importante para el CI sobretodo.

Para correr pruebas específicas, utiliza el parámetro `it.test` de Maven en el `-D`, es decir, así: `-Dit.test`. Por ejemplo si quieres correr solo
las pruebas en el archivo clase: `FirstTest.java`, ejecuta el siguiente comando:

```bash
mvn verify -Dit.test=FirstTest
```

Recuerda que si utilizas Visual Studio Code, puedes correr pruebas directamente utilizando la extensión Java Test Runner, cuya función está en el
panel de navegación a un costado del Visual Studio Code.

# ESTRUCTURA DEL REPOSITORIO DE PRUEBAS

El proyecto de Automatización Selenium-Java está estructurado de la siguiente manera:

```bash
├── src
│   ├── test
│   │   ├── java
│   │   │   └── e2e
│   │   │       ├── fixtures
│   │   │       │   ├── DriverManager.java
│   │   │       │   └── TestBase.java
│   │   │       ├── hooks
│   │   │       ├── page
│   │   │       │   └── GX2_4919_Checkbox_Page.java
│   │   │       ├── steps
│   │   │       │   ├── Elements
│   │   │       │   │   └── GX2_4919_CheckboxTest.java
│   │   │       │   └── FirstTest.java
│   │   │       └── utils
│   │   │           ├── Assertion.java
│   │   │           └── Locator.java
│   │   └── resources
│   │       ├── cucumber.properties
│   │       ├── features
│   │       │   └── example.feature
│   │       └── log4j.properties
│   └── test-plan
│       └── in-sprint
│           └── S21
│               └── GX2-4919.md
```

## USAR el TestBase para diseñar y correr las pruebas

El TestBase es una clase de utilidad que proporciona algunos métodos para la configuración del navegador y la inicialización de WebDriver. Si quieres
utilizar esta clase en tus pruebas, simplemente extiende tu clase de prueba con TestBase y utiliza los métodos que proporciona, ejemplo:

```java
public class SuiteTest extends TestBase {

  @Test
  @DisplayName("GX-123 TC1: Verificar formulario de Facturación")
  public void TC1() {
    // Aquí puedes utilizar los métodos del TestBase directamente...
  }
}
```

---

# PLAN DE PRUEBA: ESTRATEGIA Y DISEÑO

### 🚩NORMATIVAS A SEGUIR:

1. Perfecta Nomenclatura del nombre de Archivo de prueba: <br> `{StoryShortName}Test.java ej: addToCartTest.java`
2. Archivo de Prueba dentro del directorio de Steps correspondiente, ejemplo: <br> `src/test/java/e2e/steps/FirstTest.java`.
3. **En caso de usar PageObjectModel**: Chequear que el "Page.java" esté dentro de la carpeta "pages" en la de "support", ejemplo: <br>
   `src/test/java/e2e/page/ProductsPage.java`.
4. **En caso de usar el CI Pipeline**: Usar únicamente el archivo predeterminado del proyecto `sanity.yml`, y asegurarse de modificarlo correctamente
   (Solo cambiar el Path del Test Suite) y no borrar o cambiar nada más, que funcione y pase los Checks. El archivo `regression.yml` se ejecutará
   automaticamente cuando los cambios hayan mergeado a QA.
5. **En caso de usar Cucumber**: Chequear que el archivo Gherkin (.feature) y los StepDefinitions (.java) estén correctamente diseñados y que la
   Ejecución en CI funcione y pase los Checks.

---

# 🚩NIVELES DE TESTER QA en UPEX Galaxy:

El programa **UPEX Galaxy** está diseñado para guiar a los Testers a través de 2 Etapas (Career Paths). Cada Etapa conlleva ciertos **NIVELES** que el
Tester debe alcanzar para llegar a su mayor **SENIORITY**:

## QA Engineer (Pruebas Manuales)

Capacidad de realizar análisis, planificación, ejecución y gestión de:

-   Pruebas Manuales de UI
-   Bases de Datos
-   API Testing

### 🧪L1

Capaz de realizar tareas (US) sencillas de frontend sin mucha complejidad.

##### Prácticas:

-   Entiende y puede seguir guías y protocolos de prueba previamente definidos.
-   Identifica errores obvios en la interfaz y reporta con claridad.
-   Familiarizado con herramientas básicas de testing y reporting.
-   Capaz de realizar pruebas de regresión siguiendo casos de prueba definidos.

### 🧪L2

Capaz de realizar tareas (US) avanzadas de frontend y también tareas de Backend (Pruebas de Bases de Datos y Pruebas de API).

##### Prácticas:

-   Realiza pruebas exploratorias identificando puntos críticos en las aplicaciones.
-   Puede diseñar casos de prueba simples basados en requisitos.
-   Familiarizado con SQL básico para realizar pruebas en Bases de Datos.
-   Inicia pruebas básicas en APIs usando herramientas como Postman o similares.
-   Entiende la importancia de ciclos de vida de defectos y los gestiona correctamente.

### 🧪L3

Capaz de realizar tareas (US) de performance y/o diseñar nuevas Historias de Usuario.

##### Prácticas:

-   Diseña y ajusta casos de prueba complejos basados en cambios de requisitos.
-   Identifica y reporta problemas de rendimiento usando herramientas básicas.
-   Realiza pruebas exploratorias avanzadas e identifica áreas no cubiertas.
-   Gestiona los Planes de Prueba (Cobertura, Regresión, Sanity, Smoke) de manera efectiva.
-   Ofrece guía y mentoría a testers de niveles inferiores (Capacidad de ser Tutor).
-   Tiene una comprensión básica sobre automatización de pruebas.

## QA Automation Engineer (Pruebas Automatizadas)

Capacidad de realizar análisis, planificación, ejecución y gestión de:

-   Pruebas Automatizadas de E2E
-   Integration Testing (Aplicando para cualquiera de los Frameworks de automatización de Browsers/Apps)

### 🧪L3

Capaz de realizar tareas (TechDept) para Automatizar pruebas UI de historias implementadas.

##### Prácticas:

-   Capaz de manejar el flujo completo de trabajo ordinario.
-   Capaz de realizar pruebas Frontend con data sin iteración (hardcodeada).
-   Capaz de realizar Page-Object-Model básico.
-   Capaz de realizar controles de versionado de código (conocimiento básico en GIT).

### 🧪L4

Capaz de realizar tareas (TD) para Automatizar pruebas complejas y de integración de historias implementadas.

##### Prácticas:

-   Capacidad de resolución de problemas y conflictos de pruebas (Debugging).
-   Capaz de realizar pruebas E2E con data en iteración (Parametrizadas).
-   Capaz de escribir código con Excelentes prácticas y principios (POM, “DRY”, etc.).
-   Capaz de escribir scripts de prueba con Estructura de Datos, condicionales, bucles, etc.
-   Capaz de entender y ejecutar Pipelines de Regresión en Continuous Integration (CI).
-   Capaz de escribir scripts de prueba para intercepción y assertions de API Testing.

### 🧪L5

Capaz de realizar cualquier tarea (TD) de Automatización y gestionar los Planes de Prueba.

##### Prácticas:

-   Capacidad de resolución de conflictos de GIT con facilidad.
-   Capacidad de resolución de problemas de ambientes y errores de config del Repo.
-   Capaz de realizar Planes de Prueba generales y para Automatización de pruebas.
-   Capaz de planificar, armar y hacer funcionar los Repositorios de Automatización de Prueba.
-   Capaz de configurar integraciones de aplicaciones de Reporte de Prueba con el Repo.
-   Capaz de realizar pruebas automatizadas de Performance (con ciertas herramientas).

---

### 🧙🏻‍♂️APRENDE Y GANA EXPERIENCIA COMO QA AUTOMATION EN UPEX GALAXY🚀

Suscríbete a un Sprint y trabaja como un QA Automation Engineer!

### 🚩ENTRA EN [UPEXDOCU](https://linktree.com/upexjira) Y BUSCA LAS GUÍAS DE CYPRESS AL GRANO!

---

## CURSO YOUTUBE DE SELENIUM-JAVA AL GRANO:

-   [🛸CURSO: "AUTOMATION SELENIUM-JAVA AL GRANO" (UPEX GALAXY)]()

### 🧪 Happy Testing

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[vscode-logo]: https://img.shields.io/badge/VSCode-black?logo=visualstudiocode&style=for-the-badge
[vscode-site]: https://code.visualstudio.com/
[selenium-logo]: https://img.shields.io/badge/Selenium-black?logo=selenium&style=for-the-badge
[selenium-site]: https://www.selenium.dev
[java-logo]: https://img.shields.io/badge/Java-black?logo=java&style=for-the-badge
[java-site]: https://www.tutorialspoint.com/java/java_documentation.htm
