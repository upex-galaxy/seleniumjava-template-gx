# Proyecto Selenium Java con Maven (+Cucumber)

Este es un proyecto de ejemplo de Selenium WebDriver usando Java y Maven.

## Instalación

1. Asegurarse de tener instalado JAVA y MAVEN.
2. Asegurarse de tener la variable de environment JAVA_HOME y MAVEN_HOME en la variable PATH del sistema.
3. Reiniciar VSCODE por si acaso.

4. Para clonar el repositorio, ejecuta el siguiente comando:

```
git clone https://github.com/tu-usuario/tu-proyecto.git
```

5. Una vez descargado y dentro del Repo, automáticamente JAVA y MAVEN detectarán los paquetes para instalar las dependencias del archivo pom.xml, dado
   que el nombre del archivo del proyecto es igual al `<artifactId>` del archivo pom.xml. (Esto es importante)
6. Para comprobar que todo está instalado, puedes correr el comando de pruebas `mvn test`, lo cual ejecutará todas las pruebas activas del repo.
   **(Puedes detener esta ejecución de pruebas si te parece larga con Ctrl+C en la terminal)**

## Ejecutar las pruebas

Para ejecutar las pruebas, abre Visual Studio Code y asegúrate de tener el Test Runner instalado. Si no lo tienes, puedes instalarlo desde la sección
de extensiones de Visual Studio Code.

Después, abre el archivo de prueba que deseas ejecutar y haz clic en el botón de "Run" que aparece al lado del nombre del archivo. Esto ejecutará
todas las pruebas dentro del archivo.

## En la Terminal

Este proyecto utiliza el plugin de Surefire de Maven para correr las pruebas. Para correr todas las pruebas, ejecuta el siguiente comando en la raíz
del proyecto:

```
mvn test
```

Para correr pruebas específicas, utiliza la opción -Dtest de Maven. Por ejemplo, si quieres correr solo las pruebas en el archivo FirstTest.java,
ejecuta el siguiente comando:

```
mvn -Dtest=FirstTest test
```

Si utilizas Visual Studio Code, puedes correr pruebas directamente utilizando la extensión Java Test Runner.

## Estructura del proyecto

El proyecto está estructurado de la siguiente manera:

```
.
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── e2e
│   │           └── guice
│   │               ├── GuiceInjectorSource.java
│   │               ├── ProjectModule.java
│   │               └── provider
│   │                   └── WebDriverProvider.java
│   └── test
│       ├── java
│       │   └── e2e
│       │       ├── acceptancetests
│       │       │   └── AllTests.java
│       │       ├── fixtures
│       │       │   ├── DriverManager.java
│       │       │   └── TestBase.java
│       │       ├── hooks
│       │       │   └── Hooks.java
│       │       ├── pages
│       │       ├── steps
│       │       │   ├── ExampleSteps.java
│       │       │   └── FirstTest.java
│       │       └── utils
│       │           ├── Assertion.java
│       │           └── Locator.java
│       └── resources
│           ├── cucumber.properties
│           ├── features
│           │   └── example.feature
│           └── log4j.properties
└── target
    ├── classes
    │   └── e2e
    │       └── guice
    │           ├── GuiceInjectorSource.class
    │           ├── ProjectModule.class
    │           └── provider
    │               └── WebDriverProvider.class
    └── test-classes
        ├── cucumber.properties
        ├── e2e
        │   ├── acceptancetests
        │   │   └── AllTests.class
        │   ├── fixtures
        │   │   ├── DriverManager.class
        │   │   └── TestBase.class
        │   ├── hooks
        │   │   └── Hooks.class
        │   ├── pages
        │   ├── steps
        │   │   ├── ExampleSteps.class
        │   │   └── FirstTest.class
        │   └── utils
        │       ├── Assertion.class
        │       └── Locator.class
        ├── features
        │   └── example.feature
        └── log4j.properties
```

## Uso del TestBase

El TestBase es una clase de utilidad que proporciona algunos métodos para la configuración del navegador y la inicialización de WebDriver. Si quieres
utilizar esta clase en tus pruebas, simplemente extiende tu clase de prueba con TestBase y utiliza los métodos que proporciona:

```
public class SuiteDeTest extends TestBase {

  @Test
  public void myTest() {
    // Aquí puedes utilizar los métodos
  }
}
```
