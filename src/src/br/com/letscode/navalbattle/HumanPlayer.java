package src.br.com.letscode.navalbattle;

import java.util.Arrays;

import static src.br.com.letscode.navalbattle.Board.*;

public class HumanPlayer extends Player{

        String[] coordinate = new String[2];

        public HumanPlayer(int pontosIniciais) {
            super.points = pontosIniciais;
        }



//--------------------------------------------------------------------------------------------------------------------
//    Função para o jogador inserir manualmente suas peças no tabuleiro
//    public void playerInsertShipsOnBoard() {
//
//               /*
//                    Armazenamos a coordenada inserida
//                    (que deve vir em formato LetraNúmero, exemplos: B2, C4)
//                    em um array de chars;
//                    O que estamos fazendo é o seguinte:
//                    Temos o array de char que recebeu a entrada: [char B, char 2] por exemplo.
//                    Vamos armazenar o primeiro char em coordinateRow e o segundo em coordinateTile,
//                    Linha e Casinha respectivamente.
//                    Convertemos o primeiro char da entrada para String: [String "B", char 2]
//                    buscamos seu índice usando o array auxiliar de letras lá encima: [int 1, char 2]
//                    Esse índice será passado no primeiro parâmetro: playerboard[1][].
//                    No segundo nível, convertemos o char numérico para Integer: [int 1, int 2]
//                    e ele se torna o segundo parâmetro: playerboard[1][2].
//                    Fazemos um teste antes para ver se já há um "N" naquele espaço.
//                    Se houver, usamos o princípio da RECURSÃO e chamamos a função dentro dela mesmo de novo.
//                    Se não houver, preenchemos o Tile com o "N" e incrementamos o contador para o próximo Submarino.
//                 */
//
//        while (submarineNumber <= 10) {
//            System.out.printf("Selecione a localização do Submarino %d %n", submarineNumber);
//            coordinate = input.next().toCharArray();
//
//
//            if (coordinate.length != 2) {
//                System.err.println("Você escreveu errado. Escreve direito. Letra e número.");
//                playerInsertShipsOnBoard();
//                break;
//            }
//
//            coordinateRow = Arrays.asList(columnLetter).indexOf(Character.toString(coordinate[0]).toUpperCase());
//            coordinateTile = Character.getNumericValue(coordinate[1]);
//
//            if (playerBoard[coordinateRow][coordinateTile] == "N") {
//                System.err.println("Já existe um Submarino nesta casa. Tente novamente em outro lugar.");
//                playerInsertShipsOnBoard();
//                break;
//            } else {
//                playerBoard[coordinateRow][coordinateTile] = "N";
//                submarineNumber++;
//            }
//        }

        protected void playerInsertShipsOnBoard() {

            // TODO: Substituir o uso dessa variável estática submarineNumber pela submarineCounter de cada jogador;
            while (submarineNumber <= 10) {
                System.out.printf("Selecione a localização do Submarino %d %n", submarineNumber);
                coordinate = input.next().split("");


            //TODO: Checar aqui se o input do jogador é diferente de LetraNúmero, antes de entrar nas linhas abaixo.


                if (coordinate.length != 2)  {
                    System.err.println("Você escreveu errado. Escreve direito. Letra e número.");
                    playerInsertShipsOnBoard();
                    break;
                }

                coordinateRow = Arrays.asList(columnLetter).indexOf((coordinate[0]).toUpperCase());
                coordinateTile = Integer.parseInt(coordinate[1]);

                if (playerBoard[coordinateRow][coordinateTile] == "N") {
                    System.err.println("Já existe um Submarino nesta casa. Tente novamente em outro lugar.");
                    playerInsertShipsOnBoard();
                    break;
                } else {
                    playerBoard[coordinateRow][coordinateTile] = "N";
                    submarineNumber++;
                }
            }

        }
//-------------------------------------------------------------------------------------------------------------
        protected void playerMoves() {

            System.out.println("Faça sua jogada. Digite uma coordenada!");

            coordinate = input.next().split("");

            //TODO: Checar aqui se o input do jogador é diferente de LetraNúmero, antes de entrar nas linhas abaixo.

            coordinateRow = Arrays.asList(columnLetter).indexOf((coordinate[0]).toUpperCase());
            coordinateTile = Integer.parseInt(coordinate[1]);

                if(enemyBoard[coordinateRow][coordinateTile] == "N") {
                playerBoard[coordinateRow][coordinateTile] = "*";
                enemyBoard[coordinateTile][coordinateRow] = "*";
                this.points++;
            } else {
                if (playerBoard[coordinateRow][coordinateTile] == "N") {
                    playerBoard[coordinateRow][coordinateTile] = "X";
                } else {
                    playerBoard[coordinateRow][coordinateTile] = "-";
                }
            }
        }
}



