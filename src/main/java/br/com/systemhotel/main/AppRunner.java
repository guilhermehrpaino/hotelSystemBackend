package br.com.systemhotel.main;


import br.com.systemhotel.dto.CustomerDTO;
import br.com.systemhotel.dto.UserDTO;
import br.com.systemhotel.entity.User;
import br.com.systemhotel.service.CustomerService;
import br.com.systemhotel.service.NameValidator;
import br.com.systemhotel.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppRunner implements CommandLineRunner {
    Long id;
    private final CustomerService customerService; // Classe customerService
    private final Scanner scanner = new Scanner(System.in); // Criamos o Scanner
    private final UserService userService;


    public AppRunner(CustomerService customerService, UserService userService) { // Construtor
        this.customerService = customerService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) { // irá executar o nosso menu

        menuLogin();







    }


    private void menuLogin() {
        int opcao;
        do { // estrutura de loop (mostre o menu enquanto a opção for =/= 0)
            showLogin(); // mostra o menu
            opcao = readInt("Escolha uma opção:"); // utiliza o metodo readInt para escrever a frase e ler a opcao do usuario
            switch (opcao) { // inicia um switch case das opcoes do menu
                case 1:
                    Login();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
            }

        } while (opcao != 0);
            System.exit(0); // finaliza a aplicação

    }

    private void Login() {
        int tentativas = 0;
        boolean loginValidado = false;
        System.out.println("==== LOGIN ====");
        do {
            String username = readString("Username:");
            String pwd = readString("Senha:");
            if (userService.auth(username, pwd) && userService.checkRole(username, User.RoleUsuario.ADMIN)) {
                menuAdmin();
                loginValidado = true;
            } else if (userService.auth(username,pwd)) {

                loginValidado = true;
            } else {
                tentativas++;
                System.out.println("Usuário ou senha inválidos.");
            } if (tentativas >= 3) {
                System.out.println("Limite máximo de tentativas excedido. O programa irá se encerrar!");
                System.exit(0);
            }
        } while (!loginValidado);
    }

    private void cadastrarUsuario() {
        System.out.println("==== Cadastro de Usuário =====");
        String username = readString("Username:");
        String password = readString("Senha:");
        String email = readString("Email:");
        User.RoleUsuario roleUsuario = User.RoleUsuario.USER;
        UserDTO dto = new UserDTO(id, username, password, email, roleUsuario);
        userService.register(dto);
        System.out.println("Cadastro de Usuário realizado com sucesso!");
    }

    private void showMenu() { // metodo que irá mostrar o menu principal
        System.out.println("""
        ===== SISTEMA HOTEL =====
        1 - Cadastrar cliente
        2 - Checar reserva
        3 - Checar quartos
        0 - Sair
        =========================
        """);
    }
    private void cadastrarCliente() { // método que irá mostrar pro usuario qual dado ele deve inserir

        String nome = readValidName(); // chama um metodo para verificar se foi informado um nome valido
        int idade = readInt("Idade:"); // variaveis para receber as informações atraves de readString e readInt
        String telefone = readString("Telefone:");
        String email = readString("Email:");
        String endereco = readString("Endereço:");
        String cpf = readString("CPF:");
        CustomerDTO dto = new CustomerDTO(id, nome, idade, cpf, endereco, email, telefone);

        customerService.createCustomer(dto); // chama nosso service para criar um novo cliente no banco de dados

        System.out.println("Cliente cadastrado com sucesso!!!"); // retorna o sucesso do registro
    }


    private String readString(String label) { // readString a fim de evitar bugs do scanner
        System.out.print(label + " "); // mostramos a frase
        return scanner.nextLine(); // le oque o usuario retorna
    }

    private int readInt(String label) { // readInt para evitar bugs do scanner (nextInt le os numeros mas nao consome o ENTER)
        while (true) { // cria um loop que sai apenas quando o usuario entrega um numero valido
            try {
                System.out.print(label + " "); // mostra o texto
                return Integer.parseInt(scanner.nextLine()); // recebe uma string e converte em numero
            } catch (NumberFormatException e) { // trata um erro caso o usuario digite um numero invalido ou não-numero
                System.out.println("Digite um número válido...");
            }
        }
    }
    private String readValidName() { // validar o nome
        while (true) { // enquanto o loop for verdadeiro (o nome ainda nao ter sido aceito) o programa irá ficar pedindo o nome)
            String nome = readString("Nome:"); // entrega a informação de nome pro usuario

            if (NameValidator.isValid(nome)) { // se o nome for valido retorna o nome
                return nome;
            }

            System.out.println("Nome inválido! Use apenas letras e espaços."); // avisa que tem algo errado
        }
    }
    private void showLogin() {
        System.out.println("""
        ===== LOGIN SISTEMA HOTEL =====
        1 - Login
        2 - Cadastrar usuario
        0 - Sair
        ===============================
        """);
    }

    private void menuAdmin() {
        int opcao; // variavel de opcao
        do { // estrutura de loop (mostre o menu enquanto a opção for =/= 0)
            showMenu(); // mostra o menu
            opcao = readInt("Escolha uma opção:"); // utiliza o metodo readInt para escrever a frase e ler a opcao do usuario

            switch (opcao) { // inicia um switch case das opcoes do menu
                case 1:
                    cadastrarCliente(); // chama o cadastro de cliente
                    break;
            }

        } while (opcao != 0); // enquanto a opcao for =/= 0 o programa nao encerra
        System.exit(0); // finaliza a aplicação
    }

}




