package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BoardGUI {
    private JButton[][] buttons;
    private Board board;
    private JPanel boardPanel;
    private BufferedImage image;
    private Image whiteImg = null, blackImg = null;

    public BoardGUI(int boardSize) {
        board = new Board(boardSize);
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(board.getSize(), board.getSize()));
        buttons = new JButton[board.getSize()][board.getSize()];

        try {
            image = ImageIO.read(new File("image name and path"));
        } catch (IOException ex) {
            // handle exception...
        }

        try {
            blackImg = ImageIO.read(getClass().getResource("/BB.gif"));
            whiteImg = ImageIO.read(getClass().getResource("/WB.gif"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < board.getSize(); ++i) {
            for (int j = 0; j < board.getSize(); ++j) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener(i, j));
                button.setPreferredSize(new Dimension(60, 50));
                buttons[i][j] = button;

                if (board.getField(i, j).getPiece() != null) {
                    if (board.getField(i, j).getPiece().getAlliance().isBlack()) {
                        button.setIcon(new ImageIcon(blackImg));
                    } else {
                        button.setIcon(new ImageIcon(whiteImg));
                    }
                }

                boardPanel.add(button);
            }
        }
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public void refresh(List<Position> positions) {
        for (Position position : positions) {
            JButton button = buttons[position.getX()][position.getY()];
            button.setBackground(Color.GRAY);
            System.out.println(position);
        }
    }

    public void move(Field selectedField, Field actualField) {
        clear();
        JButton button = buttons[selectedField.getPosition().getX()][selectedField.getPosition().getY()];
        button.setIcon(null);
        JButton button2 = buttons[actualField.getPosition().getX()][actualField.getPosition().getY()];
        if (selectedField.getPiece().getAlliance().isBlack()) {
            button2.setIcon(new ImageIcon(blackImg));
        } else {
            button2.setIcon(new ImageIcon(whiteImg));
        }
        actualField.setPiece(board.getSelected().getPiece().getAlliance());
        board.getSelected().removePiece();
        board.setSelected(null);


        if(actualField.getPiece().getAlliance().max(board) == actualField.position.getX()){
            board.setWinner(actualField.getPiece().getAlliance());
        }
    }

    public void clear() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                JButton button = buttons[i][j];
                button.setBackground(null);
            }
        }
    }

    class ButtonListener implements ActionListener {

        private int x, y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Field actualField = board.getField(x, y);

            if (actualField.isFieldOccupied) {
                if (board.getSelected() != null) {
                    clear();
                    if (actualField.getPiece().getAlliance() != board.getSelected().getPiece().getAlliance() &&
                            board.getSelected().getPiece().calculateLegalMoves(board)
                                    .stream()
                                    .filter(position -> actualField.getPosition().equals(position))
                                    .findAny()
                                    .orElse(null) != null) {
                        move(board.getSelected(), actualField);
                    }
                }
                board.setSelected(actualField);
                if(actualField.getPiece().getAlliance().max(board) != actualField.position.getX()) {
                    List<Position> canMove = actualField.getPiece().calculateLegalMoves(board);
                    canMove.forEach(System.out::println);
                    refresh(canMove);
                }
            } else if (board.getSelected() != null && board.getSelected().getPiece().calculateLegalMoves(board) != null) {
                if (board.getSelected().getPiece().calculateLegalMoves(board)
                        .stream()
                        .filter(position -> actualField.getPosition().equals(position))
                        .findAny()
                        .orElse(null) != null) {
                    move(board.getSelected(), actualField);
                }
            }
            if (board.getWinner() != null) {
                JOptionPane.showMessageDialog(boardPanel, (board.getWinner().isBlack() ? "Black" : "White") + " win.","Congrats!",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}
