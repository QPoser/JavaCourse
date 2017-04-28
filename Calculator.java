public class Calculator {
    
    private int result = 0;
    
    public void plus(int x, int y)
    {
        this.result = x + y;
    }
    
    public void minus(int x, int y) {
        this.result = x - y;
    }
    
    public void multiply(int x, int y) {
        this.result = x * y;
    }
    
    public void dividing(int x, int y) {
        this.result = x / y;
    }
    
    public int getResult() {
        return this.result;
    }
    
    public void cleanResult() {
        this.result = 0;
    }
    
    public void setResult(int i) {
        this.result = i;
    }
}