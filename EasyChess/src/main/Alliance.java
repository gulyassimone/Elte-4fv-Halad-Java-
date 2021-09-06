package main;

public enum Alliance {
    WHITE() {

        @Override
        public boolean isBlack() {
            return false;
        }
        @Override
        int getDirection() {
            return -1;
        }
        @Override
        public String toString() {
            return "main.Alliance{white}";
        }
        @Override
        public int max(Board board) {
            return 0;
        }
    },
    BLACK() {

        @Override
        public boolean isBlack() {
            return true;
        }

        @Override
        int getDirection() {
            return 1;
        }
        @Override
        public String toString() {
            return "main.Alliance{black}";
        }
        @Override
        public int max(Board board) {
            return board.getSize()-1;
        }
    };

    abstract int getDirection();

    public abstract boolean isBlack();

    public abstract int max(Board board);
}
