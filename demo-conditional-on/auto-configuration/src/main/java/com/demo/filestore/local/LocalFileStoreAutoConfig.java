package com.demo.filestore.local;

import com.demo.filestore.FileStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "file.store", havingValue = "local")
public class LocalFileStoreAutoConfig {

    @Bean
    public FileStore fileStore() {
        return new LocalFileStore();
    }
}
