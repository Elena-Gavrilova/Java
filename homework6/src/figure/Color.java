package figure;

public enum Color implements Draw {
    RED {
        @Override
        public void draw() {
            System.out.println("Рисуем красным маркером.");
        }
    },
    BLUE {
        @Override
        public void draw() {
            System.out.println("Рисуем синим маркером.");
        }
    },
    GREEN {
        @Override
        public void draw() {
            System.out.println("Рисуем зеленым маркером.");
        }
    };


}
