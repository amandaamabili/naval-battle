package src.br.com.letscode.navalbattle.grid.enums;

public enum Column {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    //Você pode atribuir um valor a uma variável final apenas uma vez, ou seja, seus valores não podem ser alterados.
    public final String number;

    Column(String number){
        this.number = number;
    }
    // 'this.number' é a variável 'number' da classe "Column" e 'number' é a variável que a classe recebeu para criar um objeto!
    //Usamos o 'this' dentro da classe. Assim, sempre que colocarmos 'this.' antes de uma variável, fica implícito ao Java que estamos nos referindo aos atributos daquela Classe.
}
