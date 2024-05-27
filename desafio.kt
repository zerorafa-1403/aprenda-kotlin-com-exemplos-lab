enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String )

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String,val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} matriculado com sucesso ")
    }
}

fun main() {
    //criando conteudo educacional
    val conteudoJava = ConteudoEducacional("Programação Java", 180)
    //criando formacao
    val formacaoKotlin = Formacao("Formação Kotlin Developer", Nivel.INTERMEDIARIO, listOf(conteudoJava))
    // matriculando usuario
    val usuario2 = Usuario("Roni Ganancio")                                                                                 
    val usuario1 = Usuario("Rafael Reis");
    
    //usando a funcao matricular
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    //mostrando  conteudo educacional
    println("Conteudo educacional  nome:${conteudoJava.nome} duracao: ${conteudoJava.duracao}")
    //mostrando formacao 
    println("Formacao : ${formacaoKotlin.nome} Nivel ${formacaoKotlin.nivel}" )
    // mostrando usuarios matriculados
    println("Matriculados : ${formacaoKotlin.inscritos.joinToString { it.nome }}")

        
}