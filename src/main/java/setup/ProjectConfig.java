package setup;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:creds.properties"})
public interface ProjectConfig extends Config {

    @Key("url")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();
}
