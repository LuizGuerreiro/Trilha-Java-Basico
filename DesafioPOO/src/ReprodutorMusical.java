public class ReprodutorMusical {
    private static String musica = null;
    private static boolean tocando = false;
            
    public static void tocar(){
        if (musica == null) {
            System.out.println("Selecione uma música para reproduzir!");
        } else {
            System.out.println("Tocando a música " + musica + "!");
            tocando = true;
        }
    }

    public static void pausar(){
        if (tocando == false) {
            System.out.println("Nenhuma música está sendo reproduzida no momento!");
        } else {
            System.out.println("Música pausada!");
            tocando = false;
        }
    }

    public static void selecionarMusica(String musica){
        ReprodutorMusical.musica = musica;
        System.out.println("Música " + musica + " selecionada!");
    }
}