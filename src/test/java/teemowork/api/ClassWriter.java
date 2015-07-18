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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private final Imports imports;

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
        this.imports = new Imports(packageName);

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
                text = ((Importable) value).text(imports);
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
            StringBuilder copy = new StringBuilder(code);
            copy.insert(importPosition, imports);

            Files.write(copy, path.resolve(packageName.replace('.', '/'))
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
        // ImportableParameters importable = new ImportableParameters();
        //
        // for (Object param : params) {
        // if (param == null) {
        // param = "null";
        // } else if (param instanceof Float) {
        // param = param + "F";
        // }
        // importable.joiner.add(param.toString());
        // }

        return new ImportableParameters(params);
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
        return new ImportableParameterDefinition(params);
    }

    /**
     * <p>
     * Helper method to write generic parameter definition.
     * </p>
     * 
     * @param params
     * @return
     */
    public static Object generic(Class base, Class... params) {
        return new ImportableGeneric(base, params);
    }

    /**
     * @version 2015/07/19 4:27:34
     */
    private static abstract class Importable {

        abstract String text(Imports imports);
    }

    /**
     * @version 2015/07/14 10:31:33
     */
    private static class ImportableParameters extends Importable {

        /** The parameters. */
        private final Object[] params;

        /**
         * @param params
         */
        private ImportableParameters(Object[] params) {
            this.params = params;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String text(Imports imports) {
            StringJoiner joiner = new StringJoiner(", ", "(", ")");
            for (Object param : params) {
                joiner.add(imports.add(param));
            }
            return joiner.toString();
        }
    }

    /**
     * @version 2015/07/14 10:31:33
     */
    private static class ImportableParameterDefinition extends Importable {

        /** The parameters. */
        private final Object[] params;

        /**
         * @param params
         */
        private ImportableParameterDefinition(Object[] params) {
            this.params = params;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String text(Imports imports) {
            StringJoiner joiner = new StringJoiner(", ", "(", ")");
            for (int i = 0; i < params.length; i++) {
                joiner.add(imports.add(params[i++]) + " " + params[i]);
            }
            return joiner.toString();
        }
    }

    /**
     * @version 2015/07/19 4:18:32
     */
    private static class ImportableGeneric extends Importable {

        /** The base type. */
        private final Class base;

        /** The parameter types. */
        private final Class[] params;

        /**
         * @param base
         * @param params
         */
        private ImportableGeneric(Class base, Class... params) {
            this.base = base;
            this.params = params;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String text(Imports imports) {
            StringJoiner joiner = new StringJoiner(", ", imports.add(base) + "<", ">");
            for (Class param : params) {
                joiner.add(imports.add(param));
            }
            return joiner.toString();
        }
    }

    /**
     * @version 2015/07/14 10:49:54
     */
    private static class Imports {

        /** The package name. */
        private final String packageName;

        /** The imported classes. */
        private final Set<Class> classes = new HashSet();

        /**
         * @param packageName
         */
        private Imports(String packageName) {
            this.packageName = packageName;
        }

        /**
         * <p>
         * Import class.
         * </p>
         * 
         * @param clazz
         */
        private String add(Object value) {
            if (value instanceof Importable) {
                return ((Importable) value).text(this);
            }
            return convert2(value);
        }

        /**
         * <p>
         * Import class.
         * </p>
         * 
         * @param clazz
         */
        private String convert2(Object value) {
            if (value == null) {
                value = "null";
            }

            if (value instanceof Class) {
                Class clazz = (Class) value;
                String full = clazz.getName();
                String simple = clazz.getSimpleName();

                if (clazz == Integer.class) {
                    return "int";
                } else if (clazz.isArray()) {
                    return convert2(clazz.getComponentType()) + "[]";
                } else if (clazz.isPrimitive() || full.startsWith("java.lang.") || packageName
                        .equals(clazz.getPackage().getName())) {
                    return simple;
                }

                classes.add(clazz);

                return clazz.getSimpleName();
            }
            return value.toString();
        }

        /**
         * <p>
         * Import class.
         * </p>
         * 
         * @param clazz
         */
        private static String convert(Object value) {
            if (value == null) {
                value = "null";
            }

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

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(EOL);
            for (Class clazz : classes) {
                builder.append("import ").append(clazz.getName()).append(";").append(EOL);
            }
            return builder.toString();
        }
    }
}
