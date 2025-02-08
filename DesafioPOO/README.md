# 📱️ Desafio POO 📲️

Modelagem e Diagramação de um Componente iPhone, seguindo instruções do [desafio POO](https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/poo) da [DIO](https://web.dio.me).

## Modelagem UML

```mermaid
classDiagram

    class ReprodutorMusical {
        -String musica
        -boolean tocando
        +tocar()
        +pausar()
        +selecionarMusica(String musica)
    }
    
    class AparelhoTelefonico {
        -String numero
        +ligar(String numero)
        +atender()
        +iniciarCorreioVoz()
    }
    
    class NavegadorInternet {
        +exibirPagina(String url)
        +adicionarNovaAba()
        +atualizarPagina()
    }

    class iPhone {
    }
    
    iPhone --> ReprodutorMusical
    iPhone --> AparelhoTelefonico
    iPhone --> NavegadorInternet
```

## Telas de exemplo:

<img src="./assets/tela01.png">
<img src="./assets/tela02.png">
<img src="./assets/tela03.png">
<img src="./assets/tela04.png">
<img src="./assets/tela05.png">