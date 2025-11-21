package config;

import io.cucumber.java.Scenario;
import static java.lang.System.getProperty;

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
        String envFromMaven = getProperty("environment");

        if (envFromMaven != null) {
            environment = envFromMaven;
            return;
        }

        // Si nada está definido, usar default
        environment = "qa";
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

    public static void initFromSystem() {
        String env = System.getProperty("environment");

        if (env == null || env.isEmpty()) {
            env = "qa";
        }

        environment = env.toLowerCase();
    }

    public static String getEnvironment() {
        return environment;
    }
}
