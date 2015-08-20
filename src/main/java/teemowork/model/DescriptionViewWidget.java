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

import java.util.List;

import js.math.Mathematics;
import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget3;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2015/08/19 12:46:26
 */
public abstract class DescriptionViewWidget<D extends Describable> extends Widget3<D, StatusCalculator, List> {

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
     * <p>
     * Specify the current version of descriptor.
     * </p>
     * 
     * @return
     */
    protected abstract Version getVersion();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure ⅼ) {
        ⅼ.nbox.ⅼ($.Passive, model3, text -> {
            if (text instanceof Variable) {
                writeVariable(ⅼ, (Variable) text, getLevel());
            } else {
                ⅼ.ⅼ(text);
            }
        });
    }

    /**
     * <p>
     * </p>
     * 
     * @param root
     * @param variable
     * @param level
     */
    private void writeVariable(VirtualStructure ⅼ, Variable variable, int level) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.getAmplifiers();

        if (!resolver.isSkillLevelBased()) {
            level = resolver.convertLevel(calculator);
        }

        // compute current value
        ⅼ.nbox.ⅼ($.ComputedValue, status.format(variable.calculate(Math.max(1, level), calculator)));

        // All values
        int size = resolver.estimateSize();
        int current = level;

        if (1 < size || !amplifiers.isEmpty()) {
            ⅼ.ⅼ("(");
            ⅼ.nbox.ⅼ(null, size, i -> {
                ⅼ.nbox.ⅼ($.Value, () -> {
                    ⅼ.style.〡($.Current, i + 1 == current);
                    ⅼ.style.〡($.Indicator, "title", resolver.getLevelDescription(i + 1));
                    ⅼ.ⅼ(Mathematics.round(resolver.compute(i + 1), 2));
                });

                if (i + 1 != size) {
                    ⅼ.nbox.ⅼ($.Separator, "/");
                }
            });

            writeAmplifier(ⅼ, amplifiers, level);
            ⅼ.ⅼ(")");
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
    private void writeAmplifier(VirtualStructure ⅼ, List<Variable> amplifiers, int level) {
        ⅼ.nbox.ⅼ(null, amplifiers, amplifier -> {
            ⅼ.nbox.ⅼ($.Amplifier, () -> {
                int amp = level;

                ⅼ.ⅼ("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    amp = resolver.convertLevel(calculator);
                }

                int size = resolver.estimateSize();
                int current = amp;

                ⅼ.nbox.ⅼ(null, size, i -> {
                    ⅼ.nbox.ⅼ($.Value, () -> {
                        ⅼ.style.〡($.Current, size != 1 && i + 1 == current);
                        ⅼ.style.〡($.Indicator, "title", resolver.getLevelDescription(i + 1));
                        ⅼ.ⅼ(Mathematics.round(amplifier.calculate(i + 1, calculator, true), 4));
                    });

                    if (i + 1 != size) {
                        ⅼ.nbox.ⅼ($.Separator, "/");
                    }
                });

                ⅼ.ⅼ(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    ⅼ.ⅼ("(");
                    writeAmplifier(ⅼ, amplifier.getAmplifiers(), current);
                    ⅼ.ⅼ(")");
                }
                ⅼ.ⅼ(amplifier.getStatus().name);
            });
        });
    }

    /**
     * @version 2015/08/20 15:59:24
     */
    private static class $ extends StyleRuleDescriptor {

        static Style ComputedValue = () -> {
            font.weight.bolder();
        };

        static Style Value = () -> {
            text.align.center();
        };

        static Style Separator = () -> {
            box.opacity(0.4);
            margin.horizontal(1, px);
        };

        static Style Current = () -> {
            font.color(rgba(160, 123, 1, 1));
        };

        static Style Passive = () -> {
            margin.right(1, em);
        };

        static Style Indicator = () -> {
            cursor.help();
        };

        static Style Amplifier = () -> {
            font.color(25, 111, 136);

            inBackOf(Value, () -> {
                margin.left(0.4, em);
            });

            // inBackOf(Amplifier, () -> {
            // margin.left(0.4, em);
            // });
        };
    }

}
