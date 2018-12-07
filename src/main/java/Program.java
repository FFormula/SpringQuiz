import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Exam;

class Program {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        context.getBean(Exam.class).start();
    }
}
