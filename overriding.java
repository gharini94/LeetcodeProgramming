public class overriding {
    private String name;
    private int age;
    private String passport;

	//getters and setters, constructor

    public overriding(String name, int age, String pass){
        this.name=name;
        this.age = age;
        this.passport=pass;
    }
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof overriding)) {
            return false;
        }

        overriding user = (overriding) o;

        return user.name.equals(name) &&
                user.age == age &&
                user.passport.equals(passport);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        return result;
    }
    public static void main(String[] args) {
        overriding user1 = new overriding("mkyong", 35, "111222333");
    overriding user2 = new overriding("mkyon", 35, "111222333");

    System.out.println(user1.equals(user2)); // true
    }
}