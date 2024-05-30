package reprodutormusical;

public interface ReprodutorMusical {
    
    //Ações de um reprodutor musical
    void tocar();
    void pausar();
    void selecionarMusica();
    void buscarMusica(String musica);
    void ligarAparelho();
    void desligarAparelho();
    void aumentarVolume();
    void diminuirVolume();

}
