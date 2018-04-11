class Rules {

    var rules = mutableListOf<Rule>()

    fun add(rule: Rule) {
        if (rules.find { it.fromChar == rule.fromChar && it.fromState == rule.fromState } != null) {
            throw UndeterministicRuleException("Cannot define same rule")
        }
        rules.add(rule)
    }

    fun findRule(state: String, char: Char): Rule {
        return rules.find { it.fromState == state && it.fromChar == char } ?: throw NoRuleException("No rule found")
    }

}