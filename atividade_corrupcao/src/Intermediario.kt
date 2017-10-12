open class Intermediario(var tipo: Int, var valor: Double): CorrupcaoI{
    override fun descreveCorrupcao():String {
        return  String.format("Tipo: %-15s", "${this.tipo}") +
                String.format("Valor: %-15s", "${this.valor}")
    }

    override fun retornaTipo(): Int {
        return this.tipo
    }
}
