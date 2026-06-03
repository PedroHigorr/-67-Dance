package Model;

public class Passo {

    private String id;
    private String nome;
    private String historia;
    private String caminho_video;
    
    
    public Passo(String id, String nome, String historia, String caminho_video){
    
        this.id = id;
        this.nome = nome;
        this.historia = historia;
        this.caminho_video = caminho_video;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getHistoria() {
        return historia;
    }

    public String getCaminho_video() {
        return caminho_video;
    }
    
    
}
