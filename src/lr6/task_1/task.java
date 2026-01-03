package lr6.task_1;

public class task {

    String str1;
    char ch1;

    public void setCh1OrStr1(char ch1) {
        this.ch1 = ch1;
    }

    public void setCh1OrStr1(String str1) {
        this.str1 = str1;
    }

    public void setCh1OrStr1(char[] chars) {
        if (chars.length == 1) {
            this.ch1 = chars[0];
        } else if (chars.length > 1) {
            this.str1 = String.valueOf(chars);
        }
    }

}
