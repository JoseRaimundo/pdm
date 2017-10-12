class Iniciante (
        var desc: String
): CorrupcaoI{
    override fun descreveCorrupcao():String {
        return String.format("Descição: %-15s", "${this.desc}")
    }

    override fun retornaTipo(): Int {
        return 0
    }

}