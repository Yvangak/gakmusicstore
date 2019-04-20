package gak.library.music.proxy.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:music_library.properties")
public class ProxyConfiguration {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
