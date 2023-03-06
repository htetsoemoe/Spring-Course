package com.demo.filestore.network;

import com.demo.filestore.FileStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "file.store", havingValue = "network")
public class NetworkFileStoreAutoConfig {
    @Bean
    public FileStore fileStore() {
        return new NetworkFileStore();
    }

}
