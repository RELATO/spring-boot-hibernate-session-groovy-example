package com.devglan;

import com.devglan.groovy.GroovyParse;
import com.devglan.groovy.GroovyScriptEngine;
import com.devglan.model.UserDetails;
import com.devglan.scripting.DynamicScriptEngine;
import com.devglan.scripting.GroovyScriptProvider;
import com.devglan.service.UserService;
import groovy.lang.Binding;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import static java.lang.System.exit;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by relato user on 04/05/2018.
 */
@Profile({"console"})
@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceLoader resourceLoader;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(ApplicationRunner.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    // Put the logic here.
    @Override
    public void run(String... args) throws Exception {


//
//        UserDetails newUser = new UserDetails();
//        newUser.setId(0);
//        newUser.setEmail("junior3.quiescente@gmail.com");
//        newUser.setFirstName("Junior3");
//        newUser.setLastName("Quiescente3");
//        newUser.setPassword("lalalaki3");
//        userService.add(newUser);
//
//        List<UserDetails> userDetails = userService.getUserDetails();
//
//        for (UserDetails user : userDetails) {
//            System.out.println(user.getFirstName());
//        }


        Resource res = resourceLoader.getResource("classpath:Hello.groovy");

//        try {
//
//            // String[] roots = new String[] { "/src/main/resources/" };
//            GroovyScriptEngine gse = new GroovyScriptEngine(new URL[]{res.getURL()},
//                    Thread.currentThread().getContextClassLoader());
//
//            Binding binding = new Binding();
//            binding.setVariable("name", "Gweneth");
//
//            Object output = gse.run("Hello.groovy", binding);
//            assert output.equals("Hello Gweneth");
//        } catch (IOException | ResourceException | ScriptException e) {
//            System.out.println(e.getMessage());
//        }



//        GroovyScriptProvider gse = new GroovyScriptProvider("src/main/resources");
//        gse.setVariable("result", 0);
//        gse.executeScript("firsttest.groovy");
//        Integer gres = gse.getVariable("result");
//
//        System.out.println("DYNRES => " + gres );

//        String formula = "println 'Hello World!';po = '9s00';return (a * b);";
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("a", 900);
//        map.put("b", 10);
//        Object value = GroovyParse.formulaParse(formula, map);
//        System.out.println("VALUE => " + value);


        String formula = "println 'Hello World!';po = '9s00';return (a * b);";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("a", 900);
        map.put("b", 10);
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine();
        Object value = groovyScriptEngine.executeObject(formula, map);
        System.out.println(value);
        System.out.println(groovyScriptEngine.binding.getVariable("po"));


        exit(0);
    }
}
