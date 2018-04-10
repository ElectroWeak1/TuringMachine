class Rules {

    var rules = mutableListOf<Rule>()

    fun add(rule: Rule) = rules.add(rule)

    fun findRule(state: String, char: Char): Rule {
        return rules.find { it.fromState == state && it.fromChar == char } ?: throw NoRuleException("No rule found")
    }

}