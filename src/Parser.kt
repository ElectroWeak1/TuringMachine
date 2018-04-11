import java.nio.file.Files
import java.nio.file.Path

class Parser {

    fun parseCode(file: Path): Rules {
        return convertLinesToRules(Files.readAllLines(file))
    }

    fun parseCode(input: String): Rules {
        return convertLinesToRules(input.split("\n"))
    }

    private fun convertLinesToRules(lines: List<String>): Rules {
        val rules = Rules()

        lines.forEach {
            if (!it.isBlank()) {
                val regex = Regex("""\[.+?\]""")
                val result = regex.findAll(it)

                val from = result.first()
                val to = from.next()!!

                val (fromState, fromChar) = from.value.substring(1, from.value.length - 1).split(",")
                val (toState, toChar, movement) = to.value.substring(1, to.value.length - 1).split(",")

                try {
                    rules.add(Rule(fromState, fromChar.first(), toState, toChar.first(), movement.first()))
                } catch (ex: UndeterministicRuleException) {
                    System.err.println("Cannot define same rule")
                    System.exit(1)
                }
            }
        }

        return rules
    }

}