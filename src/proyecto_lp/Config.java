/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_lp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Farlo
 */

public class Config {
    private static Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Error cargando config.properties: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}