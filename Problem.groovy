class Problem {
    private static final double TOLERANCE = 0.00000001
    List<Double> inputs
    double goal
    Solution solution

    Problem(List<Double> inputs, double goal) {
        setInputs(inputs)
        setGoal(goal)
    }

    Solution solve() {
        if (inputs.size() == 1) {
            if (Math.abs(inputs[0] - goal) < TOLERANCE) {
                return new Solution(inputs[0], null, null)
            } else {
                return null
            }
        } else {
            inputs.findResult { input ->
                Operation.values().findResult { operation ->
                    final Problem problem = new Problem(inputs - [input], operation.invert(input, goal))
                    solution = (problem.solve() != null) ? new Solution(input, operation, problem) : null
                    solution
                }
            }
        }
    }

}
