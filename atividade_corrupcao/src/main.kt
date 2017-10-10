
import java.io.File
import java.io.InputStream


class Usuario(
        var nome : String,
        var renda : Int,
        var corrupcao : Int,
        var descricao : String,
        var frequencia : Int
):Comparable<Usuario>{
    override fun compareTo(other: Usuario): Int {
        return compareValuesBy(this, other, nullsLast<Int>().reversed(), Usuario::frequencia)
    }

    override fun toString(): String {
        return String.format("|%-15s", "${this.nome}") + String.format("|%-10s", "${this.renda}") + String.format("|%-10s", "${this.corrupcao}")  + String.format("|%-10s", "${this.frequencia}")+ String.format("|%-15s", "${this.descricao}")
    }
}

class Brasilia(){

    var iniciante   = arrayListOf<Usuario>();
    var media       = arrayListOf<Usuario>();
    var avancada    = arrayListOf<Usuario>();

    fun addUsuario(user: Usuario, nivel: Int){
        if (nivel == 1){
            iniciante.add(user)
        }else if(nivel == 2){
            media.add(user)
        }else if(nivel == 3){
            avancada.add(user)
        }
    }

    fun quantitativoPorTipo(): String{
        var ativa = 0
        var passiva = 0
        var sistematica = 0
        for (ele in media){
            if(ele.corrupcao == 1){
                ativa += 1
            }else if(ele.corrupcao == 2){
                passiva += 1
            }else if(ele.corrupcao == 3){
                sistematica += 1
            }
        }

        for (ele in avancada){
            if(ele.corrupcao == 1){
                ativa += 1
            }else if(ele.corrupcao == 2){
                passiva += 1
            }else if(ele.corrupcao == 3){
                sistematica += 1
            }
        }
        return "Ativa: ${ativa} - Passiva: ${passiva} - Sistematica: ${sistematica} "
    }

    fun quantitativoPorClassificacao(): String{
        return "Iniciante: ${iniciante.size} - Media: ${media.size} - Avançada: ${avancada.size} "
    }

    fun classificaUsuario():String{
        avancada.sort()
        media.sort()
        var output = ""
        for (ele in avancada){
            output += "${ele} \n-----------------------------------------------------\n"
        }
        for (ele in media){
            output += "${ele} \n-----------------------------------------------------\n"
        }
        for (ele in iniciante){
            output += "${ele} \n-----------------------------------------------------\n"
        }
        return output
    }


}



fun main(args: Array<String>) {
    var b = Brasilia();
    val inputStream: InputStream = File("input").inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }
    var cont = 0
    while(cont < lineList.size-1) {
        //println("Informe o nome do usuário:")
        val nome = lineList[cont++]
        //println("Informe a renda do usuário:")
        val renda = lineList[cont++].toString()
        var u = Usuario(nome, renda.toInt(), 0, "--", 1)
       // println("Informe a classificação da corrupção: (1 iniciante, 2 média, 3 avançado)")
        val tipo = lineList[cont++].toString()
        if (tipo.equals("1")) {
            //println("Informe a descrição da corrupção:")
            u.descricao = lineList[cont++].toString()
        } else if (tipo.equals("2")) {
           // println("Informe o tipo de corrupção:")
            u.corrupcao = lineList[cont++].toString().toInt()
        } else if (tipo.equals("3")) {
            //println("Informe o tipo de corrupção:")
            u.corrupcao = lineList[cont++].toString().toInt()
           // println("Informe a frequência:")
            u.frequencia = lineList[cont++].toString().toInt()
        }
        b.addUsuario(u, tipo.toInt())
    }

    println("\n------------- Quantitativo por Tipo -----------------")
    println(b.quantitativoPorTipo())
    println("\n------------- Quantitativo por Classificação --------")
    println(b.quantitativoPorClassificacao())
    println("\n------------- Tabela de Classificação ---------------")
    println("|Nome:          |Rend:     |Corrup:   |Freq:     |Desc:")
    println("-----------------------------------------------------")
    println(b.classificaUsuario())
    println("A tabela de classificação está organizada para ordenar\n" +
            "os criminosos na ordem pelos critérios: \n" +
            "Primeiro: os os crimes mais graves\n" +
            "Segundo: os criminosos que cometeram mais delitos")

}







//    var b = Brasilia();


//    while (true) {
//        println("Informe o nome do usuário:")
//        val nome = readLine().toString()
//
//        println("Informe a renda do usuário:")
//        val renda = readLine().toString()
//
//        var u = Usuario(nome, renda.toInt(), 0,"",0)
//        println("Informe a classificação da corrupção: (1 iniciante, 2 média, 3 avançado)")
//        val tipo = readLine().toString()
//        if (tipo.equals("1")){
//            println("Informe a descrição da corrupção:")
//            u.descricao = readLine().toString()
//        }else if (tipo.equals("2")){
//            println("Informe o tipo de corrupção:")
//            u.corrupcao = readLine().toString().toInt()
//        }else if (tipo.equals("3")){
//            println("Informe o tipo de corrupção:")
//            u.corrupcao = readLine().toString().toInt()
//            println("Informe a frequência:")
//            u.frequencia = readLine().toString().toInt()
//        }else if (tipo.equals("3")) {
//            break
//        }else{
//            println("Informe um valor válido ou zero para parar!")
//            continue
//        }
//        b.addUsuario(u, tipo.toInt())
//
//
//        println(u)
//    }

