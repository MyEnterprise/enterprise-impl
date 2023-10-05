package com.voyager.enterprise.config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
    	Object value = getEnvProperty(key);
        if (value != null) {
            return value.toString();
        } 
        value = getYamlProperty(key);
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    public Object getYamlProperty(String key) { return yamlConfig.get(key); }

    public String getEnvProperty(String key) { return envConfig.getProperty(key); }

}
