class Tape(input: String, startPosition: Int = 1) {

    companion object {
        const val TAPE_END = '|'
        const val BLANK = '#'
    }

    var list = mutableListOf<Char>()
    var currentPosition = startPosition

    init {
        list.add(TAPE_END)
        list.addAll(input.toCharArray().toList())
        list.add(TAPE_END)
    }

    fun update(value: Char, movement: Char) {
        list[currentPosition] = value
        when (movement) {
            'R' -> {
                if (list[currentPosition + 1] == TAPE_END) {
                    list.add(currentPosition + 1, BLANK)
                }
                currentPosition++
            }
            'L' -> {
                if (list[currentPosition - 1] == TAPE_END) {
                    list.add(1, BLANK)
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
        val printList = list.toMutableList()
        printList.removeAt(0)
        printList.removeAt(printList.size - 1)
        val pos = Math.max(0, currentPosition - 2)

        println("$printList, Current: ${printList[pos]}($pos)")
    }

}