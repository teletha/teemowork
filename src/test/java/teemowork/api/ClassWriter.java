/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.api;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import com.google.common.io.Files;

import kiss.I;

/**
 * @version 2015/07/13 14:58:21
 */
public class ClassWriter {

    /** The end of line. */
    public static final String EOL = "\r\n";

    /** The code buffer. */
    private final StringBuilder code = new StringBuilder();

    /** The package name. */
    public final String packageName;

    /** The class name. */
    public final String className;

    /** The import manager. */
    private final Imports imports = new Imports();

    /** The import position. */
    private final int importPosition;

    /** The indent depth. */
    private int indentDepth;

    /** The line head management. */
    private boolean isHead;

    /** The indent text. */
    private String indent = "    ";

    /**
     * @param className
     */
    public ClassWriter(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;

        write("/*");
        write(" * Copyright (C) 2015 Nameless Production Committee");
        write(" *");
        write(" * Licensed under the MIT License (the \"License\");");
        write(" * you may not use this file except in compliance with the License.");
        write(" * You may obtain a copy of the License at");
        write(" *");
        write(" *          http://opensource.org/licenses/mit-license.php");
        write(" */");
        write("package ", packageName, ";");
        importPosition = code.length();
        write();
    }

    public <T> void writeConstants(Iterable<T> items, Consumer<T> process) {
        for (T item : items) {
            process.accept(item);
        }

        replaceLatest(',', ';');
    }

    private void replaceLatest(char target, char replacement) {
        for (int i = code.length() - 1; 0 <= i; i--) {
            char c = code.charAt(i);

            if (Character.isWhitespace(c)) {
                // ignore
            } else if (c == target) {
                code.setCharAt(i, replacement);
                return;
            } else {
                return;
            }
        }
    }

    public <T> void write(Iterable<T> items, Consumer<T> process) {
        items.forEach(process);
    }

    /**
     * <p>
     * Write blank line.
     * </p>
     */
    public void write() {
        writeEOL();
    }

    /**
     * <p>
     * Write code fragment.
     * </p>
     * 
     * @param values
     */
    public void write(Object... values) {
        for (int i = 0, length = values.length; i < length; i++) {
            Object value = values[i];
            String text = value.toString();

            if (text.endsWith("{")) {
                indentDepth++;
            } else if (text.startsWith("}")) {
                indentDepth--;
            }

            if (isHead) {
                for (int j = 0; j < indentDepth; j++) {
                    code.append(indent);
                }
                isHead = false;
            }

            if (value instanceof Importable) {

            }

            if (value instanceof Class) {
                text = imports.convert(value);
            }
            code.append(text);
        }
        writeEOL();
    }

    /**
     * <p>
     * Write end of line code.
     * </p>
     */
    private void writeEOL() {
        code.append("\r\n");

        isHead = true;
    }

    /**
     * <p>
     * Write source code to the specified {@link Path}.
     * </p>
     * 
     * @param path
     */
    public void writeTo(Path path) {
        try {
            Files.write(code, path.resolve(packageName.replace('.', '/'))
                    .resolve(className.concat(".java"))
                    .toFile(), I.$encoding);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code.toString();
    }

    /**
     * <p>
     * Helper method to write string literal.
     * </p>
     * 
     * @param values
     * @return
     */
    public static String string(Object... values) {
        StringBuilder builder = new StringBuilder();
        builder.append('"');
        for (int i = 0; i < values.length; i++) {
            builder.append(values[i].toString());
        }
        builder.append('"');

        return builder.toString();
    }

    /**
     * <p>
     * Helper method to write string literal.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(List<E> list) {
        if (list == null || list.isEmpty()) {
            return "null";
        }

        Class type = list.get(0).getClass();
        StringJoiner builder = new StringJoiner(", ", "new " + Imports.convert(type) + "[] {", "}");

        for (Object item : list) {
            builder.add(item.toString());
        }
        return builder.toString();
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(int[] array) {
        List<Integer> list = new ArrayList();
        for (Integer value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(float[] array) {
        List<Float> list = new ArrayList();
        for (Float value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(long[] array) {
        List<Long> list = new ArrayList();
        for (Long value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(double[] array) {
        List<Double> list = new ArrayList();
        for (Double value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(boolean[] array) {
        List<Boolean> list = new ArrayList();
        for (Boolean value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(char[] array) {
        List<Character> list = new ArrayList();
        for (Character value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write array.
     * </p>
     * 
     * @param values
     * @return
     */
    public static <E> String array(byte[] array) {
        List<Byte> list = new ArrayList();
        for (Byte value : array) {
            list.add(value);
        }
        return array(list);
    }

    /**
     * <p>
     * Helper method to write parameters.
     * </p>
     * 
     * @param params
     * @return
     */
    public static Object param(Object... params) {
        Importable importable = new Importable();

        for (Object param : params) {
            if (param instanceof Float) {
                param = param + "F";
            }
            importable.joiner.add(param.toString());
        }

        return importable;
    }

    /**
     * <p>
     * Helper method to write parameter definition.
     * </p>
     * 
     * @param params
     * @return
     */
    public static Object paramDef(Object... params) {
        Importable importable = new Importable();

        for (int i = 0; i < params.length; i++) {
            importable.joiner.add(importable.imports.convert(params[i]) + " " + params[++i]);
        }

        return importable;
    }

    /**
     * @version 2015/07/14 10:31:33
     */
    private static class Importable {

        /** The code holder. */
        private final StringJoiner joiner = new StringJoiner(", ", "(", ")");

        /** The imported class. */
        private final Imports imports = new Imports();

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return joiner.toString();
        }
    }

    /**
     * @version 2015/07/14 10:49:54
     */
    private static class Imports {

        /**
         * <p>
         * Import class.
         * </p>
         * 
         * @param clazz
         */
        private static String convert(Object value) {
            if (value instanceof Class) {
                Class clazz = (Class) value;
                String full = clazz.getName();
                String simple = clazz.getSimpleName();

                if (clazz == Integer.class) {
                    return "int";
                } else if (clazz.isPrimitive() || full.startsWith("java.lang.")) {
                    return simple;
                } else if (clazz.isArray()) {
                    return convert(clazz.getComponentType()) + "[]";
                }
                return clazz.getName();
            }
            return value.toString();
        }
    }
}
