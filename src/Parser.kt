class Parser {

    fun parseCode(input: String): Rules {
        val rules = Rules()
        val regex = Regex("""\[.+?\]""")

        input.splitToSequence("\n").forEach {
            val result = regex.findAll(it)

            val from = result.first()
            val to = from.next()!!

            val (fromState, fromChar) = from.value.substring(1, from.value.length - 1).split(",")
            val (toState, toChar, movement) = to.value.substring(1, to.value.length - 1).split(",")

            rules.add(Rule(fromState, fromChar.first(), toState, toChar.first(), movement.first()))
        }

        return rules
    }

}