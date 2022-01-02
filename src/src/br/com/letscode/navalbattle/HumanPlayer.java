package src.br.com.letscode.navalbattle;

import java.util.Arrays;
import java.util.Objects;

import static src.br.com.letscode.navalbattle.Board.*;
import static src.br.com.letscode.navalbattle.Randomizer.randomCoordinatesGenerator;

public class HumanPlayer extends Player{

        String[] coordinate = new String[2];

        public HumanPlayer(int pontosIniciais) {
            super.points = pontosIniciais;
        }



//--------------------------------------------------------------------------------------------------------------------
//


        protected void randomShipsForPlayer() {
            System.out.println("Você gostaria de colocar randomicamente os submarinos? 'Sim' ou 'Nao' ");

            String answer = input.next();

            //Logica para colocar a primeira letra de 'sim' ou 'nao' em maisculo;
            String firstLet = answer.substring(0, 1);
            String remLetAnswer = answer.substring(1);
            String firstLetUppercase = firstLet.toUpperCase();
            String finalAnswer = firstLetUppercase + remLetAnswer;


            if(finalAnswer.equals("Sim")) {
                while (submarineNumber <= 10) {

//                gerados 2 numeros aleatórios que serão testados se já foram usados (verificando se já tem um "N" lá)
                    coordinateRow = randomCoordinatesGenerator();
                    coordinateTile = randomCoordinatesGenerator();

                    if (Objects.equals(playerBoard[coordinateRow][coordinateTile], "N")) {
                        randomShipsForPlayer();
                    } else {
                        playerBoard[coordinateRow][coordinateTile] = "N";
                        submarineNumber++;
                    }
                }
            } else {
                playerInsertShipsOnBoard();
            }

        }



        private boolean isValidMove() {
            if (coordinate.length != 2)  {
                System.err.println("Você escreveu errado. Escreve direito. Letra e número.");
                return false;
            }

            coordinateRow = Arrays.asList(columnLetter).indexOf((coordinate[0]).toUpperCase());

            if(coordinateRow == -1) {
                System.err.println("Digite uma letra válida.");
                return false;
            }
            try {
                coordinateTile = Integer.parseInt(coordinate[1]);
            }  catch(NumberFormatException e) {
                System.err.println("Digite algo valido");
                return false;
            }
            return true;
    }

        protected void playerInsertShipsOnBoard() {




            // TODO: Substituir o uso dessa variável estática submarineNumber pela submarineCounter de cada jogador;
            while (submarineNumber <= 10) {
                System.out.printf("Selecione a localização do Submarino %d %n", submarineNumber);

                boolean isSubmarineValid = false;

                while(!isSubmarineValid) {
                    coordinate = input.next().split("");
                    isSubmarineValid = isValidMove();
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
        /*
            O que fizemos acima foi o seguinte:
                Armazenamos a coordenada inserida
                (que deve vir em formato LetraNúmero, exemplos: B2, C4)
                em um array de String chamado "coordinate";
                Temos o array de String que recebeu a entrada: [String "B", String 2] por exemplo.
                Vamos armazenar o primeiro String em coordinateRow e o segundo em coordinateTile,
                Linha e Casinha respectivamente.
                Buscamos o índice do primeiro String usando o array auxiliar de letras lá encima: [int 1, char 2]
                Esse índice será passado no primeiro parâmetro: playerboard[1][].
                No segundo nível, convertemos o String numérico para Integer: [int 1, int 2]
                e ele se torna o segundo parâmetro: playerboard[1][2].
                Fazemos um teste antes para ver se já há um "N" naquele espaço.
                Se houver, usamos o princípio da RECURSÃO e chamamos a função dentro dela mesmo de novo.
                Se não houver, preenchemos o Tile com o "N" e incrementamos o contador para o próximo Submarino.

            */




//-------------------------------------------------------------------------------------------------------------
        protected void playerMoves() {

            System.out.println("Faça sua jogada. Digite uma coordenada!");

            boolean isPlayerMoveValid = false;

            while(!isPlayerMoveValid) {
                coordinate = input.next().split("");
                isPlayerMoveValid = isValidMove();
            }


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



