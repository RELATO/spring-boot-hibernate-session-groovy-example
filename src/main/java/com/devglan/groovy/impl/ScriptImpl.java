package com.devglan.groovy.impl;

import com.devglan.groovy.IScript;
import org.springframework.stereotype.Component;

/**
 * 系统脚本
 */
@Component
public class ScriptImpl implements IScript {
    public String getCurrentUserId() {
        return "1";
    }
}