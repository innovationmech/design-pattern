package template;

public class MyLeaveRequest extends LeaveRequest
{
    @Override
    String name()
    {
        return "阿里";
    }

    @Override
    String reason()
    {
        return "参加力扣周赛";
    }

    @Override
    String duration()
    {
        return "0.5";
    }
}
