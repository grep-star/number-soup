enum Operation {

    A_PLUS_B {
        double invert(double a, double c) { c - a }
        String combine(String a, String b) { "$a + $b"}
    },
    A_MINUS_B {
        double invert(double a, double c) { a - c }
        String combine(String a, String b) { "$a - $b"}
    },
    B_MINUS_A {
        double invert(double a, double c) { a + c }
        String combine(String a, String b) { "$b - $a"}
    },
    A_TIMES_B {
        double invert(double a, double c) { c / a }
        String combine(String a, String b) { "$a * ($b)"}
    },
    A_OVER_B {
        double invert(double a, double c) { a / c }
        String combine(String a, String b) { "($a)/($b)"}
    },
    B_OVER_A {
        double invert(double a, double c) { a * c }
        String combine(String a, String b) { "($b)/($a)"}
    }

    abstract double invert(double a, double c)

    abstract String combine(String a, String b)

}

