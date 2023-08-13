[![🤖CI Regression in QA🧪](https://github.com/upex-galaxy/L1-seljava-demo/actions/workflows/CI-regressionTest.yml/badge.svg)](https://github.com/upex-galaxy/L1-seljava-demo/actions/workflows/CI-regressionTest.yml)

[![vscode-logo]][vscode-site] [![selenium-logo]][selenium-site] [![java-logo]][java-site]

# 🧪Testing Automation: Selenium 4 Java con Maven (+Cucumber)
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

### 🚩LEVEL ONE (L1):

1. La Perfecta Nomenclatura del nombre de Archivo de prueba, con CamelCase: <br>
   `{StoryID}_{StoryShortName}Test.java ej: GX_50_AddItemsToCartTest.java`
2. Archivo de Prueba dentro del directorio del Componente correspondiente, ejemplo: <br>
   `src/test/java/e2e/steps/Elements/GX2_4919_CheckboxTest.java`.
3. Buen diseño del Test Suite elaborado (Esto implica que se vea bien el código en general, que al menos funcione).
4. Tener el Markdown de la US en la carpeta Test-Plan en su correspondiente carpeta Sprint, ejemplo: <br>
   `src/test-plan/in-sprint/S21/GX2-4919.md`<br> Esto implica que cada vez que se trabaje en un Sprint nuevo, se debería crear la carpeta
   correspondiente "S" + número del sprint, como se muestra en el ejemplo arriba.
5. Hacer SIEMPRE uso del Fixture `TestBase` para el setup del Driver por lo menos. Es decir, que en cada clase de Suite de prueba, hacer el "extends
   TestBase" para llamar el DriverManager que instancia el driver para usar en cada caso de prueba. Dicho TestBase se encuentra aquí: <br>
   `src/test/java/e2e/fixtures/TestBase.java`.
6. En caso de usar PageObjectModel en Java: <br> El nombre del archivo debe terminar en `Page.java`, Y Debe estar dentro de la carpeta "pages" del
   directorio de e2e, ejemplo: <br> `src/test/java/e2e/page/CheckboxPage.java`. (ATENCIÓN: En caso de UPEX, como muchos pueden trabajar en un mismo
   POM, éste archivo puede ser almacenado en un subdirectorio con las iniciales del usuario, ejemplo yo que me llamo Elyer Maldonado, puedo usar "EM",
   pero en un escenario REAL de trabajo, No deberías usar un subdirectorio para alojar el POM, aquí lo hacemos solo para no chocar trabajos), ejemplo
   para el caso de UPEX:<br> `src/test/java/e2e/page/EM/CheckboxPage.java`
7. En caso de usar el módulo de Action, Locator, y Assertion: Asegurarse de aplicarlos adecuadamente, pero si necesitas añadir más métodos de estos
   módulos, ponte en contacto con el Líder del Repositorio.
8. En caso de usar el CI Pipeline: Modifica únicamente el archivo `CI-sanityTest.yml` del proyecto, y asegúrate de modificarlo correctamente: <br>
   Solo cambia el Nombre Class del archivo Test.java bajo prueba en el paso "🧪Run Selenium tests", y no borres o cambies nada más, que funcione y
   pase los Checks.
9. OJO: Aún no está habilitado CUCUMBER para ser usado en este proyecto, pero si quieres ayudarnos con la investigación e implementación, eres
   bienvenido (si eres nuevo aprendiedno selenium java, no investigues nada sobre cucumber, enfócate en lo primero).

---

### 🚩LEVEL TWO (L2):

1. Es obligatorio realizar TODO lo anterior declarado, pero adicionalmente:
    - Tener MUCHO mejor código en los Scripts.
2. Obligatoriamente, realizar:
    - Hacer el correspondiente PageObjectModel
    - Crear tus propios Métodos de SuperPrecondition (en caso de necesitarlo)
    - Usar los módulos de Utils (Action, Locator, Assertion) en lugar de hardcodear.
    - Hacer uso del CI Pipeline
3. OPCIONAL: usar `Cucumber` si la US conviene, pero no es obligatorio para L2.

### 🧪 Happy Testing

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[vscode-logo]: https://img.shields.io/badge/VSCode-black?logo=visualstudiocode&style=for-the-badge
[vscode-site]: https://code.visualstudio.com/
[selenium-logo]: https://img.shields.io/badge/Selenium-black?logo=selenium&style=for-the-badge
[selenium-site]: https://www.selenium.dev
[java-logo]: https://img.shields.io/badge/Java-black?logo=java&style=for-the-badge
[java-site]: https://www.tutorialspoint.com/java/java_documentation.htm
