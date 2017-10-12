
class Brasilia(){

    private var cambadaList = hashMapOf<Usuario, CorrupcaoI>()

    fun pegaLadrao(user: Usuario, c: CorrupcaoI){
            cambadaList.put(user, c)
    }


    fun quantitativoPorClassificacao(): String{
        var iniciante = 0
        var media = 0
        var avancado = 0
        for (ele in cambadaList){
            if (ele.value is Iniciante)
                iniciante++
            else if(ele.value is Intermediario)
                media++
            else if(ele.value is Profissional)
                avancado++
        }
        return "Iniciante: ${iniciante} - Media: ${media} - Avançada: ${avancado} "
    }

    fun quantitativoPorTipo():String{
        var ativa = 0
        var passiva = 0
        var sistematica = 0
        for (ele in cambadaList){
            if(ele.value.retornaTipo() == 1){
                ativa ++;
            }else if(ele.value.retornaTipo() == 2){
                passiva ++;
            }else if(ele.value.retornaTipo() == 3){
                sistematica ++;
            }
        }
        return "Ativa: ${ativa} - Passiva: ${passiva} - Sistematica: ${sistematica} "
    }

    fun classificaUsuario():String{
        var result = ""


        for (ele in cambadaList) {
            if (ele.value is Profissional && (ele.value.retornaTipo() == 3 || ele.value.retornaTipo() == 2)){
                result += "${ele.key} ${ele.value.descreveCorrupcao()} - Auta periculosidade \n"
            }else if ((ele.value is Profissional && ele.value.retornaTipo() == 1) || (ele.value is Intermediario) ){
                result += "${ele.key} ${ele.value.descreveCorrupcao()} - Sob Investigação \n"
            }else{
                result += "${ele.key} ${ele.value.descreveCorrupcao()} - Ladrão de chinelo\n"
            }

        }
        return result
    }
}