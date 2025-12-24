package config;

import io.cucumber.java.Scenario;
import static java.lang.System.getProperty;

public class EnvironmentManager {


    public static void init(Scenario scenario) {
        // Si no hay tag, usar lo que vino por Maven (-Denvironment=xxx)
        String envFromMaven = getProperty("environment");

        if (envFromMaven != null) {
            return;
        }

        // Revisa si el escenario tiene un tag tipo @env:dev
        String envFromTag = getEnvironmentFromTag(scenario);

        if (envFromTag != null) {
            System.setProperty("environment", envFromTag);
            return;
        }

        // Si nada está definido, usar default
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
