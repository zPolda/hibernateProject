package com.lucas;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import java.text.ParseException;

import com.lucas.dao.ConsultaDAO;
import com.lucas.dao.EnderecoDAO;
import com.lucas.dao.EspecialidadeDAO;
import com.lucas.dao.HospitalDAO;
import com.lucas.dao.MedicoDAO;
import com.lucas.dao.UsuarioDAO;
import com.lucas.modelos.Administrador;
import com.lucas.modelos.Consulta;
import com.lucas.modelos.Endereco;
import com.lucas.modelos.Especialidade;
import com.lucas.modelos.Hospital;
import com.lucas.modelos.Medico;
import com.lucas.modelos.Paciente;
import com.lucas.modelos.Usuario;

public class App{
        static Scanner leitor = new Scanner(System.in);
        static ConsultaDAO consultaDAO = new ConsultaDAO();
        static EnderecoDAO enderecoDAO = new EnderecoDAO();
        static EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        static HospitalDAO hospitalDAO = new HospitalDAO();
        static MedicoDAO medicoDAO = new MedicoDAO();
        static UsuarioDAO usuarioDAO = new UsuarioDAO();
    public static void main( String[] args ){
        /* Administrador admin = new Administrador("Lucas", "23", "000.000.000-00", "admin", "admin", true);
        usuarioDAO.salvarUsuario(admin);*/
        menuUsuario();
    }
    public static void menuUsuario() {
        int op = 0;

            do{

            System.out.println("Escolha uma opção em:\n"+

            "1 - Logar\n"+

            "2 - Cadastrar\n"+

            "0 - Finalizar programa\n");

            op = Integer.parseInt(leitor.nextLine());



            switch (op){

                case 1:
                    login();
                break;



                case 2:
                    cadastrarPaciente();
                break;



                default:
                    System.out.println("Opcao Nao existe!!!!");
                break;
            
            }
        }while(op != 0);
    }

    public static void login() {
        System.out.println("Login Page");
        System.out.println("Digite seu username: ");
        String username = leitor.nextLine();

        ArrayList<Usuario> user = (ArrayList<Usuario>) usuarioDAO.buscarTodosUsuarios();

            for (Usuario usuario : user) {
            if(usuario.getUsername().equals(username)){
                System.out.println("Digite sua senha: ");
                String senha = leitor.nextLine();
                String senhaArmazenada = usuario.getSenha();
                if((BCrypt.checkpw(senha, senhaArmazenada))){
                    boolean privilegio = usuario.isPrivilegio();
                    interfaceUser(privilegio, username);
                }else{
                    System.out.println("Senha Incorreta");
                    return;
                }
            }
        }
    }
    public static void interfaceUser(boolean privilegio, String username) {
        if (privilegio){
            int op = 0;

            do{

            System.out.println("Escolha uma opção em:\n"+

            "1 - Paciente\n"+

            "2 - Administrador\n"+

            "3 - Especialidade\n"+

            "4 - Hospital\n"+

            "5 - Medico \n"+

            "6 - Endereco\n"+

            "0 - Finalizar programa\n");



            op = Integer.parseInt(leitor.nextLine());



            switch (op){

                case 1:
                    crudPaciente();
                break;



                case 2:
                    crudAdministrador();
                break;



                case 3:
                    crudEspecialidade();
                break;



                case 4:
                    crudHospital();
                break;



                case 5:
                    crudMedico();
                break;


                case 6:
                    crudEndereco();
                break;

                case 0:

                return;



                default:
                    System.out.println("Opcao incorreta!!!");
                break;

            }

            }while(op != 0);
        }else{
            int op = 0;

            do{

            System.out.println("Escolha uma opção em:\n"+

            "1 - Agendar Consulta\n"+

            "2 - Mudar data Consulta\n"+

            "3 - Mudar Endereco\n"+

            "0 - Finalizar programa\n");



            op = Integer.parseInt(leitor.nextLine());



            switch (op){

                case 1:
                    agendarConsulta(username);
                break;



                case 2:
                    recebeUsuario(username);
                break;



                case 3:
                    mudarEndereco(username);
                break;



                case 0:

                return;



                default:
                    System.out.println("Opcao incorreta!!!");
                break;

            }



            }while(op != 0);
            
        }
    }
    public static void crudPaciente() {
        int op = 0;

        do{

        System.out.println("Escolha uma opção:\n"+

        "1 - Cadastrar Paciente\n"+

        "2 - Excluir Paciente\n"+

        "3 - Editar Paciente\n"+

        "4 - Mostrar Pacientes\n"+

        "0 - Voltar a Menu Principal\n");



        op = Integer.parseInt(leitor.nextLine());



        switch (op){

            case 1:
            cadastrarPaciente();

            break;



            case 2:
            excluirPaciente();

            break;



            case 3:
            editarPaciente();

            break;



            case 4:
            mostrarPacientes();

            break;


            case 0:

            break;



            default:
                System.out.println("Opcao incorreta!!!");
            break;



        

        }
        }while(op != 0);
    }
    public static void crudAdministrador() {
        int op = 0;

        do{

        System.out.println("Escolha uma opção:\n"+

        "1 - Cadastrar Administrador\n"+

        "2 - Excluir Administrador\n"+

        "3 - Editar Administrador\n"+

        "4 - Mostrar Administradores\n"+

        "0 - Finalizar programa\n");



        op = Integer.parseInt(leitor.nextLine());



        switch (op){

            case 1:
            cadastrarAdministrador();

            break;



            case 2:
            excluirAdministrador();

            break;



            case 3:
            editarAdministrador();

            break;



            case 4:
            mostrarAdministradores();

            break;


            case 0:

            break;



            default:

        

        }



        }while(op != 0);
    }
    public static void crudEspecialidade() {
        int op = 0;

        do{

        System.out.println("Escolha uma opção:\n"+

        "1 - Cadastrar Especialidade\n"+

        "2 - Excluir Especialidade\n"+

        "3 - Editar Especialidade\n"+

        "4 - Mostrar Especialidades\n"+     

        "0 - Finalizar programa\n");



        op = Integer.parseInt(leitor.nextLine());



        switch (op){

            case 1:
            cadastrarEspecialidade();

            break;



            case 2:
            excluirEspecialidade();

            break;



            case 3:
            editarEspecialidade();

            break;



            case 4:
            mostrarEspecialidades();

            break;


            case 0:

            break;



            default:

        

        }



        }while(op != 0);
    }
    public static void crudHospital() {
        int op = 0;

        do{

        System.out.println("Escolha uma opção:\n"+

        "1 - Cadastrar Hospital\n"+

        "2 - Excluir Hospital\n"+

        "3 - Editar Hospital\n"+

        "4 - Mostrar Hospitais\n"+

        "0 - Finalizar programa\n");



        op = Integer.parseInt(leitor.nextLine());



        switch (op){

            case 1:
            cadastrarHospital();

            break;



            case 2:
            excluirHospital();

            break;



            case 3:
            editarHospital();

            break;



            case 4:
            mostrarHospitais();

            break;

            case 0:

            break;



            default:

        

        }



        }while(op != 0);
    }
    public static void crudMedico() {
        int op = 0;

        do{

        System.out.println("Escolha uma opção:\n"+

        "1 - Cadastrar Medico\n"+

        "2 - Excluir Medico\n"+

        "3 - Editar Medico\n"+

        "4 - Mostrar Medicos\n"+

        "5 - Adicionar Especialidade\n"+

        "0 - Finalizar programa\n");



        op = Integer.parseInt(leitor.nextLine());



        switch (op){

            case 1:
            cadastrarMedico();

            break;



            case 2:
            excluirMedico();

            break;



            case 3:
            editarMedico();

            break;



            case 4:
            mostrarMedicos();

            break;


            case 5:
            adicionarEspecialidade();
            
            break;

            case 0:

            break;



            default:

        

        }



        }while(op != 0);
    }
    public static void crudEndereco() {
        int op = 0;

        do{

        System.out.println("Escolha uma opção:\n"+

        "1 - Mostrar Enderecos\n"+

        "0 - Finalizar programa\n");



        op = Integer.parseInt(leitor.nextLine());



        switch (op){

            case 1:
                mostrarEnderecos();

            break;



            case 0:

            break;



            default:
                System.out.println("Opcao invalida");
            break;

        }



        }while(op != 0);
    }

