import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.FileOutputStream;


public class PorteXML {

    final static String SEPARADOR = File.separator;
    final static File ESP = new File("src" + SEPARADOR + "resources" + SEPARADOR + "_ES.properties");
    final static File ENG = new File("src" + SEPARADOR + "resources" + SEPARADOR + "_EN.properties");

    final static File ESP_XML = new File("src" + SEPARADOR + "resources" + SEPARADOR + "_ES.xml");
    final static File ENG_XML = new File("src" + SEPARADOR + "resources" + SEPARADOR + "_EN.xml");
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(ESP, Charset.forName("UTF8")));

        // prop.storeToXML(System.out, null);

        prop.load(new FileReader(ENG, Charset.forName("UTF8")));
        prop.storeToXML(new FileOutputStream(ENG_XML), null);
    }
}
