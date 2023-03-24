package com.example.demo.student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepo customerRepository; //data to come from our database and added constuctor parameter

    public Main(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);

    }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }//findall customers in adn get mapping req

    record NewCustomerRequest(
            String name,
            String email,
            Integer age

    ){

    }
    @PostMapping //adding new customers to the list by the user
    // adding customer which will recieve Newcust request (record).
    // record will acc name,email,age.
    //customer can set and our repository will be involved to save it
    //request comes from client so to capture that
    //we will use request body.
    public void addCustomer(@RequestBody NewCustomerRequest request){
     Customer customer = new Customer();
     customer.setName(request.name());
     customer.setEmail(request.email());
     customer.setAge(request.age());
     customerRepository.save(customer);
    }
    //to delete customer we will recive id,so we will
    //pass the id and map it with delete mapping
    //when someone says/1 in mapping /1 means 1 is id for some person
    //pass it into the path variable
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id)
    {
        customerRepository.deleteById(id);
    }


}

//
//}
