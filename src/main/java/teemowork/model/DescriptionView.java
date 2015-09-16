/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static jsx.ui.VirtualStructure.Declarables.*;

import java.util.List;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget3;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2015/08/19 12:46:26
 */
public abstract class DescriptionView<D extends Describable> extends Widget3<D, StatusCalculator, List> {

    /** The target descriptor to view. */
    protected final Describable describable = model1;

    /** The calculator. */
    protected final StatusCalculator calculator = model2;

    /**
     * <p>
     * Specify the current level of descriptor.
     * </p>
     * 
     * @return
     */
    protected abstract int getLevel();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        box($.Passive, contents(model3, text -> {
            if (text instanceof Variable) {
                writeVariable(〡, (Variable) text, getLevel());
            } else {
                con(text);
            }
        }));
    }

    /**
     * <p>
     * </p>
     * 
     * @param root
     * @param variable
     * @param level
     */
    private void writeVariable(VirtualStructure 〡, Variable variable, int level) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.getAmplifiers();

        if (!resolver.isSkillLevelBased()) {
            level = resolver.convertLevel(calculator);
        }

        // compute current value
        text($.ComputedValue, status.format(variable.calculate(Math.max(1, level), calculator)));

        // All values
        int size = resolver.estimateSize();
        int current = level;

        if (1 < size || !amplifiers.isEmpty()) {
            text("(");
            box($.Variable, contents(size, i -> {
                System.out.println(i + "   " + current);
                String description = resolver.getLevelDescription(i + 1);

                box($.Value, $.Current.when(i + 1 == current), $.Indicator.when(!description.isEmpty()), title(description), () -> {
                    text(round(resolver.compute(i + 1), 2));
                });

                if (i + 1 != size) {
                    text($.Separator, "/");
                }
            }));

            writeAmplifier(amplifiers, level, calculator);
            text(")");
        }
    }

    /**
     * <p>
     * Write skill amplifier.
     * </p>
     * 
     * @param root A element to write.
     * @param amplifiers A list of skill amplifiers.
     * @param level A current skill level.
     */
    public static void writeAmplifier(List<Variable> amplifiers, int level, StatusCalculator calculator) {
        box(contents(amplifiers, amplifier -> {
            box($.Amplifier, () -> {
                int amp = level;

                text("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    amp = resolver.convertLevel(calculator);
                }

                int size = resolver.estimateSize();
                int current = amp;

                box(contents(size, i -> {
                    String description = resolver.getLevelDescription(i + 1);

                    box($.Value, $.Current.when(size != 1 && i + 1 == current), $.Indicator
                            .when(!description.isEmpty()), title(description), () -> {
                        text(round(amplifier.calculate(i + 1, calculator, true), 4));
                    });

                    if (i + 1 != size) {
                        text($.Separator, "/");
                    }
                }));

                text(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    text("(");
                    writeAmplifier(amplifier.getAmplifiers(), current, calculator);
                    text(")");
                }
                text(amplifier.getStatus().name);
            });
        }));
    }

    /**
     * <p>
     * Returns the closest {@code long} to the argument, with ties rounding up.
     * </p>
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is 0.</li>
     * <li>If the argument is negative infinity or any value less than or equal to the value of
     * {@code Long.MIN_VALUE}, the result is equal to the value of {@code Long.MIN_VALUE}.</li>
     * <li>If the argument is positive infinity or any value greater than or equal to the value of
     * {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.</li>
     * </ul>
     * 
     * @param value A floatingpoint value to be rounded.
     * @param precision
     * @return The value of the argument rounded to the nearest {@code int} value.
     */
    private static double round(double value, int precision) {
        double factor = Math.pow(10, precision);
        return Math.round(value * factor) / factor;
    }

    /**
     * @version 2015/08/20 15:59:24
     */
    private static class $ extends StyleRuleDescriptor {

        private static Style ComputedValue = () -> {
            font.weight.bolder();
        };

        private static Style Value = () -> {
            text.align.center();
        };

        private static Style Separator = () -> {
            font.color(210, 210, 210);
            margin.horizontal(1, px);
        };

        private static Style Current = () -> {
            font.color(rgba(160, 123, 1, 1));
        };

        private static Style Passive = () -> {
            margin.right(1, em);
        };

        private static Style Indicator = () -> {
            cursor.help();
        };

        private static Style Amplifier = () -> {
            font.color(25, 111, 136);
            margin.left(0.5, em);
            box.opacity(0.8);

            // inBackOf(Amplifier, () -> {
            // margin.left(0.4, em);
            // });
        };

        private static Style Variable = () -> {
            font.color(90, 90, 90);
        };
    }

}
