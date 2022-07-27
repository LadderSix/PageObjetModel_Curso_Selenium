package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
    //Atributos
    private static Properties props;

    public static String getProperty(){
        props = new Properties();
        String rutaFile = "C:\\Users\\matias.rojas\\IdeaProjects\\PageObjectModel_Curso_Selenium\\src\\main\\resources\\properties.properties":

        try {
            InputStream input = new FileInputStream(rutaFile);

            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
