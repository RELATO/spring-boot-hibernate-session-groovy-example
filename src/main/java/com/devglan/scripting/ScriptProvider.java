package com.devglan.scripting;

import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

/**
 * Created by relato user on 06/05/2018.
 */
public interface ScriptProvider {

    void setScriptPath(String codePath) throws IOException;

    void executeScript(String groovyScriptName) throws ResourceException,
            ScriptException;

    <T> T getVariable(String variableName);

    Map getVariables();

    void setVariable(String variableName, Object value);

    Object invokeMethodOnClass(String scriptName,  String invokeMethodName, Object[] arguments) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException;

    <T> T createInstance(String scriptName) throws InstantiationException, IllegalAccessException, CompilationFailedException, IOException;
}