package Session5.Example;

public class RikkeiAcademy {
    private int view = 0;

    public RikkeiAcademy() {
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void visited() {
        view++;
    }
}
