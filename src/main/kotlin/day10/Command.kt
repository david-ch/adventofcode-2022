package day10


interface Command

data class AddxCommand(val operand: Int) : Command

class NoopCommand : Command