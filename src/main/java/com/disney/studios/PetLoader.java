package com.disney.studios;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Loads stored objects from the file system and builds up
 * the appropriate objects to add to the data source.
 *
 * Created by fredjean on 9/21/15.
 */
@Component
public class PetLoader implements InitializingBean {
    // Resources to the different files we need to load.

    @Value("classpath:data/labrador.txt")
    private Resource labradors;

    @Value("classpath:data/pug.txt")
    private Resource pugs;

    @Value("classpath:data/retriever.txt")
    private Resource retrievers;

    @Value("classpath:data/yorkie.txt")
    private Resource yorkies;

    @Autowired
    DataSource dataSource;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadCategory("Labrador", labradors);
        loadCategory("Pug", pugs);
        loadCategory("Retriever", retrievers);
        loadCategory("Yorkie", yorkies);
    }

    private void loadCategory(String category, Resource source) throws IOException {
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                /* TODO: Create appropriate objects and save them to
                 *       the datasource.
                 */
            }
        }
    }
}
