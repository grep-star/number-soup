enum Operation {

    A_PLUS_B {
        double perform(double a, double b) { a + b }
        String combine(String a, String b) { "($a + $b)"}
    },
    A_MINUS_B {
        double perform(double a, double b) { a - b }
        String combine(String a, String b) { "($a - $b)"}
    },
    B_MINUS_A {
        double perform(double a, double b) { b - a }
        String combine(String a, String b) { "($b - $a)"}
    },
    A_TIMES_B {
        double perform(double a, double b) { a * b }
        String combine(String a, String b) { "($a)*($b)"}
    },
    A_OVER_B {
        double perform(double a, double b) { a / b }
        String combine(String a, String b) { "($a)/($b)"}
    },
    B_OVER_A {
        double perform(double a, double b) { b / a }
        String combine(String a, String b) { "($b)/($a)"}
    }

    abstract double perform(double a, double b)

    abstract String combine(String a, String b)

}

