package iphone;


import java.util.Locale;
import java.util.Scanner;
import aparelhotelefonico.AparelhoTelefonico;
import navegadorinternet.NavegadorInternet;
import reprodutormusical.ReprodutorMusical;


public class Iphone implements ReprodutorMusical, NavegadorInternet,  AparelhoTelefonico {

    private String musicaAtual = null;
    private String ultimaMusica = null;
    private int volume = 10;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        
        //declarando um novo Iphone
        Iphone iphone = new Iphone(); 

        System.out.println("O que deseja fazer?");
        System.out.println("(1) - Tocar Musica");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                iphone.tocar();
                break;
        
            default:
                break;
        }

        sc.close();
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o número: " + numero);
    }

    @Override
    public void atender() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja atender o telefone? (Sim/Não)");
        String sn = sc.next();
        sc.close();
        switch (sn) {
            case "Sim":
                System.out.println("Atendido");
                break;
            case "Não":
                System.out.println("Rejeitado");
                break;
            default:
                break;
        }

    }

    @Override
    public void iniciarConversa() {
        System.out.println("Iniciando conversa.");;
    }

    @Override
    public void SalvarNumero(String numero, String nome) {
        System.out.println("Contato de nome " + nome + " e número " + numero + " Salvo na agenda.");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Por favor, aguarde.");
        System.out.println("Concluido");
    }

    @Override
    public void adicionarAba() {
        System.out.println("Nova guia");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Por favor, aguarde");
        System.out.println("Pagina atualizada");
    }

    @Override
    public void tocar() {
        if (getMusicaAtual() == null){
            if (getUltimaMusica() == null){ //Se não tiver nenhuma música anterior e atual
                selecionarMusica();
                System.out.println("Tocando " + getMusicaAtual());
            } else { //Caso tenha uma música anterior
                System.out.println("Tocando " + getUltimaMusica());
            }
        } else { //Destinado a tocar uma musica no aparelho caso já possua uma atual
            System.out.println("Tocando música " + getMusicaAtual());
        }
    }

    @Override
    public void pausar() {
        System.out.println("Musica pausada");
    }

    @Override
    public void selecionarMusica() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        setUltimaMusica(getMusicaAtual()); //atualiza o status da ultima música para a musica que esta tocando até o presente momento.
        System.out.println("Digite o nome da música");
        String musica = sc.nextLine();
        sc.close();
        buscarMusica(musica);
    }

    @Override
    public void buscarMusica(String musica) {
        System.out.println("Buscando musica...");
        System.out.println("Música " + musica + " encontrada!");
        setMusicaAtual(musica); //atualiza a Música Atual para a música procurada;
    }

    @Override
    public void ligarAparelho() {
        setAparelhoLigado(true);
    }

    @Override
    public void desligarAparelho() {
        setAparelhoLigado(false);
    }

    @Override
    public void aumentarVolume() {
        setVolume(getVolume() + 1);
        System.out.println("Volume: " + getVolume());
    }

    @Override
    public void diminuirVolume() {
        setVolume(getVolume() - 1);
        System.out.println("Volume: " + getVolume());
    }

    public void setAparelhoLigado(boolean aparelhoLigado) {
        if(aparelhoLigado == true){
            System.out.println("Ligando...");
            System.out.println("iPod Ligado");
        } else System.out.println("Desligando...");
    }

    //Getters e Setters
    public String getMusicaAtual() {
        return musicaAtual;
    }

    public void setMusicaAtual(String musicaAtual) {
        this.musicaAtual = musicaAtual;
    }

    public String getUltimaMusica() {
        return ultimaMusica;
    }

    public void setUltimaMusica(String ultimaMusica) {
        this.ultimaMusica = ultimaMusica;
    }


    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
