public class AparelhoTelefonico {
    private static String numero = "(99)9999-9999";
    
    public static void ligar(){
        System.out.println("Discando... " + numero + "!");
    }

    public static void atender(){
        System.out.println("Ligação recebida!");
    }

    public static void iniciarCorreioVoz(String numero){
        System.out.println("Ouvindo correio de voz de " + numero + ".");
    }
}