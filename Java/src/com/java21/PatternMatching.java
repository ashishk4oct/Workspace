package com.java21;

public class PatternMatching {

    public static void main(String[] args) {

    }

    public static double getPerimeterWithIf(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    public static double getPerimeterWithPatternSwitchExpression(Shape shape) throws IllegalArgumentException {
        return switch (shape) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c -> 2 * c.radius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    public static double getPerimeterWithSwitchStatement(Shape shape) throws IllegalArgumentException {
        switch (shape) {
            case Rectangle r:
                return 2 * r.length() + 2 * r.width();
            case Circle c:
                return 2 * c.radius() * Math.PI;
            default:
                throw new IllegalArgumentException("Unrecognized shape");
        }
    }


    static void typeTester(Object obj) {
        switch (obj) {
            case null -> System.out.println("null");
            case String s -> System.out.println("String");
            case Color c -> System.out.println("Color with " + c.values().length + " values");
            case Point p -> System.out.println("Record class: " + p.toString());
            case int[] ia -> System.out.println("Array of int values of length" + ia.length);
            default -> System.out.println("Something else");
        }
    }


    /**
     * @param obj
     *
     *  Pattern Label Dominance
     *  It's possible that many pattern labels could match the value of the selector expression.
     *  To help readability, the labels are tested in the order that they appear in the switch block.
     *  In addition, the compiler raises an error when a pattern label can never match because a preceding one will always match first.
     *  The following example results in a compile-time error:
     */
    static void error(Object obj) {
        switch (obj) {
            case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
//            Uncomment below 2 lines to see compile time error
//            case String s ->    // Error - pattern is dominated by previous pattern
//                    System.out.println("A string: " + s);
            default -> throw new IllegalStateException("Invalid argument");
        }
    }
    /*
    The first pattern label case CharSequence cs dominates the second pattern label case String s because every value that
    matches the pattern String s also matches the pattern CharSequence cs but not the other way around.
    It's because String is a subtype of CharSequence.

    There are two labels that match all values: the default label and a total type pattern (see Null-Matching case Labels).
    You can't have more than one of these two labels in a switch block.
    */

}

// Pattern Matching for switch Expressions and Statements
interface Shape {
}

record Rectangle(double length, double width) implements Shape {
}

record Circle(double radius) implements Shape {
}


//    Selector Expression Type
record Point(int x, int y) {
}

enum Color {RED, GREEN, BLUE;}