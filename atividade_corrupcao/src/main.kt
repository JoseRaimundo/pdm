import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    var b = Brasilia();
    val inputStream: InputStream = File("input").inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
    var cont = 0
    while(cont < lineList.size-1) {

        var u = Usuario(lineList[cont++].toString(), lineList[cont++].toString().toDouble())
        val tipo = lineList[cont++].toString()
        if (tipo.equals("1")) {
            var c = Iniciante(lineList[cont++].toString())
            b.pegaLadrao(u, c)
        } else if (tipo.equals("2")) {
            var c = Intermediario(  lineList[cont++].toString().toInt(),
                                    lineList[cont++].toString().toDouble())
            b.pegaLadrao(u, c)
        } else if (tipo.equals("3")) {
            var c = Profissional(   lineList[cont++].toString().toInt(),
                                    lineList[cont++].toString().toDouble(),
                                    lineList[cont++].toString().toInt())
            b.pegaLadrao(u, c)
        }
    }

    println("\n------------- Quantitativo por Tipo -----------------")
    println(b.quantitativoPorTipo())
    println("\n------------- Quantitativo por Classificação --------")
    println(b.quantitativoPorClassificacao())
    println("\n------------- Tabela de Classificação ---------------")
    println(b.classificaUsuario())


}