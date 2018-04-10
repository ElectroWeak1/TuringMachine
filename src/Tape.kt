class Tape(val input: String, val startPosition: Int = 1) {

    var list = mutableListOf<Char>()
    var currentPosition = startPosition

    init {
        list.add('|')
        list.addAll(input.toCharArray().toList())
        list.add('|')
    }

    fun update(value: Char, movement: Char) {
        list[currentPosition] = value
        when (movement) {
            'R' -> {
                if (list[currentPosition + 1] == '|') {
                    list.add(currentPosition + 1, 'B')
                    currentPosition++
                } else {
                    currentPosition++
                }
            }
            'L' -> {
                if (list[currentPosition - 1] == '|') {
                    list.add(1, 'B')
                } else {
                    currentPosition--
                }
            }
            'S' -> {}
        }
    }

    fun getChar(): Char {
        return list[currentPosition]
    }

    fun print() {
        println(list + " Current: ${list[currentPosition]}($currentPosition)")
    }

}