package builder.practice;

public class PClient
{
    public static void main(String[] args)
    {
        User user = new User.Builder("mayun", 10).nickName("jack ma").build();
        System.out.println(user);
        Employee employee = new Employee.EmployeeBuilder().name("peter").age(18).hobby("pingpang").build();
        System.out.println(employee);

    }
}
