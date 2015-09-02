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
        〡.nbox.〡($.Passive, model3, text -> {
            if (text instanceof Variable) {
                writeVariable(〡, (Variable) text, getLevel());
            } else {
                〡.〡(text);
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
    private void writeVariable(VirtualStructure 〡, Variable variable, int level) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.getAmplifiers();

        if (!resolver.isSkillLevelBased()) {
            level = resolver.convertLevel(calculator);
        }

        // compute current value
        〡.nbox.〡($.ComputedValue, status.format(variable.calculate(Math.max(1, level), calculator)));

        // All values
        int size = resolver.estimateSize();
        int current = level;

        if (1 < size || !amplifiers.isEmpty()) {
            〡.〡("(");
            〡.nbox.〡(null, size, i -> {
                〡.nbox.〡($.Value, () -> {
                    〡.style.〡($.Current, i + 1 == current);
                    〡.style.〡($.Indicator, "title", resolver.getLevelDescription(i + 1));
                    〡.〡(resolver.compute(i + 1));
                });

                if (i + 1 != size) {
                    〡.nbox.〡($.Separator, "/");
                }
            });

            writeAmplifier(〡, amplifiers, level, calculator);
            〡.〡(")");
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
    public static void writeAmplifier(VirtualStructure 〡, List<Variable> amplifiers, int level, StatusCalculator calculator) {
        〡.nbox.〡(null, amplifiers, amplifier -> {
            〡.nbox.〡($.Amplifier, () -> {
                int amp = level;

                〡.〡("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    amp = resolver.convertLevel(calculator);
                }

                int size = resolver.estimateSize();
                int current = amp;

                〡.nbox.〡(null, size, i -> {
                    〡.nbox.〡($.Value, () -> {
                        〡.style.〡($.Current, size != 1 && i + 1 == current);
                        〡.style.〡($.Indicator, "title", resolver.getLevelDescription(i + 1));
                        〡.〡(amplifier.calculate(i + 1, calculator, true));
                    });

                    if (i + 1 != size) {
                        〡.nbox.〡($.Separator, "/");
                    }
                });

                〡.〡(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    〡.〡("(");
                    writeAmplifier(〡, amplifier.getAmplifiers(), current, calculator);
                    〡.〡(")");
                }
                〡.〡(amplifier.getStatus().name);
            });
        });
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
            box.opacity(0.4);
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

            inBackOf(Value, () -> {
                margin.left(0.4, em);
            });

            // inBackOf(Amplifier, () -> {
            // margin.left(0.4, em);
            // });
        };
    }

}
