package Session5.Example;

public class RikkeiAcademy {
    // de y khi phong van
    public static int view = 0;// nam o HEAD, STATIC POOL

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
