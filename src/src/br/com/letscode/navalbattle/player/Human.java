package src.br.com.letscode.navalbattle.player;

import src.br.com.letscode.navalbattle.grid.Grid;
import src.br.com.letscode.navalbattle.grid.Position;
import src.br.com.letscode.navalbattle.grid.enums.Row;
import src.br.com.letscode.navalbattle.grid.enums.Status;

import java.util.Scanner;

public class Human extends Player {
    Scanner scanner;

    public Human(String name, Scanner scanner) {
        super(name, true);
        this.scanner = scanner;
    }

    public void distributeShipsRandomly() {
        System.out.println("Você gostaria de colocar randomicamente os submarinos? 'Sim' ou 'Nao' ");
        String answer = scanner.next();

        //Logica para colocar a primeira letra de 'sim' ou 'nao' em maisculo;
        String firstLet = answer.substring(0, 1);
        String remLetAnswer = answer.substring(1);
        String firstLetUppercase = firstLet.toUpperCase();
        String finalAnswer = firstLetUppercase + remLetAnswer;

        if (finalAnswer.equals("Sim")) {
            super.distributeShipsRandomly();
        } else {
            distributeShipsManually();
        }
    }

    public void distributeShipsManually() {
        var coordinate = new String[2];

        while (this.grid.shipsAdded < 10) {
            boolean isSubmarineValid = false;

            System.out.printf("Selecione a localização do Submarino %d %n", this.grid.shipsAdded + 1);

            while (!isSubmarineValid) {
                coordinate = scanner.next().split("");
                isSubmarineValid = isValidMoveAndPosition(coordinate, true);
            }

            var row = Row.valueOf(coordinate[0].toUpperCase()).ordinal();
            var column = Integer.parseInt(coordinate[1]);

            var position = this.grid.positionList[row][column];
            position.setStatus(Status.FILLED);
            this.grid.positionList[row][column] = position;
            this.grid.shipsAdded++;
        }
    }

    public void shoot(Grid enemyBoard) {
        boolean isPlayerMoveValid = false;

        System.out.println("Faça sua jogada. Digite uma coordenada!");
        var coordinate = new String[2];

        while (!isPlayerMoveValid) {
            coordinate = scanner.next().split("");
            isPlayerMoveValid = isValidMoveAndPosition(coordinate, false);
        }

        var row = Row.valueOf(coordinate[0].toUpperCase()).ordinal();
        var column = Integer.parseInt(coordinate[1]);

        var hit = shoot(row, column, enemyBoard);
        grid.updateGrid(row, column, hit);
    }

    //todo refatorar essa validação de posição para outro worker.
    private boolean isValidMoveAndPosition(String[] coordinate, boolean shouldCheckPosition) {
        int row;
        int column;

        if (coordinate.length != 2) {
            System.err.println("Você escreveu errado. Escreve direito. Letra e número.");
            return false;
        }

        try {
            row = Row.valueOf(coordinate[0].toUpperCase()).ordinal();
        } catch (IllegalArgumentException exception) {
            System.err.println("Digite uma letra válida.");
            return false;
        }

        try {
            column = Integer.parseInt(coordinate[1]);
        } catch (NumberFormatException e) {
            System.err.println("Digite um número válido");
            return false;
        }

        var position = this.grid.positionList[row][column];

        if (shouldCheckPosition) {
            return isValidPosition(position);
        }
        return true;
    }

    private boolean isValidPosition(Position position) {
        if (!position.isEmpty()) {
            System.err.println("Já existe um Submarino nesta casa. Tente novamente em outro lugar.");
            return false;
        }
        return true;
    }

}
