open class Usuario(
        var nome : String,
        var renda : Double
){
    override fun toString(): String {
        return return String.format("Nome: %-15s", "${this.nome}") + String.format("Renda: %-10s", "${this.renda}")
    }
}