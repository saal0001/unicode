package com.example.unicodejpaopgave.config;

import com.example.unicodejpaopgave.model.Unicode;
import com.example.unicodejpaopgave.repository.UnicodeREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeREpository unicodeREpository;


    @Override
    public void run(String... args) throws Exception {
        Set<Unicode> unicodes = new HashSet<>();
        unicodeREpository.saveAll(unicodes);
    }
}
