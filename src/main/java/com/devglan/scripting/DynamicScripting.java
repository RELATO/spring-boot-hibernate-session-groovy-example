package com.devglan.scripting;

/**
 * Created by relato user on 06/05/2018.
 */
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.util.Map;

interface DynamicScripting {

    void setScriptPath(String codePath) throws IOException;

    void executeScript(String groovyScriptName) throws ResourceException,
            ScriptException;

    <T> T getVariable(String variableName);

    Map getVariables();

    void setVariable(String variableName, Object value);

}