import java.util.Random;

public class PasswordRandomizer {
    // Define the variables
    private Random random = new Random();
    private int i;
    private int length;
    private String password = "";

    public PasswordRandomizer(int length) {
        // Initialize the variable
        this.length = length;
        
    }

    public String createPassword() {
        // write code that returns a randomized password
        this.password = "";
        for (i = 0; i < this.length; i++) {
            int charNumber = random.nextInt(26);
            this.password += "abcdefghijklmnopqrstuvwxyz".charAt(charNumber);                
        }
        return this.password;
        
    }
}
