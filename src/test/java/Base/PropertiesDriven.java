package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
    //Atributos
    private static Properties props;

    public static String getProperty(String key){
        //Instanciamos un objero properties
        props = new Properties();
        // Definimos String con la ruta del fichero con las properties del proyecto
        String rutaFile = "C:\\Users\\matias.rojas\\IdeaProjects\\PageObjectModel_Curso_Selenium\\src\\main\\resources\\properties.properties";

        //Intentamos instancia el fichero como un objeto de tipo file
        try {
            InputStream input = new FileInputStream(rutaFile);
            //Cargamos las properties del fichero
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Retornamos una property en base a su key
        return props.getProperty(key);
    }
}
