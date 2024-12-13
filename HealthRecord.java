public class HealthRecord {
    private int height;
    private static int counter = 0;
    private static double averageHeight = 0.0;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // Static variables for tracking tallest and shortest heights
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    // Constructor เพื่อเปลี่ยนความสูง
    public HealthRecord(int height) {
        counter++;  // ทุกครั้งที่ใช้ func นี้เพิ่มจำนวนนักเรียน
        setHeight(height); //func
    }

    public void setHeight(int height) {
        // Check if the input height condition
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            this.height = height;
        } else { // ถ้าไม่อยู่เงื่อนไขติดค่า default
            this.height = DEFAULT_HEIGHT;
        }

        // Update the tallest and shortest heights
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }
        // คำนวน ค่าเฉลี่ย
        averageHeight = ((averageHeight * (counter - 1)) + this.height) / counter;
    }

    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static int getCounter(){
        return counter++;
    }
    
    public static double getAverageHeight(){
        return averageHeight;
    }

    public void displayDetails() {
        System.out.println("Student height: " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("Student counter: "+ getCounter());
        System.out.println("Tallest height: " + getTallestHeight());
        System.out.println("Shortest height: " + getShortestHeight());
        System.out.printf("AverageHeight:%.2f%n" , getAverageHeight()); // ทศนิยม 2 ตำแหน่ง
    }
    
    public static void main(String[] args) {
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(180);

        student1.displayDetails(); // 120
        student2.displayDetails(); // 55
        student3.displayDetails(); // 180 is not permitted, so it is replaced by default value (100)

        HealthRecord.displayClassDetails(); // Tallest = 120, Shortest = 55
    }
}
