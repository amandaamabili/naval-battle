package src.br.com.letscode.navalbattle.grid.enums;


public enum Row {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J");


    //Você pode atribuir um valor a uma variável final apenas uma vez, ou seja, seus valores não podem ser alterados.
    public final String letter;

    Row(String letter) {
        this.letter = letter;
    }
    // 'this.letter' é a variável 'letter' da classe "Row" e 'letter' é a variável que a classe recebeu para criar um objeto!
    //Usamos o 'this' dentro da classe. Assim, sempre que colocarmos 'this.' antes de uma variável, fica implícito ao Java que estamos nos referindo aos atributos daquela Classe.
}