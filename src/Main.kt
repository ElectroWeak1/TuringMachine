import java.nio.file.Path
import java.nio.file.Paths

fun main(args: Array<String>) {
    var file: Path? = null
    var input: String? = null
    var startState = "q0"
    var finalState = "qf"

    if (args.size in 4..8) {
        args.forEachIndexed { index, arg ->
            when (arg) {
                "-f" -> file = Paths.get(args[index + 1])
                "-i" -> input = args[index + 1]
                "-s" -> startState = args[index + 1]
                "-e" -> finalState = args[index + 1]
            }
        }
    } else {
        System.err.println("Not enough parameters")
        return
    }

    if (file == null) {
        System.err.println("No input rules specified")
        return
    } else if (input == null) {
        System.err.println("No input specified")
        return
    }

    val tape = Tape(input!!)
    val parser = Parser()
    val rules = parser.parseCode(file!!)

    val sim = Simulation(tape, rules, startState, finalState)

    tape.print()
    while (sim.canStep()) {
        sim.step()
        tape.print()
    }

    println(if (sim.isInFinalState()) "Input is correct" else "Cannot reach final state")
}