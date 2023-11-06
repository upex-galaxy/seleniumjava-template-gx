package e2e.steps.tutorial;

import java.util.*;
import org.junit.jupiter.api.*;

public class BasicJavaTutorialTest {

    // Todo: ESTO ES UN EJEMPLO DE UNA VARIABLE DECLARADA (con muchas
    // modificaciones):
    public static final String EXAMPLE_VARIABLE = "This is an example variable.";
    // name = "Sai"
    // const name = "Sai" | let name = "" | var name = "Sai"
    // const name: string = "Sai" | let name = "" | var name = "Sai"
    // String name = "Sai"

    // Todo: Modificadores de Acceso:
    // * <public/private/protected/default>
    // * Estos modificadores determinan desde dónde se puede acceder o modificar una
    // variable.
    // * public: La variable es accesible desde cualquier otra clase.
    // * private: La variable sólo es accesible dentro de la clase donde se declara.
    // * protected: La variable es accesible dentro de su misma clase, paquete y
    // subclases.
    // * default (sin modificador): La variable es accesible sólo dentro de su mismo
    // paquete.

    // Todo: Modificadores Adicionales:
    // * <tags: static, final, transient, volatile>
    // * static: Indica que la variable pertenece a la clase y no a una instancia
    // específica de ella.
    // * final: Una vez que la variable ha sido asignada, no puede cambiar su valor.
    // * transient: Esta variable no será serializada cuando la clase sea
    // serializada.
    // * volatile: Indica que una variable puede ser modificada por diferentes hilos
    // y garantiza que cualquier hilo lea el último cambio.

    // Todo: Tipo de la Variable:
    // * <!Tipo>
    // * Define el tipo de dato de la variable.
    // * Puede ser un tipo primitivo (int, double, char, etc.),
    // * Puede ser una clase (String, List, Map, etc.), o una interfaz.

    // Todo: Nombre de la Variable:
    // * Esta es la etiqueta que usamos para referirnos a la variable.
    // * Debe seguir las convenciones de nomenclatura de Java: camelCase para
    // nombres de variables y UPPER_CASE para constantes.

    // Todo: Asignación:
    // * = "valor"
    // * Aquí es donde asignamos un valor inicial a la variable. La asignación es
    // opcional en la declaración;
    // * podemos declarar una variable sin asignarle un valor de inmediato.

    // Todo: */ String:
    // * Es una clase que representa secuencias de caracteres. Similar al "string"
    // en JavaScript.
    public static final String sampleString = "Hello, \"World\"!";

    // Todo: */ Integer y Double:
    // * Estas son clases envolventes (wrapper classes) para los tipos primitivos
    // int y double.
    // * Corresponden aproximadamente al "number" en JavaScript.
    public static final Integer sampleInteger = 42;
    public static final Double sampleDouble = 56.78;

    // Todo: */ Boolean:
    // * Clase envolvente para el tipo primitivo boolean. Similar al "boolean" en
    // JavaScript.
    public static final Boolean sampleBoolean = true;

    // Todo: */ List (parecido al Array en JavaScript):
    // * Es una interfaz que representa una colección ordenada. La implementación
    // más común es ArrayList.
    // const bookList: Array<string> = ["A", "B", "C"]
    public static final List<String> sampleList = new ArrayList<>(Arrays.asList("one", "two", "three"));

    // Todo: */ Map (parecido al Object en JavaScript en términos de pares
    // clave-valor):
    // * Es una interfaz que representa una colección de pares clave-valor.
    public static final Map<String, Integer> sampleMap = new HashMap<>();
    static {
        sampleMap.put("one", 1);
        sampleMap.put("two", 2);
    }

    public String getName() {
        String name = "Sai";
        String password = "galaxy";
        return name + " is on " + password;
    }

    @Test
    public void methodito() {
        System.out.print("----Hola Selenium Java! Estos son todos los tipos de Datos más comunes----");
        System.out.print("STRING:");
        System.out.println(sampleString);
        System.out.print("NUMBER-INTEGER:");
        System.out.println(sampleInteger);
        System.out.print("NUMBER-FLOAT:");
        System.out.println(sampleDouble);
        System.out.print("BOOLEAN:");
        System.out.println(sampleBoolean);
        System.out.print("ARRAY LIST:");
        System.out.println(sampleList);
        System.out.print("OBJECT-MAP:");
        System.out.println(sampleMap);
        String givenName = getName();
        System.out.print(givenName);
    }
}
