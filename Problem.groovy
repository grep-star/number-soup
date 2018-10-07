class Problem {

    List<Double> inputs
    double goal
    SolutionStep solution

    Problem(List<Integer> inputs, int goal) {
        this(inputs.collect { it as Double }, goal as Double)
    }

    private Problem(List<Double> inputs, double goal) {
        setInputs(inputs)
        setGoal(goal)
    }

    SolutionStep solve() {
        if (inputs.size() == 2) {
            final Operation operation = Operation.values().find { operation ->
                MathUtils.equals(operation.perform(inputs[0], inputs[1]), goal)
            }
            if (operation != null) {
                solution = new SolutionStep(inputs[0], inputs[1], operation, null)
            }
        } else {
            inputs.subsequences().findAll { it.size() == 2 }.findResult { pair ->
                final double number1 = pair[0]
                final double number2 = pair[1]
                final List<Double> subList = inputs.clone() as List<Double>
                subList.removeElement(number1)
                subList.removeElement(number2)
                Operation.values().findResult { operation ->
                    final Problem problem = new Problem(subList + [operation.perform(number1, number2)], goal)
                    solution = (problem.solve() != null) ? new SolutionStep(number1, number2, operation, problem) : null
                }
            }
        }
        solution
    }

}
