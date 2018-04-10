class Simulation(val tape: Tape, val rules: Rules) {

    private var currentState = "q0"

    fun canStep(): Boolean {
        try {
            rules.findRule(currentState, tape.getChar())
        } catch (ex: NoRuleException) {
            return false;
        }
        return currentState != "qf"
    }

    fun isInFinalState() = currentState == "qf"

    fun step() {
        val rule = rules.findRule(currentState, tape.getChar())
        currentState = rule.toState
        tape.update(rule.toChar, rule.movement)
    }

}