public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println(basicComputer);
        Computer highEndComputer = new Computer.Builder("Intel i7", "16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA GTX 3080")
                .setOperatingSystem("Windows 10")
                .build();
        System.out.println(highEndComputer);
        Computer customComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .setStorage("512GB SSD")
                .setGraphicsCard("AMD Radeon RX 6800")
                .setOperatingSystem("Linux")
                .build();
        System.out.println(customComputer);
    }
}
