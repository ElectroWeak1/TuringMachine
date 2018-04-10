class Simulation(val tape: Tape, val rules: Rules, val firstState: String = "q0", val finalState: String = "qf") {

    private var currentState = firstState

    fun canStep(): Boolean {
        try {
            rules.findRule(currentState, tape.getChar())
        } catch (ex: NoRuleException) {
            return false;
        }
        return currentState != finalState
    }

    fun isInFinalState() = currentState == finalState

    fun step() {
        val rule = rules.findRule(currentState, tape.getChar())
        currentState = rule.toState
        tape.update(rule.toChar, rule.movement)
    }

}