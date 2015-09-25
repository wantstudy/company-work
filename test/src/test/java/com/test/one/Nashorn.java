package com.test.one;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Nashorn {
//	static void rhino(String parser, String code) {
//        String source = "speedtest";
//        int line = 1;
//        Context context = Context.enter();
//        context.setOptimizationLevel(9);
//        try {
//            Scriptable scope = context.initStandardObjects();
//            context.evaluateString(scope, parser, source, line, null);
//            ScriptableObject.putProperty(scope, "$code", Context.javaToJS(code, scope));
//            Object tree = new Object();
//            Object tokens = new Object();
//            for (int i = 0; i < RUNS; ++i) {
//                long start = System.nanoTime();
//                tree = context.evaluateString(scope, "esprima.parse($code)", source, line, null);
//                tokens = context.evaluateString(scope, "esprima.tokenize($code)", source, line, null);
//                long stop = System.nanoTime();
//                System.out.println("Run #" + (i + 1) + ": " + Math.round((stop - start) / 1e6) + " ms");
//            }
//        } finally {
//            Context.exit();
//            System.gc();
//        }
//    }
    static void nashorn(String parser, String code) throws ScriptException,NoSuchMethodException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        engine.eval(parser);
        Invocable inv = (Invocable) engine;
        Object esprima = engine.get("esprima");
        Object tree = new Object();
        Object tokens = new Object();
        for (int i = 0; i < 100; ++i) {
            long start = System.nanoTime();
            tree = inv.invokeMethod(esprima, "parse", code);
            tokens = inv.invokeMethod(esprima, "tokenize", code);
            long stop = System.nanoTime();
            System.out.println("Run #" + (i + 1) + ": " + Math.round((stop - start) / 1e6) + " ms");
        }
        // System.out.println("Data is " + tokens.toString() + " and " + tree.toString());
    }
}
