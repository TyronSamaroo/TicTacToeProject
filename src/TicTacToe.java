import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.util.Random;


public class TicTacToe extends Application {
    private boolean changeTurns = false;
    private boolean changeCompTurn = false;
    private static int[][] board = new int[3][3];
    private GridPane grid = new GridPane();
    private int row;
    private int col;
    private VBox vBox = new VBox(15);
    private Button X = new Button("Winner is X");
    private Button O = new Button("Winner is O ");
    private Button Draw = new Button("Draw");


    @Override
    public void start(Stage primaryStage) {
        BorderPane border = new BorderPane();
        border.setRight(getVBox());
        border.setCenter(grid);
        Scene scene = new Scene(border, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    private VBox getVBox() {


        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setPadding(new Insets(15, 15, 15, 15));
        vBox.setStyle("-fx-background-color: gold");
        vBox.getChildren().add(new Label("Welcome to Tic Tac Toe"));
        vBox.getChildren().add(new Label("Choose an Option! "));
        Button restart = new Button("Restart");
        Button exit = new Button("Exit");
        Button player_vs_player = new Button("Player vs Player");
        Button playerVsComputer = new Button("Player vs Computer");
        vBox.getChildren().addAll(player_vs_player, playerVsComputer, restart, exit);

        player_vs_player.setOnAction(event -> {
            resetBoard();
            vBox.getChildren().removeAll(X, O, Draw);
            PvP();


        });
        restart.setOnAction(event -> {

            resetBoard();
            vBox.getChildren().removeAll(X, O, Draw);
            PvP();

        });
        playerVsComputer.setOnAction(event -> {
            resetBoard();
            vBox.getChildren().removeAll(X, O, Draw);
            PvE();

        });

        exit.setOnAction(event -> {
            System.exit(0);
        });
        // if(PvP.getText().equals("X"))


        return vBox;

    }

    private void PvP() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button btn = new Button();
                grid.add(btn, j, i);
                btn.setPrefSize(200, 200);

                //Each Button will do one of these actioons

                btn.setOnAction(event -> {
                    row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
                    col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();

                    playerTurn(btn);
                    displayWinner();
                    int r;


                });
            }
        }
    }


    private void PvE() {
        Button[][] btn2 = new Button[3][3];

        for (int i = 0; i < 3; i++) {
            for(int j= 0; j < 3; j++){
                grid.add(btn2[3][3],j,i);
                btn2[3][3].setPrefSize(200, 200);
            }
        }

        //Each Button will do one of these actions


        btn2[0][0].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[0][1].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[0][2].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[1][0].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[1][1].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[1][2].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[2][0].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[2][1].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
        btn2[2][2].setOnAction(event -> {
            row = GridPane.getRowIndex((Node) (event.getSource())).intValue();
            col = GridPane.getColumnIndex((Node) (event.getSource())).intValue();
            //checknPlay(btn2);


        });
    }

