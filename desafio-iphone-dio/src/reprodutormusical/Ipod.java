package reprodutormusical;

import java.util.Locale;
import java.util.Scanner;

public abstract class Ipod implements ReprodutorMusical{

    private String musicaAtual = null;
    private String ultimaMusica = null;
    private int volume = 10;

    public void ligarAparelho() { //Destinado a ligar o iPod
        setAparelhoLigado(true);

    }
    
    public void desligarAparelho() {
        setAparelhoLigado(false); //Destinado a desligar o iPod
    }

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

    public void pausar() {
        System.out.println("Musica pausada");
    }

    public void selecionarMusica() {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        setUltimaMusica(getMusicaAtual()); //atualiza o status da ultima música para a musica que esta tocando até o presente momento.
        System.out.println("Digite o nome da música");
        String musica = sc.next();
        sc.close();
        buscarMusica(musica);
    }

    public void buscarMusica(String musica) {
        System.out.println("Buscando musica...");
        System.out.println("Música " + musica + " encontrada!");
        setMusicaAtual(musica); //atualiza a Música Atual para a música procurada;
    }

    public void aumentarVolume() {
        setVolume(getVolume() + 1);
        System.out.println("Volume: " + getVolume());
    }

    public void diminuirVolume() {
        setVolume(getVolume() - 1);
        System.out.println("Volume: " + getVolume());
    }


    //Getters e Setters
    public void setAparelhoLigado(boolean aparelhoLigado) {
        if(aparelhoLigado == true){
            System.out.println("Ligando...");
            System.out.println("iPod Ligado");
        } else System.out.println("Desligando...");
    }
    
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
