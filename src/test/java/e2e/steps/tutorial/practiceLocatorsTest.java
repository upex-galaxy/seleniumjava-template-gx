package e2e.steps.tutorial;

public class practiceLocatorsTest {
    // * */ CSS Selectors
    // * */ #filtrar Tags => 'div'
    // * */ #4 Class => '.nombre-de-la-clase'
    // * */ #2 Id => '#searchPanel'
    // * */ #1 datatestid => '[datatestid=value]' // son atributos:
    // * */ #3 Attr => '[key=value]' // name=xx // colindex=zz ....
    // * Usar una Class/id como Attr => [class=nombre] // [id=xx]

    // * */ Xpaths (util para Selenium cuando no puedes agarrar el elemento con un
    // Css
    // Selector: último recurso, abstenerse)
    // * */ #filter Tags => '//div'
    // * */ #4 Class => '//*[@class="active oxd-main"]'
    // * */ #2 Id => '//*[@id="searchPanel"]'
    // * */ #1 datatestid => '//*[@datatestid="value"]'
    // * */ #3 Attr => '//*[@key="value"]'
    // * */ #1 Textos => '//*[text()="TEXTO"]'
    // * */ #1 TextoParcial => '//*[contains(text(),"TEXTO")]'
}
