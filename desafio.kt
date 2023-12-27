import java.util.Scanner

class Usuario {
    var nome: String = ""
    var email: String = ""
    var senha: String = ""

    fun cadastro() {
        val scanner = Scanner(System.`in`)

        var nomeValido = false

        while (!nomeValido) {
            println("Por favor, insira o seu nome completo: ")
            this.nome = scanner.nextLine()

            if (!isValidName(this.nome)) {
                println("Erro: Nome inválido.")
            } else {
                nomeValido = true
            }
        }


        var emailValido = false

        while (!emailValido) {
            println("Por favor, insira o seu email: ")
            this.email = scanner.nextLine()

            if (!isValidEmail(this.email)) {
                println("Erro: Email inválido.")
            } else {
                emailValido = true
            }
        }

        var senhaValida = false

        while (!senhaValida) {
            println("Por favor, insira a sua senha: ")
            this.senha = scanner.nextLine()

            println("Por favor, repita a sua senha: ")
            val senhaRepetida = scanner.nextLine()

            if (this.senha != senhaRepetida) {
                println("Erro: Senhas diferentes.")
            } else if (!isValidPassword(this.senha)) {
                println("Erro: Senha inválida. A senha deve conter pelo menos um dígito, uma letra minúscula, uma letra maiúscula, um caractere especial e ter pelo menos 8 caracteres.")
            } else {
                senhaValida = true
            }
        }

        if (this.nome.isNotEmpty() && this.email.isNotEmpty() && this.senha.isNotEmpty()) {
            println("################################################################################# ")
            println("############### $nome, Seja Bem-Vindo a familia X cursos! ############# ")
            println("################################################################################# ")
            println("############### Aqui começa a sua jornada no mundo da programação. ############## ")
            println("################################################################################# ")
            println("##### Inscreva-se em um de nossos cursos e conquiste a sua primeira vaga!! ###### ")
            println("################################################################################# ")
            menu()
        } else {
            println("Erro: Nome, email ou senha não fornecidos.")
        }
    }

    private fun isValidName(name: String): Boolean {
        val nameRegex = "^[A-Z][a-z]*((\\s[A-Z][a-z]*)+)?$".toRegex()
        return nameRegex.matches(name)
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex()
        return emailRegex.matches(email)
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+\$).{8,}".toRegex()
        return passwordRegex.matches(password)
    }
    fun menu() {
        val scanner = Scanner(System.`in`)
        println("Escolha uma opção: ")
        println("[1] Continuar")
        println("[2] Sair")
        val opcao = scanner.nextLine()

        when (opcao) {
            "1" -> {
                println("Você escolheu continuar.")
            }
            "2" -> {
                println("Você escolheu sair. Por favor, faça o login novamente para continuar.")
                login()
            }
            else -> {
                println("Opção inválida. Por favor, escolha entre [1] Continuar e [2] Sair.")
                menu()

            }
        }
    }

    fun login() {
        val scanner = Scanner(System.`in`)
        println("Por favor, insira o seu email: ")
        val emailEntrada = scanner.nextLine()
        println("Por favor, insira a sua senha: ")
        val senhaEntrada = scanner.nextLine()

        if (emailEntrada == this.email && senhaEntrada == this.senha) {
            println("Olá, $nome! Seja bem-vindo a X cursos!")
        } else {
            println("Erro: Email ou senha incorretos.")
        }
    }
}


private fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex()
    return emailRegex.matches(email)
}

private fun isValidPassword(password: String): Boolean {
    val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+\$).{8,}".toRegex()
    return passwordRegex.matches(password)
}

data class ConteudoEducacional(var nome: String)

data class Formacao(val nome: String, var duracao: Int, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)

    }
}

class Cursos(val formacao: Formacao) {
    fun matricular(usuario: Usuario) {
        formacao.matricular(usuario)

    }

    fun exibirInformacoes() {
        println("Formação: ${formacao.nome}")
        println("Duração total do curso: ${formacao.duracao} horas")
        println("Conteúdo da formação:")
        formacao.conteudos.forEach { conteudo ->
            println("- ${conteudo.nome}")
        }
    }
}

fun main() {
    val usuario = Usuario()
    usuario.cadastro()

    val formacaoKotlin = Formacao(
        nome = "Desenvolvimento back-end com kotlin",
        duracao = 46,
        conteudos = listOf(
            ConteudoEducacional(nome = "Princípios de agilidade e desenvolvimento colaborativo"),
            ConteudoEducacional(nome = "Aprendendo kotlin na prática em sua documentação oficial"),
            ConteudoEducacional(nome = "Praticando sua lógica de programação com kotlin"),
            ConteudoEducacional(nome = "Explorando padrões de projeto em kotlin"),
            ConteudoEducacional(nome = "Entendendo Banco de dados SQL e NoSQL"),
            ConteudoEducacional(nome = "Kotlin no Back-end com spring boot 3")
        )
    )

    val formacaoPython = Formacao(
        nome = "Formação python developer",
        duracao = 64,
        conteudos = listOf(
            ConteudoEducacional(nome = "Fundamentos de python"),
            ConteudoEducacional(nome = "Aprendendo estrutura de dados com python"),
            ConteudoEducacional(nome = "Programação orientada a objetos(POO) com python"),
            ConteudoEducacional(nome = "Integração com python e frameworks"),
            ConteudoEducacional(nome = "Tratamento de Dados com python"),
            ConteudoEducacional(nome = "Praticando com projetos reais em python")
        )
    )

    val formacaoLogica = Formacao(
        nome = "Formação logica de programação",
        duracao = 42,
        conteudos = listOf(
            ConteudoEducacional(nome = "Bem-vindo a sua jornada de lógica de programação"),
            ConteudoEducacional(nome = "Introdução a lógica de programação"),
            ConteudoEducacional(nome = "Explorando operadores"),
            ConteudoEducacional(nome = "Dominando estruturas de controle"),
            ConteudoEducacional(nome = "Trabalhando com funções"),
            ConteudoEducacional(nome = "Refinando sua técnica com desafios de códigos básicos em lógica"),
            ConteudoEducacional(nome = "Estruturas de dados e objetos")
        )
    )

    val opcoes = listOf("Python", "Kotlin", "Lógica de programação")
    var formacao: Formacao

    do {
        println("Escolha um curso para começar a estudar: ")
        println("Ou escolha a opção [0] para sair.")
        println("""
########## Formações ######################
###########################################
########## [1] ${opcoes[0]} #####################        
########## [2] ${opcoes[1]} #####################       
########## [3] ${opcoes[2]} ######       
########## [0] Sair => ####################       
###########################################                                
###########################################
    """
        )

        val opcao = readLine()!!

        if (opcao == "0") break

         formacao = when (opcao) {
            "1" -> formacaoPython
            "2" -> formacaoKotlin
            "3" -> formacaoLogica
            else -> {
                println("Escolha inválida.")
                continue

            }
        }

        formacao.let {
            it.matricular(usuario)
            println("Parabens!! voce acaba de se matricular no curso ${it.nome}!")
            Cursos(it).exibirInformacoes()
        
        }
    } while (true)
}