//                for (int x = 0; x < 3; x++) {
//                    for (int o = 0; o < 3; o++)
//                        if (btn2.getText().isEmpty()) {
//                            btn2.setText("X");
//
//                        }
//                }


   public void selectrandomemptybutton(Button empty){
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if(empty.getText().isEmpty())
                    empty.setText("Hello");
            }

            }
    }


   private void checknPlay(Button computer){


        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                    if (computer.getText().isEmpty()) {
                        if (!changeCompTurn) {
                            computer.setText("X");
                            board[row][col] = 1;
                            changeCompTurn = true;
                        } else {
                            computer.setText("O");
                            board[row][col] = 2;
                           changeCompTurn = false;
                        }
                    }

            }
        }
    }

   private void playerTurn(Button player){
        if (player.getText().isEmpty()) {
            if (!changeTurns) {
                player.setText("X");
                board[row][col] = 1;
                changeTurns = true;
            } else {
                player.setText("O");
                board[row][col] = 2;
                changeTurns = false;
            }
        }
    }

    private void computerTurn(Button computer){
        if(!computer.getText().isEmpty()){

        }
    }



    private void resetBoard() {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                board[a][b] = 0;

            }
        }
    }



   private void displayWinner(){
                // This declare each button to a value
                int r1c1 = 0;int r1c2 = 0;int r1c3 = 0;
                int r2c1 = 0;int r2c2 = 0;int r2c3 = 0;
                int r3c1 = 0;int r3c2 = 0;int r3c3 = 0;

                //After setting a button to either X or O it will then go through and declare a new value for each
                for (int x = 0; x < 3; x++) {
                    for (int p = 0; p < 3; p++) {
                        //System.out.print(board[x][p]);
                        r1c1 = board[0][0];r1c2 = board[0][1];r1c3 = board[0][2];
                        r2c1 = board[1][0];r2c2 = board[1][1];r2c3 = board[1][2];
                        r3c1 = board[2][0];r3c2 = board[2][1];r3c3 = board[2][2];
                    }
                    System.out.println();
                }

                // This would print check the new value

                System.out.print(" r1c1 " + r1c1);System.out.print(" r1c2 " + r1c2);System.out.print(" r1c3 " + r1c3);
                System.out.println();
                System.out.print(" r2c1 " + r2c1);System.out.print(" r2c2 " + r2c2);System.out.print(" r2c3 " + r2c3);
                System.out.println();
                System.out.print(" r3c1 " + r3c1);System.out.print(" r3c2 " + r3c2);System.out.print(" r3c3 " + r3c3);
                System.out.println();


                // String win ="No Winners Yet ";
                int win= 0;

                //This would check rows and cols and diagonals for X
                if ((r1c1 == 1 && r1c2 == 1 && r1c3 == 1) || (r2c1 == 1 && r2c2 == 1 && r2c3 == 1) || (r3c1 == 1 && r3c2 == 1 && r3c3 == 1)
                        || (r1c1 == 1 && r2c1 == 1 && r3c1 == 1) || (r1c2 == 1 && r2c2 == 1 && r3c2 == 1) || (r1c3 == 1 && r2c3 == 1 && r3c3 == 1)) {
                    //  win = "Player X Wins";
                    win = 1;
                }
                else if  (r1c1 == 1 && r2c2 == 1 && r3c3 == 1 || r1c3 == 1 && r2c2 == 1 && r3c1 == 1) {
                    //  win = "Player X Wins";
                    win =1;
                }
                //This would check rows and cols and diagonals for X
                else if ((r1c1 == 2 && r1c2 == 2 && r1c3 == 2) || (r2c1 == 2 && r2c2 == 2 && r2c3 == 2) || (r3c1 == 2 && r3c2 == 2 && r3c3 == 2)
                        || (r1c1 == 2 && r2c1 == 2 && r3c1 == 2) || (r1c2 == 2 && r2c2 == 2 && r3c2 == 2) || (r1c3 == 2 && r2c3 == 2 && r3c3 == 2)) {
                    //win = "Player O Wins";
                    win = 2;
                }
                else if (r1c1 == 2 && r2c2 == 2 && r3c3 == 2 || r1c3 == 2 && r2c2 == 2 && r3c1 == 2) {
                    //win = "Player O Wins";
                    win = 2;
                }
                else if((r1c1 == 1 || r1c1 == 2) && (r1c2 == 1 || r1c2 == 2) && (r1c3 == 1 || r1c3 == 2) &&
                        (r2c1 == 1 || r2c1 == 2) && (r2c2 == 1 || r2c2 == 2) && (r2c3 == 1 || r2c3 == 2) &&
                        (r3c1 == 1 || r3c1 == 2) && (r3c2 == 1 || r3c2 == 2) && (r3c3 == 1 || r3c3 == 2))
                    //win = "Draw";
                    win = 3;


                if (win == 3) {
                    System.out.print(win);
                    popUp0();
                    resetBoard();


                }
                if (win == 1) {
                    System.out.print(win);
                    popUp1();
                    resetBoard();


                }
                if (win == 2) {
                    System.out.print(win);
                    popUp2();
                    resetBoard();


                }





            }


   private int popUp0(){

                vBox.getChildren().add(Draw);
                return 0;

            }
   private  int popUp1(){

                vBox.getChildren().add(X);
                return 0;
            }
   private  int popUp2(){

                vBox.getChildren().add(O);
                return  0;
            }

   public static void main (String args[]){


                Application.launch(args);


            }

        }






