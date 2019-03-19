package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {

        this.name = name;
        if(weight < 0) {
            throw new IllegalArgumentException("Weight cannot be less than 0");
        }
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public int hashCode() {
        int code = 0;
        for(int i = 0; i < name.length(); i++) {
            code += name.charAt(i);
        }
        return code * 11;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Thing other = (Thing) obj;
        return !((this.name == null) ? (other.name != null) : !this.name.equals(other.name));
    }

}
