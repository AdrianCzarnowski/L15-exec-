package pages.config;

import configuration.model.EnvironmentList;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Config {
    public EnvironmentList environment;
    public BrowserConfig browserConfig;
}
