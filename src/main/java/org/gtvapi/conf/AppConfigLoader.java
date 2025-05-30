package org.gtvapi.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("file:${CONFIG_PATH}/appconfig.conf")
public class AppConfigLoader {

    @Value("${channel_icon}")
    private String channelIcon;
}


