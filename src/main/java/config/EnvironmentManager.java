package config;

import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.getProperty;

public class EnvironmentManager {

    private static final Logger log = LoggerFactory.getLogger(EnvironmentManager.class);

    public static void init(Scenario scenario) {
        // Si no hay tag, usar lo que vino por Maven (-Denvironment=xxx)
        String envFromMaven = getProperty("environment");

        if (envFromMaven != null) {
            log.info("Environment cargado desde maven: {}",
                    envFromMaven);
            return;
        }

        // Revisa si el escenario tiene un tag tipo @env:dev
        String envFromTag = getEnvironmentFromTag(scenario);

        if (envFromTag != null) {
            log.info("Environment cargado desde tag: {}",
                    envFromTag);
            System.setProperty("environment", envFromTag);
            return;
        }

        // Si nada está definido, usar default
        log.info("Environment cargado por defecto: {}",
                "qa");
        System.setProperty("environment", "qa");
    }

    public static String getEnvironmentFromTag(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@env:")) {
                return tag.replace("@env:", "");
            }
        }
        return null;
    }
}
