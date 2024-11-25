package by.IT._02_jpa;
import by.itclass._02_jpa.configs.AppConfig;
import by.itclass._02_jpa.entities.Airplane;
import by.itclass._02_jpa.entities.Passenger;
import by.itclass._02_jpa.repositories.AirplaneRepository;
import by.itclass._02_jpa.repositories.PassengerRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var repository = ctx.getBean(AirplaneRepository.class);
        var passRepository = ctx.getBean(PassengerRepository.class);

//        var airbus = repository.findByPlaceBetween(250, 500);
//        airbus.forEach(System.out::println);
//        repository.findAll().forEach(System.out::println);
//        System.out.println("_________________________");
//        repository.concretePlanes("Boe%", 300).forEach(System.out::println);
        var passengers = (List<Passenger>)ctx.getBean("passengers");
        passRepository.saveAll(passengers);
        var flight_BRU_982 = ctx.getBean("boeing736", Airplane.class);
        repository.save(flight_BRU_982);
    }
}
