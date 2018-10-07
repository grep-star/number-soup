class SolutionStep {

    double firstNumber
    double secondNumber
    Operation operation
    Problem subproblem

    SolutionStep(double firstNumber, double secondNumber, Operation operation, Problem subproblem) {
        setFirstNumber(firstNumber)
        setSecondNumber(secondNumber)
        setOperation(operation)
        setSubproblem(subproblem)
    }

    String represent() {
        final double step = operation.perform(firstNumber, secondNumber)
        final List<Double> subproblemInputs = subproblem.inputs.clone() as List<Double>
        subproblemInputs.removeElement(step)
        final List<Representation> representations = subproblemInputs.collect { input ->
            new Representation(String.valueOf(input as int), input)
        } + [new Representation("${operation.combine(String.valueOf(firstNumber as int), String.valueOf(secondNumber as int))}", step)]
        subproblem.solution.merge(representations)
    }

    private String merge(List<Representation> representations) {
        if (representations.size() <= 2) {
            final Representation representation1 = findRepresentation(representations, subproblem.inputs[0])
            final Representation representation2 = findRepresentation(representations, subproblem.inputs[1])
            subproblem.solution.operation.combine(representation1.asString, representation2.asString)
        } else {
            final Representation representation1 = findRepresentation(representations, firstNumber)
            final Representation representation2 = findRepresentation(representations, secondNumber)
            representations.removeElement(representation1)
            representations.removeElement(representation2)
            merge(representations + [new Representation(operation.combine(representation1.asString, representation2.asString),
                    operation.perform(representation1.asDouble, representation2.asDouble))])
        }
    }

    private Representation findRepresentation(List<Representation> representations, double value) {
        representations.find { representation ->
            MathUtils.equals(representation.asDouble, value)
        }
    }

}