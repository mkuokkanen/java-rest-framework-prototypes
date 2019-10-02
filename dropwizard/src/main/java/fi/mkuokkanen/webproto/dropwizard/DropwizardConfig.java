package fi.mkuokkanen.webproto.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class DropwizardConfig extends Configuration {

    @NotEmpty
    private String defaultName;

    @Min(5)
    private Integer defaultAge;

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @JsonProperty
    public Integer getDefaultAge() {
        return defaultAge;
    }

    @JsonProperty
    public void setDefaultAge(Integer defaultAge) {
        this.defaultAge = defaultAge;
    }
}
