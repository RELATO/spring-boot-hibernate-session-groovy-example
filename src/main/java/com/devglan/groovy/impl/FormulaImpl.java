package com.devglan.groovy.impl;

import com.devglan.groovy.IScript;
import org.springframework.stereotype.Component;

/**
 * 公式脚本
 */
@Component
public class FormulaImpl implements IScript {
    public Double add(Double a,Double b) {
        return a*b;
    }
}