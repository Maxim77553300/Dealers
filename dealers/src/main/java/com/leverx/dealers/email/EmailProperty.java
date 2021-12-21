package com.leverx.dealers.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;



@Validated
@ConfigurationProperties(prefix = "dealers.email")
public class EmailProperty {
    @NotNull
    private boolean real;

    public boolean getReal() {
        return real;
    }

    public void setReal(boolean real) {
        this.real = real;
    }
}
