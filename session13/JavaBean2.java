
package session13;

/**
 *
 * @author Haiping Zhu
 */
public class JavaBean2 extends Object {
    private String firstName, lastName;

    public JavaBean2() { }    
    
    public void setFirstName(String name) { firstName = name; }
    public String getFirstName() { return firstName; }

    public void setLastName(String name) { lastName = name; }
    public String getLastName() { return lastName; }

    public String toString() { return firstName + " " + lastName; }
}