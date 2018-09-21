class Solution {
    double number
    Operation operation
    Problem subproblem

    Solution(double number, Operation operation, Problem subproblem) {
        setNumber(number)
        setOperation(operation)
        setSubproblem(subproblem)
    }

    String represent() {
        (subproblem.solution == null) ? operation.combine(String.valueOf(number), String.valueOf(subproblem.goal)) : operation.combine(String.valueOf(number), subproblem.solution.represent())
    }

}