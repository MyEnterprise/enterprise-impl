package com.voyager.enterprise.config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class Config {

	private final Map<String, Object> yamlConfig;
    private final Properties envConfig;

    public Config() {
        // Carrega o arquivo application.yml do classpath
        InputStream yamlInputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
        Yaml yaml = new Yaml();
        yamlConfig = yaml.load(yamlInputStream);

        // Carrega o arquivo .env do diretório de execução
        envConfig = new Properties();
        try (InputStream envInputStream = new FileInputStream(".env")) {
            envConfig.load(envInputStream);
        } catch (IOException e) {
            // Lidar com possíveis erros de leitura do arquivo .env
            System.out.println("NOT found .env");
        }
    }

    public String getProperty(String key) {

    	Object value = getEnvProperty(key);
        if (value != null) {
            return resolveVariable(value.toString());
        } 
        value = getYamlProperty(key);
        if (value != null) {
            return resolveVariable(value.toString());
        }
        return "";
    }

    public Object getYamlProperty(String key) { 
        if( yamlConfig == null ) return null;

        var attr = key.split("\\.");
        var value = yamlConfig.get(attr[0]);
        for(var i = 1; i < attr.length; i++){
            value = ((Map)value).get( attr[i] );
        }

        return value;
    }

    public String getEnvProperty(String key) { 
        if( envConfig == null ) return null;
        return envConfig.getProperty(key); 
    }

    public static String resolveVariable(String input) {
        if (input != null && input.startsWith("${") && input.endsWith("}")) {
            var sanitized = input.substring(2, input.length() - 1);
            String[] parts = sanitized.split(":");

            String varName = parts[0];

            String defaultValue = (parts.length == 2) ? parts[1] : ((parts.length > 2) ? sanitized.substring(varName.length()+1, sanitized.length()) : "");

            String systemPropertyValue = System.getProperty(varName);

            if (systemPropertyValue != null) {
                return systemPropertyValue;
            }

            return defaultValue;
        }

        return input;
    }


}
