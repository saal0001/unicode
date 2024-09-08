package com.example.unicodejpaopgave.controller;

import com.example.unicodejpaopgave.model.Unicode;
import com.example.unicodejpaopgave.repository.UnicodeREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    UnicodeREpository unicodeREpository;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i){

        char c = (char) i;

        return "unicode=" + i + "char=" + c;
    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c){

        int i = (int) c;

        return "char=" + c + "unicode=" + i ;
    }


    @GetMapping("/unicode/{bogstav}/{antal}")
    public List<Unicode> print(@PathVariable char bogstav, @PathVariable int antal){
        List<Unicode> bogstaver = new ArrayList<>();
        Unicode unicode = new Unicode();
        unicode.setBogstav(bogstav);
        unicode.setUnicode((int) bogstav);
        unicodeREpository.save(unicode);
        for (int i = 0; i < antal; i++) {
            bogstaver.add(unicode);
        }
        return bogstaver;
    }

}
