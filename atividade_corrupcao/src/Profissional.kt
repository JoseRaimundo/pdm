class Profissional(var tipo: Int, var valor:Double, var frequencia : Int): CorrupcaoI{
    override fun descreveCorrupcao():String {
        return  String.format("Tipo: %-15s", "${this.tipo}") +
                String.format("Valor: %-15s", "${this.valor}")
                String.format("Frequencia: %-15s", "${this.frequencia}")
    }

    override fun retornaTipo(): Int {
        return this.tipo
    }
}