    // Bloco de Funcoes

    public static void cadastrarPaciente(){
        boolean validadorUsername = true;
        boolean validacao = false;
        System.out.println("Cadastro de Paciente");
        String nomePaciente = null, idade = null, cpf = null, username = null, senha = null, peso = null, altura = null, senhaCriptografada = null;
        Endereco endereco = null;
        do{
            System.out.println("Nome: ");
            nomePaciente = leitor.nextLine();
            if(validador(nomePaciente)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }
        }while(!validacao);
        do{
            System.out.println("Idade: ");
            idade = leitor.nextLine();
            if(validador(idade)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }
        }while(!validacao);
        do{
            System.out.println("CPF: ");
            cpf = leitor.nextLine();
            if(validador(cpf)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }
        }while(!validacao);
        do {
            System.out.println("Username: ");
            username = leitor.nextLine();
            if (validador(username)) {
                validacao = true;
            } else {
                System.out.println("Erro. Digite Algo");
            }

            if (usuarioDAO.validarUsername(username)) {
                validadorUsername = true;
                System.out.println("Já existe esse nome de usuário");
            }else{
                validadorUsername = false;
            }
        } while (!validacao || validadorUsername);

        do{
            System.out.println("Senha: ");
            senha = leitor.nextLine();
            if(validador(senha)){
                validacao = true;
                senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());
            }else{
                System.out.println("Erro. Digite Algo");
            }
        }while(!validacao);
        do{
            System.out.println("Peso[Exemplo: 89.5]Kg: ");
            peso = leitor.nextLine();
            if(validador(peso)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }
        }while(!validacao);
        do{
            System.out.println("Altura[Exemplo: 189]cm");
            altura = leitor.nextLine();
            if(validador(altura)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

        }while(!validacao);

        if(username != null){
            endereco = cadastrarEndereco(username);
        }else{
            System.out.println("Erro. Username nulo");
            return;
        }

        boolean privilegio = false;

        Paciente p = new Paciente(nomePaciente, idade, cpf, username, senha, privilegio, peso, altura, endereco);

        p.setSenha(senhaCriptografada);
        

        usuarioDAO.salvarUsuario(p);
        System.out.println("Paciente criado com sucesso!");
    }
    public static void excluirPaciente() {
        ArrayList<Usuario> paciente = (ArrayList<Usuario>) usuarioDAO.buscarTodosPacientes();

        if(paciente.size() > 0){
            for (Usuario usuario : paciente) {
                System.out.println("------------------------------");
                System.out.println("ID:" + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Username: " + usuario.getUsername());
                System.out.println("--------------------------------");
            
            }
            System.out.println("Digite o ID do usuario que sera excluido: ");
            Long idSelecionado= Long.parseLong(leitor.nextLine());

            Usuario usuarioRemover = usuarioDAO.buscarUsuarioPorId(idSelecionado);
            usuarioDAO.excluirPessoa(usuarioRemover);
            System.out.println("Usuario excluido com sucesso");
            try{
                for(Usuario usuario : paciente) {
                    String imutableUser = usuarioRemover.getUsername();
                    excluirEnderecoNomeUser(imutableUser);
                }
            }catch(Exception e){

            }
        }else{
            System.out.println("Nennhum paciente cadastrado. Cadastre um paciente para mostrar excluir o mesmo");
            return;
        }
    }
    public static void editarPaciente() {
        ArrayList<Usuario> paciente = (ArrayList<Usuario>) usuarioDAO.buscarTodosPacientes();

        if(paciente.size()> 0){
            System.out.println("Digite o Username do usuario que sera editado: ");
            String userNome = leitor.nextLine();

            for (Usuario usuario : paciente) {
                if(userNome.equals(usuario.getUsername())){
                    String imutableUsername = usuario.getUsername();
                    int op = 0;
                    System.out.println("Escolha uma opção para alterar:\n"+

                    "1 - Nome\n"+

                    "2 - Idade\n"+

                    "3 - CPF\n"+

                    "4 - UserName\n"+ 

                    "5 - Senha\n");



                    op = Integer.parseInt(leitor.nextLine());



                    switch (op){

                        case 1:
                            System.out.println("Digite um nome novo: ");
                            String nomeNovo = leitor.nextLine();
                            usuario.setNome(nomeNovo);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;



                        case 2:
                            System.out.println("Digite a nova Idade: ");
                            String idadeNova = leitor.nextLine();
                            usuario.setIdade(idadeNova);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;



                        case 3:
                            System.out.println("Digite o novo CPF: ");
                            String cpfNovo = leitor.nextLine();
                            usuario.setCpf(cpfNovo);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;



                        case 4:
                            System.out.println("Digite o novo UserName: ");
                            String userNameNovo = leitor.nextLine();
                            usuario.setUsername(userNameNovo);
                            usuarioDAO.atualizarPessoa(usuario);
                            editarEndercoNomeUser(userNameNovo, imutableUsername);

                        break;


                        case 5:
                            System.out.println("Digite uma nova Senha: ");
                            String senhaNova = leitor.nextLine();
                            usuario.setSenha(senhaNova);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;


                        default:
                            System.out.println("Opcao incorreta");
                            return;
                    }
                }
            }
        }else{
            System.out.println("Nennhum paciente cadastrado. Cadastre um paciente para mostrar modificar o mesmo");
            return;
        }
    }
    public static void mostrarPacientes() {
        ArrayList<Usuario> paciente = (ArrayList<Usuario>) usuarioDAO.buscarTodosPacientes();
        if(paciente.size() > 0){
            for (Usuario usuario : paciente) {
                System.out.println("------------------------------");
                System.out.println("ID:" + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Idade: " + usuario.getIdade());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.println("Username: " + usuario.getUsername());
                System.out.println("Senha: " + usuario.getSenha());
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Nennhum paciente cadastrado. Cadastre um paciente para mostrar os pacientes");
            return;
        }
        
    }

    /* Bloco de crud administrador */
    public static void cadastrarAdministrador(){
        boolean validadorUsername = false;
        boolean validacao = false;

        System.out.println("Cadastro de Administrador: \n");
        String nomeAdmin = null, idade = null, cpf = null, username = null, senha = null, senhaCriptografada = null;

        do{
            System.out.println("Nome: ");
            nomeAdmin = leitor.nextLine();
            if(validador(nomeAdmin)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

        }while(validacao);
        do{
            System.out.println("Idade: ");
            idade = leitor.nextLine();
            if(validador(idade)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

        }while(validacao);
        do{
            System.out.println("CPF: ");
            cpf = leitor.nextLine();
            if(validador(cpf)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

        }while(validacao);
        do{
            System.out.println("Username: ");
            username = leitor.nextLine();
            if(validador(username)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

            if(validadorUsername(username)){
                validadorUsername = true;
            }else{
                System.out.println("Ja existe esse nome de usuario");
            }

        }while(!validacao || !validadorUsername);
        do{
            System.out.println("Senha: ");
            senha = leitor.nextLine();
            if(validador(senha)){
                validacao = true;
                senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());
            }else{
                System.out.println("Erro. Digite Algo");
            }
        }while(!validacao);

        boolean privilegio = true;

        Administrador adm = new Administrador(nomeAdmin, idade, cpf, username, senha, privilegio);

        adm.setSenha(senhaCriptografada);

        usuarioDAO.salvarUsuario(adm);

        System.out.println("Administrador criado com sucesso");
    }
    public static void excluirAdministrador() {
        ArrayList<Usuario> admininistradores = (ArrayList<Usuario>) usuarioDAO.buscarTodosAdministradores();

        if(admininistradores.size() > 0){
            for (Usuario usuario : admininistradores) {
                System.out.println("------------------------------");
                System.out.println("ID:" + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Username: " + usuario.getUsername());
                System.out.println("--------------------------------");
            
            }
            System.out.println("Digite o ID do usuario que sera excluido: ");
            Long idSelecionado = Long.parseLong(leitor.nextLine());
            Usuario usuarioRemover = usuarioDAO.buscarUsuarioPorId(idSelecionado);
            usuarioDAO.excluirPessoa(usuarioRemover);
        }else{
            System.out.println("Nunhum administrador cadastrado no momento. Cadastre um administrador para excluir o mesmo");
            return;
        }
    }
    public static void editarAdministrador() {
        ArrayList<Usuario> adm = (ArrayList<Usuario>) usuarioDAO.buscarTodosAdministradores();

        if(adm.size() > 0){
            System.out.println("Digite o Username do usuario que sera editado: ");
            String userNome = leitor.nextLine();

            for (Usuario usuario : adm) {
                if(userNome.equals(usuario.getUsername())){
                    int op = 0;
                    System.out.println("Escolha uma opção para alterar:\n"+

                    "1 - Nome\n"+

                    "2 - Idade\n"+

                    "3 - CPF\n"+

                    "4 - UserName\n"+ 

                    "5 - Senha\n"+

                    "6 - Privilegio\n");



                    op = Integer.parseInt(leitor.nextLine());



                    switch (op){

                        case 1:
                            System.out.println("Digite um nome novo: ");
                            String nomeNovo = leitor.nextLine();
                            usuario.setNome(nomeNovo);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;



                        case 2:
                            System.out.println("Digite a nova Idade: ");
                            String idadeNova = leitor.nextLine();
                            usuario.setIdade(idadeNova);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;



                        case 3:
                            System.out.println("Digite o novo CPF: ");
                            String cpfNovo = leitor.nextLine();
                            usuario.setCpf(cpfNovo);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;



                        case 4:
                            System.out.println("Digite o novo UserName: ");
                            String userNameNovo = leitor.nextLine();
                            usuario.setUsername(userNameNovo);
                            usuarioDAO.atualizarPessoa(usuario);

                        break;


                        case 5:
                            System.out.println("Digite uma nova Senha: ");
                            String senhaNova = leitor.nextLine();
                            usuario.setSenha(senhaNova);
                            usuarioDAO.atualizarPessoa(usuario);
                        break;


                        case 6:
                            boolean stat = false;
                            usuario.setPrivilegio(stat);
                        break;


                        default:
                            System.out.println("Opcao incorreta");
                        return;
                    }
                }
            }
        }else{
            System.out.println("Nunhum administrador cadastrado no momento. Cadastre um administrador para editar o mesmo");
            return;
        }
    }
    public static void mostrarAdministradores() {
        ArrayList<Usuario> adm = (ArrayList<Usuario>) usuarioDAO.buscarTodosAdministradores();
        if(adm.size() > 0){
            for (Usuario usuario : adm) {
                System.out.println("------------------------------");
                System.out.println("ID:" + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Username: " + usuario.getUsername());
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Nunhum administrador cadastrado no momento. Cadastre um administrador para mostar os adminiistradores");
            return;
        }
        
    }

    /* Bloco de crud especialidade */
    public static void cadastrarEspecialidade() {
        boolean validacaoEspecialidade = false;
        boolean validacao = false;
        String nome = null, codigo = null;
        do{
            System.out.println("Digite nome da especialidade: ");
            nome = leitor.nextLine();

            if(validador(nome)){
                validacao = true;  
            }else{
                System.out.println("Erro. Digite Algo");
            }
            if(validadorEspecialidadeNome(nome)){
                validacaoEspecialidade = true;
            }else{
                System.out.println("Erro. Especialidade ja criada");
            }
        }while(!validacao || !validacaoEspecialidade);
        do{
            System.out.println("Codigo");
            codigo = leitor.nextLine();

            if(validador(codigo)){
                validacao = true;  
            }
        }while(!validacao);

        Especialidade e = new Especialidade(nome, codigo);
        especialidadeDAO.salvarEspecialidade(e);

        System.out.println("Especialidade Salva com sucesso");
    }
    public static void excluirEspecialidade() {
        ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) especialidadeDAO.buscarTodasEspecialidades();
        if(especialidades.size() > 0){
            for (Especialidade especialidade : especialidades) {
                System.out.println("------------------------------");
                System.out.println("ID:" + especialidade.getId());
                System.out.println("Nome: " + especialidade.getNome());
                System.out.println("Codigo: " + especialidade.getCodigo());
                System.out.println("--------------------------------");
            }
            System.out.println("Digite o ID da Especialidade que sera excluida: ");
            Long idSelecionado= Long.parseLong(leitor.nextLine());

            Especialidade especialidadeRemover = especialidadeDAO.buscarEspecialidadePorId(idSelecionado);
            especialidadeDAO.excluirEspecialidade(especialidadeRemover);
            System.out.println("Especialidade removida com sucesso");
        }else{
            System.out.println("Nenhuma especialidade cadastrada no momento. Cadastre uma especialidade primeiro para excluir a mesma");
            return;
        }
    }
    public static void editarEspecialidade() {
        ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) especialidadeDAO.buscarTodasEspecialidades();
        if(especialidades.size() > 0){
            System.out.println("Digite o Nome da Especialidade que sera editado: ");
            String especialidadeName = leitor.nextLine();


            for (Especialidade especialidade : especialidades) {
                if(especialidadeName.equals(especialidade.getNome())){
                    int op = 0;
                    System.out.println("Escolha uma opção para alterar:\n"+

                    "1 - Nome\n"+

                    "2 - Codigo\n");



                    op = Integer.parseInt(leitor.nextLine());



                    switch (op){

                        case 1:
                            System.out.println("Digite um nome novo: ");
                            String nomeNovo = leitor.nextLine();
                            especialidade.setNome(nomeNovo);
                            especialidadeDAO.atualizarEspecialidade(especialidade);
                        break;



                        case 2:
                            System.out.println("Digite um novo Codgo: ");
                            String codgoNovo = leitor.nextLine();
                            especialidade.setCodigo(codgoNovo);
                            especialidadeDAO.atualizarEspecialidade(especialidade);
                        break;


                        default:
                            System.out.println("Opcao incorreta");
                            return;
                    }
                }
            }
        }else{
            System.out.println("Nenhuma especialidade cadastrada no momento. Cadastre uma especialidade primeiro para editar a mesma");
            return;
        }
    }
    public static void mostrarEspecialidades() {
        ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) especialidadeDAO.buscarTodasEspecialidades();
        if(especialidades.size()> 0){
            for (Especialidade especialidade : especialidades) {
                System.out.println("------------------------------");
                System.out.println("ID:" + especialidade.getId());
                System.out.println("Nome: " + especialidade.getNome());
                System.out.println("Codigo: " + especialidade.getCodigo());
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Nenhuma especialidade cadastrada no momento. Cadastre uma especialidade primeiro para mostrar as especialidades");
            return;
        }
        
    }

    /* Bloco de crud Hospital*/
    public static void cadastrarHospital() {
        boolean validadorNomeHospital = false;
        boolean validacao = false;
        Endereco endereco = null;
        String nomeHospital = null;
        do{
            System.out.println("Digite o nome do Hospital: ");
            nomeHospital = leitor.nextLine();
            if(validador(nomeHospital)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

            if(validadorHospitalNome(nomeHospital)){
                validadorNomeHospital = true;
            }else{
                System.out.println("Ja existe esse nome do Hospital");
            }

        }while(!validacao || !validadorNomeHospital);
        
        if(nomeHospital != null){
            endereco = cadastrarEndereco(nomeHospital);
        }else{
            System.out.println("Erro. Username nulo");
            return;
        }
        
        Hospital h = new Hospital(nomeHospital, endereco);

        hospitalDAO.salvarHospital(h);

        System.out.println("Hospital criado com sucesso");
    }
    public static void excluirHospital() {
        ArrayList<Hospital> hospitais = (ArrayList<Hospital>) hospitalDAO.buscarTodasHospitais();
        if(hospitais.size() > 0){
            for (Hospital hospital : hospitais) {
                System.out.println("------------------------------");
                System.out.println("ID:" + hospital.getId());
                System.out.println("Nome: " + hospital.getNome());
                System.out.println("--------------------------------");
            }
            System.out.println("Digite o ID do Hospital que sera excluido");
            Long idSelecionado = Long.parseLong(leitor.nextLine());
            Hospital hospitalRemover = hospitalDAO.buscarHospitalPorId(idSelecionado);
            hospitalDAO.excluirHospital(hospitalRemover);
            for (Hospital hospital : hospitais) {
                String imutableHospital = hospitalRemover.getNome();
                excluirEnderecoNomeUser(imutableHospital);
            }
        }else{
            System.out.println("Nenhum Hospital cadastrado no momento. Cadastre um Hospital primeiro para excluir o mesmo");
            return;
        }
    }
    public static void editarHospital() {
        ArrayList<Hospital> hospitais = (ArrayList<Hospital>) hospitalDAO.buscarTodasHospitais();
        if(hospitais.size() > 0){
            System.out.println("Digite o nome do Hospital que sera editado: ");
            String nomeHospital = leitor.nextLine();
        
        

            for (Hospital hospital : hospitais) {
                if(nomeHospital.equals(hospital.getNome())){
                    String imutableHospitalName = hospital.getNome();
                    int op = 0;
                    System.out.println("Escolha uma opção para alterar:\n"+

                    "1 - Nome\n");

                    op = Integer.parseInt(leitor.nextLine());



                    switch (op){

                        case 1:
                            System.out.println("Digite o novo Nome do Hospital: ");
                            String novoHospitalName = leitor.nextLine();
                            hospital.setNome(novoHospitalName);
                            hospitalDAO.atualizarHospital(hospital);
                            editarEndercoNomeUser(novoHospitalName, imutableHospitalName);

                        break;


                        default:
                            System.out.println("Opcao incorreta");
                            return;
                    }
                }
            }
        }else{
            System.out.println("Nenhum Hospital cadastrado no momento. Cadastre um Hospital primeiro para editar o mesmo");
            return;
        }
    }
    public static void mostrarHospitais() {
        ArrayList<Hospital> hospitais = (ArrayList<Hospital>) hospitalDAO.buscarTodasHospitais();
        if(hospitais.size() > 0){
            for (Hospital hospital : hospitais) {
                System.out.println("------------------------------");
                System.out.println("ID:" + hospital.getId());
                System.out.println("Nome: " + hospital.getNome());
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Nenhum Hospital cadastrado no momento. Cadastre um Hospital primeiro para mostrar todos os Hospitais");
            return;
        }
        
        
    }
    /* Bloco de crud medico */
    public static void cadastrarMedico() {
        boolean validadorCrmMedico = false;
        boolean validadorNomeMedico = false;
        boolean validacao = false;
        String nomeMedico = null, crm = null;
        do{
            System.out.println("Digite o nome do medico: ");
            nomeMedico = leitor.nextLine();
            if(validador(nomeMedico)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

            if(validadorMedicoNome(nomeMedico)){
                validadorNomeMedico = true;
            }else{
                System.out.println("Ja existe esse nome do medico");
            }

        }while(!validacao || !validadorNomeMedico);
        
        do{
            System.out.println("Digite o crm: ");
            crm = leitor.nextLine();
            if(validador(crm)){
                validacao = true;
            }else{
                System.out.println("Erro. Digite Algo");
            }

            if(validadorMedicoCrm(crm)){
                validadorCrmMedico = true;
            }else{
                System.out.println("Este numero de crm ja esta atribuido a outro Medico");
            }

        }while(!validacao || !validadorCrmMedico);

        ArrayList<Hospital> hospitais = (ArrayList<Hospital>) hospitalDAO.buscarTodasHospitais();

        if(hospitais.size() > 0){
            for (Hospital hospital : hospitais) {
                System.out.println("------------------------------");
                System.out.println("ID:" + hospital.getId());
                System.out.println("Nome: " + hospital.getNome());
                System.out.println("--------------------------------");
            }

            System.out.println("Digite o ID do Hospital que o medico sera Atribuido: ");
            Long idSelecionado = Long.parseLong(leitor.nextLine());
            Hospital hospitalAtribuido = hospitalDAO.buscarHospitalPorId(idSelecionado);

            Medico m = new Medico(crm, nomeMedico, hospitalAtribuido);

            medicoDAO.salvarMedico(m);
            System.out.println("Medico criado com sucesso");
        }else{
            System.out.println("Nenhum Hospital cadastrado no momento. Cadastre um Hospital primeiro para cadastrar um medico");
            return;
        }
        
        
    }
    public static void excluirMedico() {
        ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDAO.buscarTodosMedicos();
        if(medicos.size()> 0){
            for (Medico medico : medicos) {
                System.out.println("------------------------------");
                System.out.println("ID:" + medico.getId());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("--------------------------------");
            }
            System.out.println("Digite o ID do medico que sera excluido: ");
            Long idSelecionado = Long.parseLong(leitor.nextLine());
            Medico medicoRemover = medicoDAO.buscarMedicoPorId(idSelecionado);
            medicoDAO.excluirMedico(medicoRemover);

            System.out.println("Medico excluido com sucesso");

        }else{
            System.out.println("Nenhum medico cadastrado no momento. Cadastre um medico primeiro para excluir o mesmo");
            return;
        }
    }
    public static void editarMedico() {
        ArrayList<Medico> medico = (ArrayList<Medico>) medicoDAO.buscarTodosMedicos();

        if(medico.size() > 0){
            System.out.println("Digite o Nome do medico que sera editado: ");
            String medicoName = leitor.nextLine();

            
            
            for (Medico medicos : medico) {
                if(medicoName.equals(medicos.getNome())){
                    int op = 0;
                    System.out.println("Escolha uma opção para alterar:\n"+

                    "1 - Nome\n"+

                    "2 - CRM\n");



                    op = Integer.parseInt(leitor.nextLine());



                    switch (op){

                        case 1:
                            System.out.println("Digite um nome novo: ");
                            String nomeNovo = leitor.nextLine();
                            medicos.setNome(nomeNovo);
                            medicoDAO.atualizarMedico(medicos);
                        break;



                        case 2:
                            System.out.println("Digite a novo CRM: ");
                            String crmNovo = leitor.nextLine();
                            medicos.setCrm(crmNovo);
                            medicoDAO.atualizarMedico(medicos);
                        break;



                        default:
                            System.out.println("Opcao Incorreta!!!!!");
                        return;
                    }
                }
            }
        }else{
            System.out.println("Nenhum medico cadastrado no momento. Cadastre um medico primeiro para modificar o mesmo");
            return;
        }
        
    }
    public static void mostrarMedicos() {
        ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDAO.buscarTodosMedicos();
        if(medicos.size() > 0){
            for (Medico medico : medicos) {
                System.out.println("------------------------------");
                System.out.println("ID:" + medico.getId());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Nenhum medico cadastrado no momento. Cadastre um medico primeiro para mostrar os Medicos");
            return;
        }
        
        
    }
    public static void adicionarEspecialidade(){
        ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDAO.buscarTodosMedicos();

        if(medicos.size()> 0){
            System.out.println("Digite o nome do Medico: ");
            String nomeMedico = leitor.nextLine();
            for (Medico medico : medicos) {
                if(nomeMedico.equals(medico.getNome())){
                    funcaoArrayListMedico(medico);
                    medicoDAO.atualizarMedico(medico);
                }
            }
        }else{
            System.out.println("Nenhum medico cadastrado no momento. Cadastre um medico primeiro para adicionar uma especialidade a ele");
            return;
        }
    }

    /* Bloco de crud endereco */
    public static Endereco cadastrarEndereco(String nome) {


        String nomeUser = nome;

        System.out.println("Logradouro[Exemplo: Rua Jao de Freitas]: ");
        String logradouro = leitor.nextLine();

        System.out.println("Bairro: ");
        String bairro = leitor.nextLine();

        System.out.println("CEP[Exemplo: 98.487-99]: ");
        String cep = leitor.nextLine();

        System.out.println("Numero: ");
        String numero = leitor.nextLine();

        System.out.println("Complemento[Exemplo: Casa da esquina]: ");
        String complemento = leitor.nextLine();

        System.out.println("Cidade: ");
        String cidade = leitor.nextLine();

        System.out.println("UF[Exemplo: PR]: ");
        String uf = leitor.nextLine();


        Endereco end = new Endereco(nomeUser,logradouro, bairro, cep, numero, complemento, cidade, uf);

        enderecoDAO.salvarEndereco(end);

        return end;
    }
    public static void excluirEnderecoNomeUser(String userNameExclude) {
        try{
            ArrayList<Endereco> enderecos = (ArrayList<Endereco>) enderecoDAO.buscarTodosEnderecos();
            for (Endereco endereco : enderecos) {
                if(endereco.getNomeUser().equals(userNameExclude)){
                    
                    Long idEndereco = endereco.getId();
                    Endereco excluiEndereco = enderecoDAO.buscarEnderecoPorId(idEndereco);
                    enderecoDAO.excluirEndereco(excluiEndereco);
                    
                }
            }
        }catch(Exception e){

        }
    }
    
    public static void editarEndercoNomeUser(String nomeUser, String primeiraVersaoDeNome){
        ArrayList<Endereco> enderecos = (ArrayList<Endereco>) enderecoDAO.buscarTodosEnderecos();
        for (Endereco endereco : enderecos) {
            if(endereco.getNomeUser().equals(primeiraVersaoDeNome)){
                endereco.setNomeUser(nomeUser);
                enderecoDAO.atualizarEndereco(endereco);
            }
        }
    }
    public static void mostrarEnderecos() {
        ArrayList<Endereco> enderecos = (ArrayList<Endereco>) enderecoDAO.buscarTodosEnderecos();
        if(enderecos.size() > 0){
            for (Endereco endereco : enderecos) {
                System.out.println("------------------------------");
                System.out.println("Logradouro: " + endereco.getLogradouro());
                System.out.println("Bairro: " + endereco.getBairro());
                System.out.println("CEP: " + endereco.getCep());
                System.out.println("Numero :" + endereco.getNumero());
                System.out.println("Complemento: " + endereco.getComplemento());
                System.out.println("Cidade: " + endereco.getCidade());
                System.out.println("UF: " + endereco.getUf());
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Nenhum endereco cadastrado. Cadastre um endereco para mostrar todos os enderecos");
            return;
        }
        
    }


    public static void funcaoArrayListMedico(Medico med){
        ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) especialidadeDAO.buscarTodasEspecialidades();
        for (Especialidade especialidade : especialidades) {
            System.out.println("------------------------------");
            System.out.println("ID:" + especialidade.getId());
            System.out.println("Nome: " + especialidade.getNome());
            System.out.println("Codigo: " + especialidade.getCodigo());
            System.out.println("--------------------------------");
        }
        System.out.println("Digite o ID da Especialidade que sera Adicionada: ");
        Long idSelecionado= Long.parseLong(leitor.nextLine());

        Especialidade especialidadeNew = especialidadeDAO.buscarEspecialidadePorId(idSelecionado);
        med.especialidadeNova(especialidadeNew);

        for (Especialidade especialidade2 : especialidades) {
            if(especialidade2.getId() == idSelecionado){
                especialidade2.adicionarMedicoAoList(med);
                especialidadeDAO.atualizarEspecialidade(especialidadeNew);
            }
        }
    }
    //Paciente
    public static void agendarConsulta(String username) {
        ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) especialidadeDAO.buscarTodasEspecialidades();
        if(especialidades.size() > 0){
            for (Especialidade especialidade : especialidades) {
                System.out.println("------------------------------");
                System.out.println("ID:" + especialidade.getId());
                System.out.println("Nome: " + especialidade.getNome());
                System.out.println("Codigo: " + especialidade.getCodigo());
                System.out.println("--------------------------------");
            }
            System.out.println("Digite o ID da Especialidade que vc gostaria de se Consultar: ");
            Long idSelecionadoEspecialidade= Long.parseLong(leitor.nextLine());
            Especialidade especialidadeConsultar = especialidadeDAO.buscarEspecialidadePorId(idSelecionadoEspecialidade);
            ArrayList<Medico> idHospital = especialidadeConsultar.verificarMedico();

            mostrarHospitaisConsulta(idHospital, idSelecionadoEspecialidade, username);
        }else{
            System.out.println("Nenhuma especialidade cadastrada. Impossivel fazer consultas no momento");
        }
    }
    public static void mostrarHospitaisConsulta(ArrayList<Medico> iMedicos, Long idSelecionadoEspecialidade, String username) {
        ArrayList<Hospital> hospitais = (ArrayList<Hospital>) hospitalDAO.buscarTodasHospitais();
        if(hospitais.size() > 0){
            for (Medico medicos : iMedicos) {
                Hospital hospitaisAhMostra = medicos.getHospitalContratante();
                for (Hospital hospital : hospitais) {
                    if(hospitaisAhMostra.getId().equals(hospital.getId())){
                        System.out.println("------------------------------");
                        System.out.println("ID:" + hospital.getId());
                        System.out.println("Nome: " + hospital.getNome());
                        System.out.println("--------------------------------");
                    }
                }
            }
            System.out.println("Digite o ID do Hospital que sera Escolhido: ");
            Long idSelecionadoHospital = Long.parseLong(leitor.nextLine());
            if(iMedicos.size() > 0){
                for (Medico medico : iMedicos) {
                    if(medico.getHospitalContratante().getId().equals(idSelecionadoHospital)){
                        System.out.println("------------------------------");
                        System.out.println("ID:" + medico.getId());
                        System.out.println("Nome: " + medico.getNome());
                        System.out.println("CRM: " + medico.getCrm());
                        System.out.println("--------------------------------");
                    }
                }
                System.out.println("Digite o ID do medico que vc gostaria de Fazer o atendimento: ");
                Long idSelecionadoMedico = Long.parseLong(leitor.nextLine());
                Medico medicoSelecionado = null;
                for (Medico medicoPorId : iMedicos) {
                    if(medicoPorId.getId().equals(idSelecionadoMedico)){
                        medicoSelecionado = medicoPorId;
                    }
                }
                finalizarConsulta(medicoSelecionado, username);
            }else{
                System.out.println("Nenhum medico cadastrado com esta Especialidade neste Hospital. impossivel fazer consulta neste Hopital tente em outro");
                return;
            }
        }else{
            System.out.println("Nenhum Hospital cadastrado com esta Especialidade. Impossivel fazer consulta com essa especialidade");
            return;
        }
        

    }
    public static void finalizarConsulta(Medico medicoSelecionado, String username) {
        Usuario usuarioSelected = null;
        Date dataHoraAtendimentoSelected = null;
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDAO.buscarTodosPacientes();
        for (Usuario usuario : usuarios) {
            if (username.equals(usuario.getUsername())) {
                boolean dataValida = false;
                while (!dataValida) {
                    System.out.print("Digite a data de atendimento (formato dd/MM/yyyy): ");
                    String dataInput = leitor.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    try {
                        Date dataAtendimento = dateFormat.parse(dataInput);

                        // Check for existing appointments on the specified day with the selected doctor
                        boolean conflitoEncontrado = false;
                        ArrayList<Consulta> consultas = (ArrayList<Consulta>) consultaDAO.buscarTodasConsultas();
                        for (Consulta consulta : consultas) {
                            Calendar consultaCalendar = Calendar.getInstance();
                            consultaCalendar.setTime(consulta.getData());
                            int consultaDay = consultaCalendar.get(Calendar.DAY_OF_MONTH);

                            Calendar dataAtendimentoCalendar = Calendar.getInstance();
                            dataAtendimentoCalendar.setTime(dataAtendimento);
                            int dataAtendimentoDay = dataAtendimentoCalendar.get(Calendar.DAY_OF_MONTH);

                            if (consulta.getMedico().equals(medicoSelecionado) && consultaDay == dataAtendimentoDay) {
                                System.out.println("Não é possível marcar a consulta neste dia. Já existe uma consulta agendada com o mesmo médico.");
                                conflitoEncontrado = true;
                                break;
                            }
                        }

                        if (!conflitoEncontrado) {
                            // If no conflicts found, save the appointment
                            usuarioSelected = usuario;
                            dataHoraAtendimentoSelected = dataAtendimento;
                            dataValida = true;
                            System.out.println("Consulta marcada com sucesso para o dia " + dataInput);
                        }
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yyyy.");
                    }
                }
            }
        }

        if (usuarioSelected != null && dataHoraAtendimentoSelected != null) {
            Consulta c = new Consulta(usuarioSelected, medicoSelecionado, dataHoraAtendimentoSelected);
            consultaDAO.salvarConsulta(c);
        }
    }
    public static void mudarEndereco(String username){
        Long idEndereco = null;
        Endereco enderecoNovo = null;
        ArrayList<Endereco> enderecos = (ArrayList<Endereco>) enderecoDAO.buscarTodosEnderecos();
        for (Endereco endereco : enderecos) {
            if(endereco.getNomeUser().equals(username)){
                enderecoNovo = cadastrarEndereco(username);
                idEndereco = endereco.getId();
            }
        }
        enderecoNovo = enderecoDAO.buscarEnderecoPorId(idEndereco);
        enderecoDAO.salvarEndereco(enderecoNovo);
    }
    public static void recebeUsuario(String username) {
        Usuario user = null;
        ArrayList<Usuario> paciente = (ArrayList<Usuario>) usuarioDAO.buscarTodosPacientes();
        for (Usuario usuario : paciente) {
            if(usuario.getUsername().equals(username)){
                user = usuario;
            }
        }
        mudarDataConsulta(user);
    }
    public static void mudarDataConsulta(Usuario user) {
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) consultaDAO.buscarTodasConsultas();

        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equals(user)) {
                System.out.print("Digite a data de atendimento (formato dd/MM/yyyy): ");
                String dataInput = leitor.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date dataAtendimento = dateFormat.parse(dataInput);

                    // Check for existing appointments on the specified day
                    boolean conflitoEncontrado = false;
                    for (Consulta outraConsulta : consultas) {
                        if (!outraConsulta.equals(consulta) && isSameDay(outraConsulta.getData(), dataAtendimento)) {
                            System.out.println("Não é possível marcar a consulta neste dia. Já existe uma consulta agendada.");
                            conflitoEncontrado = true;
                            break;
                        }
                    }

                    if (!conflitoEncontrado) {
                        // Update the date of the consultation
                        consulta.setData(dataAtendimento);
                        consultaDAO.atualizarConsulta(consulta);

                        System.out.println("Data da consulta atualizada com sucesso para " + dateFormat.format(dataAtendimento));
                    }
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yyyy.");
                }
            }
        }
    }

    /* Validadores */
    public static boolean validador(String x) {
        if(x.length() == 0){
            return false;
        }else{
            return true;
        }
    }
    public static boolean validadorUsername(String username){
        boolean oBoolean = true;
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDAO.buscarTodosUsuarios();
        for (Usuario usuario : usuarios) {
            if(username.equals(usuario.getUsername())){
                 oBoolean = false;
            }else{
                 oBoolean = true;
            }
        }
        return oBoolean;
    }
    public static boolean validadorHospitalNome(String nomeHospital){
        boolean oBoolean = true;
        ArrayList<Hospital> hospitais = (ArrayList<Hospital>) hospitalDAO.buscarTodasHospitais();

        for (Hospital hospital : hospitais) {
            if(nomeHospital.equals(hospital.getNome())){
                oBoolean = false;
            }else{
                oBoolean = true;
            }
        }
        return oBoolean;
    }
    public static boolean validadorEspecialidadeNome(String especialidadeNome){
        boolean oBoolean = true;
        ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) especialidadeDAO.buscarTodasEspecialidades();

        for (Especialidade especialidade : especialidades) {
            if(especialidadeNome.equals(especialidade.getNome())){
                oBoolean = false;
            }else{
                oBoolean = true;
            }
        }
        return oBoolean;
    }
    public static boolean validadorMedicoNome(String medicoNome) {
        boolean oBoolean = true;
        ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDAO.buscarTodosMedicos();

        for (Medico medico : medicos) {
            if(medicoNome.equals(medico.getNome())){
                oBoolean = false;
            }else{
                oBoolean = true;
            }
        }
        return oBoolean;
    }
    public static boolean validadorMedicoCrm(String crm) {
        boolean oBoolean = true;
        ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDAO.buscarTodosMedicos();

        for (Medico medico : medicos) {
            if(crm.equals(medico.getCrm())){
                oBoolean = false;
            }else{
                oBoolean = true;
            }
        }
        return oBoolean;
    }
    private static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }
    
}
