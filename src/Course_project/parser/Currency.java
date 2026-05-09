package Course_project.parser;

public class Currency {
    private String code;
    private String name;
    private String value;

    public Currency(String code, String name, String value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
