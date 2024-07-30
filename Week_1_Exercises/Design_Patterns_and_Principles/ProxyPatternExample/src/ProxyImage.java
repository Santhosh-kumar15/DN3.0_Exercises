public class ProxyImage implements Image {
    private RealImage realImage;
    private String imagePath;

    public ProxyImage(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imagePath);
        }
        realImage.display();
    }
}
