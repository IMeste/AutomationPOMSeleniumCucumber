package config;

import io.cucumber.java.Scenario;

public class EnvironmentManager {

    private static String environment = null;

    public static void init(Scenario scenario) {
        // Revisa si el escenario tiene un tag tipo @env:dev
        String envFromTag = getEnvironmentFromTag(scenario);

        if (envFromTag != null) {
            environment = envFromTag;
            System.setProperty("environment", envFromTag);
            return;
        }

        // Si no hay tag, usar lo que vino por Maven (-Denvironment=xxx)
        String envFromMaven = System.getProperty("environment");

        if (envFromMaven != null) {
            environment = envFromMaven;
            return;
        }

        // Si nada está definido, usar default
        environment = "qa";
        System.setProperty("environment", "qa");
    }

    private static String getEnvironmentFromTag(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@env:")) {
                return tag.replace("@env:", "");
            }
        }
        return null;
    }

    public static String getEnvironment() {
        return environment;
    }
}
