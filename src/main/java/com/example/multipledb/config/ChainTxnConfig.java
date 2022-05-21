package com.example.multipledb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainTxnConfig {
    @Bean(name = "chainedTransactionManager")
    public ChainedTransactionManager transactionManager(@Qualifier("lyricsTransactionManager") PlatformTransactionManager ds1, @Qualifier("transactionManager") PlatformTransactionManager ds2)
    {
        return new ChainedTransactionManager(ds1,ds2);
    }
}
