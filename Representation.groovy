class Representation {

    String asString
    double asDouble

    Representation(String asString, double asDouble) {
        setAsString(asString)
        setAsDouble(asDouble)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Representation that = (Representation) o

        Double.compare(that.asDouble, asDouble) == 0
    }

    int hashCode() {
        long temp = asDouble != +0.0d ? Double.doubleToLongBits(asDouble) : 0L
        temp ^ (temp >>> 32) as int
    }

}
