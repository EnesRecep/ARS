package sample.model;

public class Radar {
    private int scanAngle = 20; // default (degrees)
    private int radius = 50; // default (pixels)
    private int scanInterval = 1000; // default (milliseconds)
    private int[] position;
    private ChangeListener listener;

    public Radar() {
        /* Empty - Not sure if we'll ever need this... Keeping it for now... */
    }

    public Radar(Integer scanAngle, Integer radius, Integer scanInterval, int[] position) {
        if (scanAngle != null) this.scanAngle = scanAngle;
        if (radius != null) this.radius = radius;
        if (scanInterval != null) this.scanInterval = scanInterval;
        this.position = position;
    }

    public int getScanAngle() {
        return scanAngle;
    }

    public void setScanAngle(int scanAngle) {
        this.scanAngle = scanAngle;
        notifyChange();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        notifyChange();
    }

    public int getWidth() {
        return 2 * radius;
    }

    public int getHeight() {
        return getWidth();
    }

    public int getScanInterval() {
        return scanInterval;
    }

    public void setScanInterval(int scanInterval) {
        this.scanInterval = scanInterval;
        notifyChange();
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new int[]{x, y};
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    private void notifyChange() {
        if (listener != null) {
            listener.onChange();
        }
    }

    public enum Color {
        ACTIVE("#4CAF50", "#388E3C"), THREAT("#F44336", "#D32F2F"), INACTIVE("#757575", "#424242");

        private javafx.scene.paint.Color fill;
        private javafx.scene.paint.Color stroke;

        Color(String fillHex, String strokeHex) {
            fill = javafx.scene.paint.Color.web(fillHex, 0.35d);
            stroke = javafx.scene.paint.Color.web(strokeHex, 0.5d);
        }

        public javafx.scene.paint.Color getFill() {
            return fill;
        }

        public javafx.scene.paint.Color getStroke() {
            return stroke;
        }
    }

    public interface ChangeListener {
        void onChange();
    }
}
