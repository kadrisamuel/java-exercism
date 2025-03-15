enum Signal {

    WINK(0), DOUBLE_BLINK(1), CLOSE_YOUR_EYES(2), JUMP(3);

    private final int number;
    
    Signal(int number) {
        this.number = number;
    }

    public static Signal getSignal(int number){
        for (Signal signal : Signal.values()) {
            if (signal.number == number) {
                return signal;
            }
        }
        throw new IllegalArgumentException("No signal with number " + number);
    }

}
